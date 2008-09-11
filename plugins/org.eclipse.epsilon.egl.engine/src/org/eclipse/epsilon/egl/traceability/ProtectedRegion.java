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
package org.eclipse.epsilon.egl.traceability;

public class ProtectedRegion extends Content<OutputFile> {

	private final String id;
	private final boolean enabled;
	private final int offset;
	
	protected ProtectedRegion(OutputFile parent, String id, boolean enabled, int offset) {
		super(parent);
		
		if (parent == null)
			throw new NullPointerException("parent cannot be null");
		
		if (id == null)
			throw new NullPointerException("id cannot be null");
		
		this.id      = id;
		this.enabled = enabled;
		this.offset  = offset;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public String getId() {
		return id;
	}

	public int getOffset() {
		return offset;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) return false;
		if (!(o instanceof ProtectedRegion)) return false;
		
		final ProtectedRegion that = (ProtectedRegion)o;
		
		return id.equals(that.id)      &&
		       enabled == that.enabled &&
		       offset  == that.offset;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result += 37 * result + id.hashCode();
		result += 37 * result + (enabled ? 1 : 0);
		result += 37 * result + offset;
		
		return result;
	}
	
	@Override
	public String toString() {
		return id + "[" + (enabled ? "on" : "off") + "]" + "@" + offset;
	}
}
