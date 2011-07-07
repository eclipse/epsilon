/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.formatter.language;

import java.util.regex.Pattern;

import org.eclipse.epsilon.egl.formatter.Formatter;

public class JavaFormatter extends LanguageFormatter implements Formatter {

	// Increase indentation after every open bracket that terminates a line
	// (allowing for any whitespace between the bracket and the line terminator)
	private static final String increasePattern = "\\{\\s*$";
	
	// Decrease indentation after every close bracket that begins a line
	private static final String decreasePattern = "^\\}";
	
	public JavaFormatter() {
		super(Pattern.compile(increasePattern, Pattern.MULTILINE),
		      Pattern.compile(decreasePattern, Pattern.MULTILINE));
	}

}
