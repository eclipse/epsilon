package org.eclipse.epsilon.evl.execute.context.concurrent;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.concurrent.PersistentThreadLocal;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public class EvlContextParallel extends EolContextParallel implements IEvlContextParallel {

	protected PersistentThreadLocal<Set<UnsatisfiedConstraint>> concurrentUnsatisfiedConstraints;
	protected Set<UnsatisfiedConstraint> unsatisfiedConstraints;
	protected ConstraintTrace constraintTrace;
	protected Set<Constraint> constraintsDependedOn;
	
	public EvlContextParallel() {
		this(0, true);
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
		constraintsDependedOn = ConcurrencyUtils.concurrentSet(4, numThreads);
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
	
	@Override
	public Set<Constraint> getConstraintsDependedOn() {
		return constraintsDependedOn;
	}

	@Override
	public void setConstraintsDependedOn(Set<Constraint> constraints) {
		constraintsDependedOn = constraints;
	}
}