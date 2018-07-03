package org.eclipse.epsilon.eol.execute.concurrent.executors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.function.CheckedEolRunnable;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutionStatus;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;

/**
 * Convenience interface which allows for easy handling of {@link #awaitTermination(long, TimeUnit)}
 * under both normal and exceptional completion scenarios.
 * @author Sina Madani
 */
public interface EolExecutorService extends ExecutorService {
	
	EolExecutionStatus getExecutionStatus();
	
	/**
	 * Blocks until all submitted jobs have completed.
	 * @throws EolRuntimeException if an exception is thrown from any of the jobs,
	 * or otherwise any other abnormal completion.
	 */
	default void awaitCompletion() throws EolRuntimeException {
		final EolExecutionStatus status = getExecutionStatus();
		
		Thread termWait = new Thread(() -> {
			shutdown();
			try {
				awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
				status.completeSuccessfully();
			}
			catch (InterruptedException ie) {
				status.setException(ie);
			}
		});
		termWait.setName(getClass().getSimpleName()+"-AwaitTermination");
		termWait.start();

		Exception exception = status.waitForCompletion();
		
		if (exception != null) {
			termWait.interrupt();
			shutdownNow();
			EolRuntimeException.propagateDetailed(exception);
		}
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
		final EolExecutionStatus status = getExecutionStatus();
		Collection<R> results = new ArrayList<>(futures.size());
		
		Thread termWait = new Thread(() -> {
			try {
				for (Future<R> future : futures) {
					results.add(future.get());
				}
				status.completeSuccessfully();
			}
			catch (InterruptedException | ExecutionException ex) {
				status.setException(ex);
			}
		});
		termWait.setName(getClass().getSimpleName()+"-AwaitTermination");
		termWait.start();

		Exception exception = status.waitForCompletion();
		
		if (exception != null) {
			termWait.interrupt();
			EolRuntimeException.propagateDetailed(exception);
		}
		
		return results;
	}
	
	/**
	 * Hack for allowing execution of methods which throw exceptions! Lambdas will call this instead of the regular execute().
	 */
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
