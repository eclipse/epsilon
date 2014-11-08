package org.eclipse.epsilon.common.parse;

public class Region {
	
	protected Position start;
	protected Position end;
	
	public Region() {}
	
	public Region(int startLine, int startColumn, int endLine, int endColumn) {
		this.start = new Position(startLine, startColumn);
		this.end = new Position(endLine, endColumn);
	}
	
	public Position getStart() {
		return start;
	}
	
	public Position getEnd() {
		return end;
	}
	
	public void setStart(Position start) {
		this.start = start;
	}
	
	public void setEnd(Position end) {
		this.end = end;
	}
	
	@Override
	public String toString() {
		return start + "-" + end;
	}
	
}
