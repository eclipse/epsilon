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

import static org.easymock.classextension.EasyMock.*;

import java.util.Collections;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.model.MigrateRule;
import org.eclipse.epsilon.flock.model.MigrationStrategy;
import org.eclipse.epsilon.flock.model.Rule;
import org.eclipse.epsilon.flock.model.checker.MigrationStrategyChecker;
import org.junit.Test;

public class MigrationStrategyCheckerTests {

	@Test
	public void ruleForTypeNotKnownToOriginalMetamodelProducesWarning() {
		final MigrationStrategy mockStrategy = createMock(MigrationStrategy.class);
		final Rule              mockRule     = createMock(MigrateRule.class);
		final IFlockContext mockContext  = createMock(IFlockContext.class);
		
		// Stubbed methods
		
		expect(mockStrategy.getRules())
			.andReturn(Collections.singleton(mockRule));
		
		expect(mockRule.getOriginalType())
			.andReturn("UnknownType")
			.anyTimes();
		
		expect(mockContext.isTypeInOriginalMetamodel("UnknownType"))
			.andReturn(false);
		
		
		// Expectations
		
		mockContext.addWarning("Rule defined for migrating instances of UnknownType, " +
		                       "but no type UnknownType was found in the original metamodel.");
		
		replay(mockStrategy, mockRule, mockContext);
		
		
		// Verification
		
		new MigrationStrategyChecker(mockStrategy, mockContext).check();
		
		verify(mockStrategy, mockRule, mockContext);
	}
	
	
	@Test
	public void ruleForTypeKnownToOriginalMetamodelDoesNotProduceWarning() {
		final MigrationStrategy mockStrategy = createMock(MigrationStrategy.class);
		final Rule              mockRule     = createMock(MigrateRule.class);
		final IFlockContext mockContext  = createMock(IFlockContext.class);
		
		// Stubbed methods
		
		expect(mockStrategy.getRules())
			.andReturn(Collections.singleton(mockRule));
		
		expect(mockRule.getOriginalType())
			.andReturn("KnownType")
			.anyTimes();
		
		expect(mockContext.isTypeInOriginalMetamodel("KnownType"))
			.andReturn(true);
		
		
		// Expectations
		
		// expect nothing to happen
		
		replay(mockStrategy, mockRule, mockContext);
		
		
		// Verification
		
		new MigrationStrategyChecker(mockStrategy, mockContext).check();
		
		verify(mockStrategy, mockRule, mockContext);
	}
}
