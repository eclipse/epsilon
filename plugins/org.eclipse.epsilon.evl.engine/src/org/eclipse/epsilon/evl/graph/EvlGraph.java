package org.eclipse.epsilon.evl.graph;

import java.util.*;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.function.CheckedEolFunction;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.dom.ConstraintContext;
import org.eclipse.epsilon.evl.execute.exceptions.EvlConstraintNotFoundException;

/*
 * A class used for computing dependencies between Constraints and ConstraintContexts.
 */
public class EvlGraph {
	
	protected final IEolContext context;
	private final Map<ModuleElement, Set<String>> dependenciesCache = new WeakHashMap<>();
	private boolean
		addContextsCalled = false,
		refreshConstraintPriorities;
	
	private final Set<Constraint>
		allConstraints = new LinkedHashSet<>(),
		constraintsNoDependencies = new LinkedHashSet<>(),
		constraintsWithDependencies = new LinkedHashSet<>(),
		allConstraintsDependedOn = new LinkedHashSet<>();
	
	private final Set<ConstraintContext>
		allContexts = new LinkedHashSet<>();
	
	private final Set<String>
		allConstraintsDependedOnString = new LinkedHashSet<>(),
		constraintsToFind = new LinkedHashSet<>(),
		constraintsFound = new LinkedHashSet<>();
	
	private final Map<String, Constraint> constraintStringMap = new HashMap<>();
	private final Map<Constraint, Set<String>> constraintDependenciesMap = new HashMap<>();
	private final Map<Constraint, Integer> constraintPriorities = new LinkedHashMap<>();
	private final Map<ConstraintContext, Set<String>> contextDependenciesMap = new HashMap<>();
	
	public EvlGraph(IEolContext context) {
		this.context = context;
	}
	
	static boolean isDependencyWord(ExecutableBlock<?> block) {
		String word = block.getText();
		return
			word.equals("guard") ||
			word.equals("check") ||
			word.equals("message");
	}
	
	static boolean isSatisfiesCall(OperationCallExpression oce) {
		switch (oce.getOperationName()) {
			case "satisfies":
			case "satisfiesOne":
			case "satisfiesAll":
				return true;
		}
		return false;
	}
	
	public boolean hasDependencies(ModuleElement ast, IEolContext context) {
		Set<String> dependencies = dependenciesCache.get(ast);
		if (dependencies == null) {
			dependencies = getDependencies(ast, context);
		}
		return dependencies.size() > 0;
	}
	
	public Set<String> getDependencies(ModuleElement ast, IEolContext context) {
		Set<String> dependencies = dependenciesCache.get(ast);
		
		if (dependencies == null) {
			dependencies = ast.getChildren()
				.stream()
				.filter(ExecutableBlock.class::isInstance)
				.map(ExecutableBlock.class::cast)
				.filter(EvlGraph::isDependencyWord)
				.map(eb -> eb.getChildren()
					.stream()
					.filter(OperationCallExpression.class::isInstance)
					.map(OperationCallExpression.class::cast)
					.filter(EvlGraph::isSatisfiesCall)
					.collect(Collectors.toList())
				)
				.flatMap(List::stream)
				.map(OperationCallExpression::getParameterExpressions)
				.flatMap(List::stream)
				.map((CheckedEolFunction<Expression, String>) expr -> (String) expr.execute(context))
				.collect(Collectors.toSet());
			
			dependenciesCache.put(ast, dependencies);
		}
		
		return dependencies;
	}
	
	public void addConstraintContexts(Collection<? extends ConstraintContext> constraintContexts) throws EvlConstraintNotFoundException {
		if (constraintContexts == null)
			return;
		
		//Note: a "satisfies" call in the guard block of a context is equivalent to having a satisfies call in the guard block of all the constraints in that context.
		
		for (ConstraintContext constraintContext : constraintContexts) {
			allContexts.add(constraintContext);
			
			Set<String> contextDependencies = getDependencies(constraintContext, context);
			
			//Remove self
			contextDependencies.remove(constraintContext.getTypeName());
			
			boolean contextHasDependencies = !contextDependencies.isEmpty();
			
			if (contextHasDependencies) {
				allConstraintsDependedOnString.addAll(contextDependencies);
				contextDependenciesMap.put(constraintContext, contextDependencies);
				for (String dependency : contextDependencies) {
					if (!(constraintsFound.contains(dependency))) {
						constraintsToFind.add(dependency);
					}
				}
			}
			
			for (final Constraint constraint : constraintContext.getConstraints()) {
				allConstraints.add(constraint);
				String constraintName = constraint.getName();
				constraintsToFind.remove(constraintName);
				constraintsFound.add(constraintName);
				constraintStringMap.put(constraintName, constraint);
				
				if (contextHasDependencies) {
					constraintsWithDependencies.add(constraint);
					constraintDependenciesMap.put(constraint, contextDependencies);
				}
				
				Set<String> constraintDependencies = getDependencies(constraint, context);
				constraintDependencies.addAll(contextDependencies);
				
				//Remove self
				constraintDependencies.remove(constraintName);
				
				if (!constraintDependencies.isEmpty()) {
					constraintsWithDependencies.add(constraint);
					allConstraintsDependedOnString.addAll(constraintDependencies);
					constraintDependenciesMap.put(constraint, constraintDependencies);
					for (String dependency : constraintDependencies) {
						if (!(constraintsFound.contains(dependency))) {
							constraintsToFind.add(dependency);
						}
					}
				}
				else if (!contextHasDependencies)
					constraintsNoDependencies.add(constraint);
			}
		}
		
		if (!constraintsToFind.isEmpty())
			throw new EvlConstraintNotFoundException(constraintsToFind.iterator().next(), null);
		
		for (String constraintDependency : allConstraintsDependedOnString) {
			allConstraintsDependedOn.add(constraintStringMap.get(constraintDependency));
		}
		
		refreshConstraintPriorities = true;
		addContextsCalled = true;
	}
	
	/*
	 * Returns a List of Constraints ordered by dependencies, such that constraints with the least dependencies appear before those with most dependencies.
	 */
	public List<Constraint> getConstraintSequence() {
		List<Constraint> result = new ArrayList<>(constraintsNoDependencies);
		int numNodesLast = result.size(), numNodesDiff;
		
		while (result.size() < allConstraints.size()) {
			numNodesDiff = 1;
			while (numNodesDiff != 0) {
				Iterator<Constraint> itConstraint = constraintsWithDependencies.iterator();
				while (itConstraint.hasNext()) {
					Constraint constraint = itConstraint.next();
					boolean dependenciesSatisfied = true;
					for (String constraintString : constraintDependenciesMap.get(constraint)) {
						Constraint dependency = constraintStringMap.get(constraintString);
						if (!result.contains(dependency) && !(constraint.equals(dependency))) {
							dependenciesSatisfied = false;
							break;
						}
					}
					if (dependenciesSatisfied) {
						result.add(constraint);
						itConstraint.remove();
					}
				}
				
				numNodesDiff = numNodesLast - result.size();
				numNodesLast = result.size();
			}
			if (result.size() < allConstraints.size()) {
				Iterator<Constraint> itConstraint = constraintsWithDependencies.iterator();
				Constraint constraint = itConstraint.next();
				result.add(constraint);
				itConstraint.remove();
			}
		}
		
		return result;
	}

	/*
	 * Maps each Constraint to a priority level based on their dependencies.
	 * @param descendingPriority - if true, the higher priority items will have a lower number (and vice-versa)
	 * @param startNumber - the base priorityto begin counting from
	 */
	public Map<? extends Constraint, Integer> getPriorityConstraints(boolean descendingPriority, final int startNumber) {
		if (!addContextsCalled)
			throw new IllegalStateException("No Constraints to work with: must call addConstraintContexts first");
		
		if (constraintPriorities.isEmpty() || refreshConstraintPriorities) {
			int priority = startNumber;
			if (descendingPriority) {
				for (Constraint constraint : getConstraintSequence())
					constraintPriorities.put(constraint, priority++);
			}
			else {
				for (Constraint constraint : getConstraintSequence())
					constraintPriorities.put(constraint, priority--);
			}
			refreshConstraintPriorities = false;
		}
		
		return constraintPriorities;
	}
	
	
	public Set<Constraint> getAllConstraintsDependedOn() {
		return allConstraintsDependedOn;
	}
	
	public void reset() {
		dependenciesCache.clear();
		
		allConstraints.clear();
		allConstraintsDependedOn.clear();
		allConstraintsDependedOnString.clear();
		constraintStringMap.clear();
		constraintDependenciesMap.clear();
		constraintsWithDependencies.clear();
		constraintsNoDependencies.clear();
		constraintsFound.clear();
		constraintsToFind.clear();
		constraintPriorities.clear();
		
		allContexts.clear();
		contextDependenciesMap.clear();
		
		addContextsCalled = false;
	}
	
	@Override
	public String toString() {
		final String nL = System.getProperty("line.separator"); 
		return 	"Constraints: "+allConstraints.size()+nL+
				"Constraints (no dependencies): "+constraintsNoDependencies.size()+nL+
				"Constraint (with dependencies): "+constraintsWithDependencies.size()+nL+
				"Contexts: "+allContexts.size();
	}
}
