package org.eclipse.epsilon.flexmi;

public class ParseWarning {
	
	protected int line;
	protected String message;
	
	public ParseWarning(int line, String message) {
		super();
		this.line = line;
		this.message = message;
	}

	public int getLine() {
		return line;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
