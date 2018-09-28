/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.engine.test.acceptance.firstOrder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.concurrent.EolModuleParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.junit.Test;

public class FirstOrderOperationExceptionHandlingTests {

	final String
		testData = "var testData := Sequence{-9..16};\ntestData.",
		testPredicate = "n | n >= 0 and n.invalidProp.nullPointer";
	
	@Test
	public void testExceptionIsThrown() throws Exception {
		String code = testData+"select("+testPredicate+");";
		EolRuntimeException expectedException = execute(code, new EolModule());
		EolRuntimeException actualException = execute(code, new EolModuleParallel());
		testExceptionEquivalence(expectedException, actualException);
	}
	
	@Test
	public void testInvalidNMatch() throws Exception {
		String code = testData+"nMatch(n | n > 0);";
		EolRuntimeException expectedException = execute(code, new EolModule());
		EolRuntimeException actualException = execute(code, new EolModuleParallel());
		testExceptionEquivalence(expectedException, actualException);
	}
	
	static void testExceptionEquivalence(EolRuntimeException expected, EolRuntimeException actual) {
		assertNotNull(expected);
		assertNotNull(expected);
		assertEquals(expected.getAst().toString(), actual.getAst().toString());
	}
	
	static EolRuntimeException execute(String code, IEolModule module) throws Exception {
		try {
			module.parse(code);
			module.execute();
			return null;
		}
		catch (EolRuntimeException ex) {
			return ex;
		}
	}
	
}
