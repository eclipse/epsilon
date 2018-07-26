/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
