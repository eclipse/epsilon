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
	public String resource;
	
	public TextLocation(Region region) {
		this.region = region;
	}


	// Getters for compatibility with JavaModel, which are used in acceptance tests

	public String getResource() {
		return resource;
	}
	
	public void setResource(String resource) {
		this.resource = resource;
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
}
