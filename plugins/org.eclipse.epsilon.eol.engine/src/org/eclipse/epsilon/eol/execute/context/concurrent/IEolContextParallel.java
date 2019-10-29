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
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

/**
 * Thread-safe IEolContext, offering utilities for parallel execution.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public interface IEolContextParallel extends IEolContext {
	
	/**
	 * The key used for configuring the parallelism in dt plugins.
	 */
	static final String NUM_THREADS_CONFIG = "parallelism";
	
	/**
	 * Indicates the scalability of this Context when more processing nodes are added.
	 * 
	 * @return the number of threads.
	 */
	int getParallelism();
	
	/**
	 * Attempts to set the parallelism of this context and its associated executor.
	 * Note that this may not take effect immediately and is intended to be called during parallel
	 * execution. Implementations may ignore this operation or throw an {@linkplain UnsupportedOperationException}.
	 * It is recommended that this method is only called during initialisation, and is present for convenience only.
	 * 
	 * @param parallelism The new value. Must be positive.
	 * @throws UnsupportedOperationException If this context (or its ExecutorService) has an immutable parallelism.
	 * @throws IllegalStateException If this method is called at an inconvenient time.
	 * @throws IllegalArgumentException If the new value is out of bounds.
	 */
	void setParallelism(int parallelism) throws UnsupportedOperationException, IllegalStateException, IllegalArgumentException;
	
	/**
	 * This method will return true if {@link #beginParallelTask()} has been called
	 * and false if {@link #endParallelTask()} has been called, or if {@link #beginParallelTask()}
	 * has not been called yet.
	 * 
	 * @return Whether this Context is currently executing in parallel mode.
	 */
	boolean isParallel();
	
	/**
	 * A re-usable ExecutorService.
	 * @return a cached {@link ExecutorService}.
	 */
	ExecutorService getExecutorService();

	/**
	 * Convenience method for testing whether to perform an operation in parallel using
	 * this context without encountering an {@link EolNestedParallelismException}.
	 * 
	 * @return <code>true</code> if calling {@link #enterParallelNest(ModuleElement)} is permitted.
	 */
	default boolean isParallelisationLegal() {
		return !isParallel();
	}
	
	/**
	 * This method should be called prior to performing any parallel execution.
	 * 
	 * @param entryPoint The module element to use as the cause of an exception
	 * @throws EolNestedParallelismException If {@link #isParallelisationLegal(Object)} returns false
	 */
	default void ensureNotNested(ModuleElement entryPoint) throws EolNestedParallelismException {
		if (!isParallelisationLegal())
			throw new EolNestedParallelismException(entryPoint);
	}
	
	/**
	 * Registers the beginning of parallel task on the default ExecutorService.
	 * The {@link #endParallelTask()} method must be called once finished.
	 * 
	 * @param entryPoint The AST to associate with this task. May be null, in which
	 * case a default value (e.g. {@linkplain #getModule()}) should be used.
	 * @param shortCircuiting Whether the task may be terminated abruptly.
	 * @return {@link #getExecutorService()}
	 * @throws EolNestedParallelismException If there was already a parallel task in progress.
	 */
	default ExecutorService beginParallelTask(ModuleElement entryPoint, boolean shortCircuiting) throws EolNestedParallelismException {
		ensureNotNested(entryPoint != null ? entryPoint : getModule());
		ExecutorService executor = getExecutorService();
		assert executor != null && !executor.isShutdown();
		return executor;
	}
	
	/**
	 * Registers the beginning of parallel task on the default ExecutorService.
	 * The {@link #endParallelTask()} method must be called once finished.
	 * 
	 * @param entryPoint The AST to associate with this task. May be null, in which
	 * case a default value (e.g. {@linkplain #getModule()}) should be used.
	 * @return {@link #getExecutorService()}
	 * @throws EolNestedParallelismException If there was already a parallel task in progress.
	 */
	default ExecutorService beginParallelTask(ModuleElement entryPoint) throws EolNestedParallelismException {
		return beginParallelTask(entryPoint, false);
	}
	
	/**
	 * Must be called once parallel processing has finished.
	 * 
	 * @see #beginParallelTask(ModuleElement)
	 * @throws EolRuntimeException if the status completed exceptionally.
	 * @throws IllegalStateException if the current job is still executing.
	 */
	void endParallelTask() throws EolRuntimeException;
	
	/**
	 * Executes all of the tasks in parallel, blocking until they have completed.
	 * The returned Collection is ordered based on the same ordering of the input Collection.
	 * 
	 * @param <T> The return type for each job.
	 * @param entryPoint The identifier for this parallel task.
	 * @param jobs The transformations to perform.
	 * @return The result of the jobs in encounter order.
	 * @throws EolRuntimeException If any of the jobs fail (i.e. throw an exception).
	 */
	default <T> Collection<T> executeParallel(ModuleElement entryPoint, Collection<? extends Callable<? extends T>> jobs) throws EolRuntimeException {
		final ExecutorService executor = beginParallelTask(entryPoint);
		Collection<T> results;
		try {
			results = new ArrayList<>(jobs.size());
			for (Future<? extends T> future : executor.invokeAll(jobs)) {
				results.add(future.get());
			}
		}
		catch (InterruptedException | ExecutionException ex) {
			EolRuntimeException.propagateDetailed(ex);
			assert false : "This should never be reached";
			results = null;
		}
		endParallelTask();
		return results;
	}
	
	/**
	 * Submits all jobs and waits until either all jobs have completed, or 
	 * {@link #completeShortCircuit(ModuleElement, Object)} is called.
	 * 
	 * @param <T> The return type of each job.
	 * @param entryPoint The identifier for this parallel task.
	 * @param jobs The jobs to execute.
	 * @return The result of this task, as set by {@linkplain #completeShortCircuit(ModuleElement, Object)}, if any.
	 * @throws EolRuntimeException If any of the jobs fail (i.e. throw an exception).
	 */
	default <T> T shortCircuit(ModuleElement entryPoint, Collection<? extends Callable<? extends T>> jobs) throws EolRuntimeException {
		final ExecutorService executor = beginParallelTask(entryPoint, true);
		T result;
		try {
			result = executor.invokeAny(jobs);
		}
		catch (InterruptedException | ExecutionException ex) {
			EolRuntimeException.propagateDetailed(ex);
			assert false : "This should never be reached";
			result = null;
		}
		endParallelTask();
		return result;
	}

	/**
	 * Evaluates the job using this context's parallel execution facilities.
	 * Implementations may override this to support additional job types, calling
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
	default Object executeJob(Object job) throws EolRuntimeException {
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
				return executeParallel(jobs);
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
		if (job instanceof Iterator) {
			Iterable<?> iter = () -> (Iterator<Object>) job;
			return executeJob(iter);
		}
		if (job instanceof Spliterator) {
			return executeJob(StreamSupport.stream((Spliterator<?>) job, isParallelisationLegal()));
		}
		if (job instanceof Supplier) {
			return ((Supplier<?>) job).get();
		}
		try {
			if (job instanceof Future) {
				return ((Future<?>) job).get();
			}
			else if (job instanceof Callable) {
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
	
	/**
	 * Convenience method for setting the parallelism on a context.
	 * @param properties The parameter passed to the configure method of the module.
	 * @param contextConstructor The function which creates a parallel context from a given number of threads.
	 * @param currentContext The existing context to return, if no changes are made.
	 * @return The new context if {@link #NUM_THREADS_CONFIG} is present in the properties, otherwise currentContext.
	 * @throws IllegalArgumentException If the value of {@link #NUM_THREADS_CONFIG} property is invalid.
	 */
	static <C extends IEolContextParallel> C configureContext(Map<String, ?> properties, Function<Integer, ? extends C> contextConstructor, C currentContext) throws IllegalArgumentException {
		if (properties.containsKey(NUM_THREADS_CONFIG)) {
			int parallelism = Integer.valueOf(Objects.toString((properties.get(NUM_THREADS_CONFIG))));
			if (parallelism < 1) throw new IllegalArgumentException("Parallelism must be at least 1!");
			return contextConstructor.apply(parallelism);
		}
		return currentContext;
	}
	
	// No entryPoint defaults
	
	default ExecutorService beginParallelTask() throws EolNestedParallelismException {
		return beginParallelTask(null);
	}
	default <T> Collection<T> executeParallel(Collection<? extends Callable<? extends T>> jobs) throws EolRuntimeException {
		return executeParallel(null, jobs);
	}
	default <T> T shortCircuit(Collection<? extends Callable<? extends T>> jobs) throws EolRuntimeException {
		return shortCircuit(null, jobs);
	}
}
