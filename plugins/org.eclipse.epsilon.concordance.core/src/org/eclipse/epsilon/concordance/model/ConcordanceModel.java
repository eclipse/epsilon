/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.model;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.concordance.model.nsuri.EObjectContainer;
import org.eclipse.epsilon.concordance.model.nsuri.ModelWalkingNsUriAnalyser;

/**
 * Default implementation of {@link IConcordanceModel} that uses the actual
 * model file for its operations
 */
public class ConcordanceModel implements IConcordanceModel, EObjectContainer {

	private final URI uri;
	
	public ConcordanceModel(IResource resource) {
		this(resource.getFullPath());
	}
	
	public ConcordanceModel(IPath path) {
		this(URI.createPlatformResourceURI(path.toOSString(), true));
	}
	
	public ConcordanceModel(URI uri) {
		this.uri = uri;
	}

	public URI getUri() {
		return uri;
	}
	
	public Collection<EObject> getAllContents(boolean resolve) throws IOException {
		final Collection<EObject> contents = new LinkedList<EObject>();
		
		for (Iterator<EObject> iterator = getEmfResource(resolve).getAllContents(); iterator.hasNext();) {
			contents.add(iterator.next());
		}
		
		return contents;
	}
	
	public Resource getEmfResource(boolean resolve) throws IOException {
		final Resource resource = new ResourceSetImpl().createResource(uri);
		
		resource.load(null);
//		resource.load(Collections.singletonMap(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true));
		if (resolve) EcoreUtil.resolveAll(resource);
		
		return resource;
	}
	
	public IResource getResource() {
		if (uri.isPlatformResource()) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		}
		
		return null;
	}

	public boolean isInstance(String nsUri) {
		return nsUri.equals(getNsUri());
	}

	public String getNsUri() {
		//Profiler.INSTANCE.start("DetermineNsUri");
		final Collection<String> nsUris = new ModelWalkingNsUriAnalyser(this).determineNsUris();
		//Profiler.INSTANCE.stop("DetermineNsUri");
		
		return nsUris.isEmpty() ? null : nsUris.iterator().next();
	}
	
	public Set<CrossReference> getAllCrossReferences() {
		return new CrossReferenceAnalyser(this).determineCrossReferences();
	}
	
	public Set<IConcordanceModel> getAllReferencedModels() {
		final Set<IConcordanceModel> referencedModels = new HashSet<IConcordanceModel>();
		
		for (CrossReference xref : getAllCrossReferences()) {
			referencedModels.add(xref.target.model);
		}
		
		return referencedModels;
	}
	
	public void reconcileCrossReferences(IConcordanceModel original, IConcordanceModel moved) {
		new CrossReferenceReconciler(this).reconcile(original, moved);
	}
	
	public boolean contains(String modelElementFragment) {
		return new ContentAnalyser(this).contains(modelElementFragment);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ConcordanceModel))
			return false;
		
		return ((ConcordanceModel)obj).uri.equals(this.uri);
	}
	
	@Override
	public int hashCode() {
		return uri.hashCode();
	}
	
	@Override
	public String toString() {
		return "Model (uri=" + uri + ")";
	}
}
