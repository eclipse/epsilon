package org.eclipse.epsilon.egl.formatter.linebyline;

import org.eclipse.epsilon.egl.formatter.Formatter;

public abstract class LineByLineFormatter<T extends Line> implements Formatter {

	protected LineByLineNavigator<T> navigator;
	
	@Override
	public final String format(String text) {
		navigator = new LineByLineNavigator<T>(text, createLineFactory());

		while (navigator.hasMoreLines()) {
			
			formatLine();
			
			navigator.moveToNextLine();
		}
		
		return navigator.getText();
	}

	protected abstract LineFactory<T> createLineFactory();
	protected abstract void formatLine();
}
