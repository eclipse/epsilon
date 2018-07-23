/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Region))
			return false;
		
		final Region other = (Region)object;
		
		return offset == other.offset &&
		       length == other.length;
	}

	@Override
	public int hashCode() {
		return offset + length;
	}
	
	@Override
	public String toString() {
		return offset + "+" + length; 
	}
}
