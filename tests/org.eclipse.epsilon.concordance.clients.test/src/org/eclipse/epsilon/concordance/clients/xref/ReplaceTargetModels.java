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

import static org.junit.Assert.assertEquals;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.EventType;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.Test;

public class ReplaceTargetModels extends CrossReferenceReconcilerIntegrationTest {
		
	private final static String TARGET1_REPLACEMENT = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                                 "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_dy6cYOlcEd6sWK81OWLGdQ\" name=\"Parlophone\">" + "\n" +
	                                                 "  <artists name=\"Weezer\"/>" + "\n" +
	                                                 "</label:RecordLabel>";
	
	private final static String TARGET2_REPLACEMENT = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                                  "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_dy6cYOlcEd6sWK81OWLGdQ\" name=\"Sub Pop\">" + "\n" +
	                                                  "  <artists name=\"Sunny Day Real Estate\"/>" + "\n" +
	                                                  "</label:RecordLabel>";
	
	@Test
	public void shouldReconcileCrossReferencesWhenFirstTargetModelIsDeletedAndLaterReplaced() throws CoreException, InterruptedException, EolModelLoadingException {
		deleteResource(target1);
		waitFor(event(EventType.DELETE, target1));
		
		assertEquals("Preconditions of test are not satisifed.", 1, danglingXrefMarkersOf(source1).length);
		assertEquals("Preconditions of test are not satisifed.", 2, danglingXrefMarkersOf(source2).length);
		
		changeFileContents(target1, TARGET1_REPLACEMENT);
		waitFor(event(EventType.ADD, target1));

		
		
		hasNoDanglingReferences(source1);
		hasReferencesTo(source1, "Weezer", "Nirvana");
		
		hasReferencesTo(source2, "Weezer");
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 1));
	}
	
	
	@Test
	public void shouldReconcileCrossReferenceWhenSecondTargetModelIsDeletedAndLaterReplaced() throws CoreException, InterruptedException, EolModelLoadingException {
		deleteResource(target2);
		waitFor(event(EventType.DELETE, target2));
		
		assertEquals("Preconditions of test are not satisifed.", 1, danglingXrefMarkersOf(source1).length);
		assertEquals("Preconditions of test are not satisifed.", 0, danglingXrefMarkersOf(source2).length);
		
		changeFileContents(target2, TARGET2_REPLACEMENT);
		waitFor(event(EventType.ADD, target2));
		
		
		hasNoDanglingReferences(source1);
		hasReferencesTo(source1, "Radiohead", "Sunny Day Real Estate");
		
		hasNoDanglingReferences(source2);
		hasReferencesTo(source2, "Radiohead", "The Beatles");
	}
	
	
	@Test
	public void shouldReconcileCrossReferencesWhenTargetModelsAreDeletedAndLaterReplaced() throws CoreException, InterruptedException, EolModelLoadingException {
		deleteResource(target1);
		deleteResource(target2);
		waitFor(event(EventType.DELETE, target1), event(EventType.DELETE, target2));;
		
		assertEquals("Preconditions of test are not satisifed.", 2, danglingXrefMarkersOf(source1).length);
		assertEquals("Preconditions of test are not satisifed.", 2, danglingXrefMarkersOf(source2).length);
		
		changeFileContents(target1, TARGET1_REPLACEMENT);
		changeFileContents(target2, TARGET2_REPLACEMENT);
		waitFor(event(EventType.ADD, target1), event(EventType.ADD, target2));;
		
		
		hasNoDanglingReferences(source1);
		hasReferencesTo(source1, "Weezer", "Sunny Day Real Estate");
		
		hasReferencesTo(source2, "Weezer");
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 1));	
	}
}
