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

public class ActionTests extends FlexmiTests {
	
	@Test
	public void testVar() throws Exception {
		assertEval("EOperation.all.first().name", "createC1", "actions/model-with-actions.flexmi");
		assertEval("EOperation.all.second().name", "createC3", "actions/model-with-actions.flexmi");
		assertEval("EOperation.all.first().eType.name", "C1", "actions/model-with-actions.flexmi");
		assertEval("EOperation.all.second().eType.name", "C3", "actions/model-with-actions.flexmi");
		//TODO: See why this test fails
		//assertEval("EClass.all.fourth().name", "C2Clone", "actions/model-with-actions.flexmi");
		
		assertWarning("Undefined variable", 7, "actions/model-with-actions.flexmi");
	}
	
	
	
}
