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

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.concurrent.ConcurrentBaseDelegate;
import org.eclipse.epsilon.common.function.BaseDelegate.MergeMode;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolThreadPoolExecutor;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
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
 * @since 1.6
 */
public class EolContextParallel extends EolContext implements IEolContextParallel {

	int numThreads;
	protected boolean isInParallelTask, isInShortCircuitTask;
	protected EolThreadPoolExecutor executorService;
	
	// Data structures which will be written to and read from during parallel execution:
	protected ThreadLocal<FrameStack> concurrentFrameStacks;
	protected ThreadLocal<OperationContributorRegistry> concurrentMethodContributors;
	protected ThreadLocal<ExecutorFactory> concurrentExecutorFactories;
	
	public EolContextParallel() {
		this(0);
	}
	
	/**
	 * @param parallelism The number of threads to use.
	 * @param persistThreadLocals Whether to save the state of thread-local values
	 * (such as variable declarations) so that they can be merged into the main thread later.
	 */
	public EolContextParallel(int parallelism) {
		numThreads = parallelism > 0 ? parallelism : ConcurrencyUtils.DEFAULT_PARALLELISM;
		initMainThreadStructures();
	}
	
	/**
	 * Copy constructor.
	 * NOTE: The context parameter may be modified.
	 * 
	 * @param other The context to copy from. Structures
	 * in this parameter may be modified to be thread-safe.
	 */
	public EolContextParallel(IEolContext other) {
		super(other);
		frameStack.setThreadSafe(true);
		executorFactory.setThreadSafe(true);
		
		if (other instanceof IEolContextParallel) {
			numThreads = ((IEolContextParallel) other).getParallelism();
		}
		else {
			numThreads = ConcurrencyUtils.DEFAULT_PARALLELISM;
		}
	}
	
	protected void initMainThreadStructures() {
		// This will be the "base" of others, so make it thread-safe for concurrent reads
		frameStack = new FrameStack(null, true);
		executorFactory = new ExecutorFactory(null, true);
	}
	
	protected void initThreadLocals() {
		concurrentMethodContributors = ThreadLocal.withInitial(OperationContributorRegistry::new);
		concurrentFrameStacks = initDelegateThreadLocal(() -> new FrameStack(frameStack, false));
		concurrentExecutorFactories = initDelegateThreadLocal(() -> new ExecutorFactory(executorFactory, false));
	}
	
	protected <T extends ConcurrentBaseDelegate<T>> DelegatePersistentThreadLocal<T> initDelegateThreadLocal(Supplier<? extends T> constructor) {
		return new DelegatePersistentThreadLocal<>(numThreads, constructor);
	}
	
	/**
	 * Determines whether calling {@link #parallelGet(ThreadLocal, Object)} or
	 * {@link #parallelSet(Object, ThreadLocal, Consumer)} should use the ThreadLocal
	 * value or if the alternative value should be returned.
	 * 
	 * @return <code>true</code> if the ThreadLocal should be used, <code>false</code> otherwise.
	 */
	protected boolean useThreadLocalValue() {
		return !ConcurrencyUtils.isTopLevelThread();
	}
	
	/**
	 * Utility method used to appropriately return either a thread-local or the original value,
	 * depending on whether this context {@linkplain #isParallel()}.
	 * 
	 * @param <R> The value type
	 * @param threadLocal The ThreadLocal value (returned if parallel).
	 * @param originalValueGetter The non-thread-local value (returned if not parallel).
	 * @return The appropriate value for the current thread.
	 */
	protected final <R> R parallelGet(ThreadLocal<? extends R> threadLocal, Supplier<? extends R> originalValueGetter) {
		return threadLocal != null && useThreadLocalValue() ? threadLocal.get() : originalValueGetter.get();
	}
	
	/**
	 * Utility method used to appropriately return either a thread-local or the original value,
	 * depending on whether this context {@linkplain #isParallel()}.
	 * 
	 * @param <R> The value type
	 * @param threadLocal The thread-local wrapper for the value
	 * @param originalValue The main, persistent variable
	 * @return The appropriate value for the current thread.
	 */
	protected final <R> R parallelGet(ThreadLocal<? extends R> threadLocal, R originalValue) {
		return threadLocal != null && useThreadLocalValue() ? threadLocal.get() : originalValue;
	}
	
	/**
	 * Utility method used to appropriately set either a thread-local or the original value,
	 * depending on whether this context {@linkplain #isParallel()}.
	 * @param value The value to set.
	 * @param threadLocal The ThreadLocal value (will be set if parallel).
	 * @param originalValueSetter The non-thread-local value (will be set if not parallel).
	 */
	protected final <T> void parallelSet(T value, ThreadLocal<? super T> threadLocal, Consumer<? super T> originalValueSetter) {
		if (threadLocal != null && useThreadLocalValue())
			threadLocal.set(value);
		else
			originalValueSetter.accept(value);
	}
	
	public static IEolContextParallel convertToParallel(IEolContext context) throws EolNestedParallelismException {
		if (context instanceof IEolContextParallel) return (IEolContextParallel) context;
		return new EolContextParallel(context);
	}
	
	protected void removeAll(ThreadLocal<?>... threadLocals) {
		if (threadLocals != null) for (ThreadLocal<?> tl : threadLocals) {
			if (tl instanceof DelegatePersistentThreadLocal && !isInShortCircuitTask) {
				((DelegatePersistentThreadLocal<?>) tl).removeAll(MergeMode.MERGE_INTO_BASE);
			}
			else if (tl instanceof PersistentThreadLocal) {
				((PersistentThreadLocal<?>) tl).removeAll();
			}
			else if (tl != null) {
				tl.remove();
			}
		}
	}
	
	protected void clearThreadLocals() {
		removeAll(concurrentFrameStacks, concurrentExecutorFactories, concurrentMethodContributors);
	}
	
	protected void nullifyThreadLocals() {
		concurrentFrameStacks = null;
		concurrentExecutorFactories = null;
		concurrentMethodContributors = null;
	}
	
	protected void clearExecutor() {
		if (executorService != null) {
			executorService.shutdownNow();
			executorService = null;
		}
	}
	
	protected EolThreadPoolExecutor newExecutorService() {
		return new EolThreadPoolExecutor(numThreads);
	}
	
	@Override
	public EolExecutorService beginParallelTask(ModuleElement entryPoint, boolean shortCircuiting) throws EolNestedParallelismException {
		ensureNotNested(entryPoint != null ? entryPoint : getModule());
		isInShortCircuitTask = shortCircuiting;
		initThreadLocals();
		EolExecutorService executor = getExecutorService();
		assert executor != null && !executor.isShutdown();
		if (!executor.getExecutionStatus().register()) {
			throw new EolNestedParallelismException(entryPoint);
		}
		isInParallelTask = true;
		return executor;
	}
	
	@Override
	public Object endParallelTask() throws EolRuntimeException {
		Object result = IEolContextParallel.super.endParallelTask();
		if (isInShortCircuitTask) {
			clearExecutor();
		}
		clearThreadLocals();
		isInParallelTask = false;
		isInShortCircuitTask = false;
		return result;
	}
	
	public boolean isInShortCircuitingTask() {
		return isInShortCircuitTask;
	}
	
	@Override
	public void setParallelism(int threads) throws IllegalStateException, IllegalArgumentException {
		if (threads != this.numThreads) {
			if (isInParallelTask) {
				throw new IllegalStateException("Cannot change parallelism whilst execution is in progress!");
			}
			if (threads <= 0) {
				throw new IllegalArgumentException("Parallelism of "+threads+" is nonsensical!");
			}
			this.numThreads = threads;
		}
	}
	
	@Override
	public boolean isParallel() {
		return isInParallelTask;
	}
	
	@Override
	public final int getParallelism() {
		return numThreads;
	}
	
	@Override
	public final EolExecutorService getExecutorService() {
		if (executorService == null) {
			executorService = newExecutorService();
		}
		return executorService;
	}
	
	@Override
	protected void finalize() {
		clearExecutor();
	}
	
	@Override
	public void dispose() {
		super.dispose();
		clearExecutor();
		nullifyThreadLocals();
	}
	
	@Override
	public FrameStack getFrameStack() {
		return parallelGet(concurrentFrameStacks, frameStack);
	}
	
	@Override
	public void setFrameStack(FrameStack frameStack) {
		parallelSet(frameStack, concurrentFrameStacks, super::setFrameStack);
	}
	
	@Override
	public ExecutorFactory getExecutorFactory() {
		return parallelGet(concurrentExecutorFactories, executorFactory);
	}

	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		parallelSet(executorFactory, concurrentExecutorFactories, super::setExecutorFactory);
	}
	
	@Override
	public OperationContributorRegistry getOperationContributorRegistry() {
		return parallelGet(concurrentMethodContributors, methodContributorRegistry);
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [parallelism="+getParallelism()+']';
	}
}
