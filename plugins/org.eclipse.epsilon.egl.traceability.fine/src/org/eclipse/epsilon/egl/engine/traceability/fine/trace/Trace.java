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

public class Trace {

	public final List<TextLocation> locations = new LinkedList<TextLocation>();
	public final List<TraceLink> elements = new LinkedList<TraceLink>();
	
	
	// Getters for compatibility with JavaModel, which are used in acceptance tests 
	
	public List<TraceLink> getElements() {
		return elements;
	}
	
	public List<TextLocation> getLocations() {
		return locations;
	}

	public Collection<? extends Object> getAllContents() {
		final List<Object> allContents = new LinkedList<Object>();
		allContents.add(this);
	
		for (TraceLink element : elements) {
			allContents.addAll(element.getAllContents());
		}
		
		for (TextLocation location : locations) {
			allContents.addAll(location.getAllContents());
		}
		
		return allContents;
	}
}
