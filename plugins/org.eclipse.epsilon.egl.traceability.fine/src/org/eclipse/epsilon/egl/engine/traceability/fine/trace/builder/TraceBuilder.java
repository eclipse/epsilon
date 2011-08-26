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
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceFactory;


public class TraceBuilder {
	
	private final Trace trace = TraceFactory.eINSTANCE.createTrace();
	
	public void withTraceElements(Collection<ModelLocation> featureAccesses, Region destination) {
		if (!featureAccesses.isEmpty()) {
			withTraceElements(featureAccesses, createTextLocationFor(destination));
		}
	}
	
	private TextLocation createTextLocationFor(Region region) {
		final TextLocation location = TraceFactory.eINSTANCE.createTextLocation();
		location.setRegion(region);
		return location;
	}
	
	private void withTraceElements(Collection<ModelLocation> featureAccesses, TextLocation destination) {
		trace.getLocations().add(destination);
		
		for (ModelLocation featureAccess : featureAccesses) {
			trace.getElements().add(createTraceElement(featureAccess, destination));
		}
	}

	private TraceElement createTraceElement(ModelLocation featureAccess, TextLocation destination) {
		final TraceElement element = TraceFactory.eINSTANCE.createTraceElement();
		element.setSource(featureAccess);
		element.setDestination(destination);
		return element;
	}
	
	
	public void withResource(String resource) {
		for (TextLocation location : trace.getLocations()) {
			location.getResources().add(resource);
		}
	}
	
	public Trace build() {
		return trace;
	}
}
