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
package org.eclipse.epsilon.migration.execution;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.eclipse.epsilon.migration.model.MigrationRule;
import org.eclipse.epsilon.migration.model.MigrationStrategy;
import org.junit.Test;

public class EquivalenceEstablisherTests {

	@Test
	public void equivalenceForShouldFindRuleAndCreateMigratedModelElement() throws MigrationExecutionException {
		final MigrationStrategy mockStrategy = createMock("MockStrategy", MigrationStrategy.class);
		final IMigrationContext mockContext  = createMock("MockContext",  IMigrationContext.class);
		
		final EquivalenceEstablisher establisher = new EquivalenceEstablisher(mockStrategy, mockContext);
		
		final ModelElement  dummyOriginal   = createMock("DummyOriginal",   ModelElement.class);
		final ModelElement  dummyEquivalent = createMock("DummyEquivalent", ModelElement.class);
		final MigrationRule dummyRule       = createMock("DummyRule",       MigrationRule.class);

		
		// Expectations
		
		expect(mockStrategy.ruleFor(dummyOriginal, mockContext))
			.andReturn(dummyRule);
		
		expect(dummyRule.createMigratedModelElement(mockContext))
			.andReturn(dummyEquivalent);
		
		replay(mockStrategy, mockContext, dummyOriginal, dummyEquivalent, dummyRule);
		
		
		// Verification
		
		assertEquals(new RuleBasedEquivalence(mockContext, dummyOriginal, dummyEquivalent, dummyRule),
		             establisher.createEquivalenceFor(dummyOriginal));
		
		verify(mockStrategy, mockContext, dummyOriginal, dummyEquivalent, dummyRule);
	}
	
	@Test
	public void equivalenceForShouldReturnSameTypeEquivalenceWhenRuleForReturnsNullAndOriginalTypeExistsInMigratedMetamodel() throws MigrationExecutionException {
		final MigrationStrategy mockStrategy = createMock("MockStrategy", MigrationStrategy.class);
		final IMigrationContext mockContext  = createMock("MockContext",  IMigrationContext.class);
		
		final EquivalenceEstablisher establisher = new EquivalenceEstablisher(mockStrategy, mockContext);
		
		final ModelElement dummyOriginal   = createMock("DummyOriginal",   ModelElement.class);
		final ModelElement dummyEquivalent = createMock("DummyEquivalent", ModelElement.class);

		
		// Expectations
		
		expect(mockStrategy.ruleFor(dummyOriginal, mockContext))
			.andReturn(null);
		
		expect(mockContext.createModelElementOfSameTypeInMigratedModel(dummyOriginal))
			.andReturn(dummyEquivalent);
		
		replay(mockStrategy, mockContext, dummyOriginal, dummyEquivalent);
		
		
		// Verification
		
		assertEquals(new TypeBasedEquivalence(mockContext, dummyOriginal, dummyEquivalent),
		             establisher.createEquivalenceFor(dummyOriginal));
		
		verify(mockStrategy, mockContext, dummyOriginal, dummyEquivalent);
	}
}
