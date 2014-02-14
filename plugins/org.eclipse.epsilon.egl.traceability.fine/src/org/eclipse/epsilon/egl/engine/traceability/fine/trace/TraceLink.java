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
import java.util.Map;

public class TraceLink {

	public final ModelLocation source;
	public final TextLocation destination;
	public final Map<String, String> customData;

	public TraceLink(ModelLocation source, TextLocation destination, Map<String, String> customData) {
		this.source = source;
		this.destination = destination;
		this.customData = customData;
	}

	
	// Getters for compatibility with JavaModel, which are used in acceptance tests
	
	public ModelLocation getSource() {
		return source;
	}
	
	public TextLocation getDestination() {
		return destination;
	}
	
	public Map<String, String> getCustomData() {
		return customData;
	}

	public Collection<? extends Object> getAllContents() {
		final List<Object> allContents = new LinkedList<Object>();
		allContents.add(this);
		allContents.addAll(source.getAllContents());
		allContents.addAll(destination.getAllContents());
		return allContents;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof TraceLink))
			return false;
		
		final TraceLink other = (TraceLink)object;
		
		return source.equals(other.source) &&
		       destination.equals(other.destination) &&
		       customData.equals(other.customData);
	}

	@Override
	public int hashCode() {
		return source.hashCode() + destination.hashCode() + customData.hashCode();
	}
}
