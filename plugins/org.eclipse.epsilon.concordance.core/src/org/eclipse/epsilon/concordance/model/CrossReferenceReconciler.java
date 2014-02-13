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

import org.eclipse.emf.ecore.resource.Resource;
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
			res = renaming.renamed.getEmfResource(false);

			EcoreUtil.resolveAll(res);

			res.setURI(renaming.renamed.getUri());

		} else {
			res = reconcilee.getEmfResource(false);

			final Resource renamed = renaming.renamed.getEmfResource(false);

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
	}
}
