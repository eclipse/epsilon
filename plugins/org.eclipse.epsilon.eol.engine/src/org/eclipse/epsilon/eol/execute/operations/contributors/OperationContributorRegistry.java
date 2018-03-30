/*******************************************************************************
 * Copyright (c) 2012-2018 The University of York, Aston University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - provide context for checking if an operation is contributed.
 *     Sina Madani - concurrency support
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.contributors;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.eclipse.epsilon.common.concurrent.ConcurrentBaseDelegate;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.ObjectMethod;
import org.eclipse.epsilon.eol.execute.operations.contributors.compatibility.StringCompatibilityOperationContributor;

public class OperationContributorRegistry implements ConcurrentBaseDelegate<OperationContributorRegistry> {
	
	private Collection<OperationContributor> operationContributorsCache;
	private boolean isConcurrent;
	private final OperationContributorRegistry base;
	
	public OperationContributorRegistry() {
		this(null);
	}
	
	public OperationContributorRegistry(OperationContributorRegistry parent) {
		this(parent, false);
	}
	
	public OperationContributorRegistry(OperationContributorRegistry parent, boolean concurrent) {
		this.base = parent;
		this.isConcurrent = concurrent;
		operationContributorsCache = concurrent ?
			new ConcurrentLinkedQueue<>(getDefaultOperationContributors()) :
			getDefaultOperationContributors();
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
		return new LinkedList<>(
			Arrays.asList(
				new StringCompatibilityOperationContributor(),
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
                new BasicEUnitOperationContributor(),
                new ModelElementOperationContributor()
			)
		);
	}
	
	/**
	 * Finds a contributed operation that is invoked without prior evaluation
	 * (i.e. the contributed operation evaluates its own AST). This category 
	 * of contributed operation is rare, but can be used for rewriting parts 
	 * of the AST at runtime or for selective logging or tracing. See, for 
	 * example, EGL's contributor for OutputBuffer's print operations.
	 */
	public ObjectMethod findContributedMethodForUnevaluatedParameters(Object target, String name, List<Expression> parameterExpressions, IEolContext context) {
		return delegateLookup(ocr -> {
			for (OperationContributor c : ocr.getOperationContributorsFor(target)) {
				ObjectMethod objectMethod = c.findContributedMethodForUnevaluatedParameters(target, name, parameterExpressions, context);
				if (objectMethod != null)
					return objectMethod;
			}
			
			return null;
		});
	}
	
	/**
	 * Finds a contributed operation for the given target, name and parameters.
	 * This is the most common mechanism for contributing an operation. Operations
	 * contributed in this manner are invoked after their parameters have been
	 * evaluated.
	 */
	public ObjectMethod findContributedMethodForEvaluatedParameters(Object target, String name, Object[] parameters, IEolContext context) {
		return delegateLookup(ocr -> {
			for (OperationContributor c : ocr.getOperationContributorsFor(target)) {
				ObjectMethod objectMethod = c.findContributedMethodForEvaluatedParameters(target, name, parameters, context, false);
				if (objectMethod != null)
					return objectMethod;
			}
			return null;
		});
	}
	
	protected Collection<OperationContributor> getOperationContributorsFor(Object target) {
		return operationContributorsCache.stream()
			.filter(oc -> oc.contributesTo(target))
			.collect(Collectors.toList());
	}
	
	public Stream<OperationContributor> stream() {
		return operationContributorsCache.stream();
	}
	
	@Override
	public OperationContributorRegistry getBase() {
		return base;
	}

	@Override
	public void merge(MergeMode mode) {
		mergeCollectionsUnique(
			ocr -> ocr.operationContributorsCache,
			ConcurrentLinkedQueue::new,
			LinkedList::new,
			mode
		);
	}
	
	@Override
	public void setThreadSafe(boolean concurrent) {
		if (this.isConcurrent != concurrent) {
			this.isConcurrent = concurrent;
			operationContributorsCache = isConcurrent ?
				new ConcurrentLinkedQueue<>(operationContributorsCache) :
				new ArrayList<>(operationContributorsCache);
		}
	}
	
	@Override
	public boolean isThreadSafe() {
		return isConcurrent;
	}
}
