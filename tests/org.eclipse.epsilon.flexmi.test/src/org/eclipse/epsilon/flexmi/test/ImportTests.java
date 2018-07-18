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

import static org.junit.Assert.*;

import org.junit.Test;

public class ImportTests extends FlexmiTests {
	
	@Test
	public void testNoWarnings() throws Exception {
		assertEquals(loadResource("import/valid-main.flexmi").getWarnings().size(), 0);
	}
	
	@Test
	public void testESuperType() throws Exception {
		assertEval("EClass.all.first().eSuperTypes.first().name", "c2", "import/valid-main.flexmi");
	}
	
	@Test
	public void testUnresolvedReferenceWarning() throws Exception {
		assertEquals(loadResource("import/invalid-main.flexmi").getWarnings().size(), 1);
	}
	
}
