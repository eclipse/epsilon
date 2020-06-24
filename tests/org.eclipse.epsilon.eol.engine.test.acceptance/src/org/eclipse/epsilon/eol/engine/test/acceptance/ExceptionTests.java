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

import static org.junit.Assert.*;
import org.eclipse.epsilon.eol.*;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.EolUndefinedVariableException;
import org.junit.Test;
import org.junit.Before;

/**
 * Tests for exceptions, which can't be handled by EUnit.
 *
 * @author Sina Madani
 * @since 1.6
 */
public class ExceptionTests {

	IEolModule module;
	
	@Before
	public void setUp() throws Exception {
		module = new EolModule();
	}
	
	@Test
	public void testUndefined() throws Exception {
		module.parse("uVar.npe();");
		try {
			module.execute();
			fail("Expected "+EolUndefinedVariableException.class.getName());
		}
		catch (EolUndefinedVariableException npe) {
			return;
		}
	}
	
	@Test
	public void testStackTraceIsPreserved() throws Exception {
		module.parse(
			"foo(); \n" + 
			"operation foo() { \n" + 
			"  foo.println(); \n" + 
			"}"
		);
		try {
			module.execute();
			fail("Expected "+EolUndefinedVariableException.class.getSimpleName());
		}
		catch (EolUndefinedVariableException eox) {
			assertNotNull(eox.getAst());
			String[] lines = eox.getMessage().split("\\n\\t");
			assertEquals(9, lines.length);
		}
	}
}
