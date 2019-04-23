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

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Function;
import static org.eclipse.epsilon.common.concurrent.ConcurrencyUtils.isTopLevelThread;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;
import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.concurrent.EolNestedParallelismException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolThreadPoolExecutor;
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
	 * This method signals the start of parallel execution. A typical implementation
	 * should initialise thread-local data structures (if not already done so) and
	 * make non-thread-local structures thread-safe. It should also set a flag to
	 * indicate that parallel execution has begun; so that {@linkplain #isParallel()}
	 * returns true.
	 */
	void goParallel();
	
	/**
	 * This method signals the end of parallel execution. A typical implementation
	 * should merge all useful data from thread-local structures into the original
	 * structures, dispose of any variables and structures used during parallel
	 * execution and shutdown the cached EolExecutorService.
	 */
	void endParallel();
	
	/**
	 * This method will typically return true if execution of the associated
	 * {@link IEolModule} has begun, and will return false if execution has ended or not started.
	 * 
	 * @return whether this Context is currently executing in parallel mode.
	 */
	boolean isParallel();
	
	/**
	 * A single-use ExecutorService.
	 * @return a new {@link EolExecutorService}.
	 */
	default EolExecutorService newExecutorService() {
		return EolThreadPoolExecutor.defaultExecutor(getParallelism());
	}
	
	/**
	 * A re-usable ExecutorService.
	 * @return a cached {@link EolExecutorService}.
	 */
	EolExecutorService getExecutorService();
	
	//Convenience methods

	/**
	 * Convenience method for testing whether to perform an operation in parallel using
	 * this context without encountering an {@link EolNestedParallelismException}.
	 * 
	 * @return <code>true</code> if calling {@link #enterParallelNest(ModuleElement)} is permitted.
	 */
	default boolean isParallelisationLegal() {
		return isParallel() && isTopLevelThread();
	}
	
	/**
	 * This method should be called prior to performing any parallel execution.
	 * 
	 * @param entryPoint The module element to use as the cause of an exception
	 * @throws EolNestedParallelismException If {@link #isParallelisationLegal(Object)} returns false
	 */
	default void ensureNotNested(ModuleElement entryPoint) throws EolNestedParallelismException {
		if (!isParallelisationLegal()) throw new EolNestedParallelismException(entryPoint);
		EolExecutorService executor = getExecutorService();
		ConcurrentExecutionStatus status = executor != null ? executor.getExecutionStatus() : null;
		if (status != null && (entryPoint != null ? status.isInProgress(entryPoint) : status.isInProgress()))
			throw new EolNestedParallelismException(entryPoint);
	}
	
	/**
	 * Utility method for dealing with exceptions in lambda expressions / parallel jobs.
	 * @param exception The exception to handle.
	 */
	default void handleException(Exception exception) {
		handleException(exception, getExecutorService());
	}
	
	/**
	 * Caches the Epsilon stack trace and informs the EolExecutorService's
	 * {@linkplain SingleConcurrentExecutionStatus}.
	 * @param exception The exception.
	 * @param executor The ExecutorService which was used to execute the job.
	 */
	default void handleException(Exception exception, EolExecutorService executor) {
		// Cache the Epsilon stack trace
		if (exception instanceof EolRuntimeException) {
			exception.getMessage();
		}
		if (executor != null) {
			ConcurrentExecutionStatus status = executor.getExecutionStatus();
			if (status != null) {
				status.completeExceptionally(exception);
			}
		}
	}

	default EolExecutorService beginParallelTask() throws EolNestedParallelismException {
		return beginParallelTask(null);
	}
	
	/**
	 * Registers the beginning of parallel task on the default EolExecutorService.
	 * @param entryPoint The AST to associate with this task.
	 * @return {@link #getExecutorService()}
	 * @throws EolNestedParallelismException If there was already a parallel task in progress.
	 */
	default EolExecutorService beginParallelTask(ModuleElement entryPoint) throws EolNestedParallelismException {
		if (!isParallel()) throw new IllegalStateException("Should be parallel!");
		ensureNotNested(entryPoint != null ? entryPoint : getModule());
		EolExecutorService executor = getExecutorService();
		if (executor == null || executor.isShutdown()) {
			executor = newExecutorService();
		}
		if (!executor.getExecutionStatus().register()) {
			throw new EolNestedParallelismException(entryPoint);
		}
		return executor;
	}
	
	/**
	 * 
	 * @return The result of the task, if any.
	 */
	default Object endParallelTask() {
		EolExecutorService executor = getExecutorService();
		if (executor != null) {
			ConcurrentExecutionStatus status = executor.getExecutionStatus();
			if (status != null) {
				status.completeSuccessfully();
				return status.getResult();
			}
		}
		return null;
	}
	
	/**
	 * Executes all of the tasks in parallel, blocking until they have completed.
	 * @param jobs The jobs to execute.
	 * @param entryPoint The identifier for this parallel task.
	 * @throws EolRuntimeException If any of the jobs fail (i.e. throw an exception).
	 */
	default void executeParallel(ModuleElement entryPoint, Collection<? extends Runnable> jobs) throws EolRuntimeException {
		EolExecutorService executor = beginParallelTask(entryPoint);
		executor.completeAll(jobs);
		endParallelTask();
	}
	
	/**
	 * Executes all of the tasks in parallel, blocking until they have completed.
	 * @param <T> The return type for each job.
	 * @param entryPoint The identifier for this parallel task.
	 * @param jobs The transformations to perform.
	 * @return The result of the jobs.
	 * @throws EolRuntimeException If any of the jobs fail (i.e. throw an exception).
	 */
	default <T> Collection<T> executeParallelTyped(ModuleElement entryPoint, Collection<Callable<T>> jobs) throws EolRuntimeException {
		EolExecutorService executor = beginParallelTask(entryPoint);
		Collection<T> results = executor.collectResults(executor.submitAllTyped(jobs));
		endParallelTask();
		return results;
	}
	
	/**
	 * Signals the completion of a short-circuitable task.
	 * @param entryPoint The identifier used to initiate the parallel task.
	 * @param result The result of the task, if any.
	 */
	default void completeShortCircuit(ModuleElement entryPoint, Object result) {
		getExecutorService().getExecutionStatus().completeWithResult(result);
	}
	
	/**
	 * Submits all jobs and waits until either all jobs have completed, or 
	 * {@link #completeShortCircuit(ModuleElement, Object)} is called.
	 * 
	 * @param entryPoint The identifier for this parallel task.
	 * @param jobs The jobs to execute.
	 * @return The result of this task, as set by {@linkplain #completeShortCircuit(ModuleElement, Object)}, if any.
	 * @throws EolRuntimeException If any of the jobs fail (i.e. throw an exception).
	 */
	default Object shortCircuit(ModuleElement entryPoint, Collection<? extends Runnable> jobs) throws EolRuntimeException {
		EolExecutorService executor = beginParallelTask(entryPoint);
		Object result = executor.shortCircuitCompletion(executor.submitAll(jobs));
		endParallelTask();
		return result;
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
	@SuppressWarnings("unchecked")
	default <T> T shortCircuitTyped(ModuleElement entryPoint, Collection<Callable<T>> jobs) throws EolRuntimeException {
		EolExecutorService executor = beginParallelTask(entryPoint);
		T result = (T) executor.shortCircuitCompletion(executor.submitAllTyped(jobs));
		endParallelTask();
		return result;
	}
	
	/**
	 * Copies the state of the given context into a new context and calls {@linkplain #goParallel()}.
	 * @param context The source context to copy from.
	 * @param parallelConstructor The copy constructor for the new context.
	 * @return The newly created context.
	 * @throws EolNestedParallelismException
	 */
	static <C extends IEolContext, P extends IEolContextParallel> P copyToParallel(
			C context, Function<C, ? extends P> parallelConstructor)
			throws EolNestedParallelismException {

		P parallelContext = parallelConstructor.apply(context);
		parallelContext.goParallel();
		return parallelContext;
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
}
