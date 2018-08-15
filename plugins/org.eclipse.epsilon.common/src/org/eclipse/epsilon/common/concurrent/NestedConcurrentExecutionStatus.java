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

import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Utility class which allows for co-ordinating concurrent execution with waiting
 * semantics for successful and exceptional completion. This class supports
 * nested parallelism, and does not require serial thread confinement.
 * 
 * @author Sina Madani
 */
public final class NestedConcurrentExecutionStatus {
	
	private Exception exception;
	private boolean failed = false;
	private final Map<Object, Object> results = ConcurrencyUtils.concurrentMap(4, 2);
	private final Set<Object> inProgress = ConcurrencyUtils.concurrentSet(4, 2);
	private final Object exceptional = new Object();
	
	public Exception getException() {
		return exception;
	}

	public Object getResult(Object lockObj) {
		return results.remove(lockObj);
	}
	
	public Object register() {
		Object lockObj = new Object();
		inProgress.add(lockObj);
		return lockObj;
	}
	
	public boolean isInProgress(Object lockObj) {
		return inProgress.contains(lockObj);
	}
	
	// SIGNAL CODE
	
	private void complete(Object lockObj) {
		inProgress.remove(lockObj);
		synchronized (lockObj) {
			lockObj.notify();
		}
	}
	
	public void completeSuccessfully(Object lockObj) {
		complete(lockObj);
	}
	
	public void completeSuccessfully(Object lockObj, Object result) {
		if (result != null) results.put(lockObj, result);
		complete(lockObj);
	}
	
	public void completeExceptionally(Exception exception) {
		if (!failed) {
			this.exception = exception;
			failed = true;
			complete(exceptional);
		}
		//results.keySet().forEach(Object::notify);
	}
	
	// WAIT CODE
	
	private void waitForCondition(Object lockObj, Supplier<Boolean> targetState) {
		synchronized (lockObj) {
			while (isInProgress(lockObj) && (targetState == null || !targetState.get())) {
				try {
					lockObj.wait(1<<10);
				}
				catch (InterruptedException ie) {
					// Interrupt is desirable - no special action needed.
				}
			}
		}
	}
	
	/**
	 * Waits until either exceptional or successful completion conditions are signalled.
	 * 
	 * @return Whether the completion was successful (<code>true</code>) or exceptional (<code>false</code>).
	 */
	public boolean waitForCompletion(Object lockObj, Supplier<Boolean> targetState) {
		waitForCondition(lockObj, targetState);
		return !failed;
	}
	
	public boolean waitForCompletion(Object lockObj) {
		return waitForCompletion(lockObj, () -> !failed);
	}
	
	public Exception waitForExceptionalCompletion() {
		waitForCondition(exceptional, () -> failed);
		return exception;
	}
}