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
import org.eclipse.epsilon.flock.execution.MigrateRuleContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Test;

public class MigrateRuleTests {

	@Test
	public void applyToShouldExecuteWhenApplicable() throws FlockRuntimeException {
		final AST body = mock(AST.class);
		final MigrateRule rule = new MigrateRule("Person", null, body);
		
		final MigrateRuleContext context = mock(MigrateRuleContext.class);
		
		when(context.isEligibleFor(rule))
			.thenReturn(true);
		
		rule.applyTo(context);
		
		verify(context).execute(new Body(body));
	}
	
	@Test
	public void applyToShouldNotExecuteWhenInapplicable() throws FlockRuntimeException {
		final AST body = mock(AST.class);
		final MigrateRule rule = new MigrateRule("Person", null, body);
		
		final MigrateRuleContext context = mock(MigrateRuleContext.class);
		
		when(context.isEligibleFor(rule))
			.thenReturn(false);
		
		rule.applyTo(context);
		
		verify(context, never()).execute(new Body(body));
	}
}
