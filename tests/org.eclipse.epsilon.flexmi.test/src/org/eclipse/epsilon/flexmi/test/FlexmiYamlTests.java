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

import org.junit.Test;

public class FlexmiYamlTests extends FlexmiTests {
	
	@Test
	public void testEmptyClasses() throws Exception {
		assertEval("EClass.all.size()", 2, "yaml/empty-classes.yaml");
	}
}
