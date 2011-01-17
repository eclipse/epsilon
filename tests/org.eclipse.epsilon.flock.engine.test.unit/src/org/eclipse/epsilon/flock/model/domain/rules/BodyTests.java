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
package org.eclipse.epsilon.flock.model.domain.rules;

import static org.mockito.Mockito.*;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Test;

public class BodyTests {

	@Test
	public void applyToShouldDelegateToExecutorWhenBodyIsNonNull() throws FlockRuntimeException {
		final AST block = mock(AST.class);
		final Body body = new Body(block);
		
		final EolExecutor executor = mock(EolExecutor.class);
		
		body.applyTo(executor);
		
		
		verify(executor).executeBlock(block);
	}
	
	@Test
	public void applyToShouldNotDelegateToExecutorWhenBodyIsNull() throws FlockRuntimeException {
		final Body body = new Body(null);
		
		final EolExecutor executor = mock(EolExecutor.class);
		
		body.applyTo(executor);
		
		
		verify(executor, never()).executeBlock(any(AST.class));
	}
}
