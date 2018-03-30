package org.eclipse.epsilon.erl.execute.concurrent;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ErlThreadFactory implements ThreadFactory {

	protected final AtomicInteger threadCount = new AtomicInteger();
	protected final String namePrefix;
	protected final ErlExecutionStatus executionStatus;
	
	public ErlThreadFactory(ErlExecutionStatus status) {
		this(status, null);
	}
	
	protected ErlThreadFactory(ErlExecutionStatus status, String threadNamePrefix) {
		this.namePrefix = threadNamePrefix != null ? threadNamePrefix : "ERL-Worker";
		this.executionStatus = status;
	}

	@Override
	public Thread newThread(Runnable target) {
		Thread thread = new Thread(target, namePrefix+(threadCount.incrementAndGet()));
		
		if (executionStatus != null) {
			thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
				@Override
				public void uncaughtException(Thread t, Throwable e) {
					if (e instanceof Exception) {
						executionStatus.setException((Exception) e);
					}
					else {
						Thread.getDefaultUncaughtExceptionHandler().uncaughtException(t, e);
					}
				}
			});
		}
		
		return thread;
	}
}
