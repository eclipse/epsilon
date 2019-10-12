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
import java.util.List;
import java.util.concurrent.*;
import org.eclipse.epsilon.common.function.CheckedRunnable;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.EolConcurrentExecutionStatus;

/**
 * Convenience interface which allows for easy handling of waiting for job completions,
 * under both exceptional and successful conditions as well as short-circuiting jobs.
 * This class provides utility methods which handle the complex waiting and signalling.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public interface EolExecutorService extends ExecutorService {

	/**
	 * This method should return a non-null {@link EolConcurrentExecutionStatus} representing the
	 * current job in progress.
	 * 
	 * @return A re-usable status object used to interrupt short-circuiting jobs and
	 * handling exceptions.
	 */
	EolConcurrentExecutionStatus getExecutionStatus();
	
	default void handleException(Exception exception) {
		if (exception instanceof EolRuntimeException) {
			exception.getMessage();
		}
		getExecutionStatus().completeExceptionally(exception);
	}
	
	/**
	 * Shuts down this ExecutorService and waits for all jobs to complete.
	 * 
	 * @throws EolRuntimeException if an exception is thrown from any of the jobs,
	 * or otherwise any other abnormal completion.
	 */
	default void awaitCompletion() throws EolRuntimeException {
		collectResults(null);
	}
	
	/**
	 * Blocks until all futures have completed, in the order returned by the futures' iterator.
	 * This method takes care of exception handling semantics. Note that this method uses a new
	 * {@linkplain ConcurrentExecutionStatus}.
	 * 
	 * @param futures The Futures to wait for. A <code>null</code> value will
	 * wait for all submitted jobs to terminate and shut down this executor.
	 * @return The result of futures, or <code>null</code> if <code>futures</code> is null.
	 * @throws EolRuntimeException If an exception is thrown from any of the Futures.
	 */
	default <R> List<R> collectResults(Collection<Future<R>> futures) throws EolRuntimeException {
		final boolean keepAlive = futures != null;
		final EolConcurrentExecutionStatus status = getExecutionStatus();
		try {
			Throwable statusException = status.getException();
			if (statusException != null) {
				EolRuntimeException.propagateDetailed(statusException);
			}
			else if (keepAlive && futures.isEmpty()) {
				if (status.isInProgress()) {
					status.completeSuccessfully();
				}
				return Collections.emptyList();
			}
			else if (!status.isInProgress()) {
				status.register();
			}
			
			final List<R> results = keepAlive ? new ArrayList<>(futures.size()) : null;
			
			final Thread compWait = new Thread(() -> {
				try {
					if (keepAlive) for (Future<R> future : futures) {
						if (status.isInProgress()) {
							results.add(future.get());
						}
						else {
							assert status.getException() != null;
							return;
						}
					}
					else {
						shutdown();
						if (!awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS)) {
							throw new IllegalStateException("Infinite wait on termination!");
						}
					}
					status.completeSuccessfully();
				}
				catch (ExecutionException ex) {
					status.completeExceptionally(ex.getCause());
				}
				catch (Exception ex) {
					if (status.getException() == null || status.isInProgress()) {
						status.completeExceptionally(ex);
					}
				}
				finally {
					if (status.isInProgress() && status.getException() == null) {
						status.completeSuccessfully();
					}
					assert !status.isInProgress();
				}
			});
			compWait.setName(getClass().getSimpleName()+"-AwaitCompletion");
			compWait.start();
	
			try {
				if (!status.waitForCompletion()) {
					statusException = status.getException();
					compWait.interrupt();
					shutdownNow();
					EolRuntimeException.propagateDetailed(statusException);
				}
			}
			finally {
				if (compWait.isAlive()) try {
					compWait.join();
				}
				catch (InterruptedException ie) {}
			}
			
			return results;
		}
		finally {
			assert !status.isInProgress();
		}
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
	default Object shortCircuitCompletion(Collection<? extends Future<?>> jobs) throws EolRuntimeException {
		final EolConcurrentExecutionStatus status = getExecutionStatus();
		try {
			Throwable statusException = status.getException();
			if (statusException != null) {
				EolRuntimeException.propagateDetailed(statusException);
			}
			else if (jobs == null || jobs.isEmpty()) {
				if (status.isInProgress()) {
					status.completeSuccessfully();
				}
				return status.getResult();
			}
			
			final Thread compWait = new Thread(() -> {
				try {
					for (Future<?> future : jobs) {
						if (status.isInProgress())
							future.get();
						else return;
					}
					status.completeSuccessfully();
				}
				catch (ExecutionException ex) {
					status.completeExceptionally(ex.getCause());
				}
				catch (Exception ex) {
					if (status.isInProgress()) {
						status.completeExceptionally(ex);
					}
				}
				finally {
					if (status.isInProgress() && status.getException() == null) {
						status.completeSuccessfully();
					}
					assert !status.isInProgress();
				}
			});
			compWait.setName(getClass().getSimpleName()+"-AwaitCompletion");
			compWait.start();
			
			try {
				boolean success = status.waitForCompletion();
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
			}
			finally {
				if (compWait.isAlive()) try {
					compWait.join();
				}
				catch (InterruptedException ie) {}
			}
			
			return status.getResult();
		}
		finally {
			assert !status.isInProgress();
		}
	}
	
	/**
	 * Submits all jobs to this ExecutorService (non-blocking).
	 * 
	 * @param jobs The tasks to execute.
	 * @return The Futures, so that they can be waited on for completion.
	 */
	default List<Future<?>> submitAll(Collection<? extends Runnable> jobs) {
		List<Future<?>> jobFutures = new ArrayList<>(jobs.size());
		for (Runnable job : jobs) {
			if (job != null) {
				jobFutures.add(job instanceof CheckedRunnable ?
					submit((CheckedRunnable<?>) job) :
					submit(job)
				);
			}
		}
		return jobFutures;
	}
	
	/**
	 * Submits all jobs to this ExecutorService (non-blocking).
	 * 
	 * @param jobs The tasks to execute.
	 * @return The Future results of the jobs.
	 */
	default <T> List<Future<T>> submitAllTyped(Collection<Callable<T>> jobs) {
		List<Future<T>> jobFutures = new ArrayList<>(jobs.size());
		for (Callable<T> job : jobs) {
			if (job != null) {
				jobFutures.add(submit(job));
			}
		}
		return jobFutures;
	}
	
	/**
	 * Submits and waits for the jobs to complete.
	 * @param jobs The tasks to execute.
	 * @throws EolRuntimeException If any of the jobs fail.
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	default void completeAll(Collection<? extends Runnable> jobs) throws EolRuntimeException {
		// Just to please the compiler
		Collection futures = submitAll(jobs);
		collectResults(futures);
	}
	
	default void execute(CheckedRunnable<?> command) {
		execute((Runnable) () -> {
			try {
				command.runThrows();
			}
			catch (Exception ex) {
				handleException(ex);
			}
		});
	}
	
	default Future<?> submit(CheckedRunnable<?> task) {
		return submit(task, null);
	}
	
	default <T> Future<T> submit(CheckedRunnable<?> task, T result) {
		return submit((Runnable) () -> {
			try {
				task.runThrows();
			}
			catch (Exception ex) {
				handleException(ex);
			}
		}, result);
	}
	
}
