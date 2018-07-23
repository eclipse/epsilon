/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.test;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompsTests extends FlexmiTests {
	protected EPackage comps = null;
	
	@Test
	public void testInPorts() throws Exception {
		assertEval("Component.all.first().inPorts.size()", 1, "comps/comp-with-ports.flexmi");
	}
	
	@Test
	public void testOutPorts() throws Exception {
		assertEval("Component.all.first().outPorts.size()", 1, "comps/comp-with-ports.flexmi");
	}
	
	@Test
	public void testInPortsNamedIn() throws Exception {
		assertEval("Component.all.first().inPorts.size()", 1, "comps/in-out.flexmi");
		assertEval("Component.all.first().inPorts.first().eClass().name", "Port", "comps/in-out.flexmi");
		
	}
	
	@Test
	public void testOutPortsNamedOut() throws Exception {
		assertEval("Component.all.first().outPorts.first().eClass().name", "Port", "comps/in-out.flexmi");
	}
	
	@Before
	public void setup() throws Exception {
		comps = EmfUtil.register(URI.createURI(
			FlexmiTestSuite.class.getResource("models/comps/comps.ecore").toURI().toString()), 
				EPackage.Registry.INSTANCE).get(0);
	}
	
	@After
	public void teardown() {
		EPackage.Registry.INSTANCE.remove(comps.getNsURI());
	}
	
}
