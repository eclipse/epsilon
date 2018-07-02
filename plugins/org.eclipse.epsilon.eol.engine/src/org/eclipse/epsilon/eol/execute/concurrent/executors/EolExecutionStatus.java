package org.eclipse.epsilon.eol.execute.concurrent.executors;

import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;

/**
 * Internal class for tracking the completion status of job batches
 * submitted to {@link EolExecutorService}.
 * A batch may complete successfully or exceptionally.
 */
public class EolExecutionStatus {
	
	private boolean success;
	private volatile boolean stop;
	private Exception exception;
	
	public boolean hasFinishedSuccessfully() {
		return success;
	}
	
	protected Exception getException() {
		return exception;
	}
	
	/**
	 * This method is only intended to be called by {@linkplain EolExecutorService#awaitCompletion()}.
	 */
	public synchronized void completeSuccessfully() {
		success = true;
		finished();
	}
	
	public synchronized void setException(Exception ex) {
		if (!stop) {
			exception = ex;
			finished();
		}
	}
	
	private synchronized void finished() {
		stop = true;
		notify();
	}
	
	/**
	 * Blocks until an exception is raised or {@linkplain #completeSuccessfully()} is called.
	 * @return the Exception that was raised which caused this to terminate, or <code>null</code> if successful.
	 */
	public final synchronized Exception waitForCompletion() {
		try {
			while (!stop) wait();
		}
		catch (InterruptedException ix) {
			ix.printStackTrace();
		}
		return exception;
	}
}