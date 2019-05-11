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

import java.util.concurrent.*;
import org.eclipse.epsilon.eol.execute.concurrent.EolConcurrentExecutionStatus;
import org.eclipse.epsilon.eol.execute.concurrent.EolThreadFactory;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolThreadPoolExecutor;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EolThreadPoolExecutor extends ThreadPoolExecutor implements EolExecutorService {

	protected static final long DEFAULT_KEEP_ALIVE = 1024L;
	protected static final TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MILLISECONDS;
	protected static final int
		DEFAULT_CORE_POOL_SIZE = 1,
		DEFAULT_MAX_POOL_SIZE = Runtime.getRuntime().availableProcessors();
	
	protected final EolConcurrentExecutionStatus execStatus = new EolConcurrentExecutionStatus();

	/**
	 * Unbounded thread pool size with fixed queue capacity.
	 */
	public static EolThreadPoolExecutor boundedQueueExecutor(int queueCapacity) {
		return new EolThreadPoolExecutor(DEFAULT_CORE_POOL_SIZE, Integer.MAX_VALUE, DEFAULT_KEEP_ALIVE, DEFAULT_TIME_UNIT, new ArrayBlockingQueue<>(queueCapacity));
	}
	
	/**
	 * Fixed thread pool with unbounded queueing in FIFO order.
	 */
	public static EolThreadPoolExecutor fixedPoolExecutor(int numThreads) {
		return new EolThreadPoolExecutor(numThreads, numThreads, Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue<>());
	}
	
	/**
	 * No queueing - a new thread is created for each new job.
	 */
	public static EolThreadPoolExecutor directHandoffExecutor() {
		return new EolThreadPoolExecutor(DEFAULT_CORE_POOL_SIZE, Integer.MAX_VALUE, DEFAULT_KEEP_ALIVE, DEFAULT_TIME_UNIT, new SynchronousQueue<>());
	}
	
	/**
	 * Guarantees a minimum of numThreads with infinite queueing.
	 */
	public static EolThreadPoolExecutor defaultExecutor(int numThreads) {
		return new EolThreadPoolExecutor(numThreads, Math.max(DEFAULT_MAX_POOL_SIZE+1, numThreads), Long.MAX_VALUE, TimeUnit.NANOSECONDS, new LinkedBlockingQueue<>());
	}
	
	/**
	 * Starts with 1 thread and grows to maxThreads as needed.
	 */
	public static EolThreadPoolExecutor adaptiveExecutor(int maxThreads) {
		return new EolThreadPoolExecutor(1, maxThreads, DEFAULT_KEEP_ALIVE, DEFAULT_TIME_UNIT, new LinkedBlockingQueue<>());
	}
	
	/**
	 * Custom configuration with default RejectedExecutionHandler.
	 */
	public EolThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, (r, e) -> {});
		setThreadFactory(new EolThreadFactory(this::handleException, maximumPoolSize));
	}

	@Override
	public EolConcurrentExecutionStatus getExecutionStatus() {
		return execStatus;
	}
	
	@Override
	protected void terminated() {
		super.terminated();
		if (execStatus != null && execStatus.isInProgress()) {
			execStatus.completeSuccessfully();
		}
	}
}
