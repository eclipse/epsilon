package org.eclipse.epsilon.erl.execute.context.concurrent;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.erl.execute.concurrent.executors.ErlExecutorService;
import org.eclipse.epsilon.erl.execute.concurrent.executors.ErlThreadPoolExecutor;

public interface IErlContextParallel extends IEolContext {
	
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
	 * structures, and dispose of any variables and structures used during parallel
	 * execution.
	 */
	void endParallel();
	
	/**
	 * This method will typically return true if execution of the associated
	 * {@link IErlModule} has begun, and will return false if execution has ended or not started.
	 * 
	 * @return whether this Context is currently executing in parallel mode.
	 */
	boolean isParallel();
	
	default ErlExecutorService getExecutor() {
		return ErlThreadPoolExecutor.defaultExecutor(getParallelism());
	}
	
	//Convenience methods
	
	default void handleException(Exception exception, ErlExecutorService executor) {
		// Cache the Epsilon stack trace
		if (exception instanceof EolRuntimeException)
			exception.getMessage();
		
		if (executor != null) {
			executor.getExecutionStatus().setException(exception);
		}
	}
	
	default <R> R parallelGet(ThreadLocal<? extends R> threadLocal, Supplier<? extends R> originalValueGetter) {
		return isParallel() ? threadLocal.get() : originalValueGetter.get();
	}
	
	default <T> void parallelSet(T value, ThreadLocal<? super T> threadLocal, Consumer<? super T> originalValueSetter) {
		if (isParallel())
			threadLocal.set(value);
		else
			originalValueSetter.accept(value);
	}
}
