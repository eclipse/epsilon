package org.eclipse.epsilon.egl.patch;

public class InvalidLineException extends Exception {
	
	protected Line line;
	
	public InvalidLineException(Line line) {
		this.line = line;
	}
	
	@Override
	public String getMessage() {
		return "Line " + line.getNumber() + ": Invalid patch line " + line.getText();
	}
	
	public Line getLine() {
		return line;
	}
}
