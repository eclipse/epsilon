package org.eclipse.epsilon.emc.simulink.exception;

public class MatlabException extends Exception {

	private static final long serialVersionUID = -2998670342449368598L;

	private static final String ERROR = "Matlab Engine Error:\n %s.\n %s";
	private static final String TOO_MANY_OUTPUT = "Too many output arguments";
	
	public MatlabException(Exception e) {
		super(String.format(ERROR, (e.getCause() != null) ? e.getCause().getMessage() : "",
				(e.getCause().getCause() != null) ? e.getCause().getCause().getMessage() : ""), e.getCause());
	}

	public boolean isTooManyOutput() {
		return getMessage().contains(TOO_MANY_OUTPUT);
	}
}
