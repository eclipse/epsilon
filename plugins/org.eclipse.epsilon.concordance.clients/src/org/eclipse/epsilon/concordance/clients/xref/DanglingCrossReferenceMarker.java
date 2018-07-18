/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.clients.xref;

import org.eclipse.epsilon.concordance.index.ConcordanceIndex;
import org.eclipse.epsilon.concordance.model.CrossReference;
import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;

public class DanglingCrossReferenceMarker {

	private final ConcordanceIndex index;
	private final CrossReferenceVisitor visitor = new DanglingCrossReferenceMarkingVisitor();
	
	public DanglingCrossReferenceMarker(ConcordanceIndex index) {
		this.index = index;
	}
	
	public void markDanglingCrossReferencesTo(IConcordanceModel model) {
		index.visitAllCrossReferencesWithTarget(model, visitor);
	}
	
	static class DanglingCrossReferenceMarkingVisitor implements CrossReferenceVisitor {

		public void visit(CrossReference crossReference) {
			new MarkerManager(crossReference.source.getResource()).addErrorMarker(crossReference);
		}
		
	}
}
