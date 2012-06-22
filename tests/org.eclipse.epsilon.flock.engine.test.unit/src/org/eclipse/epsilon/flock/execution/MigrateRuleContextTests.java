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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.TypedAndGuardedConstruct;
import org.junit.Test;


public class MigrateRuleContextTests {

	private final Equivalence        equivalence = mock(Equivalence.class);
	private final EolExecutor        executor    = mock(EolExecutor.class);
	private final FlockExecution     execution   = mock(FlockExecution.class);
	private final MigrateRuleContext context     = new MigrateRuleContext(equivalence, executor, execution);
	
	private final TypedAndGuardedConstruct construct = mock(TypedAndGuardedConstruct.class);
	
	
	@Test
	public void firstCallToEvaluateGuardDelegatesToTypedAndGuardedConstruct() throws FlockRuntimeException {
		context.isEligibleFor(construct);
		
		verify(construct).appliesIn(any(GuardedConstructContext.class));
	}
	
	@Test
	public void secondCallToEvaluateGuardDoesNotDelegateToTypedAndGuardedConstruct() throws FlockRuntimeException {
		context.isEligibleFor(construct);
		context.isEligibleFor(construct);
		
		verify(construct, times(1)).appliesIn(any(GuardedConstructContext.class));
	}
	
	@Test
	public void secondCallToEvaluateGuardReturnsTrueWhenFirstCallReturnedTrue() throws FlockRuntimeException {
		when(construct.appliesIn(any(GuardedConstructContext.class))).thenReturn(false);
		
		assertFalse(context.isEligibleFor(construct));
		assertFalse(context.isEligibleFor(construct));
	}
	
	@Test
	public void secondCallToEvaluateGuardReturnsFalseWhenFirstCallReturnedFalse() throws FlockRuntimeException {
		when(construct.appliesIn(any(GuardedConstructContext.class))).thenReturn(true);
		
		assertTrue(context.isEligibleFor(construct));
		assertTrue(context.isEligibleFor(construct));
	}
}
