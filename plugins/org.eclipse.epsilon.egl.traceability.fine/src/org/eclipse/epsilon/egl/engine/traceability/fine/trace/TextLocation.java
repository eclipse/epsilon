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
import java.util.LinkedList;
import java.util.List;

public class TextLocation {

	public final Region region;
	public final String resource;
	
	public TextLocation(Region region) {
		this(region, null);
	}
	
	public TextLocation(Region region, String resource) {
		this.region = region;
		this.resource = resource;
	}


	// Getters for compatibility with JavaModel, which are used in acceptance tests

	public String getResource() {
		return resource;
	}
	
	public Region getRegion() {
		return region;
	}
	
	public Collection<? extends Object> getAllContents() {
		final List<Object> allContents = new LinkedList<Object>();
		allContents.add(this);
		allContents.add(region);
		return allContents;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TextLocation))
			return false;
		
		final TextLocation other = (TextLocation)object;
		
		return (resource == null ? other.resource == null : resource.equals(other.resource)) &&
		       region.equals(other.region);
	}

	@Override
	public int hashCode() {
		return (resource == null ? 0 : resource.hashCode()) + region.hashCode();
	}
	
	@Override
	public String toString() {
		final String resourceName = resource == null ? "unknown" : resource;
		return resourceName + "@" + region; 
	}
}
