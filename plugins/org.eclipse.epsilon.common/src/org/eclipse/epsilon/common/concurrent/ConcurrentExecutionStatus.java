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
 * A status object used in co-ordinating concurrent jobs.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public abstract class ConcurrentExecutionStatus {
	
	protected boolean failed;
	protected Throwable exception;

	public Throwable getException() {
		return exception;
	}
	
	public abstract Object getResult(Object lockObj);
	
	public Object getResult() {
		return getResult(this);
	}
	
	public boolean register() {
		return register(this);
	}
	
	/**
	 * 
	 * @param lockObj
	 * @return <code>true</code> if registration was successful.
	 */
	public abstract boolean register(Object lockObj);
	
	public boolean isInProgress() {
		return isInProgress(this);
	}
	
	public abstract boolean isInProgress(Object lockObj);
	
	public void completeSuccessfully() {
		completeSuccessfully(this);
	}
	
	public abstract void completeSuccessfully(Object lockObj);
	
	public void completeWithResult(Object result) {
		completeWithResult(this, result);
	}
	
	public abstract void completeWithResult(Object lockObj, Object result);
	
	protected final boolean completeExceptionallyBase(Throwable exception) {
		boolean firstFail = !failed;
		if (firstFail) {
			this.exception = exception;
			failed = true;
		}
		return firstFail;
	}
	
	public abstract void completeExceptionally(Throwable exception);
	
	public synchronized Throwable waitForExceptionalCompletion() {
		while (!failed) {
			try {
				wait();
			}
			catch (InterruptedException ie) {
				// May be desirable
			}
		}
		return exception;
	}
	
	/**
	 * Waits until either exceptional or successful completion conditions are signalled.
	 * 
	 * @return Whether the completion was successful (<code>true</code>) or exceptional (<code>false</code>).
	 */
	public abstract boolean waitForCompletion(Object lockObj, Supplier<Boolean> targetState);
	
	public boolean waitForCompletion(Object lockObj) {
		return waitForCompletion(lockObj, null);
	}
	
	public boolean waitForCompletion() {
		return waitForCompletion(this);
	}
}
