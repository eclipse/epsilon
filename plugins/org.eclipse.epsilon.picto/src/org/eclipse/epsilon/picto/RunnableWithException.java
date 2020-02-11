package org.eclipse.epsilon.picto;

public abstract class RunnableWithException implements Runnable {
	
	protected Exception exception;
	
	@Override
	public void run() {
		try {
			runWithException();
		} catch (Exception e) {
			this.exception = e;
		}
	}
	
	public abstract void runWithException() throws Exception;

	public Exception getException() {
		return exception;
	}

}
