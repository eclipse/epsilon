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
package org.eclipse.epsilon.flock.execution;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.CopyRule;
import org.eclipse.epsilon.flock.model.MigrateRule;
import org.eclipse.epsilon.flock.model.MigrationStrategy;
import org.junit.Test;

public class EquivalenceEstablisherTests {

	@Test
	public void equivalenceForShouldFindRuleAndCreateEquivalence() throws FlockRuntimeException {
		final MigrationStrategy mockStrategy = createMock("MockStrategy", MigrationStrategy.class);
		final IFlockContext mockContext  = createMock("MockContext",  IFlockContext.class);
		
		final EquivalenceEstablisher establisher = new EquivalenceEstablisher(mockStrategy, mockContext);
		
		final ModelElement  dummyOriginal   = createMock("DummyOriginal",   ModelElement.class);
		final MigrateRule dummyRule       = createMock("DummyRule",       MigrateRule.class);
		
		final Equivalence dummyEquivalence = createMock("DummyEquivalent", Equivalence.class);


		
		// Expectations
		
		expect(mockStrategy.ruleFor(dummyOriginal, mockContext))
			.andReturn(dummyRule);
		
		expect(dummyRule.createEquivalence(dummyOriginal, mockContext))
			.andReturn(dummyEquivalence);
		
		replay(mockStrategy, mockContext, dummyOriginal, dummyEquivalence, dummyRule);
		
		
		// Verification
		
		assertEquals(dummyEquivalence, establisher.createEquivalenceFor(dummyOriginal));
		
		verify(mockStrategy, mockContext, dummyOriginal, dummyEquivalence, dummyRule);
	}
	
	@Test
	public void equivalenceForShouldReturnSameTypeEquivalenceWhenRuleForReturnsCopyRule() throws FlockRuntimeException {
		final MigrationStrategy mockStrategy = createMock("MockStrategy", MigrationStrategy.class);
		final IFlockContext mockContext  = createMock("MockContext",  IFlockContext.class);
		
		final EquivalenceEstablisher establisher = new EquivalenceEstablisher(mockStrategy, mockContext);
		
		final ModelElement dummyOriginal   = createMock("DummyOriginal",   ModelElement.class);
		final ModelElement dummyEquivalent = createMock("DummyEquivalent", ModelElement.class);

		
		// Expectations
		
		expect(mockStrategy.ruleFor(dummyOriginal, mockContext))
			.andReturn(new CopyRule("foo"));
		
		expect(mockContext.safelyCreateModelElementInMigratedModel("foo"))
			.andReturn(dummyEquivalent);
		
		replay(mockStrategy, mockContext, dummyOriginal, dummyEquivalent);
		
		
		// Verification
		
		assertEquals(new TypeBasedEquivalence(mockContext, dummyOriginal, dummyEquivalent),
		             establisher.createEquivalenceFor(dummyOriginal));
		
		verify(mockStrategy, mockContext, dummyOriginal, dummyEquivalent);
	}
}
