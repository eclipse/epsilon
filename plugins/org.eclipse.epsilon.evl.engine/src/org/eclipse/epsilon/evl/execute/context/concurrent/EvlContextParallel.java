/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.evl.execute.context.concurrent;

import java.util.Set;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.erl.execute.context.concurrent.ErlContextParallel;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.execute.context.IEvlContext;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlContextParallel extends ErlContextParallel implements IEvlContextParallel {

	protected Set<UnsatisfiedConstraint> unsatisfiedConstraints;
	protected ConstraintTrace constraintTrace;
	protected boolean optimizeConstraintTrace = false;
	protected boolean shortCircuit = false;
	protected /*volatile*/ boolean terminate = false;
	
	public EvlContextParallel() {
		this(0);
	}
	
	public EvlContextParallel(IEvlContext other) {
		super(other, true);
	}
	
	/**
	 * @param parallelism The number of threads to use.
	 * @param threadSafeBaseFrames whether the base FrameStack should use a thread-safe collection.
	 * default is <code>true</code>
	 */
	public EvlContextParallel(int parallelism) {
		super(parallelism, true);
	}
	
	@Override
	protected void initMainThreadStructures() {
		super.initMainThreadStructures();
		constraintTrace = new ConstraintTrace(true);
		unsatisfiedConstraints = ConcurrencyUtils.concurrentSet(64, numThreads);
	}
	
	@Override
	public void setModule(IModule module) {
		if (module instanceof EvlModuleParallel) {
			super.setModule(module);
		}
	}
	
	@Override
	public EvlModuleParallel getModule() {
		return (EvlModuleParallel) super.getModule();
	}
	
	@Override
	public Set<UnsatisfiedConstraint> getUnsatisfiedConstraints() {
		return unsatisfiedConstraints;
	}

	@Override
	public ConstraintTrace getConstraintTrace() {
		return constraintTrace;
	}

	@Override
	public void setOptimizeConstraintTrace(boolean optimize) {
		this.optimizeConstraintTrace = optimize;
	}

	@Override
	public boolean isOptimizeConstraintTrace() {
		return optimizeConstraintTrace;
	}
	
	public static IEvlContextParallel convertToParallel(IEvlContext context) throws EolNestedParallelismException {
		if (context instanceof IEvlContextParallel) {
			IEvlContextParallel pContext = (IEvlContextParallel) context;
			if (!pContext.isParallel()) pContext.goParallel();
			return pContext;
		}
		return IEolContextParallel.copyToParallel(context, EvlContextParallel::new);
	}

	@Override
	public boolean isShortCircuiting() {
		return shortCircuit;
	}

	@Override
	public void setShortCircuit(boolean shortCircuit) {
		this.shortCircuit = shortCircuit;
	}

	@Override
	public boolean shouldShortCircuit(Constraint constraint) throws EolRuntimeException {
		if (!terminate) {
			terminate = IEvlContextParallel.super.shouldShortCircuit(constraint);
		}
		return terminate;
	}
}