/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock.model.domain.common;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.Guard;
import org.junit.Test;

public class GuardTests {
	
	private final Guard guard = new Guard();
	private final EolExecutor executor = mock(EolExecutor.class);

	@Test
	public void isSatisifiedByReturnsTrueWhenExecuteGuardReturnsTrue() throws FlockRuntimeException {
		when(executor.executeGuard(isA(AST.class), isA(Variable.class)))
			.thenReturn(true);		
				
		assertTrue(guard.isSatisifedBy(executor, mock(Variable.class)));
	}
	
	@Test
	public void isSatisifiedByReturnsFalseWhenExecuteGuardReturnsFalse() throws FlockRuntimeException {
		when(executor.executeGuard(isA(AST.class), isA(Variable.class)))
			.thenReturn(false);		
			
		assertFalse(guard.isSatisifedBy(executor, mock(Variable.class)));
	}
	
	@Test
	public void isSatisifiedByReturnsTrueWhenAstIsNull() throws FlockRuntimeException {
		final Guard guard = new Guard();
		
		assertTrue(guard.isSatisifedBy(executor, mock(Variable.class)));
	}
}
