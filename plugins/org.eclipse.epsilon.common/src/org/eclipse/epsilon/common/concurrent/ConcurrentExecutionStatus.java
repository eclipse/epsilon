/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.common.concurrent;

import java.util.function.Supplier;

/**
 * Utility class which allows for co-ordinating concurrent execution with waiting
 * semantics for successful and exceptional completion. This class is only suitable
 * for non-nested parallelism, where at most one thread (typically the main) will
 * invoke this class's methods at any given time.
 * 
 * @author Sina Madani
 */
public final class ConcurrentExecutionStatus {
	
	private Exception exception;
	private boolean failed = false;
	private volatile boolean inProgress = false;
	private Thread waitingThread;
	private Object result;
	private final Object lockObj = new Object();
	
	public Exception getException() {
		return exception;
	}

	public Object getResult() {
		return result;
	}
	
	public void begin() {
		inProgress = true;
	}
	
	public boolean isInProgress() {
		return inProgress;
	}
	
	// SIGNAL CODE
	
	private void complete() {
		if (inProgress) {
			inProgress = false;
			if (waitingThread != null) {
				waitingThread.interrupt();
			}
			/*synchronized (lockObj) {
				lockObj.notify();
			}*/
		}
	}
	
	public void completeSuccessfully() {
		complete();
	}
	
	public void completeSuccessfully(Object result) {
		this.result = result;
		completeSuccessfully();
	}
	
	public void completeExceptionally(Exception exception) {
		if (!failed) {
			this.exception = exception;
			failed = true;
			complete();
		}
	}
	
	// WAIT CODE
	
	/**
	 * Waits until either exceptional or successful completion conditions are signalled.
	 * 
	 * @return Whether the completion was successful (<code>true</code>) or exceptional (<code>false</code>).
	 */
	public boolean waitForCompletion(Supplier<Boolean> targetState) {
		synchronized (lockObj) {
			waitingThread = Thread.currentThread();
			while (inProgress && (targetState == null || !targetState.get())) {
				try {
					lockObj.wait();
				}
				catch (InterruptedException ie) {
					// Interrupt is desirable - no special action needed.
				}
			}
		}
		return !failed;
	}
	
	public boolean waitForCompletion() {
		return waitForCompletion(null);
	}
	
	public Exception waitForExceptionalCompletion() {
		waitForCompletion(() -> failed);
		return exception;
	}
}