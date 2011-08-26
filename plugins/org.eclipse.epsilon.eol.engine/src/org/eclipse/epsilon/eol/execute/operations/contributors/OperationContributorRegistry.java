package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.contributors.compatibility.StringCompatibilityOperationContributor;

public class OperationContributorRegistry {
	
	private final List<OperationContributor> operationContributorsCache = new ArrayList<OperationContributor>();

	public OperationContributorRegistry() {
		operationContributorsCache.addAll(getDefaultOperationContributors());
	}
	
	/**
	 * <p>Adds the specified {@link OperationContributor} to the list of contributors
	 * used to discover contributed operations by the registry. Contributors added
	 * with this method have a lower precedence than the default operation 
	 * contributors.</p>
	 * 
	 * <p>To add an operation contributor with a higher precedence than one or more of
	 * the default operation contributors, define a subclass that overrides the 
	 * {@link #getDefaultOperationContributors()} method.</p>
	 */
	public void add(OperationContributor operationContributor) {
		operationContributorsCache.add(operationContributor);
	}
	
	/**
	 * The list of {@link OperationContributor}s used to discover contributed
	 * operations by the registry. Subclasses may override this method to add, 
	 * remove or change the order of the {@link OperationContributor}s used 
	 * by the registry. 
	 */
	protected List<OperationContributor> getDefaultOperationContributors() {
		return new LinkedList<OperationContributor>(
		             Arrays.asList(new StringCompatibilityOperationContributor(),
		                           new ReflectiveOperationContributor(),
		                           new WrapperOperationContributor(),
		                           new StringOperationContributor(),
		                           new IntegerOperationContributor(),
		                           new NumberOperationContributor(),
		                           new BooleanOperationContributor(),
		                           new ArrayOperationContributor(),
		                           new CollectionOperationContributor(),
		                           new ScalarOperationContributor(),
		                           new AnyOperationContributor(),
		                           new BasicEUnitOperationContributor()));
	}

	public ObjectMethod getContributedMethod(Object o, String name, Object[] parameters, IEolContext context) {
		for (OperationContributor c : operationContributorsCache) {
			if (c.contributesTo(o)) {
				ObjectMethod objectMethod = c.getObjectMethodFor(o, name, parameters, context);
				if (objectMethod != null) return objectMethod;
			}
		}
		return null;
	}
	
	public ObjectMethod getContributedMethod(Object o, String name, AST ast, IEolContext context) {
		for (OperationContributor c : operationContributorsCache) {
			if (c.contributesTo(o)) {
				ObjectMethod objectMethod = c.getObjectMethodFor(o, name, ast, context);
				if (objectMethod != null) return objectMethod;
			}
		}
		return null;
	}
}
