package org.eclipse.epsilon.common.dt.editor;

import java.util.Enumeration;
import java.util.ResourceBundle;

public class EmptyResourceBundle extends ResourceBundle {

	@Override
	protected Object handleGetObject(String key) {
		return null;
	}

	@Override
	public Enumeration<String> getKeys() {
		return null;
	}

}
