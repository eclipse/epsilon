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
package org.eclipse.epsilon.flock.execution;

import static org.mockito.Mockito.*;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.junit.Before;
import org.junit.Test;

public class EolExecutorTests {

	private final EolContext      context         = mock(EolContext.class);
	private final ExecutorFactory executorFactory = mock(ExecutorFactory.class);
	private final Variable        variable        = mock(Variable.class);
	
	private final EolExecutor executor = new EolExecutor(context);

	
	@Before
	public void setup() {
		when(context.getExecutorFactory())
			.thenReturn(executorFactory);
	}
	
	@Test
	public void executeGuardShouldDelegateToExecutorFactoryAndRunInAProtectedFrame() throws EolRuntimeException {
		final AST guard = mock(AST.class);
		
		when(executorFactory.executeBlockOrExpressionAst(guard, context, false))
			.thenReturn(true);
		
		executor.executeGuard(guard, variable);
		
		verify(context).enterProtectedFrame(guard, new Variable[]{variable});
		verify(executorFactory).executeBlockOrExpressionAst(guard, context, false);
		verify(context).leaveFrame(guard);
	}
	
	@Test
	public void executeBlockShouldDelegateToExecutorFactoryAndRunInAProtectedFrame() throws EolRuntimeException {	
		final AST block = mock(AST.class);

		when(executorFactory.executeBlockOrExpressionAst(block, context, false))
			.thenReturn(true);
		
		executor.executeBlock(block, variable);
		
		verify(context).enterProtectedFrame(block, new Variable[]{variable});
		verify(executorFactory).executeAST(block, context);
		verify(context).leaveFrame(block);
	}
}
