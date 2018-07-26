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

import org.eclipse.epsilon.concordance.history.ConcordanceHistory.Event;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.EventType;
import org.eclipse.epsilon.concordance.model.IConcordanceModel;
import org.eclipse.epsilon.concordance.reporter.model.DefaultModelChangeListener;

public class CrossReferenceReconciler extends DefaultModelChangeListener {
	
	private final DanglingCrossReferenceMarker marker;
	private final DanglingCrossReferenceUnmarker unmarker;
	private final DanglingCrossReferenceReconciler reconciler;
	
	public CrossReferenceReconciler() {
		super();

		marker     = new DanglingCrossReferenceMarker(index);
		unmarker   = new DanglingCrossReferenceUnmarker(index);
		reconciler = new DanglingCrossReferenceReconciler(index);
	}
	
	
	@Override
	public void modelAdded(IConcordanceModel model) {
//		System.out.println("model added: " + model);
		
		//Profiler.INSTANCE.start("Add");
		unmarker.unmarkResolvedCrossReferencesTo(model);
		//Profiler.INSTANCE.stop("Add");

		
		history.log(new Event(EventType.ADD, model));
	}
	
	@Override
	public void modelRemoved(IConcordanceModel model) {
//		System.out.println("model removed: " + model);
		//Profiler.INSTANCE.start("Delete");
		marker.markDanglingCrossReferencesTo(model);
		//Profiler.INSTANCE.stop("Delete");
		
		history.log(new Event(EventType.DELETE, model));
	}
	
	@Override
	public void modelChanged(IConcordanceModel model) {
//		System.out.println("model changed: " + model);
		
		//Profiler.INSTANCE.start("Change");
		marker.markDanglingCrossReferencesTo(model);
		unmarker.unmarkResolvedCrossReferencesTo(model);
		//Profiler.INSTANCE.stop("Change");
		
		history.log(new Event(EventType.CHANGE, model));
	}
	
	@Override
	public void modelMoved(IConcordanceModel original, IConcordanceModel moved) {
//		System.out.println("model moved: " + original + " to " + moved);
		//Profiler.INSTANCE.start("Move");
		reconciler.reconcileCrossReferences(original, moved);
		//Profiler.INSTANCE.stop("Move");

		history.log(new Event(EventType.MOVE, moved));
	}
}
