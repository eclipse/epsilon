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
package org.eclipse.epsilon.egl.dt.traceability.fine.emf;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.EmfModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.ModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.Position;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.Region;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TextLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.Trace;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TraceElement;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.trace.TraceFactory;

public class Pojo2Emf {

	public Trace transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace original) {
		final Trace transformed = TraceFactory.eINSTANCE.createTrace();
		transformed.getElements().addAll(transform(original.elements));
		transformed.getLocations().addAll(transform(original.locations));
		return transformed;
	}
	
	private Collection<? extends TraceElement> transform(Collection<org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement> original) {
		final Collection<TraceElement> transformed = new LinkedList<TraceElement>();
		
		for (org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement element : original) {
			transformed.add(transform(element));
		}
		
		return transformed;
	}
	
	private TraceElement transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceElement original) {
		final TraceElement transformed = TraceFactory.eINSTANCE.createTraceElement();
		transformed.setSource(transform(original.source));
		transformed.setDestination(transform(original.destination));
		return transformed;
	}

	private ModelLocation transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation original) {
		if (!(original.modelElement instanceof EObject))
			throw new IllegalArgumentException("Cannot translate model locations whose model element is: " + original.modelElement);
			
		final EmfModelLocation transformed = TraceFactory.eINSTANCE.createEmfModelLocation();
		transformed.setModelElement((EObject)original.modelElement);
		transformed.setFeatureName(original.featureName);
		return transformed;					
	}

	private TextLocation transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation original) {
		final TextLocation transformed = TraceFactory.eINSTANCE.createTextLocation();
		transformed.setRegion(transform(original.region));
		return transformed;
	}

	private Region transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region original) {
		final Region transformed = TraceFactory.eINSTANCE.createRegion();
		transformed.setStart(transform(original.start));
		transformed.setEnd(transform(original.end));
		return transformed;
	}

	private Position transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.Position original) {
		final Position transformed = TraceFactory.eINSTANCE.createPosition();
		transformed.setLine(original.line);
		transformed.setColumn(original.column);
		return transformed;
	}

	private Collection<? extends TextLocation> transform(List<org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation> original) {
		final Collection<TextLocation> transformed = new LinkedList<TextLocation>();
		
		for (org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation element : original) {
			transformed.add(transform(element));
		}
		
		return transformed;
	}
	
}
