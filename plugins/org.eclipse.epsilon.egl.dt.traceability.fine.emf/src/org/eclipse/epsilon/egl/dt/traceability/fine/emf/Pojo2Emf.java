/*******************************************************************************
\ * Copyright (c) 2011 The University of York.
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
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.egl.dt.extensions.fineGrainedTracePostprocessor.IFineGrainedTracePostprocessor;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.EmfModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.ModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.Region;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TextLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TextlinkFactory;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TextlinkPackage;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.Trace;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TraceLink;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TraceLinkData;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TraceLinkDataItem;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;

public class Pojo2Emf implements IFineGrainedTracePostprocessor {
	
	@Override
	public void postprocess(org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace trace) {
		new InMemoryEmfModel("Trace", EmfUtil.createResource(transform(trace)), TextlinkPackage.eINSTANCE).store(trace.getDestination());
	}	
		
	private Trace transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.Trace original) {
		final Trace transformed = TextlinkFactory.eINSTANCE.createTrace();
		transformed.getTraceLinks().addAll(transform(original.traceLinks));
		return transformed;
	}
	
	private Collection<? extends TraceLink> transform(Collection<org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceLink> original) {
		final Collection<TraceLink> transformed = new LinkedList<TraceLink>();
		
		for (org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceLink element : original) {
			transformed.add(transform(element));
		}
		
		return transformed;
	}
	
	private TraceLink transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.TraceLink original) {
		final TraceLink transformed = TextlinkFactory.eINSTANCE.createTraceLink();
		transformed.setCustomData(transform(original.customData));
		transformed.setSource(transform(original.source));
		transformed.setDestination(transform(original.destination));
		return transformed;
	}

	private TraceLinkData transform(Map<String, String> customData) {
		final TraceLinkData transformed = TextlinkFactory.eINSTANCE.createTraceLinkData();
		for (Map.Entry<String, String> item : customData.entrySet()) {
			transformed.getItems().add(transform(item));
		}
		return transformed;
	}

	private TraceLinkDataItem transform(Entry<String, String> item) {
		final TraceLinkDataItem transformed = TextlinkFactory.eINSTANCE.createTraceLinkDataItem();
		transformed.setKey(item.getKey());
		transformed.setValue(item.getValue());
		return transformed;
	}

	private ModelLocation transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.ModelLocation original) {
		if (!(original.modelElement instanceof EObject))
			throw new IllegalArgumentException("Cannot translate model locations whose model element is: " + original.modelElement);
			
		final EmfModelLocation transformed = TextlinkFactory.eINSTANCE.createEmfModelLocation();
		transformed.setModelElement((EObject)original.modelElement);
		transformed.setPropertyName(original.propertyName);
		return transformed;					
	}

	private TextLocation transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.TextLocation original) {
		final TextLocation transformed = TextlinkFactory.eINSTANCE.createTextLocation();
		transformed.setResource(original.resource);
		transformed.setRegion(transform(original.region));
		return transformed;
	}

	private Region transform(org.eclipse.epsilon.egl.engine.traceability.fine.trace.Region original) {
		final Region transformed = TextlinkFactory.eINSTANCE.createRegion();
		transformed.setOffset(original.offset);
		transformed.setLength(original.length);
		return transformed;
	}
}
