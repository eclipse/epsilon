/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * Copyright (c) 2014 University of Twente.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Maarten Bezemer - Make use of IConcordanceModel methods
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.model;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;

public class CrossReferenceReconciler {

	private final IConcordanceModel reconcilee;

	public CrossReferenceReconciler(IConcordanceModel reconcilee) {
		this.reconcilee = reconcilee;
	}

	public void reconcile(IConcordanceModel original, IConcordanceModel moved) {
		try {
			reconcile(new Renaming(original, moved));
		} catch (IOException e) {
			LogUtil.log("Error encountered whilst trying to reconcile " + reconcilee + " by changing " + original + " to " + moved, e);
		}
	}

	private void reconcile(Renaming renaming) throws IOException {
		final Resource res;

		if (renaming.isRenamed(reconcilee)) {
			res = renaming.loadRenamedResource();

			EcoreUtil.resolveAll(res);
			res.setURI(renaming.renamed.getUri());

		} else {
			res = reconcilee.getEmfResource(false);

			final Resource renamed = renaming.loadRenamedResource();

			res.getResourceSet().getResources().add(renamed);
			EcoreUtil.resolveAll(res);

			renamed.setURI(renaming.renamed.getUri());
		}

		res.save(null);
	}

	private static class Renaming {

		public final IConcordanceModel original, renamed;

		public Renaming(IConcordanceModel original, IConcordanceModel renamed) {
			this.original = original;
			this.renamed  = renamed;
		}

		private boolean isRenamed(IConcordanceModel model) {
			return renamed.equals(model);
		}

		/**
		 * Provides (a copy of) the renamed model and fixes the broken external
		 * cross/proxy references (if there are any), caused by renaming the model.
		 *
		 * @return a resource with the copied contents of the renamed model
		 * @throws IOException
		 *             when obtaining 'renamed model' failed
		 */
		public Resource loadRenamedResource() throws IOException {
			// Create a copy of the contents of the renamed model
			final Resource renamedResource = renamed.getEmfResource(false);
			final Collection<EObject> copiedContents = EcoreUtil
					.copyAll(renamedResource.getContents());

			Map<EObject, Collection<Setting>> map = EcoreUtil.ExternalCrossReferencer
					.find(copiedContents);
			for (EObject o : map.keySet()) {
				InternalEObject eObject = (InternalEObject) o;
				// Find all proxied cross references
				if (eObject.eIsProxy()) {
					// Correct URI: replace renamed-based URI with
					// original-based URI (so all references are intact again)
					URI uri = eObject.eProxyURI();
					uri = uri.deresolve(renamed.getUri());
					uri = uri.resolve(original.getUri());
					eObject.eSetProxyURI(uri);
				}
			}

			// Put copied content into a new resource
			final Resource resource = new ResourceSetImpl()
					.createResource(original.getUri());
			resource.getContents().addAll(copiedContents);

			return resource;
		}
	}
}
