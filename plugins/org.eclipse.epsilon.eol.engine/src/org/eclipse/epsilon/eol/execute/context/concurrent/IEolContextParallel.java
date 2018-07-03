package org.eclipse.epsilon.eol.execute.context.concurrent;

import java.util.function.Consumer;
import java.util.function.Supplier;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolThreadPoolExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IEolContextParallel extends IEolContext {
	
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
	 * {@link IEolModule} has begun, and will return false if execution has ended or not started.
	 * 
	 * @return whether this Context is currently executing in parallel mode.
	 */
	boolean isParallel();
	
	/**
	 * Allows for persistence of an ExecutorService.
	 * Unlike {@linkplain #newExecutor()}, this method returns
	 * the executor as set by {@linkplain #setExecutor(EolExecutorService)}.
	 * Note that if no value is set, this method may return <code>null</code>.
	 * 
	 * @return A cached ExecutorService.
	 * @see #setExecutor()
	 */
	EolExecutorService getExecutor();
	
	/**
	 * Allows for persistence of an ExecutorService. The value set by
	 * this method can be retrieved using {@linkplain #getExecutor()}.
	 * @param exector The executor to save.
	 * @see #getExecutor()
	 */
	void setExecutor(EolExecutorService exector);
	
	/**
	 * Factory method for creating executors. Implementations may override this
	 * to provide a more suitable service for the computation tasks. Note that
	 * typically executors are used once and disposed, rather than persisted for
	 * repeated re-use.
	 * 
	 * @return a new {@linkplain EolExecutorService}.
	 */
	default EolExecutorService newExecutor() {
		return EolThreadPoolExecutor.defaultExecutor(getParallelism());
	}
	
	//Convenience methods
	
	default void handleException(Exception exception, EolExecutorService executor) {
		// Cache the Epsilon stack trace
		if (exception instanceof EolRuntimeException)
			exception.getMessage();
	
		if (executor != null)
			executor.getExecutionStatus().setException(exception);
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
