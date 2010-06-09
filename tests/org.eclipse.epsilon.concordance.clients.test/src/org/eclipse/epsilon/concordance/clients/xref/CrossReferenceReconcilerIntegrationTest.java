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

import static org.junit.Assert.assertEquals;


import junit.framework.Assert;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.concordance.clients.test.ConcordanceClientIntegrationTest;
import org.eclipse.epsilon.concordance.model.Model;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.test.util.ModelWithEolAssertions;
import org.junit.Before;

public abstract class CrossReferenceReconcilerIntegrationTest extends ConcordanceClientIntegrationTest {
	
	/*
	 * The models below contain the following cross-references:
	 * 
	 * Source1 -> Target1#Radiohead
	 *         -> Target2#Nirvana
	 * 
	 * Source2 -> Target1#Radiohead
	 *            Target1#Beatles
	 * 
	 */
	
	private final static String SOURCE_1 = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                       "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_XtTJAelcEd6sWK81OWLGdQ\" name=\"Atlantic\">" + "\n" +
	                                       "  <artists name=\"Death Cab For Cutie\" influences=\"target1.model#//@artists.0 target2.model#//@artists.0\"/>" + "\n" +
	                                       "</label:RecordLabel>";

	private final static String SOURCE_2 = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                       "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_afdgfsffEd6sWK3dfFDgj\" name=\"Saddle Creek\">" + "\n" +
	                                       "  <artists name=\"Bright Eyes\" influences=\"target1.model#//@artists.0 target1.model#//@artists.1\"/>" + "\n" +
	                                       "</label:RecordLabel>";

	private final static String TARGET_1 = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                       "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_sdfdsffEd6sWK34dfsGdA\" name=\"Parlophone\">" + "\n" +
	                                       "  <artists name=\"Radiohead\"/>" + "\n" +
	                                       "  <artists name=\"The Beatles\"/>" + "\n" +
	                                       "</label:RecordLabel>";
	
	private final static String TARGET_2 = "<?xml version=\"1.0\" encoding=\"ASCII\"?>" + "\n" +
	                                       "<label:RecordLabel xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:label=\"label\" xmi:id=\"_dy6cYOlcEd6sWK81OWLGdQ\" name=\"Sub Pop\">" + "\n" +
	                                       "  <artists name=\"Nirvana\"/>" + "\n" +
	                                       "</label:RecordLabel>";

	protected IFile source1, source2, target1, target2;
	
	@Before
	public void setupModels() throws CoreException, InterruptedException {
		source1 = createFile(project, "source1.model", SOURCE_1);
		source2 = createFile(project, "source2.model", SOURCE_2);
		target1 = createFile(project, "target1.model", TARGET_1);
		target2 = createFile(project, "target2.model", TARGET_2);
		
		waitFor(eventsForNewFiles(source1, source2, target1, target2));
	}

	protected static IMarker[] danglingXrefMarkersOf(final IResource file) throws CoreException {
		return file.findMarkers(MarkerManager.DANGLING_XREF_MARKER_ID, false, IResource.DEPTH_ZERO);
	}
	
	protected void crossReferencesResolveToExpectedValues() throws CoreException, EolModelLoadingException {
		hasNoDanglingReferences(source1);
		hasNoDanglingReferences(source2);
		
		source1HasExpectedReferences();
		source2HasExpectedReferences();
	}
	
	protected static void hasNoDanglingReferences(IResource resource) throws CoreException {
		assertEquals(0, danglingXrefMarkersOf(resource).length);
	}
	
	protected String uriForArtist(IFile model, int artistIndex) {
		return new Model(model).getUri() + "#//@artists." + artistIndex;
	}
	
	protected static void hasDanglingMarker(IResource resource, String sourceLabel, String targetUri) throws CoreException {
		String actualMessages = "";
		
		 for (IMarker marker : danglingXrefMarkersOf(resource)) {
			 final String message = marker.getAttribute(IMarker.MESSAGE).toString();
			 
			 if (message.contains(sourceLabel) && message.contains(targetUri)) {
				 return;
			 }
			 
			 actualMessages += marker.getAttribute(IMarker.MESSAGE) + "\n";
		 }
		 
		 Assert.fail("Resource " + resource + " does not contain marker with message from: " + sourceLabel + " to " + targetUri + "\nOnly the following:\n" + actualMessages);
	}
	
	private void source1HasExpectedReferences() throws EolModelLoadingException {
		hasReferencesTo(source1, "Radiohead", "Nirvana");
	}
	
	private void source2HasExpectedReferences() throws EolModelLoadingException {
		hasReferencesTo(source2, "Radiohead", "The Beatles");
	}
	
	protected static void hasReferencesTo(IFile file, String... influences) throws EolModelLoadingException {
		final ModelWithEolAssertions model = loadAsModelWithEolAssertions(file, "Source", "label");
		
		try {
			model.setVariable("artist", "RecordLabel.all.first.artists.first");
			
			for (int index = 0; index < influences.length; index++) {
				model.assertEquals(influences[index], "artist.influences.at(" + index + ").name");
			}
			
		} finally {
			model.dispose();
		}
	}
}
