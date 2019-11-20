/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.concurrent;

import java.util.Map;
import java.util.Set;
import org.eclipse.epsilon.common.function.BaseDelegate.MergeMode;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.DelegatePersistentThreadLocal;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.EvlContext;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.execute.context.concurrent.EvlContextParallel;
import org.eclipse.epsilon.evl.execute.context.concurrent.IEvlContextParallel;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class EvlModuleParallel extends EvlModule {
	
	/**
	 * Optimisation so that calls to methods like getFrameStack() don't re-fetch the ThreadLocal
	 * value every time whilst within the same parallelisation context.
	 */
	protected DelegatePersistentThreadLocal<EvlContext> concurrentContexts = new DelegatePersistentThreadLocal<>(
		getContext().getParallelism(), () -> new EvlContext(super.getContext())
	);
	
	static {
		CONFIG_PROPERTIES.add(IEolContextParallel.NUM_THREADS_CONFIG);
	}
	
	public EvlModuleParallel() {
		this(null);
	}
	
	public EvlModuleParallel(IEvlContextParallel context) {
		super(context != null ? context : new EvlContextParallel());
	}
	
	@Override
	protected abstract void checkConstraints() throws EolRuntimeException;
	
	@Override
	protected Set<UnsatisfiedConstraint> processRules() throws EolRuntimeException {
		Set<UnsatisfiedConstraint> result = super.processRules();
		concurrentContexts.removeAll(MergeMode.MERGE_INTO_BASE);
		return result;
	}
	
	/**
	 * Does not look up the element in the context.
	 */
	@Override
	public Constraint getConstraint(String constraintName, String contextName, Object modelElement, ModuleElement ast) throws EolRuntimeException {
		return super.getConstraint(constraintName, contextName, null, ast);
	}
	
	@Override
	public IEvlContextParallel getContext() {
		return (IEvlContextParallel) super.getContext();
	}
	
	/**
	 * Should be used to obtain the execution context while executing in parallel.
	 * 
	 * @return A ThreadLocal copy of {@link #getContext()}.
	 */
	protected IEvlContext getShadowContext() {
		assert getContext().isParallel() : "Shadow context should only be obtained during parallel execution!";
		return concurrentContexts.get();
	}
	
	/**
	 * WARNING: This method should only be called by the DT plugin for initialisation purposes,
	 * as the context will be reset!
	 */
	@Override
	public void configure(Map<String, ?> properties) throws IllegalArgumentException {
		super.configure(properties);
		setContext(IEolContextParallel.configureContext(
			properties,
			EvlContextParallel::new,
			getContext()
		));
	}
}
