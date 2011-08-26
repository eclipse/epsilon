/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.output;

public class ColumnCounter {

	private final String newLine;
	
	public ColumnCounter(String newLine) {
		this.newLine = newLine;
	}

	public int getCurrentColumnNumberFrom(String text) {
		return getLastLine(text).length() + 1;
	}

	private String getLastLine(String text) {
		if (text.endsWith(newLine))
			return "";
	
		final String[] lines = text.split(newLine);
		return lines[lines.length - 1];
	}

}
