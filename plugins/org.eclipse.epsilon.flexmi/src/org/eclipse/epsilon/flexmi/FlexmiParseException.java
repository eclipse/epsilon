package org.eclipse.epsilon.flexmi;

import java.io.IOException;

public class FlexmiParseException extends IOException {
	
	protected int lineNumber;
	
	public FlexmiParseException(Throwable t) {
		super(t);
	}
	
	public FlexmiParseException(Throwable t, int lineNumber) {
		super(t);
		this.lineNumber = lineNumber;
	}
	
	public int getLineNumber() {
		return lineNumber;
	}
	
	
	
}
