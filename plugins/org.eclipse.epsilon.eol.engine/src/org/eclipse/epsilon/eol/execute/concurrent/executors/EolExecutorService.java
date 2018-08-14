package org.eclipse.epsilon.eol.execute.concurrent.executors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;
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
	
	/**
	 * This is to allow for convenient co-ordination of concurrent jobs. Typically,
	 * this method will be invoked whenever parallel execution begins, followed by
	 * an invocation of the {@linkplain ConcurrentExecutionStatus#begin()} method.
	 * 
	 * @return The {@link ConcurrentExecutionStatus} for this ExecutorService.
	 */
	ConcurrentExecutionStatus getExecutionStatus();
	
	/**
	 * Shuts down this ExecutorService and waits for all jobs to complete.
	 * 
	 * @return {@link ConcurrentExecutionStatus#getResult()}
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
		ConcurrentExecutionStatus status = getExecutionStatus();
		status.begin();
		
		Thread termWait = new Thread(() -> {
			try {
				if (futures != null) {
					for (Future<?> future : futures) {
						future.get();
					}
				}
				else {
					shutdown();
					awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				}
				status.completeSuccessfully();
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

		if (!status.waitForCompletion(futures != null ? null : this::isTerminated)) {
			termWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		
		return status.getResult();
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
		ConcurrentExecutionStatus status = getExecutionStatus();
		
		final Collection<R> results = new ArrayList<>(futures.size());
		
		Thread compWait = new Thread(() -> {
			try {
				for (Future<R> future : futures) {
					results.add(future.get());
				}
				status.completeSuccessfully();
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

		if (!status.waitForCompletion()) {
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
	default <T> T shortCircuitCompletionTyped(Collection<Future<T>> jobs) throws EolRuntimeException {
		Collection<Future<?>> casted = jobs.stream().map(j -> (Future<?>) j).collect(Collectors.toList());
		return (T) shortCircuitCompletion(casted);
	}
	
	/**
	 * Waits for completion on the provided status. Upon being notified of a result
	 * (or exceptional completion), all submitted jobs are cancelled to prevent
	 * unnecessary computations.
	 * 
	 * @param jobs The Futures to cancel in the event of early completion.
	 * @return The result as set by {@linkplain ConcurrentExecutionStatus#completeSuccessfully()}.
	 * @throws EolRuntimeException If {@linkplain ConcurrentExecutionStatus#completeExceptionally(Exception)}
	 * was called whilst waiting.
	 */
	default Object shortCircuitCompletion(Collection<Future<?>> jobs) throws EolRuntimeException {
		ConcurrentExecutionStatus status = getExecutionStatus();
		//status.begin();
		
		Thread compWait = new Thread(() -> {
			try {
				for (Future<?> future : jobs) {
					if (status.isInProgress())
						future.get();
					else return;
				}
				status.completeSuccessfully();
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
		
		if (!status.waitForCompletion()) {
			compWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		else {
			compWait.interrupt();
			// This is to avoid unnecessary waiting for completion
			for (Future<?> future : jobs) {
				future.cancel(true);
			}
		}
		
		return status.getResult();
	}
	
}
