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
package org.eclipse.epsilon.egl.merge.output;


public abstract class ProtectedRegion extends Region {
	
	private final String id;
	private final int offset;
	private final String defaultValue;
	
	private boolean enabled;
	
	protected ProtectedRegion(String id,
	                          int offset) {

		this(id, offset, true);
	}
	
	protected ProtectedRegion(String id,
	                          int offset,
	                          boolean enabled) {

		this(id, offset, enabled, "");
	}
	
	protected ProtectedRegion(String id,
	                          int offset,
	                          boolean enabled,
	                          String contents) {
		super(contents);
		
		if (id == null)
			throw new NullPointerException("id must not be null");
		
		this.id = id;
		this.offset = offset;
		this.enabled = enabled;
		this.defaultValue = contents;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getDefaultValue() {
		return defaultValue;
	}
	
	public String getId() {
		return id;
	}
	
	public int getOffset() {
		return offset;
	}

	
	@Override
	public abstract String toString();
	
	@Override
	public boolean equals(Object o) {
		if (o==null) return false;
		if (!(o instanceof ProtectedRegion)) return false;
		
		ProtectedRegion that = (ProtectedRegion)o;
		
		return id.equals(that.id)     &&
		       offset  == that.offset &&
		       enabled == that.enabled;
	}
	
	@Override
	public int hashCode() {
		int result = 17;
		
		result += 37 * result + id.hashCode();
		result += 37 * result + offset;
		result += 37 * result + (enabled ? 1 : 0);

		return result;
	}
}
