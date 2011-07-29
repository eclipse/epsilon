package org.eclipse.epsilon.egl.formatter.linebyline;

public class Line {
	
	protected String rawLine;
	
	public Line(String rawLine) {
		this.rawLine = rawLine;
	}

	public Line addPrefix(String prefix) {
		this.rawLine = prefix + rawLine;
		return this;
	}
	
	public Line addSuffix(String suffix) {
		this.rawLine = rawLine + suffix;
		return this;
	}
	
	public String getText() {
		return rawLine;
	}
	
	void join(Line joinee) {
		this.rawLine += joinee.rawLine.trim();
	}
	
	@Override
	public String toString() {
		return "Line: " + rawLine;
	}
}