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
package org.eclipse.epsilon.egl.engine.traceability.fine.trace.builder;

import java.util.Collection;

import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement;


public class TraceBuilder {
	
	private final Trace trace = new Trace();
	
	public void withTraceElements(Collection<ModelLocation> propertyAccesses, Region destination) {
		if (!propertyAccesses.isEmpty()) {
			withTraceElements(propertyAccesses, createTextLocationFor(destination));
		}
	}
	
	private TextLocation createTextLocationFor(Region region) {
		return new TextLocation(region);
	}
	
	private void withTraceElements(Collection<ModelLocation> propertyAccesses, TextLocation destination) {
		trace.locations.add(destination);
		
		for (ModelLocation propertyAccess : propertyAccesses) {
			trace.elements.add(createTraceElement(propertyAccess, destination));
		}
	}

	private TraceElement createTraceElement(ModelLocation source, TextLocation destination) {
		return new TraceElement(source, destination);
	}
	
	
	public void withResource(String resource) {
		for (TextLocation location : trace.locations) {
			location.resources.add(resource);
		}
	}
	
	public Trace build() {
		return trace;
	}
}
