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
 * for single-condition locking, where there is only one success condition registered
 * at any given time. Multiple conditions can be supported using serial thread confinement
 * or {@link MultiConcurrentExecutionStatus}.
 * 
 * @author Sina Madani
 */
public final class SingleConcurrentExecutionStatus extends ConcurrentExecutionStatus {
	
	private volatile boolean inProgress = false;
	private Thread waitingThread;
	private Object result;

	@Override
	public Object getResult(Object lockObj) {
		return result;
	}
	
	@Override
	public void register(Object lockObj) {
		inProgress = true;
	}
	
	@Override
	public boolean isInProgress(Object lockObj) {
		return inProgress;
	}
	
	// SIGNAL CODE
	
	protected void complete() {
		if (inProgress) {
			inProgress = false;
			if (waitingThread != null) {
				waitingThread.interrupt();
			}
		}
	}
	
	@Override
	public void completeSuccessfully(Object lockObj) {
		complete();
	}
	
	@Override
	public void completeSuccessfully(Object lockObj, Object result) {
		this.result = result;
		completeSuccessfully(lockObj);
	}
	
	@Override
	public void completeExceptionally(Exception exception) {
		if (completeExceptionallyBase(exception)) {
			complete();
		}
	}
	
	// WAIT CODE
	
	/**
	 * Waits until either exceptional or successful completion conditions are signalled.
	 * 
	 * @return Whether the completion was successful (<code>true</code>) or exceptional (<code>false</code>).
	 */
	@Override
	public boolean waitForCompletion(Object lockObj, Supplier<Boolean> targetState) {
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
	
	/*@Override
	public Exception waitForExceptionalCompletion() {
		waitForCompletion(lockObj, () -> failed);
		return exception;
	}*/
}