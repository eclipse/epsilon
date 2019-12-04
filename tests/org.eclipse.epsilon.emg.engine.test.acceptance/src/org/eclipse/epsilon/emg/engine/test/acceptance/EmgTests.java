/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emg.engine.test.acceptance;

import org.eclipse.epsilon.emg.EmgModule;
import org.junit.Test;



public class EmgTests {
	
	protected EmgModule module = null;
	
	@Test
	public void testEvl() throws Exception {
		module = new EmgModule();
	}

}
