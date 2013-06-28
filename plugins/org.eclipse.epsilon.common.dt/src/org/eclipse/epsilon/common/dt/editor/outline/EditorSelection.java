package org.eclipse.epsilon.common.dt.editor.outline;

import java.io.File;

public class EditorSelection {
	
	protected int line;
	protected int column;
	protected File file;
	
	public EditorSelection(File file, int line, int column) {
		super();
		this.line = line;
		this.column = column;
		this.file = file;
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

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
