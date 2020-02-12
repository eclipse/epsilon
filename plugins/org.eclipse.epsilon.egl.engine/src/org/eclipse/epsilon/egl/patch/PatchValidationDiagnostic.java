package org.eclipse.epsilon.egl.patch;

public class PatchValidationDiagnostic {
	
	protected Line line;
	protected String reason;
	
	public PatchValidationDiagnostic(Line line, String reason) {
		super();
		this.line = line;
		this.reason = reason;
	}

	public Line getLine() {
		return line;
	}
	
	public void setLine(Line line) {
		this.line = line;
	}
	
	public String getReason() {
		return reason;
	}
	
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
}
