/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock;

import java.io.PrintStream;
import java.util.Collection;
import java.util.LinkedList;

public class FlockResult {

	private final Collection<String> warnings = new LinkedList<String>();
	
	void addWarning(String warning) {
		warnings.add(warning);
	}
	
	public Collection<String> getWarnings() {
		return warnings;
	}
	
	public void printWarnings(PrintStream printStream) {
		for (String warning : warnings) {
			printStream.println(warning);
		}
	}
}
