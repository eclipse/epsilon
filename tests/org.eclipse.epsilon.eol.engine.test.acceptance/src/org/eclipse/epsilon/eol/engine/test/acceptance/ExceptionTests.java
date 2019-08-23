/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.engine.test.acceptance;

import static org.junit.Assert.fail;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolUndefinedVariableException;
import org.junit.Test;

/**
 * Tests for exceptions, which can't be handled by EUnit.
 *
 * @author Sina Madani
 * @since 1.6
 */
public class ExceptionTests {

	@Test
	public void testUndefined() throws Exception {
		EolModule module = new EolModule();
		module.parse("uVar.npe();");
		try {
			module.execute();
			fail("Expected "+EolUndefinedVariableException.class.getName());
		}
		catch (EolUndefinedVariableException npe) {
			return;
		}
	}
	
}
