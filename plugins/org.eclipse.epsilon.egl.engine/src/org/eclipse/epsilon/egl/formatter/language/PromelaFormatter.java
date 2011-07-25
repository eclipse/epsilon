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

import org.eclipse.epsilon.egl.formatter.Formatter;

public class PromelaFormatter extends LanguageFormatter implements Formatter {

	// Increase indentation after every line that contains an open bracket
	private static final String increasePattern = "\\{";
	
	// Decrease indentation after every line that contains a close bracket
	private static final String decreasePattern = "\\}";
	
	public PromelaFormatter() {
		super(increasePattern, decreasePattern);
	}

}
