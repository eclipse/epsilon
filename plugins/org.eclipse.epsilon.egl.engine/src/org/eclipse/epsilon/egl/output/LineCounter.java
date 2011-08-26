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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineCounter {

	private final Pattern newLinePattern;
	
	public LineCounter(String newLine) {
		this.newLinePattern = Pattern.compile(newLine);
	}

	public int getCurrentLineNumberFor(String text) {
		final Matcher newLineMatcher = newLinePattern.matcher(text);
		
		int numberOfLines = 1;
		while (newLineMatcher.find()) {
			numberOfLines++;
		}
		
		return numberOfLines;
	}
	
}