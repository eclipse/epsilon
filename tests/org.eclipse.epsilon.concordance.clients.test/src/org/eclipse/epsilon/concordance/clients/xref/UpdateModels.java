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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.EventType;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.Test;

public class UpdateModels extends CrossReferenceReconcilerIntegrationTest {
	
	private final static String NO_REFS = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                      "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" name=\"Fat Cat Records\">" + "\n" +
	                                      "  <artists name=\"Sigur Ros\"/>" + "\n" +
	                                      "</label:RecordLabel>";
	
	private final static String WITH_REFERENCE = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                             "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" name=\"Fat Cat Records\">" + "\n" +
	                                             "  <artists name=\"Sigur Ros\" influences=\"target1.model#//@artists.0\"/>" + "\n" +
	                                             "</label:RecordLabel>";
	
	
	private final static String TARGET1_WITHOUT_ARTISTS = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                                     "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_dy6cYOlcEd6sWK81OWLGdQ\" name=\"Parlophone\"/>";
	
	private final static String TARGET1_REPLACEMENTS = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                                   "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_dy6cYOlcEd6sWK81OWLGdQ\" name=\"Parlophone\">" + "\n" +
	                                                   "  <artists name=\"Weezer\"/>" + "\n" +
	                                                   "  <artists name=\"Foo Fighters\"/>" + "\n" +
	                                                   "</label:RecordLabel>";
	
	private IFile norefs;
	
	@Test
	public void crossReferenceShouldNotBeMarkedAsDanglingWhenIntroducedViaUpdate() throws CoreException, InterruptedException, EolModelLoadingException {
		norefs  = createFile(project, "norefs.model", NO_REFS);
		waitFor(event(EventType.ADD, norefs));
		
		changeFileContents(norefs, WITH_REFERENCE);
		waitFor(event(EventType.CHANGE, norefs));
		
		hasReferencesTo(norefs, "Radiohead");
	}
	
	@Test
	public void shouldNotCacheCrossReferenceRemovedViaUpdate() throws CoreException, InterruptedException {
		changeFileContents(source1, NO_REFS);
		waitFor(event(EventType.CHANGE, source1));
		
		deleteResource(target2);
		waitFor(event(EventType.DELETE, target2));
		
		hasNoDanglingReferences(source1);
	}

	@Test
	public void shouldMarkCrossReferenceAsDanglingWhenTargetModelElementIsRemoved() throws CoreException, InterruptedException {
		changeFileContents(target1, TARGET1_WITHOUT_ARTISTS);
		waitFor(event(EventType.CHANGE, target1));
		
		hasDanglingMarker(source1, "Death Cab For Cutie", uriForArtist(target1, 0));
		
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 0));
		hasDanglingMarker(source2, "Bright Eyes", uriForArtist(target1, 1));
	}
	
	@Test
	public void shouldReconcileCrossReferenceWhenTargetModelElementsAreReplaced() throws CoreException, InterruptedException, EolModelLoadingException {
		changeFileContents(target1, TARGET1_REPLACEMENTS);
		waitFor(event(EventType.CHANGE, target1));
	
		hasNoDanglingReferences(source1);
		hasReferencesTo(source1, "Weezer", "Nirvana");
		
		hasNoDanglingReferences(source2);
		hasReferencesTo(source2, "Weezer", "Foo Fighters");
	}
}
