package org.eclipse.epsilon.egl.formatter.linebyline;


public interface LineFactory<T extends Line> {
	
	public T createLine(String rawLine);
	
}