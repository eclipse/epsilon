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
import java.util.function.Consumer;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class EolThreadFactory implements ThreadFactory {

	protected int threadCount;
	protected final int maxThreads;
	protected final String namePrefix;
	protected final Consumer<Exception> executorExceptionHandler;
	protected final UncaughtExceptionHandler uncaughtHandler = new UncaughtExceptionHandler() {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
			Exception exception;
			if (e instanceof Exception) {
				exception = (Exception) e;
			}
			else {
				exception = new RuntimeException(e.getClass().getSimpleName()+" in thread "+t.getName(), e);
			}
			
			executorExceptionHandler.accept(exception);
		}
	};
	
	protected EolThreadFactory(Consumer<Exception> exceptionHandler, int threadLimit, String threadNamePrefix) {
		this.namePrefix = threadNamePrefix != null ? threadNamePrefix : "EOL-Worker";
		this.executorExceptionHandler = exceptionHandler;
		this.maxThreads = threadLimit;
	}
	
	protected <T extends Thread> T setThreadProperties(T thread) {
		thread.setName(namePrefix + threadCount);
		thread.setDaemon(true);
		if (executorExceptionHandler != null) {
			thread.setUncaughtExceptionHandler(uncaughtHandler);
		}
		return thread;
	}
	
	@Override
	public Thread newThread(Runnable target) {
		if (++threadCount > maxThreads) {
			throw new IllegalStateException("Exceeded maximum number of threads: "+maxThreads);
		}
		return setThreadProperties(new EolThread(target));
	}
}
