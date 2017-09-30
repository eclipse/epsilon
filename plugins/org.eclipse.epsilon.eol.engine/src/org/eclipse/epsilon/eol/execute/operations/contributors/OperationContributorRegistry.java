/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.eol.dom.Expression;
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
		                           new DateOperationContributor(),
		                           new ArrayOperationContributor(),
		                           new IterableOperationContributor(),
		                           new ScalarOperationContributor(),
		                           new AnyOperationContributor(),
		                           new BasicEUnitOperationContributor()));
	}
	
	/**
	 * Finds a contributed operation that is invoked without prior evaluation
	 * (i.e. the contributed operation evaluates its own AST). This category 
	 * of contributed operation is rare, but can be used for rewriting parts 
	 * of the AST at runtime or for selective logging or tracing. See, for 
	 * example, EGL's contributor for OutputBuffer's print operations.
	 */
	public ObjectMethod findContributedMethodForUnevaluatedParameters(Object target, String name, List<Expression> parameterExpressions, IEolContext context) {
		for (OperationContributor c : getOperationContributorsFor(target)) {
			ObjectMethod objectMethod = c.findContributedMethodForUnevaluatedParameters(target, name, parameterExpressions, context);
			if (objectMethod != null) return objectMethod;
		}
		
		return null;
	}
	
	/**
	 * Finds a contributed operation for the given target, name and parameters.
	 * This is the most common mechanism for contributing an operation. Operations
	 * contributed in this manner are invoked after their parameters have been
	 * evaluated.
	 */
	public ObjectMethod findContributedMethodForEvaluatedParameters(Object target, String name, Object[] parameters, IEolContext context) {
		for (OperationContributor c : getOperationContributorsFor(target)) {
			ObjectMethod objectMethod = c.findContributedMethodForEvaluatedParameters(target, name, parameters, context, false);
			if (objectMethod != null) return objectMethod;
		}

		return null;
	}
	
	private Collection<OperationContributor> getOperationContributorsFor(Object target) {
		final List<OperationContributor> applicableOperationContributors = new LinkedList<OperationContributor>();
		
		for (OperationContributor c : operationContributorsCache) {
			if (c.contributesTo(target)) {
				applicableOperationContributors.add(c);
			}
		}
		
		return applicableOperationContributors;
	}
}
