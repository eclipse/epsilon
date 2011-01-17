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
package org.eclipse.epsilon.flock.model.checker;

import static org.mockito.Mockito.*;

import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.model.checker.MigrationStrategyChecker;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;
import org.eclipse.epsilon.flock.model.domain.common.TypedAndGuardedConstruct;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRule;
import org.junit.Test;

public class MigrationStrategyCheckerTests {

	private final TypedAndGuardedConstruct construct       = mock(MigrateRule.class);
	private final MigrationStrategy strategy               = new MigrationStrategy(construct);
	private final MigrationStrategyCheckingContext context = mock(MigrationStrategyCheckingContext.class);

	@Test
	public void ruleForTypeNotKnownToOriginalMetamodelProducesWarning() {
		when(construct.getOriginalType())
			.thenReturn("UnknownType");
		
		when(context.isTypeInOriginalMetamodel("UnknownType"))
			.thenReturn(false);
		
		
		new MigrationStrategyChecker(strategy, context).check();
		
		verify(context).addWarning("Rule defined for migrating instances of UnknownType, " +
		                           "but no type UnknownType was found in the original metamodel.");
	}
	
	
	@Test
	public void ruleForTypeKnownToOriginalMetamodelDoesNotProduceWarning() {
		when(construct.getOriginalType())
			.thenReturn("KnownType");
		
		when(context.isTypeInOriginalMetamodel("KnownType"))
			.thenReturn(true);
		
		
		new MigrationStrategyChecker(strategy, context).check();
		
		verify(context, never()).addWarning(anyString());
	}
}
