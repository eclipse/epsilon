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

import java.util.Map;

import org.eclipse.epsilon.egl.engine.traceability.fine.context.EglPropertyAccessRecorder.EglPropertyAccess;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace;
import org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceLink;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccess;
import org.eclipse.epsilon.eol.execute.introspection.recording.IPropertyAccesses;


public class TraceBuilder {
	
	private final Trace trace = new Trace();	
	
	public void fromPropertyAccesses(IPropertyAccesses propertyAccesses, Region destination) {
		if (!propertyAccesses.isEmpty()) {
			fromPropertyAccesses(propertyAccesses, createTextLocationFor(destination));
		}
	}
	
	private TextLocation createTextLocationFor(Region region) {
		return new TextLocation(region);
	}
	
	private void fromPropertyAccesses(IPropertyAccesses propertyAccesses, TextLocation destination) {
		trace.locations.add(destination);
		
		for (IPropertyAccess propertyAccess : propertyAccesses.all()) {
			final EglPropertyAccess eglPropertyAccess = (EglPropertyAccess)propertyAccess;
			trace.traceLinks.add(createTraceLink(eglPropertyAccess.toModelLocation(), destination, eglPropertyAccess.getCustomData()));
		}
	}

	private TraceLink createTraceLink(ModelLocation source, TextLocation destination, Map<String, String> customData) {
		return new TraceLink(source, destination, customData);
	}
	
	public Trace build() {
		return trace;
	}
}
