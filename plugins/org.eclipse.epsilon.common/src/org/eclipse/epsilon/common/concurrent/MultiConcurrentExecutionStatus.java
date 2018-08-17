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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Utility class which allows for co-ordinating concurrent execution with waiting
 * semantics for successful and exceptional completion. This class can support multiple
 * conditions to be registered, signalled and waited on.
 * 
 * @see SingleConcurrentExecutionStatus
 * @author Sina Madani
 */
public final class MultiConcurrentExecutionStatus extends ConcurrentExecutionStatus {
	
	private final Map<Object, Object> results = new HashMap<>();
	private final Map<Object, Thread> inProgress = ConcurrencyUtils.concurrentMap(4, 2);

	@Override
	public Object getResult(Object lockObj) {
		return results.remove(lockObj);
	}
	
	@Override
	public void register(Object lockObj) {
		inProgress.put(lockObj, Thread.currentThread());
	}
	
	@Override
	public boolean isInProgress(Object lockObj) {
		return inProgress.containsKey(lockObj);
	}
	
	// SIGNAL CODE
	
	private void complete(Object lockObj) {
		Thread waitingThread = inProgress.remove(lockObj);
		if (waitingThread != null) {
			waitingThread.interrupt();
		}
		/*else {
			synchronized (lockObj) {
				lockObj.notify();
			}
		}*/
	}
	
	@Override
	public void completeSuccessfully(Object lockObj) {
		complete(lockObj);
	}
	
	@Override
	public void completeSuccessfully(Object lockObj, Object result) {
		results.put(lockObj, result);
		complete(lockObj);
	}
	
	@Override
	public void completeExceptionally(Exception exception) {
		if (completeExceptionallyBase(exception)) {
			inProgress.values().forEach(Thread::interrupt);
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
			if (isInProgress(lockObj)) {
				inProgress.put(lockObj, Thread.currentThread());
			}
			
			while (isInProgress(lockObj) && (targetState == null || !targetState.get())) {
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
	
	@Override
	public boolean waitForCompletion(Object lockObj) {
		return waitForCompletion(lockObj, null);
	}
}