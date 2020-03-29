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

public class PropogenTests extends FlexmiTests {
	protected EPackage ePackage = null;
	
	@Test
	public void testInPorts() throws Exception {
		assertEval("Partner.all.first().country", "UK", "propogen/valid-model.flexmi");
	}
	
	@Before
	public void setup() throws Exception {
		ePackage = EmfUtil.register(URI.createURI(
			FlexmiTestSuite.class.getResource("models/propogen/propogen.ecore").toURI().toString()), 
				EPackage.Registry.INSTANCE).get(0);
	}
	
	@After
	public void teardown() {
		EPackage.Registry.INSTANCE.remove(ePackage.getNsURI());
	}
	
}
