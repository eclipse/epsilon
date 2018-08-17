/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.concurrent.executors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

/**
 * Convenience interface which allows for easy handling of waiting for job completions,
 * under both exceptional and successful conditions as well as short-circuiting jobs.
 * This class provides utility methods which handle the complex waiting and signalling.
 * 
 * @author Sina Madani
 */
public interface EolExecutorService extends ExecutorService {
	
	static final RejectedExecutionHandler rejectionHandler = (r, executor) -> {
		// Do nothing
	};
	
	ConcurrentExecutionStatus getExecutionStatus();
	
	/**
	 * Shuts down this ExecutorService and waits for all jobs to complete.
	 * 
	 * @return {@link SingleConcurrentExecutionStatus#getResult()}
	 * @throws EolRuntimeException if an exception is thrown from any of the jobs,
	 * or otherwise any other abnormal completion.
	 * @see #awaitCompletion(Collection)
	 */
	default Object awaitCompletion() throws EolRuntimeException {
		return awaitCompletion(null);
	}
	
	/**
	 * Blocks until all of the submitted jobs have completed.
	 * 
	 * @throws EolRuntimeException if an exception is thrown from any of the jobs,
	 * or otherwise any other abnormal completion.
	 * @return {@link ConcurrentExecutionStatus#getResult()}.
	 */
	default Object awaitCompletion(Collection<Future<?>> futures) throws EolRuntimeException {
		final boolean keepAlive = futures != null;
		if (keepAlive && futures.isEmpty())
			return null;
		
		ConcurrentExecutionStatus status = getExecutionStatus();
		Object lock = new Object();
		status.register(lock);
		
		Thread termWait = new Thread(() -> {
			try {
				if (keepAlive) {
					for (Future<?> future : futures) {
						future.get();
					}
				}
				else {
					shutdown();
					awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				}
				status.completeSuccessfully(lock);
			}
			catch (ExecutionException ex) {
				status.completeExceptionally(ex);
			}
			catch (InterruptedException ie) {
				// If this happens, it means we completed exceptionally,
				// so exit and let main thread take care of it (see below).
			}
		});
		termWait.setName(getClass().getSimpleName()+"-AwaitTermination");
		termWait.start();

		if (!status.waitForCompletion(lock)) {
			termWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		
		return status.getResult(lock);
	}
	
	/**
	 * Blocks until all futures have completed, in the order returned by the futures' iterator.
	 * This method takes care of exception handling semantics.
	 * 
	 * @param futures The Futures to wait for.
	 * @return The result of futures.
	 * @throws EolRuntimeException
	 */
	default <R> Collection<R> collectResults(Collection<Future<R>> futures) throws EolRuntimeException {
		if (futures.isEmpty())
			return Collections.emptyList();
		
		ConcurrentExecutionStatus status = getExecutionStatus();
		Object lock = new Object();
		status.register(lock);
		
		final Collection<R> results = new ArrayList<>(futures.size());
		
		Thread compWait = new Thread(() -> {
			try {
				for (Future<R> future : futures) {
					results.add(future.get());
				}
				status.completeSuccessfully(lock);
			}
			catch (ExecutionException ex) {
				status.completeExceptionally(ex);
			}
			catch (CancellationException | InterruptedException ice) {
				// This means we finished early (short-circuit)
				// or an exception was raised. Either way no action
				// required here - will be handled below.
			}
		});
		compWait.setName(getClass().getSimpleName()+"-AwaitCompletion");
		compWait.start();

		if (!status.waitForCompletion(lock)) {
			compWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		
		return results;
	}

	/**
	 * Calls {@link #shortCircuitCompletion(Collection)}.
	 * @param jobs The futures to wait on.
	 * @return The result, cast as the specified type.
	 * @throws EolRuntimeException If there was an exception in any of the <code>jobs</code>.
	 * @see {@link #shortCircuitCompletion(Collection)}
	 */
	@SuppressWarnings("unchecked")
	default <T> T shortCircuitCompletionTyped(Object lock, Collection<Future<T>> jobs) throws EolRuntimeException {
		Collection<Future<?>> casted = jobs.stream().map(j -> (Future<?>) j).collect(Collectors.toList());
		return (T) shortCircuitCompletion(lock, casted);
	}
	
	/**
	 * Waits for completion on the provided status. Upon being notified of a result
	 * (or exceptional completion), all submitted jobs are cancelled to prevent
	 * unnecessary computations.
	 * 
	 * @param jobs The Futures to cancel in the event of early completion.
	 * @return The result as set by {@linkplain SingleConcurrentExecutionStatus#completeSuccessfully()}.
	 * @throws EolRuntimeException If {@linkplain SingleConcurrentExecutionStatus#completeExceptionally(Exception)}
	 * was called whilst waiting.
	 */
	default Object shortCircuitCompletion(Object lock, Collection<Future<?>> jobs) throws EolRuntimeException {
		if (jobs.isEmpty())
			return Collections.emptyList();
		
		ConcurrentExecutionStatus status = getExecutionStatus();
		
		Thread compWait = new Thread(() -> {
			try {
				for (Future<?> future : jobs) {
					if (status.isInProgress(lock))
						future.get();
					else return;
				}
				status.completeSuccessfully(lock);
			}
			catch (ExecutionException ex) {
				ex.printStackTrace();
				status.completeExceptionally(ex);
			}
			catch (CancellationException | InterruptedException ice) {
				// This means we finished early (short-circuit) or exceptionally -
				// No action required here (see below).
			}
		});
		compWait.setName(getClass().getSimpleName()+"-AwaitCompletion");
		compWait.start();
		
		boolean success = status.waitForCompletion(lock);
		compWait.interrupt();
		
		if (!success) {
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		else {
			// This is to avoid unnecessary waiting for completion
			for (Future<?> future : jobs) {
				future.cancel(true);
			}
		}
		
		return status.getResult(lock);
	}

	/**
	 * Submits all jobs to this ExecutorService (non-blocking).
	 * 
	 * @param jobs The tasks to execute.
	 * @return The Futures, so that they can be waited on for completion.
	 */
	default Collection<Future<?>> submitAll(Collection<Runnable> jobs) {
		return jobs.stream().map(this::submit).collect(Collectors.toList());
	}
	
	/**
	 * Submits all jobs to this ExecutorService (non-blocking).
	 * 
	 * @param jobs The tasks to execute.
	 * @return The Future results of the jobs.
	 */
	default <T> Collection<Future<T>> submitAllTyped(Collection<Callable<T>> jobs) {
		return jobs.stream().map(this::submit).collect(Collectors.toList());
	}
	
	/**
	 * Submits and waits for the jobs to complete.
	 * @param jobs The tasks to execute.
	 * @return {@link ConcurrentExecutionStatus#getResult(Object)}
	 * @throws EolRuntimeException If any of the jobs fail.
	 */
	default Object completeAll(Collection<Runnable> jobs) throws EolRuntimeException {
		return awaitCompletion(submitAll(jobs));
	}
	
}
