package org.eclipse.epsilon.eol.execute.concurrent.executors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
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
	
	ConcurrentExecutionStatus getExecutionStatus();
	
	/**
	 * Blocks until all submitted jobs have completed. Upon completion,
	 * this ExecutorService will {@linkplain #shutdown()}.
	 * 
	 * @throws EolRuntimeException if an exception is thrown from any of the jobs,
	 * or otherwise any other abnormal completion.
	 * @return {@link ConcurrentExecutionStatus#getResult()}.
	 */
	default Object awaitCompletion() throws EolRuntimeException {
		final ConcurrentExecutionStatus status = getExecutionStatus();
		final Object success = status.register();
		
		Thread termWait = new Thread(() -> {
			shutdown();
			try {
				awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				status.completeSuccessfully(success);
			}
			catch (InterruptedException ie) {
				// If this happens, it means we completed exceptionally,
				// so exit and let main thread take care of it (see below).
			}
		});
		termWait.setName(getClass().getSimpleName()+"-AwaitTermination");
		termWait.start();

		if (!status.waitForCompletion(success, this::isTerminated)) {
			termWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		
		return status.getResult(success);
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
		final ConcurrentExecutionStatus status = getExecutionStatus();
		final Object success = status.register();
		
		final Collection<R> results = new ArrayList<>(futures.size());
		
		Thread compWait = new Thread(() -> {
			try {
				for (Future<R> future : futures) {
					results.add(future.get());
				}
				status.completeSuccessfully(success);
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

		if (!status.waitForCompletion(success)) {
			compWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		
		return results;
	}

	/**
	 * Waits for completion on the provided status. Upon being notified of a result
	 * (or exceptional completion), all submitted jobs are cancelled to prevent
	 * unnecessary computations.
	 * 
	 * @param jobs The Futures to cancel in the event of early completion.
	 * @param execStatus The object to wait on.
	 * @return The result as set by {@linkplain ConcurrentExecutionStatus#completeSuccessfully(Object)}.
	 * @throws EolRuntimeException If {@linkplain ConcurrentExecutionStatus#completeExceptionally(Exception)}
	 * was called whilst waiting.
	 */
	default Object shortCircuitCompletion(Collection<Future<?>> jobs, Object lockObj) throws EolRuntimeException {
		final ConcurrentExecutionStatus status = getExecutionStatus();

		Thread compWait = new Thread(() -> {
			try {
				for (Future<?> future : jobs) {
					// This is to avoid unnecessary waiting for completion
					if (status.isInProgress(lockObj))
						future.get();
					else
						future.cancel(true);
				}
				status.completeSuccessfully(lockObj);
			}
			catch (ExecutionException ex) {
				status.completeExceptionally(ex);
			}
			catch (CancellationException | InterruptedException ice) {
				// This means we finished early (short-circuit) or exceptionally -
				// No action required here.
			}
		});
		compWait.setName(getClass().getSimpleName()+"-AwaitCompletion");
		compWait.start();
		
		if (!status.waitForCompletion(lockObj)) {
			compWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		
		return status.getResult(lockObj);
	}
	
}
