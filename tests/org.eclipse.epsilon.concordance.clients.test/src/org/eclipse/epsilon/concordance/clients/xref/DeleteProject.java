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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.concordance.history.ConcordanceHistory.EventType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeleteProject extends CrossReferenceReconcilerIntegrationTest {
	
	private IProject anotherProject;
	private IFile    anotherSource;
	
	private final static String EXT_SOURCE = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                         "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_XtTJAelcEd6sWK81OWLGdQ\" name=\"Atlantic\">" + "\n" +
	                                          "  <artists name=\"Death Cab For Cutie\" influences=\"../sample/target1.model#//@artists.0 ../sample/target2.model#//@artists.0\"/>" + "\n" +
	                                          "</label:RecordLabel>";
	
	
	@Before
	public void setupReferencingProject() throws CoreException {
		anotherProject = createProject("another");
		anotherSource  = createFile(anotherProject, "another_source.model", EXT_SOURCE);
	}
	
	@After
	public void teardownReferencingProject() throws CoreException {
		deleteResource(anotherProject);
	}

	
	@Test
	public void shouldMarkCrossReferencesAsDanglingWhenProjectIsDeleted() throws CoreException, InterruptedException {
		addConcordanceNature(anotherProject);
		waitFor(eventsForNewFiles(anotherSource));
		
		deleteResource(project);
		waitFor(event(EventType.DELETE, source1), event(EventType.DELETE, source2), event(EventType.DELETE, target1), event(EventType.DELETE, target2));
		
		hasDanglingMarker(anotherSource, "Death Cab For Cutie", uriForArtist(target1, 0));
		hasDanglingMarker(anotherSource, "Death Cab For Cutie", uriForArtist(target2, 0));
	}
	
	@Test
	public void shouldNotProcessProjectWithoutConcordanceNature() throws CoreException, InterruptedException {	
		deleteResource(project);
		Thread.sleep(1000);
		
		hasNoDanglingReferences(anotherSource);
	}
}
