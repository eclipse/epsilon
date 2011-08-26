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
package org.eclipse.epsilon.egl.engine.traceability.fine.trace;

import java.util.Collection;
import java.util.Collections;

public class Position {

	public int line, column;
	
	public Position(int line, int column) {
		this.line   = line;
		this.column = column;
	}
	
	
	// Getters for compatibility with JavaModel, which are used in acceptance tests

	public int getLine() {
		return line;
	}
	
	public int getColumn() {
		return column;
	}

	public Collection<? extends Object> getAllContents() {
		return Collections.singleton(this);
	}
}
