/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
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
