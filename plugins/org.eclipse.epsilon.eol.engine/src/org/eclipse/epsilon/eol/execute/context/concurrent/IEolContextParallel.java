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
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import org.eclipse.epsilon.common.concurrent.ConcurrencyUtils;
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
 */
public interface IEolContextParallel extends IEolContext {
	
	/**
	 * Maximum supported level of parallel nesting.
	 */
	static final int PARALLEL_NEST_THRESHOLD = 1;
	
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
	
	/**
	 * This method is used to signal nesting of parallel jobs. This method records
	 * the beginning of a nesting level associated with a module element.
	 * 
	 * @param entryPoint The module element which started this parallelism nesting.
	 * @throws EolNestedParallelismException if the maximum supported nesting level is exceeded.
	 * @see #exitParallelNest()
	 */
	void enterParallelNest(ModuleElement entryPoint) throws EolNestedParallelismException;
	
	/**
	 * Leaves the parallel nest. Typical implementations will simply
	 * decrement the nest count as returned by {@link #getNestedParallelism()}.
	 * 
	 * @see #enterParallelNest(ModuleElement)
	 */
	void exitParallelNest(ModuleElement entryPoint);
	
	/**
	 * Indicates how many layers of nesting is present in this context. This is a convenience
	 * method for keeping track of the number of times {@linkplain #enterParallelNest(ModuleElement)}
	 * has been called in a row without subsequent calls to {@linkplain #exitParallelNest(ModuleElement)}.
	 * 
	 * @return The maximum number of nested parallel jobs.
	 * @see #enterParallelNest(ModuleElement)
	 */
	int getNestedParallelism();
	
	//Convenience methods
	
	/**
	 * Registers the beginning of parallel job on the default EolExecutorService.
	 * @param entryPoint The AST to associate with this job.
	 * @return {@link #getExecutorService()}
	 * @throws EolNestedParallelismException If there was already a parallel job in progress.
	 */
	default EolExecutorService beginParallelJob(ModuleElement entryPoint) throws EolNestedParallelismException {
		EolExecutorService executor = getExecutorService();
		enterParallelNest(entryPoint);
		executor.getExecutionStatus().register(entryPoint);
		return executor;
	}
	
	default Object endParallelJob(ModuleElement entryPoint) {
		exitParallelNest(entryPoint);
		ConcurrentExecutionStatus status = getExecutorService().getExecutionStatus();
		if (status.isInProgress(entryPoint)) {
			status.completeSuccessfully(entryPoint);
		}
		return status.getResult(entryPoint);
	}
	
	/**
	 * Executes all of the tasks in parallel, blocking until they have completed.
	 * @param jobs The tasks to execute.
	 * @throws EolRuntimeException If any of the jobs throw an exception.
	 */
	default void executeParallel(ModuleElement entryPoint, Collection<Runnable> jobs) throws EolRuntimeException {
		EolExecutorService executor = getExecutorService();
		enterParallelNest(entryPoint);
		executor.completeAll(jobs);
		exitParallelNest(entryPoint);
	}
	
	default <T> Collection<T> executeParallelTyped(ModuleElement entryPoint, Collection<Callable<T>> jobs) throws EolRuntimeException {
		EolExecutorService executor = getExecutorService();
		enterParallelNest(entryPoint);
		Collection<T> results = executor.collectResults(executor.submitAllTyped(jobs));
		exitParallelNest(entryPoint);
		return results;
	}
	
	default void completeShortCircuit(ModuleElement entryPoint, Object result) {
		getExecutorService().getExecutionStatus().completeSuccessfully(entryPoint, result);
	}
	
	default Object shortCircuit(ModuleElement entryPoint, Collection<Runnable> jobs) throws EolRuntimeException {
		EolExecutorService executor = beginParallelJob(entryPoint);
		Object result = executor.shortCircuitCompletion(entryPoint, executor.submitAll(jobs));
		exitParallelNest(entryPoint);
		return result;
	}
	
	default <T> T shortCircuitTyped(ModuleElement entryPoint, Collection<Callable<T>> jobs) throws EolRuntimeException {
		EolExecutorService executor = beginParallelJob(entryPoint);
		T result = executor.shortCircuitCompletionTyped(entryPoint, executor.submitAllTyped(jobs));
		exitParallelNest(entryPoint);
		return result;
	}
	
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
		if (exception instanceof EolRuntimeException)
			exception.getMessage();
	
		if (executor != null)
			executor.getExecutionStatus().completeExceptionally(exception);
	}
	
	default <R> R parallelGet(ThreadLocal<? extends R> threadLocal, Supplier<? extends R> originalValueGetter) {
		return isParallel() && !ConcurrencyUtils.isMainThread() ? threadLocal.get() : originalValueGetter.get();
	}
	
	default <T> void parallelSet(T value, ThreadLocal<? super T> threadLocal, Consumer<? super T> originalValueSetter) {
		if (isParallel() && !ConcurrencyUtils.isMainThread())
			threadLocal.set(value);
		else
			originalValueSetter.accept(value);
	}
	
	static <C extends IEolContext, P extends IEolContextParallel> P copyToParallel(
			C context, Function<C, ? extends P> parallelConstructor)
			throws EolNestedParallelismException {

		P parallelContext = parallelConstructor.apply(context);
		parallelContext.goParallel();
		return parallelContext;
	}
}
