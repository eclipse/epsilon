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
package org.eclipse.epsilon.egl.engine.traceability.fine.operations.print;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.operations.print.Arguments;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.junit.Test;


public class ArgumentsTests {

	private final Arguments arguments = new Arguments(astForArguments(1));
	
	@Test
	public void noExceptionWhenExpectedNumberOfArgumentsMatchesActualNumberOfArguments() throws Exception {
		arguments.ensureNumberOfArgumentsIs(1);
	}
	
	@Test(expected=EolIllegalOperationParametersException.class)
	public void exceptionWhenExpectedNumberOfArgumentsDoesNotMatchActualNumberOfArguments() throws Exception {
		arguments.ensureNumberOfArgumentsIs(0);
	}
	
	private static AST astForArguments(int numberOfArguments) {
		final AST argumentsAst = mock(AST.class);
		when(argumentsAst.getNumberOfChildren()).thenReturn(numberOfArguments);
		when(argumentsAst.getText()).thenReturn("dummyText");
		return argumentsAst;
	}
}
