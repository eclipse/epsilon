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
import org.eclipse.epsilon.common.concurrent.SingleConcurrentExecutionStatus;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

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
	 * This method should return an immutable, re-usable and non-null {@link ConcurrentExecutionStatus}.
	 * 
	 * @return A re-usable status object used to interrupt short-circuiting jobs and
	 * handling exceptions.
	 */
	ConcurrentExecutionStatus getExecutionStatus();
	
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
	default <R> Collection<R> collectResults(Collection<? extends Future<R>> futures) throws EolRuntimeException {
		final boolean keepAlive = futures != null;
		if (keepAlive && futures.isEmpty())
			return Collections.emptyList();
		
		final ConcurrentExecutionStatus status = getExecutionStatus();
		Throwable statusException = status.getException();
		if (statusException != null) EolRuntimeException.propagateDetailed(statusException);
		if (!status.isInProgress()) status.register();
		
		final Collection<R> results = keepAlive ? new ArrayList<>(futures.size()) : null;
		
		final Thread blockingThread = Thread.currentThread(),
		compWait = new Thread(() -> {
			try {
				if (keepAlive) for (Future<R> future : futures) {
					if (status.isInProgress()) {
						results.add(future.get());
					}
					else return;
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
				if (status.isInProgress()) {
					status.completeExceptionally(ex);
				}
			}
			finally {
				if (blockingThread.getState() == Thread.State.WAITING) {
					blockingThread.interrupt();
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
			assert !status.isInProgress();
		}
		
		return results;
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
		if (jobs == null || jobs.isEmpty()) return null;
		
		final ConcurrentExecutionStatus status = getExecutionStatus();
		final Thread blockingThread = Thread.currentThread(),
		compWait = new Thread(() -> {
			try {
				for (Future<?> future : jobs) {
					if (status.isInProgress()) {
						future.get();
					}
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
				if (blockingThread.getState() == Thread.State.WAITING) {
					blockingThread.interrupt();
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
			assert !status.isInProgress();
		}
		
		return status.getResult();
	}

	/**
	 * Submits all jobs to this ExecutorService (non-blocking).
	 * 
	 * @param jobs The tasks to execute.
	 * @return The Futures, so that they can be waited on for completion.
	 */
	default Collection<Future<?>> submitAll(Collection<? extends Runnable> jobs) {
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
	 * @throws EolRuntimeException If any of the jobs fail.
	 */
	default void completeAll(Collection<? extends Runnable> jobs) throws EolRuntimeException {
		collectResults(submitAll(jobs));
	}
	
}
