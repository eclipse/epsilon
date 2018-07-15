package org.eclipse.epsilon.eol.execute.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;

public class EolThreadFactory implements ThreadFactory {

	protected final AtomicInteger threadCount = new AtomicInteger();
	protected final String namePrefix;
	protected final ConcurrentExecutionStatus executionStatus;
	
	public EolThreadFactory(ConcurrentExecutionStatus status) {
		this(status, null);
	}
	
	protected EolThreadFactory(ConcurrentExecutionStatus status, String threadNamePrefix) {
		this.namePrefix = threadNamePrefix != null ? threadNamePrefix : "EOL-Worker";
		this.executionStatus = status;
	}

	protected <T extends Thread> T setThreadProperties(T thread) {
		thread.setName(namePrefix+(threadCount.incrementAndGet()));
		if (executionStatus != null) {
			thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					if (e instanceof Exception) {
						executionStatus.completeExceptionally((Exception) e);
					}
					else {
						executionStatus.completeExceptionally(new RuntimeException(
							e.getClass().getSimpleName()+" in thread "+t.getName(), e
						));
					}
				}
			});
		}
		return thread;
	}
	
	@Override
	public Thread newThread(Runnable target) {
		return setThreadProperties(new Thread(target));
	}
}
