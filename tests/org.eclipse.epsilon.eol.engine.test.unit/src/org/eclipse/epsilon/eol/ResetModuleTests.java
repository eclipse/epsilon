/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ResetModuleTests {

	@Test
	public void shouldResetOperations() throws Exception {
		final IEolModule module = createModuleWithOneOperation();
		
		module.reset();
		assertEquals(0, module.getOperations().size());
	}

	
	private static IEolModule createModuleWithOneOperation() throws Exception {
		final IEolModule module = new EolModule();
		
		module.parse("operation foo() { 'foo'.println(); }");
		
		if (!module.getParseProblems().isEmpty())
			throw new IllegalStateException("Parse problems encountered whilst creating module for test: " + module.getParseProblems());
		
		if (module.getOperations().size() != 1)
			throw new IllegalStateException("Test module constructed with the wrong number of operations: " + module.getOperations());
		
		return module;
	}
}
