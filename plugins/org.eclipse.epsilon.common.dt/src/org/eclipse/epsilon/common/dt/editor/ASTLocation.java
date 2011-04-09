package org.eclipse.epsilon.common.dt.editor;

public class ASTLocation {
	
	protected int line;
	protected int column;
	
	public ASTLocation(int line, int column) {
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
	
}
