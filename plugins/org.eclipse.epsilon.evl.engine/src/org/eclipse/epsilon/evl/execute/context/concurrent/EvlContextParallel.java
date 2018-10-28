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

import java.util.HashSet;
import java.util.Set;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.eol.execute.concurrent.PersistentThreadLocal;
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

	protected PersistentThreadLocal<Set<UnsatisfiedConstraint>> concurrentUnsatisfiedConstraints;
	protected Set<UnsatisfiedConstraint> unsatisfiedConstraints;
	protected ConstraintTrace constraintTrace;
	protected Set<Constraint> constraintsDependedOn;
	protected boolean optimizeConstraintTrace = false;
	
	public EvlContextParallel() {
		this(0, true);
	}
	
	public EvlContextParallel(IEvlContext other) {
		super(other, true);
	}
	
	public EvlContextParallel(int parallelism) {
		this(parallelism, true);
	}
	
	/**
	 * @param parallelism The number of threads to use.
	 * @param threadSafeBaseFrames whether the base FrameStack should use a thread-safe collection.
	 * default is <code>true</code>
	 */
	public EvlContextParallel(int parallelism, boolean threadSafeBaseFrames) {
		super(parallelism, true);
		frameStack = new FrameStack(null, threadSafeBaseFrames);
	}
	
	@Override
	protected void initMainThreadStructures() {
		super.initMainThreadStructures();

		// Make results data structures thread-safe
		constraintTrace = new ConstraintTrace(true);
		
		// No writes will be made to the base UnsatisfiedConstraints until the end, so make it empty
		unsatisfiedConstraints = new HashSet<>(0);
	}
	
	@Override
	protected void initThreadLocals() {
		super.initThreadLocals();	
		// Since no writes will be made to unsatisfiedConstraints during parallel execution, we don't need a BaseDelegate here.
		concurrentUnsatisfiedConstraints = new PersistentThreadLocal<>(numThreads, HashSet::new);
	}
	
	@Override
	public void endParallel() {
		super.endParallel();
		concurrentUnsatisfiedConstraints.getAll().forEach(unsatisfiedConstraints::addAll);
	}

	@Override
	public EvlModuleParallel getModule() {
		return (EvlModuleParallel) module;
	}
	
	@Override
	public Set<UnsatisfiedConstraint> getUnsatisfiedConstraints() {
		return parallelGet(concurrentUnsatisfiedConstraints, () -> unsatisfiedConstraints);
	}
	
	@Override
	public ConstraintTrace getConstraintTrace() {
		return constraintTrace;
	}
	
	public static IEvlContextParallel convertToParallel(IEvlContext context) throws EolNestedParallelismException {
		if (context instanceof IEvlContextParallel) return (IEvlContextParallel) context;
		return IEolContextParallel.copyToParallel(context, EvlContextParallel::new);
	}

	@Override
	public void setOptimizeConstraintTrace(boolean optimize) {
		this.optimizeConstraintTrace = optimize;
	}

	@Override
	public boolean isOptimizeConstraintTrace() {
		return optimizeConstraintTrace;
	}
}