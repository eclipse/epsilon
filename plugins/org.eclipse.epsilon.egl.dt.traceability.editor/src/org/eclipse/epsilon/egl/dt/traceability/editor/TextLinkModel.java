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
package org.eclipse.epsilon.egl.dt.traceability.editor;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.EmfModelLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TextLocation;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TextlinkPackage;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TraceLink;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;

public class TextLinkModel {
	
	private final EmfModel model;
	private final String fileName;
	
	public TextLinkModel(EmfModel model, String fileName) {
		this.model = model;
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public Collection<TraceLink> getTraceLinks() {
		final Collection<TraceLink> traceLinks = new LinkedList<TraceLink>();
		
		try {
			for (EObject traceElement : model.getAllOfKind("TraceLink")) {
				if (traceElement instanceof TraceLink) {
					traceLinks.add((TraceLink)traceElement);
				}
			}
		
		} catch (EolModelElementTypeNotFoundException e) {
			throw new TextLinkException("Error encountered whilst extracting TraceElements from Textlink model", e);
		}
		
		return traceLinks;
	}

	public Set<Resource> getSources() {
		final Set<Resource> resources = new HashSet<Resource>();
		
		for (EmfModelLocation modelLocation : getEmfModelLocations()) {
			resources.add(modelLocation.getModelElement().eResource());
		}
		
		return resources;
	}
	
	public Set<String> getDestinations() {
		final Set<String> resources = new HashSet<String>();
		
		for (TextLocation textLocation : getTextLocations()) {
			resources.add(textLocation.getResource());
		}
		
		return resources;
	}
		
	private Collection<EmfModelLocation> getEmfModelLocations() {
		final List<EmfModelLocation> result = new LinkedList<EmfModelLocation>();
			
		for (EObject modelElement : getAllOfKind(TextlinkPackage.eINSTANCE.getEmfModelLocation())) {
			result.add((EmfModelLocation)modelElement);
		}
		
		return result;
	}

	private Collection<TextLocation> getTextLocations() {
		final List<TextLocation> result = new LinkedList<TextLocation>();
			
		for (EObject modelElement : getAllOfKind(TextlinkPackage.eINSTANCE.getTextLocation())) {
			result.add((TextLocation)modelElement);
		}
		
		return result;
	}
	
	/*
	 * This method takes an EClass rather than a String to force clients to 
	 * access types via TextlinkPackage. This way, a compile-time error will 
	 * occur if the Textlink metamodel is changed in a manner that is
	 * incompatible with this class. 
	 */
	private Collection<EObject> getAllOfKind(EClass textlinkType) {
		final String textlinkTypeName = textlinkType.getName();

		try {
			return model.getAllOfKind(textlinkTypeName);
			
		} catch (EolModelElementTypeNotFoundException e) {
			throw new IllegalStateException("Error encountered whilst navigating TextLink model. The following TextLink type was not found: " + textlinkTypeName);
		}
	}

	public TextLocation getFirstDestinationFor(EObject source) {
		for (TraceLink traceLink : getTraceLinks()) {
			if (traceLink.getSource() instanceof EmfModelLocation && sameEObject(source, ((EmfModelLocation)traceLink.getSource()).getModelElement())) {
				return traceLink.getDestination();
			}
		}
		
		return null;
	}
	
	private boolean sameEObject(EObject first, EObject second) {
		return first.equals(first.eResource().getEObject(getURIFragmentFor(second)));
	}

	private String getURIFragmentFor(EObject first) {
		return first.eResource().getURIFragment(first);
	}
}