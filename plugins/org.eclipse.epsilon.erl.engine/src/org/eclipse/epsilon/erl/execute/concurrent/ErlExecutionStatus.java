package org.eclipse.epsilon.erl.execute.concurrent;

public class ErlExecutionStatus {
	
	private boolean success;
	private volatile boolean stop;
	private Exception exception;
	
	public boolean hasFinishedSuccessfully() {
		return success;
	}
	
	protected Exception getException() {
		return exception;
	}
	
	synchronized void completeSuccessfully() {
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
	
	/*
	 * Blocks until an exception is raised or {@linkplain #completeSuccessfully()} is called.
	 * @return the Exception that was raised which caused this to terminate, or null if successful.
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