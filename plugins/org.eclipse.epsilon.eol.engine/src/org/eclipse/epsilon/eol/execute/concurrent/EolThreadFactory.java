/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;

public class EolThreadFactory implements ThreadFactory {

	protected final AtomicInteger threadCount = new AtomicInteger();
	protected final int maxThreads;
	protected final String namePrefix;
	protected final ConcurrentExecutionStatus executionStatus;
	
	public EolThreadFactory() {
		this(null);
	}
	
	public EolThreadFactory(ConcurrentExecutionStatus status) {
		this(status, Integer.MAX_VALUE);
	}
	
	public EolThreadFactory(ConcurrentExecutionStatus status, int threadLimit) {
		this(status, threadLimit, null);
	}
	
	protected EolThreadFactory(ConcurrentExecutionStatus status, int threadLimit, String threadNamePrefix) {
		this.namePrefix = threadNamePrefix != null ? threadNamePrefix : "EOL-Worker";
		this.executionStatus = status;
		this.maxThreads = threadLimit;
	}
	
	protected <T extends Thread> T setThreadProperties(T thread) {
		thread.setName(namePrefix+(threadCount.incrementAndGet()));
		thread.setDaemon(true);
		
		if (executionStatus != null) {
			thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					Exception exception;
					if (e instanceof Exception) {
						exception = (Exception) e;
					}
					else {
						exception = new RuntimeException(e.getClass().getSimpleName()+" in thread "+t.getName(), e);
					}
					
					executionStatus.completeExceptionally(exception);
				}
			});
		}
		
		return thread;
	}
	
	@Override
	public Thread newThread(Runnable target) {
		if (threadCount.get() > maxThreads)
			throw new IllegalStateException("Exceeded maximum number of threads: "+maxThreads);
		
		return setThreadProperties(new Thread(target));
	}
}
