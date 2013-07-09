package org.eclipse.epsilon.common.parse;

public class Position {
	
	protected int line;
	protected int column;
	
	public Position() {
		
	}
	
	public Position(int line, int column) {
		this.line = line;
		this.column = column;
	}
	
	public int getLine() {
		return line;
	}
	
	public void setLine(int line) {
		this.line = line;
	}
	
	public int getColumn() {
		return column;
	}
	
	public void setColumn(int column) {
		this.column = column;
	}
	
	public boolean isBefore(Position position) {
		return getLine() < position.getLine() ||
			(getLine() == position.getLine() && getColumn() < position.getColumn());
	}
	
	public boolean isAfter(Position position) {
		return !isBefore(position);
	}
	
	@Override
	public String toString() {
		return line + ":" + column;
	}
}
