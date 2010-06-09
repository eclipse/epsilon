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
package org.eclipse.epsilon.concordance.clients.conformance;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.concordance.clients.test.ConcordanceClientIntegrationTest;
import org.junit.Before;
import org.junit.Test;


public class ConformanceReportingIntegrationTests extends ConcordanceClientIntegrationTest {

	private static final String ORIGINAL_MM = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"                                                   + "\n" +
	                                          "<ecore:EPackage xmi:version=\"2.0\""                                                          + "\n" +
	                                          "xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + "\n" +
	                                          "xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"families\""                      + "\n" +
	                                          "nsURI=\"families\" nsPrefix=\"families\">"                                                    + "\n" +
	                                          "    <eClassifiers xsi:type=\"ecore:EClass\" name=\"Family\" />"                               + "\n" +
	                                          "    <eClassifiers xsi:type=\"ecore:EClass\" name=\"Person\" />"                               + "\n" +
	                                          "</ecore:EPackage>";
	
	private static final String EVOLVED_MM = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"                                                   + "\n" +
	                                         "<ecore:EPackage xmi:version=\"2.0\""                                                          + "\n" +
	                                         "xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + "\n" +
	                                         "xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"families\""                      + "\n" +
	                                         "nsURI=\"families\" nsPrefix=\"families\">"                                                    + "\n" +
	                                         "    <eClassifiers xsi:type=\"ecore:EClass\" name=\"Family\" />"                               + "\n" +
	                                         "    <eClassifiers xsi:type=\"ecore:EClass\" name=\"Person\" />"                               + "\n" +
	                                         "    <eClassifiers xsi:type=\"ecore:EClass\" name=\"Pet\" />"                                  + "\n" +
	                                         "</ecore:EPackage>";
	
	private static final String BREAKING_MM = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"                                                   + "\n" +
	                                          "<ecore:EPackage xmi:version=\"2.0\""                                                          + "\n" +
	                                          "xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" + "\n" +
	                                          "xmlns:ecore=\"http://www.eclipse.org/emf/2002/Ecore\" name=\"families\""                      + "\n" +
	                                          "nsURI=\"families\" nsPrefix=\"families\">"                                                    + "\n" +
	                                          "    <eClassifiers xsi:type=\"ecore:EClass\" name=\"Family\" />"                               + "\n" +
	                                          "</ecore:EPackage>";

	
	private static final String BREAKING_MODEL = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" +
	                                             "<families:Person xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:families=\"families\"/>";
	
	private static final String NONBREAKING_MODEL = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + "\n" +
	                                                "<families:Family xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:families=\"families\"/>";

	
	private IFile metamodel, model;
	
	@Before
	public void setup() throws Exception {
		metamodel = createFile(project, "metamodel.ecore", ORIGINAL_MM);
		registerMetamodel(metamodel);
		
		model     = createFile(project, "instance.model", BREAKING_MODEL);
		waitForModelChangeNotifications();
		
	}
	
	@Test
	public void nonBreakingChangeShouldYieldNoConformanceErrors() throws Exception {	
		changeMetamodel(metamodel, EVOLVED_MM);
				
		assertEquals(0, conformanceMarkersOf(model).length);
	}
	
	@Test
	public void breakingChangeShouldYieldConformanceErrors() throws Exception {		
		changeMetamodel(metamodel, BREAKING_MM);
		
		
		assertEquals(1, conformanceMarkersOf(model).length);
		assertEquals("Unrecognised classifier: Person", conformanceMarkersOf(model)[0].getAttribute(IMarker.MESSAGE));
	}
	
	@Test
	public void twoModels() throws Exception {		
		final IFile nonbreakingModel = createFile(project, "nonbreaking.model", NONBREAKING_MODEL);
		
		changeMetamodel(metamodel, BREAKING_MM);
		
		assertEquals(0, conformanceMarkersOf(nonbreakingModel).length);
		
		assertEquals(1, conformanceMarkersOf(model).length);
		assertEquals("Unrecognised classifier: Person", conformanceMarkersOf(model)[0].getAttribute(IMarker.MESSAGE));
	}

	
	private static IMarker[] conformanceMarkersOf(final IFile nonbreakingModel) throws CoreException {
		return nonbreakingModel.findMarkers("org.eclipse.epsilon.hutn.dt.inconsistency", false, IResource.DEPTH_ZERO);
	}
}
