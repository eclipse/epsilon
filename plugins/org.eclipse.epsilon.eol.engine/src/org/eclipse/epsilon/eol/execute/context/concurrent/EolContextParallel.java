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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
import org.eclipse.epsilon.common.function.BaseDelegate;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.contributors.OperationContributorRegistry;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.eol.execute.concurrent.DelegatePersistentThreadLocal;
import org.eclipse.epsilon.eol.execute.concurrent.EolThreadPoolExecutor;
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
public class EolContextParallel extends EolContext implements IEolContextParallel, BaseDelegate<EolContextParallel> {

	int numThreads;
	protected boolean isInParallelTask;
	protected boolean isInShortCircuitTask;
	protected EolThreadPoolExecutor executorService;
	protected EolContextParallel base;
	
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
		// This will be the "base" of others, so make it thread-safe for concurrent reads
		frameStack.setThreadSafe(true);
		asyncStatementsQueue = new ConcurrentLinkedQueue<>();
	}
	
	/**
	 * Copy constructor, intended for optimising access to ThreadLocals and setting the 
	 * provided context as its parent if it is an instance of this class.
	 * 
	 * @param other The parent context to copy from. Must not be null.
	 */
	protected EolContextParallel(IEolContext other) {
		super(other);
		frameStack.setThreadSafe(true);
		
		if (other instanceof EolContextParallel) {
			base = (EolContextParallel) other;
			frameStack = base.getFrameStack();
			executorFactory = base.getExecutorFactory();
		}
		
		if (other instanceof IEolContextParallel) {
			numThreads = ((IEolContextParallel) other).getParallelism();
			isInParallelTask = ((IEolContextParallel) other).isParallel();
		}
		else {
			numThreads = ConcurrencyUtils.DEFAULT_PARALLELISM;
			asyncStatementsQueue = new ConcurrentLinkedQueue<>(other.getAsyncStatementsQueue());
		}
	}
	
	protected void initThreadLocals() {
		concurrentMethodContributors = ThreadLocal.withInitial(OperationContributorRegistry::new);
		concurrentFrameStacks = initDelegateThreadLocal(() -> new FrameStack(frameStack, false));
		concurrentExecutorFactories = initDelegateThreadLocal(() -> new ExecutorFactory(executorFactory));
	}
	
	protected <T extends BaseDelegate<T>> DelegatePersistentThreadLocal<T> initDelegateThreadLocal(Supplier<? extends T> constructor) {
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
		assert (isInParallelTask ^ base != null) || base == null : "Cannot be parallel if has a parent!";
		return isInParallelTask;
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
	
	protected synchronized void clearThreadLocals() {
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
		return base != null ? base.newExecutorService() : new EolThreadPoolExecutor(numThreads);
	}
	
	@Override
	public synchronized ExecutorService beginParallelTask(ModuleElement entryPoint, boolean shortCircuiting) throws EolNestedParallelismException {
		ensureNotNested(entryPoint != null ? entryPoint : getModule());
		isInShortCircuitTask = shortCircuiting;
		initThreadLocals();
		ExecutorService executor = getExecutorService();
		if (executor == null || executor.isShutdown()) {
			executor = this.executorService = newExecutorService();
		}
		isInParallelTask = true;
		return executor;
	}
	
	@Override
	public synchronized void endParallelTask() throws EolRuntimeException {
		if (isInShortCircuitTask) {
			clearExecutor();
		}
		clearThreadLocals();
		isInParallelTask = false;
		isInShortCircuitTask = false;
	}
	
	public boolean isInShortCircuitingTask() {
		return isInShortCircuitTask;
	}
	
	@Override
	public synchronized void setParallelism(int threads) throws IllegalStateException, IllegalArgumentException {
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
	public final EolThreadPoolExecutor getExecutorService() {
		if (base != null) return base.getExecutorService();
		if (executorService == null) synchronized (this) {
			executorService = newExecutorService();
		}
		return executorService;
	}
	
	@Override
	public synchronized void dispose() {
		super.dispose();
		clearExecutor();
		nullifyThreadLocals();
	}
	
	@Override
	public FrameStack getFrameStack() {
		return parallelGet(concurrentFrameStacks, frameStack);
	}
	
	@Override
	public ExecutorFactory getExecutorFactory() {
		return parallelGet(concurrentExecutorFactories, executorFactory);
	}
	
	@Override
	public OperationContributorRegistry getOperationContributorRegistry() {
		return parallelGet(concurrentMethodContributors, methodContributorRegistry);
	}
	
	@Override
	public void setFrameStack(FrameStack frameStack) {
		parallelSet(frameStack, concurrentFrameStacks, fs -> this.frameStack = fs);
	}

	@Override
	public void setExecutorFactory(ExecutorFactory executorFactory) {
		parallelSet(executorFactory, concurrentExecutorFactories, ef -> this.executorFactory = ef);
	}	
	
	@Override
	public String toString() {
		return getClass().getSimpleName()+" [parallelism="+getParallelism()+']';
	}
	
	/**
	 * Evaluates the job using this context's parallel execution facilities.
	 * Subclasses may override this to support additional job types, calling
	 * the super method as the last resort for unknown cases. All implementations
	 * are expected to support Iterable / Collection types, as well as common
	 * concurrency units such as Runnable, Callable and Future.
	 * 
	 * @param job The job (or jobs) to evaluate.
	 * @param isInLoop Whether this method is being called recursively from a loop.
	 * 
	 * @throws IllegalArgumentException If the job type is not recognised.
	 * @throws EolRuntimeException If an exception is thrown whilst evaluating the job(s).
	 * 
	 * @return The result of evaluating the job.
	 */
	@SuppressWarnings("unchecked")
	protected Object executeJob(Object job) throws EolRuntimeException {
		if (job == null) {
			return null;
		}
		if (job instanceof Iterable) {
			final boolean isCollection = job instanceof Collection;
			
			if (isParallelisationLegal()) {
				final Collection<Callable<?>> jobs = isCollection ?
					new ArrayList<>(((Collection<?>) job).size()) : new LinkedList<>();
				
				for (Object next : (Iterable<?>) job) {
					jobs.add(next instanceof Callable ?
						(Callable<?>) next :
						() -> executeJob(next)
					);
				}
				return executeAll(null, jobs);
			}
			else {
				final Collection<Object> results = isCollection ?
					new ArrayList<>(((Collection<?>) job).size()) : new LinkedList<>();
				
				for (Object next : (Iterable<?>) job) {
					results.add(executeJob(next));
				}
				return results;
			}
		}
		if (job instanceof ModuleElement) {
			return getExecutorFactory().execute((ModuleElement) job, this);
		}
		if (job instanceof Stream) {
			Stream<?> stream = (Stream<?>) job;
			boolean finite = stream.spliterator().hasCharacteristics(Spliterator.SIZED);
			return executeJob(finite ? stream.collect(Collectors.toList()) : stream.iterator());
		}
		if (job instanceof BaseStream) {
			return executeJob(((BaseStream<?,?>)job).iterator());
		}
		if (job instanceof Spliterator) {
			return executeJob(StreamSupport.stream((Spliterator<?>) job, isParallelisationLegal()));
		}
		if (job instanceof Iterator) {
			Iterable<?> iter = () -> (Iterator<Object>) job;
			return executeJob(iter);
		}
		if (job instanceof Supplier) {
			return ((Supplier<?>) job).get();
		}
		try {
			if (job instanceof Future) {
				return ((Future<?>) job).get();
			}
			if (job instanceof Callable) {
				return ((Callable<?>) job).call();
			}
		}
		catch (Exception ex) {
			EolRuntimeException.propagateDetailed(ex);
		}
		if (job instanceof Runnable) {
			((Runnable) job).run();
			return null;
		}
			
		throw new IllegalArgumentException("Received unexpected object of type "+job.getClass().getName());
	}
	
	@Override
	public EolContextParallel getBase() {
		return base;
	}

	@Override
	public void merge(MergeMode mode) {
		if (base != null) {
			this.getExecutorFactory().setBase(base.getExecutorFactory());
			this.getFrameStack().setBase(base.getFrameStack());
		}
		getExecutorFactory().merge(mode);
		getFrameStack().merge(mode);
	}
}
