package org.eclipse.epsilon.eol.execute.concurrent.executors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;

/**
 * Convenience interface which allows for easy handling of {@link #awaitTermination(long, TimeUnit)}
 * under both normal and exceptional completion scenarios.
 * 
 * @author Sina Madani
 */
public interface EolExecutorService extends ExecutorService {
	
	ConcurrentExecutionStatus getExecutionStatus();
	
	/**
	 * Blocks until all submitted jobs have completed.
	 * @throws EolRuntimeException if an exception is thrown from any of the jobs,
	 * or otherwise any other abnormal completion.
	 * 
	 * @return {@link ConcurrentExecutionStatus#getResult()}.
	 */
	default Object awaitCompletion() throws EolRuntimeException {
		final ConcurrentExecutionStatus status = getExecutionStatus();
		
		Thread termWait = new Thread(() -> {
			shutdown();
			try {
				awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				status.completeSuccessfully();
			}
			catch (InterruptedException ie) {
				// If this happens, it means we completed exceptionally,
				// so exit and let main thread take care of it (see below).
			}
		});
		termWait.setName(getClass().getSimpleName()+"-AwaitTermination");
		termWait.start();

		
		if (!status.waitForCompletion()) {
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
	 * @param shutdown Whether to call {@linkplain #shutdown()} on this ExecutorService.
	 * @return The result of futures.
	 * @throws EolRuntimeException
	 */
	default <R> Collection<R> collectResults(Collection<Future<R>> futures, boolean shutdown) throws EolRuntimeException {
		final ConcurrentExecutionStatus status = getExecutionStatus();
		Collection<R> results = new ArrayList<>(futures.size());
		
		Thread termWait = new Thread(() -> {
			if (shutdown) shutdown();
			try {
				for (Future<R> future : futures) {
					results.add(future.get());
				}
				status.completeSuccessfully();
			}
			catch (InterruptedException | ExecutionException ex) {
				status.completeExceptionally(ex);
			}
		});
		termWait.setName(getClass().getSimpleName()+"-AwaitTermination");
		termWait.start();

		if (!status.waitForCompletion()) {
			termWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(status.getException());
		}
		
		return results;
	}

	default void execute(CheckedEolRunnable task, IEolContextParallel context) {
		try {
			// No performance penalty in upcasting!
			execute((Runnable)task);
		}
		catch (Exception exception) {
			context.handleException(exception, this);
		}
	}
}
