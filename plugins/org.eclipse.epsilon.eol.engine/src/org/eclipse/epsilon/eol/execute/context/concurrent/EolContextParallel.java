/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.context.concurrent;

import java.util.function.Supplier;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.concurrent.ConcurrentBaseDelegate;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolThreadPoolExecutor;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.eol.execute.concurrent.DelegatePersistentThreadLocal;
import org.eclipse.epsilon.eol.execute.concurrent.PersistentThreadLocal;

/**
 * Skeletal implementation of a parallel IEolContext. This class takes care of
 * the common structures which are affected by multi-threading using
 * {@linkplain ThreadLocal}s. For use cases where these thread-local values are
 * required, a {@linkplain DelegatePersistentThreadLocal} is used, so that the
 * context will be consistent with a sequential implementation once
 * {@linkplain #endParallel()} is invoked. The default behaviour of this class is
 * to NOT persist thread-local values to improve performance and save memory.
 * 
 * @author Sina Madani
 */
public class EolContextParallel extends EolContext implements IEolContextParallel {

	protected int numThreads, nestLevel;
	protected boolean isParallel = false;
	protected final boolean isPersistent;
	protected EolExecutorService executorService;
	
	// Data strcutures which will be written to and read from during parallel execution:
	protected ThreadLocal<FrameStack> concurrentFrameStacks;
	protected ThreadLocal<OperationContributorRegistry> concurrentMethodContributors;
	protected ThreadLocal<ExecutorFactory> concurrentExecutors;
	
	public EolContextParallel() {
		this(0);
	}

	public EolContextParallel(int parallelism) {
		this(parallelism, false);
	}
	
	/**
	 * @param parallelism The number of threads to use.
	 * @param persistThreadLocals Whether to save the state of thread-local values
	 * (such as variable declarations) so that they can be merged into the main thread later.
	 */
	public EolContextParallel(int parallelism, boolean persistThreadLocals) {
		setNumThreads(parallelism);
		initMainThreadStructures();
		this.isPersistent = persistThreadLocals;
	}

	public EolContextParallel(IEolContext other) {
		this(other, false);
	}
	
	/**
	 * Copy constructor.
	 * NOTE: The context parameter may be modified.
	 * 
	 * @param other The context to copy from. Structures
	 * in this parameter may be modified to be thread-safe.
	 * @param parallelism The number of threads to use.
	 * @param persistThreadLocals Whether to save the state of thread-local values
	 * (such as variable declarations) so that they can be merged into the main thread later.
	 */
	public EolContextParallel(IEolContext other, boolean persistThreadLocals) {
		super(other);
		setBaseThreadSafety(true);
		this.isPersistent = persistThreadLocals;
		
		IEolContextParallel otherParallel = other instanceof IEolContextParallel ?
			(IEolContextParallel) other : null;
		
		if (otherParallel != null) {
			setNumThreads(otherParallel.getParallelism());
			this.nestLevel = otherParallel.getNestedParallelism();
		}
		else {
			setNumThreads(0);
		}
	}
	
	protected int setNumThreads(int parallelism) {
		return (numThreads = parallelism > 0 ? parallelism : ConcurrencyUtils.DEFAULT_PARALLELISM);
	}
	
	protected void initMainThreadStructures() {
		// This will be the "base" of others, so make it thread-safe for concurrent reads
		frameStack = new FrameStack(null, true);
		executorFactory = new ExecutorFactory(null, true);
	}
	
	protected void initThreadLocals() {
		concurrentFrameStacks = initDelegateThreadLocal(() -> new FrameStack(frameStack, false));
		concurrentMethodContributors = initThreadLocal(OperationContributorRegistry::new);
		concurrentExecutors = initDelegateThreadLocal(() -> new ExecutorFactory(executorFactory, false));
	}
	
	protected <T extends ConcurrentBaseDelegate<T>> ThreadLocal<T> initDelegateThreadLocal(Supplier<? extends T> constructor) {
		return isPersistent ?
			new DelegatePersistentThreadLocal<>(numThreads, constructor) :
			ThreadLocal.withInitial(constructor);
	}
	
	protected <T> ThreadLocal<T> initThreadLocal(Supplier<? extends T> constructor) {
		return isPersistent ?
			new PersistentThreadLocal<>(numThreads, constructor) :
			ThreadLocal.withInitial(constructor);
	}
	
	protected void setBaseThreadSafety(boolean concurrent) {
		frameStack.setThreadSafe(concurrent);
		executorFactory.setThreadSafe(concurrent);
	}
	
	protected static void removeAllIfPersistent(ThreadLocal<?> threadLocal) {
		if (threadLocal instanceof PersistentThreadLocal) {
			((PersistentThreadLocal<?>) threadLocal).removeAll();
		}
	}
	
	@Override
	protected void finalize() {
		if (executorService != null) {
			executorService.shutdownNow();
			executorService = null;
		}
	}
	
	@Override
	public void goParallel() {
		if (!isParallel) {
			initThreadLocals();
			isParallel = true;
		}
	}
	
	@Override
	public void endParallel() {
		isParallel = false;
		
		finalize();
		
		removeAllIfPersistent(concurrentFrameStacks);
		concurrentFrameStacks = null;
		removeAllIfPersistent(concurrentMethodContributors);
		concurrentMethodContributors = null;
		removeAllIfPersistent(concurrentExecutors);
		concurrentExecutors = null;
	}
	
	public boolean isPersistent() {
		return isPersistent;
	}
	
	@Override
	public final boolean isParallel() {
		return isParallel;
	}
	
	@Override
	public final int getParallelism() {
		return numThreads;
	}
	
	@Override
	public void enterParallelNest(ModuleElement entryPoint) throws EolNestedParallelismException {
		if (++nestLevel > PARALLEL_NEST_THRESHOLD) {
			throw new EolNestedParallelismException(entryPoint);
		}
	}

	@Override
	public void exitParallelNest(ModuleElement entryPoint) {
		if (nestLevel > 0)
			nestLevel--;
	}

	@Override
	public int getNestedParallelism() {
		return nestLevel;
	}
	
	@Override
	public EolExecutorService newExecutorService() {
		return EolThreadPoolExecutor.fixedPoolExecutor(numThreads);
	}
	
	@Override
	public EolExecutorService getExecutorService() {
		if (executorService == null) {
			executorService = newExecutorService();
		}
		return executorService;
	}
	
	@Override
	public FrameStack getFrameStack() {
		return parallelGet(concurrentFrameStacks, super::getFrameStack);
	}
	
	@Override
	public void setFrameStack(FrameStack frameStack) {
		parallelSet(frameStack, concurrentFrameStacks, super::setFrameStack);
	}
	
	@Override
	public ExecutorFactory getExecutorFactory() {
		return parallelGet(concurrentExecutors, super::getExecutorFactory);
	}

	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		parallelSet(executorFactory, concurrentExecutors, super::setExecutorFactory);
	}
	
	@Override
	public OperationContributorRegistry getOperationContributorRegistry() {
		return parallelGet(concurrentMethodContributors, super::getOperationContributorRegistry);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [parallelism="+getParallelism()+']';
	}
	
	public static IEolContextParallel convertToParallel(IEolContext context) throws EolNestedParallelismException {
		//if (context instanceof IEolContextParallel) return (IEolContextParallel) context;
		return IEolContextParallel.copyToParallel(context, EolContextParallel::new);
	}
}
