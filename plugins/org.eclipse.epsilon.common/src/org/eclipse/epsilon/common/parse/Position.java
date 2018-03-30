package org.eclipse.epsilon.common.parse;

import java.util.Objects;

public class Position {
	
	protected int line, column;
	
	public Position() {}
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(line, column);
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other) return true;
		if (!(other instanceof Position))
			return false;
		
		Position pos = (Position) other;
		return
			this.column == pos.column &&
			this.line == pos.line;
	}
}
