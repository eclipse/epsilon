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
import java.util.Map;

import org.eclipse.epsilon.egl.engine.traceability.fine.context.SelectivePropertyAccessRecorder.PropertyAccess;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceLink;


public class TraceBuilder {
	
	private final Trace trace = new Trace();	
	
	public void fromPropertyAccesses(Collection<PropertyAccess> propertyAccesses, Region destination) {
		if (!propertyAccesses.isEmpty()) {
			fromPropertyAccesses(propertyAccesses, createTextLocationFor(destination));
		}
	}
	
	private TextLocation createTextLocationFor(Region region) {
		return new TextLocation(region);
	}
	
	private void fromPropertyAccesses(Collection<PropertyAccess> propertyAccesses, TextLocation destination) {
		trace.locations.add(destination);
		
		for (PropertyAccess propertyAccess : propertyAccesses) {
			trace.traceLinks.add(createTraceLink(propertyAccess.toModelLocation(), destination, propertyAccess.customData));
		}
	}

	private TraceLink createTraceLink(ModelLocation source, TextLocation destination, Map<String, String> customData) {
		return new TraceLink(source, destination, customData);
	}
	
	public Trace build() {
		return trace;
	}
}
