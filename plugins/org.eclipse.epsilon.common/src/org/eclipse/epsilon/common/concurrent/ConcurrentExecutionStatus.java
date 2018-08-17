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
 */
public abstract class ConcurrentExecutionStatus {
	
	protected boolean failed;
	protected Exception exception;

	public Exception getException() {
		return exception;
	}
	
	public abstract Object getResult(Object lockObj);
	
	public abstract void register(Object lockObj);
	
	public abstract boolean isInProgress(Object lockObj);
	
	public abstract void completeSuccessfully(Object lockObj);
	
	public abstract void completeSuccessfully(Object lockObj, Object result);
	
	protected final boolean completeExceptionallyBase(Exception exception) {
		boolean firstFail = !failed;
		if (firstFail) {
			this.exception = exception;
			failed = true;
		}
		return firstFail;
	}
	
	public abstract void completeExceptionally(Exception exception);
	
	public synchronized Exception waitForExceptionalCompletion() {
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
	
}
