/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * Copyright (c) 2014 University of Twente.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Maarten Bezemer - split into base and resource backing implementation
 ******************************************************************************/
package org.eclipse.epsilon.concordance.model;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.concordance.model.nsuri.EObjectContainer;
import org.eclipse.epsilon.concordance.model.nsuri.ModelWalkingNsUriAnalyser;

/**
 * Base/partial implementation of {@link IConcordanceModel}, defining all
 * interface methods that do not require any resource-backing specific
 * implementation.
 */
abstract public class ConcordanceModelBase implements IConcordanceModel,
		EObjectContainer {
	public boolean isInstance(String nsUri) {
		return nsUri.equals(getNsUri());
	}

	public String getNsUri() {
		// Profiler.INSTANCE.start("DetermineNsUri");
		final Collection<String> nsUris = new ModelWalkingNsUriAnalyser(this)
				.determineNsUris();
		// Profiler.INSTANCE.stop("DetermineNsUri");

		return nsUris.isEmpty() ? null : nsUris.iterator().next();
	}

	public Iterator<EObject> getAllContentsIterator(boolean resolve)
			throws IOException {
		Resource resource = getEmfResource(resolve);
		if(resource == null) {
			// Return an empty iterator
			return Collections.<EObject>emptyList().iterator();
		}
		return resource.getAllContents();
	}

	public Collection<EObject> getAllContents(boolean resolve)
			throws IOException {
		// Create a new list
		final Collection<EObject> contents = new LinkedList<EObject>();

		for (Iterator<EObject> iterator = getAllContentsIterator(resolve); iterator
				.hasNext();) {
			// Add item to the list
			contents.add(iterator.next());
		}

		// Return the newly created list
		return contents;
	}

	public Set<IConcordanceModel> getAllReferencedModels() {
		final Set<IConcordanceModel> referencedModels = new HashSet<IConcordanceModel>();

		for (CrossReference xref : getAllCrossReferences()) {
			referencedModels.add(xref.target.model);
		}

		return referencedModels;
	}

	public Set<CrossReference> getAllCrossReferences() {
		return new CrossReferenceAnalyser(this).determineCrossReferences();
	}

	public void reconcileCrossReferences(IConcordanceModel original,
			IConcordanceModel moved) {
		new CrossReferenceReconciler(this).reconcile(original, moved);
	}

	public boolean contains(String modelElementFragment) {
		return new ContentAnalyser(this).contains(modelElementFragment);
	}

}
