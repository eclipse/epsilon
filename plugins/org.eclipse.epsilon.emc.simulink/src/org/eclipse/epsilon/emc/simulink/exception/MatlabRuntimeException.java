package org.eclipse.epsilon.emc.simulink.exception;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class MatlabRuntimeException extends EolRuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MatlabRuntimeException(){
		super();
	}
	
	public MatlabRuntimeException(String reason){
		super(reason);
	}
	
	public MatlabRuntimeException(MatlabException ex){
		super(ex.getMessage());
	}

}
