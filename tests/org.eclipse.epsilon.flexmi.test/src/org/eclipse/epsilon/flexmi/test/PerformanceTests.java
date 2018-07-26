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

public class PerformanceTests extends FlexmiTests {
	
	@Test
	public void testFilesystem() throws Exception {
		assertEquals(0, loadResource("performance/filesystem.flexmi").getWarnings().size());
	}
	
}
