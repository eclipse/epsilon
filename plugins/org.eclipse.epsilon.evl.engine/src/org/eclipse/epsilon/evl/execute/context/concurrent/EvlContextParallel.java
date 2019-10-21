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

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.PersistentThreadLocal;
import org.eclipse.epsilon.erl.execute.context.concurrent.ErlContextParallel;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EvlContextParallel extends ErlContextParallel implements IEvlContextParallel {

	protected PersistentThreadLocal<Collection<UnsatisfiedConstraint>> concurrentUnsatisfiedConstraints;
	protected Set<UnsatisfiedConstraint> unsatisfiedConstraints;
	protected ConstraintTrace constraintTrace;
	protected boolean optimizeConstraintTrace = false;
	protected boolean shortCircuiting = false;
	protected boolean terminate = false;
	
	public EvlContextParallel() {
		this(0);
	}

	/**
	 * @param parallelism The number of threads to use.
	 * @param threadSafeBaseFrames whether the base FrameStack should use a thread-safe collection.
	 * default is <code>true</code>
	 */
	public EvlContextParallel(int parallelism) {
		super(parallelism);
	}
	
	@Override
	protected void initMainThreadStructures() {
		super.initMainThreadStructures();
		constraintTrace = new ConstraintTrace(true);
		unsatisfiedConstraints = new HashSet<>(0);
	}
	
	@Override
	protected void initThreadLocals() {
		super.initThreadLocals();
		concurrentUnsatisfiedConstraints = new PersistentThreadLocal<>(getParallelism(), ArrayDeque::new);
	}
	
	@Override
	protected synchronized void clearThreadLocals() {
		super.clearThreadLocals();
		if (concurrentUnsatisfiedConstraints == null) return;
		
		if (unsatisfiedConstraints == null) {
			unsatisfiedConstraints = new HashSet<>();
		}
		concurrentUnsatisfiedConstraints.getAll().forEach(unsatisfiedConstraints::addAll);
		concurrentUnsatisfiedConstraints.removeAll();
		concurrentUnsatisfiedConstraints = null;
	}
	
	@Override
	public Collection<UnsatisfiedConstraint> getUnsatisfiedConstraints() {
		return parallelGet(concurrentUnsatisfiedConstraints, unsatisfiedConstraints);
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

	@Override
	public boolean isShortCircuiting() {
		return shortCircuiting;
	}

	@Override
	public void setShortCircuit(boolean shortCircuit) {
		this.shortCircuiting = shortCircuit;
	}

	@Override
	public boolean shouldShortCircuit(Constraint constraint) throws EolRuntimeException {
		if (!terminate) {
			terminate = IEvlContextParallel.super.shouldShortCircuit(constraint);
		}
		return terminate;
	}
	
	@Override
	public IEvlModule getModule() {
		return (IEvlModule) super.getModule();
	}
}