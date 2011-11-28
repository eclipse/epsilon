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


public class Region {

	public int offset, length;
	
	public Region(int offset, int length) {
		this.offset = offset;
		this.length = length;
	}

	
	// Getters for compatibility with JavaModel, which are used in acceptance tests

	public int getOffset() {
		return offset;
	}
	
	public int getLength() {
		return length;
	}
}
