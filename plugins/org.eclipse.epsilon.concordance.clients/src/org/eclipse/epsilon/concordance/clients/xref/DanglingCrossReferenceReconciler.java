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
package org.eclipse.epsilon.concordance.clients.xref;

import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.Model;
import org.eclipse.epsilon.concordance.model.ModelVisitor;

public class DanglingCrossReferenceReconciler {

	private final ConcordanceIndex index;
	
	public DanglingCrossReferenceReconciler(ConcordanceIndex index) {
		this.index = index;
	}
	
	public void reconcileCrossReferences(Model original, Model moved) {
		moved.reconcileCrossReferences(original, moved);
		
		final CrossReferenceTargetReconcilingVisitor reconciler = new CrossReferenceTargetReconcilingVisitor(original, moved);
		
		index.visitAllModelsWithCrossReferencesTo(original, reconciler);
		index.visitAllModelsWithCrossReferencesTo(moved,    reconciler);
	}
	
	static class CrossReferenceTargetReconcilingVisitor extends ModelVisitor {

		private final Model original, moved;
		
		public CrossReferenceTargetReconcilingVisitor(Model original, Model moved) {
			this.original = original;
			this.moved    = moved;
		}

		@Override
		public void visit(Model model) {
			model.reconcileCrossReferences(original, moved);
		}
	}

}
