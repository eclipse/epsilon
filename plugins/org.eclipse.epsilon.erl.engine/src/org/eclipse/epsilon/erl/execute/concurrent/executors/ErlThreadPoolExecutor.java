package org.eclipse.epsilon.erl.execute.concurrent.executors;

import java.util.concurrent.*;
import org.eclipse.epsilon.erl.execute.concurrent.ErlThreadFactory;

public class ErlThreadPoolExecutor extends ThreadPoolExecutor implements ErlExecutorService {

	protected static final long DEFAULT_KEEP_ALIVE = 1024L;
	protected static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MILLISECONDS;
	protected static final int
		DEFAULT_CORE_POOL_SIZE = 1,
		DEFAULT_MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors();
	
	protected final ErlExecutionStatus execStatus = new ErlExecutionStatus();

	/**
	 * Unbounded thread pool size with fixed queue capacity.
	 */
	public static ErlThreadPoolExecutor boundedQueueExecutor(int queueCapacity) {
		return new ErlThreadPoolExecutor(DEFAULT_CORE_POOL_SIZE, Integer.MAX_VALUE, DEFAULT_KEEP_ALIVE, DEFAULT_TIME_UNIT, new ArrayBlockingQueue<>(queueCapacity));
	}
	
	/**
	 * Fixed thread pool with unbounded queueing in FIFO order.
	 */
	public static ErlThreadPoolExecutor fixedPoolExecutor(int numThreads) {
		return new ErlThreadPoolExecutor(numThreads, numThreads, Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue<>());
	}
	
	/**
	 * No queueing - a new thread is created for each new job.
	 */
	public static ErlThreadPoolExecutor directHandoffExecutor() {
		return new ErlThreadPoolExecutor(DEFAULT_CORE_POOL_SIZE, Integer.MAX_VALUE, DEFAULT_KEEP_ALIVE, DEFAULT_TIME_UNIT, new SynchronousQueue<>());
	}
	
	/**
	 * Guarantees a minimum of numThreads with infinite queueing.
	 */
	public static ErlThreadPoolExecutor defaultExecutor(int numThreads) {
		return new ErlThreadPoolExecutor(numThreads, Math.max(DEFAULT_MAX_POOL_SIZE+1, numThreads), DEFAULT_KEEP_ALIVE, DEFAULT_TIME_UNIT, new LinkedBlockingQueue<>());
	}
	
	/**
	 * Custom configuration with default RejectedExecutionHandler.
	 */
	public ErlThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		setThreadFactory(new ErlThreadFactory(getExecutionStatus()));
	}

	@Override
	public ErlExecutionStatus getExecutionStatus() {
		return execStatus;
	}
}
