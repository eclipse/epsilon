package org.eclipse.epsilon.common.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Supplier;

/**
 * Utility class which allows for co-ordinating concurrent execution with waiting
 * semantics for successful and exceptional completion.
 * 
 * @author Sina Madani
 */
public final class ConcurrentExecutionStatus {
	
	private Exception exception;
	private Object result;
	private volatile boolean success, finished;
	private final Lock lock = new ReentrantLock();
	private final Condition
		completed = lock.newCondition(),
		successful = lock.newCondition(),
		exceptional = lock.newCondition();
	
	
	public boolean hasFinished() {
		return finished;
	}
	
	public boolean hasFinishedSuccessfully() {
		return success;
	}
	
	public Exception getException() {
		return exception;
	}

	public Object getResult() {
		return result;
	}
	
	// SIGNAL CODE
	
	private void complete(boolean state) {
		lock.lock();
		try {
			if (!finished) {
				if ((success = state) == true) {
					successful.signalAll();
				}
				else {
					exceptional.signalAll();
				}
				finished = true;
				completed.signalAll();
			}
		}
		finally {
			lock.unlock();
		}
	}
	
	public void completeSuccessfully() {
		completeSuccessfully(null);
	}
	
	public void completeSuccessfully(Object result) {
		this.result = result;
		complete(true);
	}
	
	public void completeExceptionally(Exception exception) {
		this.exception = exception;
		complete(false);
	}
	
	// WAIT CODE
	
	private void waitForCondition(Condition condition, Supplier<Boolean> loop) {
		lock.lock();
		
		while (loop.get()) {
			try {
				condition.await();
				break;
			}
			catch (InterruptedException ie) {
				// Interrupt may be desirable - no special action needed.
			}
			finally {
				lock.unlock();
			}
		}
	}
	
	/**
	 * Waits until either exceptional or successful completion conditions are signalled.
	 * 
	 * @return Whether the completion was successful (<code>true</code>) or exceptional (<code>false</code>).
	 */
	public boolean waitForCompletion() {
		waitForCondition(completed, () -> !finished);
		return success;
	}
	
	public void waitForSuccessfulCompletion() {
		waitForCondition(successful, () -> success);
	}
	
	public void waitForExceptionalCompletion() {
		waitForCondition(exceptional, () -> !success);
	}
}