package org.eclipse.epsilon.common.dt.editor.autoclose;

public class AutoClosePair {
	
	protected char left;
	protected char right;
	
	public AutoClosePair(char left, char right) {
		this.left = left;
		this.right = right;
	}
	
	public char getLeft() {
		return left;
	}
	
	public char getRight() {
		return right;
	}
	
	public boolean isSame() {
		return getLeft() == getRight();
	}
	
	public boolean isDifferent() {
		return !isSame();
	}
	
}
