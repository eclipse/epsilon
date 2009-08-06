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
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.IllegalMigrationException;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.junit.Before;
import org.junit.Test;

public class TypeBasedEquivalenceTests {

	private final ModelElement dummyOriginal = createMock("DummyOriginal",  ModelElement.class);
	
	private final IMigrationContext mockContext    = createMock("MockContext", IMigrationContext.class);
	private final ModelElement      mockEquivalent = createMock("MockEquivalent", ModelElement.class);
	
	private final Equivalence equivalence = new TypeBasedEquivalence(mockContext, dummyOriginal, mockEquivalent);
	
	@Before
	public void setup() {
		reset(mockContext, mockEquivalent);
	}
	
	
	@Test
	public void shouldDelegateToCopy() throws MigrationExecutionException {
		// Expectations
		
		expect(mockContext.isElementInOriginalModel(dummyOriginal))
			.andReturn(true);
		expect(mockContext.isElementInMigratedModel(mockEquivalent))
			.andReturn(true);
		
		mockEquivalent.conservativelyCopyPropertiesFrom(dummyOriginal, mockContext);
		
		replay(mockContext, mockEquivalent);
		
		
		// Verification
		
		equivalence.populateEquivalent();
		
		verify(mockEquivalent);
	}
	
	
	@Test(expected=IllegalMigrationException.class)
	public void shouldThrowExceptionWhenOriginalModelNoLongerOwnsOriginalModelElement() throws MigrationExecutionException {
		// Expectations
		
		expect(mockContext.isElementInOriginalModel(dummyOriginal))
			.andReturn(false);
		
		replay(mockContext);
		
		
		// Verification
		
		equivalence.populateEquivalent();
		
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
		
		equivalence.populateEquivalent();
		
		verify(mockContext);
	}
}
