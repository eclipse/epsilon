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
import org.junit.Test;

public class DeleteModels extends CrossReferenceReconcilerIntegrationTest {
		
	@Test
	public void shouldMarkCrossReferenceAsDanglingWhenFirstTargetModelIsDeleted() throws CoreException, InterruptedException {
		deleteResource(target1);
		waitFor(event(EventType.DELETE, target1));
	
		hasDanglingMarker(source1, "Death Cab For Cutie", uriForArtist(target1, 0));
		
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 0));
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 1));
	}

	@Test
	public void shouldMarkCrossReferenceAsDanglingWhenSecondTargetModelIsDeleted() throws CoreException, InterruptedException {
		deleteResource(target2);
		waitFor(event(EventType.DELETE, target2));
		
		hasDanglingMarker(source1, "Death Cab For Cutie", uriForArtist(target2, 0));
	}
	
	@Test
	public void shouldMarkCrossReferencesAsDanglingWhenTargetModelsAreDeleted() throws CoreException, InterruptedException {
		deleteResource(target1);
		deleteResource(target2);
		waitFor(event(EventType.DELETE, target1), event(EventType.DELETE, target2));
		
		hasDanglingMarker(source1, "Death Cab For Cutie", uriForArtist(target1, 0));
		hasDanglingMarker(source1, "Death Cab For Cutie", uriForArtist(target2, 0));
		
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 0));
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 1));
	}
	
	@Test
	public void shouldNotAffectTargetModelWhenSourceModelsAreDeleted() throws CoreException, InterruptedException {
		deleteResource(source1);
		deleteResource(source2);
		waitFor(event(EventType.DELETE, source1), event(EventType.DELETE, source2));
		
		hasNoDanglingReferences(target1);
		hasNoDanglingReferences(target2);
	}
}
