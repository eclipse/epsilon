package org.eclipse.epsilon.evl.execute.context.concurrent;

import java.util.HashSet;
import java.util.Set;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.erl.execute.concurrent.PersistentThreadLocal;
import org.eclipse.epsilon.erl.execute.concurrent.executors.ErlExecutorService;
import org.eclipse.epsilon.erl.execute.concurrent.executors.ErlThreadPoolExecutor;
import org.eclipse.epsilon.erl.execute.context.concurrent.ErlContextParallel;
import org.eclipse.epsilon.evl.concurrent.EvlModuleParallel;
import org.eclipse.epsilon.evl.dom.Constraint;
import org.eclipse.epsilon.evl.execute.UnsatisfiedConstraint;
import org.eclipse.epsilon.evl.trace.ConstraintTrace;

public class EvlContextParallel extends ErlContextParallel implements IEvlContextParallel {

	protected PersistentThreadLocal<Set<UnsatisfiedConstraint>> concurrentUnsatisfiedConstraints;
	protected Set<UnsatisfiedConstraint> unsatisfiedConstraints;
	protected ConstraintTrace constraintTrace;
	protected Set<Constraint> constraintsDependedOn;
	
	public EvlContextParallel() {
		this(0);
	}

	/**
	 * @param parallelism The number of threads to use.
	 */
	public EvlContextParallel(int parallelism) {
		super(parallelism);
		
		//Make results data structures thread-safe
		constraintsDependedOn = ConcurrencyUtils.concurrentSet(4, numThreads);
		constraintTrace = new ConstraintTrace(true);
		
		//No writes will be made to the base UnsatisfiedConstraints until the end, so make it empty
		unsatisfiedConstraints = new HashSet<>(0);

		//Since no writes will be made to unsatisfiedConstraints during parallel execution, we don't need a BaseDelegate here.
		concurrentUnsatisfiedConstraints = new PersistentThreadLocal<>(numThreads, HashSet::new);
	}
	
	@Override
	public void endParallel() {
		super.endParallel();
		concurrentUnsatisfiedConstraints.getAll().forEach(unsatisfiedConstraints::addAll);
	}
	
	@Override
	public ErlExecutorService getExecutor() {
		return ErlThreadPoolExecutor.fixedPoolExecutor(numThreads);
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