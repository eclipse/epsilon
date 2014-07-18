package org.eclipse.epsilon.common.dt.util;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

public abstract class ThemeChangeListener implements IPropertyChangeListener {

	protected String activeTheme = null;
	
	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (EclipseUtil.getActiveTheme().equals(activeTheme)) return;
		else {
			activeTheme = EclipseUtil.getActiveTheme();
			themeChange();
		}
	}

	public abstract void themeChange();
	
}
