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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.EventType;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.Test;

public class MoveModels extends CrossReferenceReconcilerIntegrationTest {
	
	@Test
	public void shouldReconcileCrossReferencesWhenFirstSourceModelIsMoved() throws CoreException, InterruptedException, EolModelLoadingException {
		createFolder(project, "container");
		source1 = moveFile(source1, "container/new_source1.model");
		waitFor(event(EventType.MOVE, source1));
		
		crossReferencesResolveToExpectedValues();
	}
	
	@Test
	public void shouldReconcileCrossReferenceWhenSecondSourceModelIsMoved() throws CoreException, InterruptedException, EolModelLoadingException {
		createFolder(project, "container");
		source2 = moveFile(source2, "container/new_source2.model");
		waitFor(event(EventType.MOVE, source2));
		
		crossReferencesResolveToExpectedValues();
	}
	
	@Test
	public void shouldReconcileCrossReferenceWhenFirstTargetModelIsMoved() throws CoreException, InterruptedException, EolModelLoadingException {
		createFolder(project, "container");
		target1 = moveFile(target1, "container/new_target1.model");
		waitFor(event(EventType.MOVE, target1));
		
		crossReferencesResolveToExpectedValues();
	}
	
	@Test
	public void shouldReconcileCrossReferenceWhenSecondTargetModelIsMoved() throws CoreException, InterruptedException, EolModelLoadingException {
		createFolder(project, "container");
		target2 = moveFile(target2, "container/new_target2.model");
		waitFor(event(EventType.MOVE, target2));
		
		crossReferencesResolveToExpectedValues();
	}
	
	@Test
	public void shouldReconcileCrossReferenceWhenAllModelsAreMoved() throws CoreException, InterruptedException, EolModelLoadingException {
		createFolder(project, "container1");
		createFolder(project, "container2");
		createFolder(project, "container3");
		createFolder(project, "container4");
		
		source1 = moveFile(source1, "container1/new_source1.model");
		source2 = moveFile(source2, "container2/new_source2.model");
		target1 = moveFile(target1, "container3/new_target1.model");
		target2 = moveFile(target2, "container4/new_target2.model");
		
		waitFor(event(EventType.MOVE, source1), event(EventType.MOVE, source2), event(EventType.MOVE, target1), event(EventType.MOVE, target2));
		
		crossReferencesResolveToExpectedValues();
	}
	
	
	@Test
	public void shouldUpdateCrossReferenceTargetsWhenTargetModelIsMoved() throws CoreException, InterruptedException, EolModelLoadingException {
		createFolder(project, "container");
		target1 = moveFile(target1, "container/new_target1.model");
		waitFor(event(EventType.MOVE, target1));
		
		crossReferencesResolveToExpectedValues();
		
		deleteResource(target1);
		waitFor(event(EventType.DELETE, target1));
		
		hasDanglingMarker(source1, "Death Cab For Cutie", uriForArtist(target1, 0));
		
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 0));
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 1));
	}
}
