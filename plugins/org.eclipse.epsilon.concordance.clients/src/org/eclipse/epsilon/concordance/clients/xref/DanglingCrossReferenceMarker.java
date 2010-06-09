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
import org.eclipse.epsilon.concordance.model.CrossReference;
import org.eclipse.epsilon.concordance.model.CrossReferenceVisitor;
import org.eclipse.epsilon.concordance.model.Model;

public class DanglingCrossReferenceMarker {

	private final ConcordanceIndex index;
	private final CrossReferenceVisitor visitor = new DanglingCrossReferenceMarkingVisitor();
	
	public DanglingCrossReferenceMarker(ConcordanceIndex index) {
		this.index = index;
	}
	
	public void markDanglingCrossReferencesTo(Model model) {
		index.visitAllCrossReferencesWithTarget(model, visitor);
	}
	
	static class DanglingCrossReferenceMarkingVisitor implements CrossReferenceVisitor {

		public void visit(CrossReference crossReference) {
			new MarkerManager(crossReference.source.getResource()).addErrorMarker(crossReference);
		}
		
	}
}
