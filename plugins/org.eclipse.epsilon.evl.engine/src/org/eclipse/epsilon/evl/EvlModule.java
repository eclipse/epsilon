/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - concurrency support, refactoring, optimisation
 ******************************************************************************/
package org.eclipse.epsilon.evl;

import java.util.*;
import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.TokenStream;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.AstUtil;
import org.eclipse.epsilon.eol.dom.ExecutableBlock;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.erl.ErlModule;
import org.eclipse.epsilon.evl.dom.*;
import org.eclipse.epsilon.evl.execute.EvlOperationFactory;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.EvlContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.exceptions.EvlConstraintNotFoundException;
import org.eclipse.epsilon.evl.graph.EvlGraph;
import org.eclipse.epsilon.evl.parse.EvlLexer;
import org.eclipse.epsilon.evl.parse.EvlParser;

public class EvlModule extends ErlModule implements IEvlModule {
	
	protected IEvlFixer fixer;
	protected List<ConstraintContext> constraintContexts;
	protected final ArrayList<ConstraintContext> declaredConstraintContexts = new ArrayList<>(0);
	protected final Constraints constraints = new Constraints();
	private boolean optimizeConstraints = false;
	
	public EvlModule() {
		this.context = new EvlContext();
	}

	public static final String OPTIMIZE_CONSTRAINTS = "optimizeConstraints";
	
	protected static final Set<String> CONFIG_PROPERTIES = new HashSet<>(4);
	static {
		CONFIG_PROPERTIES.add(IEvlContext.OPTIMIZE_CONSTRAINT_TRACE);
		CONFIG_PROPERTIES.add(OPTIMIZE_CONSTRAINTS);
	}
	
	@Override
	protected EvlLexer createLexer(ANTLRInputStream inputStream) {
		return new EvlLexer(inputStream);
	}
 
	@Override
	public EvlParser createParser(TokenStream tokenStream) {
		return new EvlParser(tokenStream);
	}

	@Override
	public String getMainRule() {
		return "evlModule";
	}
	
	@Override
	public ModuleElement adapt(AST cst, ModuleElement parentAst) {
		switch (cst.getType()) {
			case EvlParser.FIX: return new Fix();
			case EvlParser.DO: return new ExecutableBlock<Void>(Void.class);
			case EvlParser.TITLE:
			case EvlParser.MESSAGE:
				return new ExecutableBlock<String>(String.class);
			case EvlParser.CONSTRAINT:
			case EvlParser.CRITIQUE:
				return new Constraint();
			case EvlParser.CONTEXT:
				return new ConstraintContext();
			case EvlParser.CHECK:
			case EvlParser.GUARD:
				return new ExecutableBlock<Boolean>(Boolean.class);
		}
		return super.adapt(cst, parentAst);
	}

	@Override
	public HashMap<String, Class<?>> getImportConfiguration() {
		HashMap<String, Class<?>> importConfiguration = super.getImportConfiguration();
		importConfiguration.put("evl", getClass());
		return importConfiguration;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		
		ConstraintContext globalConstraintContext = new GlobalConstraintContext();
		globalConstraintContext.setModule(this);
		globalConstraintContext.setParent(this);
		this.getChildren().add(globalConstraintContext);
		
		Constraints globalConstraints = globalConstraintContext.getConstraints();
		
		List<AST>
			constraintASTs = AstUtil.getChildren(cst, EvlParser.CONSTRAINT),
			critiqueASTs = AstUtil.getChildren(cst, EvlParser.CRITIQUE),
			constraintContextAsts = AstUtil.getChildren(cst, EvlParser.CONTEXT);
		
		declaredConstraintContexts.ensureCapacity(constraintContextAsts.size()+1);
		globalConstraints.ensureCapacity(constraintASTs.size()+critiqueASTs.size()+globalConstraints.size());
		
		for (AST constraintAst : constraintASTs) {
			Constraint constraint = (Constraint) module.createAst(constraintAst, globalConstraintContext);
			globalConstraints.add(constraint); 
			constraint.setConstraintContext(globalConstraintContext);
		}
		
		for (AST critiqueAst : critiqueASTs) {
			Constraint critique = (Constraint) module.createAst(critiqueAst, globalConstraintContext);
			globalConstraints.add(critique); 
			critique.setConstraintContext(globalConstraintContext);
		}
		
		for (AST constraintContextAst : constraintContextAsts) {
			declaredConstraintContexts.add((ConstraintContext) module.createAst(constraintContextAst, this));
		}

		if (!globalConstraints.isEmpty()) {
			declaredConstraintContexts.add(globalConstraintContext);
		}
		
		// Cache all the constraints
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			constraints.addAll(constraintContext.getConstraints());
		}
	}

	@Override
	public List<ConstraintContext> getDeclaredConstraintContexts() {
		return declaredConstraintContexts;
	}

	@Override
	public List<ConstraintContext> getConstraintContexts() {
		if (constraintContexts == null) {
			constraintContexts = new ArrayList<>();
			for (Import import_ : imports) {
				if (import_.isLoaded() && (import_.getModule() instanceof IEvlModule)) {
					IEvlModule module = (IEvlModule) import_.getModule();
					constraintContexts.addAll(module.getConstraintContexts());
				}
			}
			constraintContexts.addAll(declaredConstraintContexts);
		}
		return constraintContexts;
	}
	
	/**
	 * 
	 * @return
	 * @throws EvlConstraintNotFoundException
	 * @since 1.6
	 */
	protected List<Constraint> computeConstraintSequence() throws EvlConstraintNotFoundException {
		IEvlContext context = getContext();
		EvlGraph graph = new EvlGraph(context);
		graph.addConstraintContexts(getConstraintContexts());
		graph.setAllConstraintsDependedOn();
		return graph.getConstraintSequence();
	}
	
	/**
	 * 
	 * @param constraintContext
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	protected Collection<Constraint> getOptimisedConstraintsFor(ConstraintContext constraintContext) throws EolRuntimeException {
		IEvlContext context = getContext();
		Collection<Constraint>
			dependedOn = context.getConstraintsDependedOn(),
			remainingConstraints = new ArrayList<>(constraintContext.getConstraints());
		ConstraintSelectTransfomer transformer = new ConstraintSelectTransfomer();
		
		for (Iterator<Constraint> itConstraint = remainingConstraints.iterator(); itConstraint.hasNext();) {
			Constraint constraint = itConstraint.next();
			if (transformer.canBeTransformed(constraint) && !constraint.isLazy(context)) {
				ExecutableBlock<?> transformedConstraint = transformer.transformIntoSelect(constraint);
				Iterable<?> results = (Iterable<?>) transformedConstraint.execute(context);

				// Postprocess the invalid objects to support custom messages and fix blocks
				for (Object self : results) {
					// We know result = false because we found it with the negated condition
					constraint.optimisedCheck(self, context, false);
				}

				// If we already know the result won't be used, don't bother adding it to the trace!
				if (dependedOn == null || dependedOn.contains(constraint)) {
					// Mark this constraint as executed in an optimised way: we will only have
					// explicit trace items for invalid objects, so we'll have to tweak isChecked
					// and isSatisfied accordingly.
					context.getConstraintTrace().addCheckedOptimised(constraint);
				}

				// Don't try to reexecute this rule later on
				itConstraint.remove();
			}
		}
		
		return remainingConstraints;
	}
	
	/**
	 * 
	 * @param constraintContext
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	protected Collection<Constraint> preProcessConstraintContext(ConstraintContext constraintContext) throws EolRuntimeException {
		Collection<Constraint> constraintsToCheck;
		
		if (optimizeConstraints) {
			for (Constraint constraint : constraintsToCheck = getOptimisedConstraintsFor(constraintContext)) {
				if (constraint.getConstraintContext() != constraintContext)
					throw new IllegalArgumentException("ConstraintContext '"+constraintContext.getTypeName()+"' is not applicable for Constraint '"+constraint.getName()+"'.");
			}
		}
		else {
			constraintsToCheck = constraintContext.getConstraints();
		}
		
		return constraintsToCheck;
	}
	
	@Override
	protected void prepareContext() {
		IEvlContext context = getContext();
		super.prepareContext();
		context.setOperationFactory(new EvlOperationFactory());
		context.getFrameStack().put(
			Variable.createReadOnlyVariable("constraintTrace", context.getConstraintTrace()),
			Variable.createReadOnlyVariable("thisModule", this)
		);
	}

	/**
	 * Invokes the execute() method on all Constraints in all ConstraintContexts.
	 * If optimizeConstraints, the constraints to be checked are filtered.
	 * @since 1.6
	 */
	protected void checkConstraints() throws EolRuntimeException {
		IEvlContext context = getContext();	
		for (ConstraintContext constraintContext : getConstraintContexts()) {
			constraintContext.execute(preProcessConstraintContext(constraintContext), context);
		}
	}
	
	/**
	 * Clean up, execute fixes and post block.
	 * @since 1.6
	 */
	@Override
	protected void postExecution() throws EolRuntimeException {
		if (fixer != null) {
			fixer.fix(this);
		}
		super.postExecution();
	}
	
	/**
	 * 
	 * @since 1.6
	 */
	@Override
	public Set<UnsatisfiedConstraint> executeImpl() throws EolRuntimeException {
		prepareExecution();
		checkConstraints();
		postExecution();
		return getContext().getUnsatisfiedConstraints();
	}
	
	/**
	 * @since 1.6
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final Set<UnsatisfiedConstraint> execute() throws EolRuntimeException {
		return (Set<UnsatisfiedConstraint>) super.execute();
	}
	
	@Override
	public IEvlContext getContext() {
		return (IEvlContext) context;
	}
	
	@Override
	public Constraints getConstraints() { 
		return constraints;
	}
	
	@Override
	public void setUnsatisfiedConstraintFixer(IEvlFixer fixer) {
		this.fixer = fixer;
	}

	@Override
	public IEvlFixer getUnsatisfiedConstraintFixer() {
		return fixer;
	}

	@Override
	protected int getPostBlockTokenType() {
		return EvlParser.POST;
	}

	@Override
	protected int getPreBlockTokenType() {
		return EvlParser.PRE;
	}

	@Override
	public void setContext(IEolContext context) {
		if (context instanceof IEvlContext) {
			super.setContext(context);
		}
	}
	
	/**
	 * Checks if is optimize constraints.
	 *
	 * @return true, if is optimize constraints
	 */
	public boolean isOptimizeConstraints() {
		return optimizeConstraints;
	}

	/**
	 * Sets the optimize constraints.
	 *
	 * @param optimizeConstraints the new optimize constraints
	 */
	public void setOptimizeConstraints(boolean optimizeConstraints) {
		this.optimizeConstraints = optimizeConstraints;
	}

	/**
	 * @since 1.6
	 */
	@Override
	public void configure(Map<String, ?> properties) {
		if (properties.containsKey(OPTIMIZE_CONSTRAINTS)) {
			this.optimizeConstraints = Boolean.valueOf(Objects.toString(properties.get(OPTIMIZE_CONSTRAINTS)));
		}
		if (properties.containsKey(IEvlContext.OPTIMIZE_CONSTRAINT_TRACE)) {
			getContext().setOptimizeConstraintTrace(Boolean.valueOf(Objects.toString(properties.get(OPTIMIZE_CONSTRAINTS))));
		}
	}

	/**
	 * @since 1.6
	 */
	@Override
	public Set<String> getConfigurationProperties() {
		return CONFIG_PROPERTIES;
	}
	
}
