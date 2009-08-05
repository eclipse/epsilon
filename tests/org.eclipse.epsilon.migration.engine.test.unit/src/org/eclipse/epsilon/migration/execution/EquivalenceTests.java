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

import static org.easymock.classextension.EasyMock.*;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.IllegalMigrationException;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.eclipse.epsilon.migration.model.MigrationRule;
import org.junit.Before;
import org.junit.Test;

public class EquivalenceTests {

	private final ModelElement dummyOriginal = createMock("DummyOriginal",  ModelElement.class);
	
	private final IMigrationContext mockContext    = createMock("MockContext", IMigrationContext.class);
	private final ModelElement      mockEquivalent = createMock("MockEquivalent", ModelElement.class);
	private final MigrationRule     mockRule       = createMock("MockRule", MigrationRule.class);
	
	private final Equivalence equivalence = new Equivalence(dummyOriginal, mockEquivalent, mockRule);
	
	@Before
	public void setup() {
		reset(mockContext, mockEquivalent, mockRule);
	}
	
	
	@Test
	public void shouldDelegateToCopyAndRule() throws MigrationExecutionException {
		// Expectations
		
		expect(mockContext.isElementInOriginalModel(dummyOriginal))
			.andReturn(true);
		expect(mockContext.isElementInMigratedModel(mockEquivalent))
			.andReturn(true);
		
		mockEquivalent.conservativelyCopyPropertiesFrom(dummyOriginal, mockContext);
		mockRule.applyTo(dummyOriginal, mockEquivalent, mockContext);
		
		replay(mockContext, mockEquivalent, mockRule);
		
		
		// Verification
		
		equivalence.populateEquivalent(mockContext);
		
		verify(mockEquivalent, mockRule);
	}
	
	
	@Test(expected=IllegalMigrationException.class)
	public void shouldThrowExceptionWhenOriginalModelNoLongerOwnsOriginalModelElement() throws MigrationExecutionException {
		// Expectations
		
		expect(mockContext.isElementInOriginalModel(dummyOriginal))
			.andReturn(false);
		
		replay(mockContext);
		
		
		// Verification
		
		equivalence.populateEquivalent(mockContext);
		
		verify(mockContext);
	}
	
	
	@Test(expected=IllegalMigrationException.class)
	public void shouldThrowExceptionWhenMigratedModelNoLongerOwnsMigratedModelElement() throws MigrationExecutionException {
		// Expectations
		
		expect(mockContext.isElementInOriginalModel(dummyOriginal))
			.andReturn(true);
		expect(mockContext.isElementInMigratedModel(mockEquivalent))
			.andReturn(false);
		
		replay(mockContext);
		
		
		// Verification
		
		equivalence.populateEquivalent(mockContext);
		
		verify(mockContext);
	}
}
