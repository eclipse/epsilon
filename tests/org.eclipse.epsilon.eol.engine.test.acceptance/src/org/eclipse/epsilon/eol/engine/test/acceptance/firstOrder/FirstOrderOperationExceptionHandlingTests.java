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
import org.eclipse.epsilon.eol.concurrent.EolModuleParallel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.junit.Test;

public class FirstOrderOperationExceptionHandlingTests {

	final String
		testData = "var testData := Sequence{-9..16};\ntestData.",
		testPredicate = "(n | n >= 0 and n.invalidProp.nullPointer)";
	
	@Test
	public void testExceptionIsThrown() throws Exception {
		EolModule expectedModule = new EolModule();
		expectedModule.parse(testData+"select"+testPredicate+";");
		EolRuntimeException expectedException = execute(expectedModule);
		
		EolModuleParallel actualModule = new EolModuleParallel();
		actualModule.parse(testData+"select"+testPredicate+";");
		EolRuntimeException actualException = execute(actualModule);
		
		assertNotNull(expectedException);
		assertNotNull(actualException);
		assertEquals(expectedException.getAst().toString(), actualException.getAst().toString());
	}
	
	static EolRuntimeException execute(EolModule module) {
		try {
			module.execute();
			return null;
		}
		catch (EolRuntimeException ex) {
			return ex;
		}
	}
	
}
