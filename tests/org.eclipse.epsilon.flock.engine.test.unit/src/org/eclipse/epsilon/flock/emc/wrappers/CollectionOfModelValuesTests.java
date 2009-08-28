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
package org.eclipse.epsilon.flock.emc.wrappers;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.AttributeValue;
import org.eclipse.epsilon.flock.emc.wrappers.BackedModelValue;
import org.eclipse.epsilon.flock.emc.wrappers.CollectionOfModelValues;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class CollectionOfModelValuesTests {

	private static final Model dummyModel  = createMock(Model.class);
	
	
	@Test
	public void unwrapShouldDelegateToUnwrapOfEachElement() {
		final BackedModelValue firstMockModelValue  = createMock(BackedModelValue.class);
		final BackedModelValue secondMockModelValue = createMock(BackedModelValue.class);

		
		// Expectations
		
		expect(firstMockModelValue.unwrap())
			.andReturn("foo");
		
		expect(secondMockModelValue.unwrap())
			.andReturn("bar");
		
		replay(firstMockModelValue, secondMockModelValue);
		
		
		// Verification
		
		assertEolCollectionsEqual(toEolCollection("foo", "bar"),
		                          new CollectionOfModelValues(dummyModel, firstMockModelValue, secondMockModelValue).unwrap());
		
		verify(firstMockModelValue, secondMockModelValue);
	}
	
	@Test
	public void getEquivalentShouldDelegateToGetEquivalentOfEachElement() throws ConservativeCopyException {
		final Model             dummyMigratedModel = createMock(Model.class);
		final IFlockContext dummyContext       = createMock(IFlockContext.class);
		
		final BackedModelValue firstMockModelValue  = createMock(BackedModelValue.class);
		final BackedModelValue secondMockModelValue = createMock(BackedModelValue.class);

		
		// Expectations
		
		expect(firstMockModelValue.getEquivalentIn(dummyMigratedModel, dummyContext))
			.andReturn(new AttributeValue(dummyMigratedModel, "foo"));
		
		expect(secondMockModelValue.getEquivalentIn(dummyMigratedModel, dummyContext))
			.andReturn(new AttributeValue(dummyMigratedModel, "bar"));
		
		replay(dummyMigratedModel, dummyContext, firstMockModelValue, secondMockModelValue);
		
		
		// Verification
		
		assertEquals(new CollectionOfModelValues(dummyMigratedModel, new AttributeValue(dummyMigratedModel, "foo"), new AttributeValue(dummyMigratedModel, "bar")),
		             new CollectionOfModelValues(dummyModel, firstMockModelValue, secondMockModelValue).getEquivalentIn(dummyMigratedModel, dummyContext));
		
		verify(dummyMigratedModel, dummyContext, firstMockModelValue, secondMockModelValue);
	}
	
	@Test
	public void getEquivalentShouldExcludeValuesThatUnwrapToNull() throws ConservativeCopyException {
		final Model             dummyMigratedModel = createMock(Model.class);
		final IFlockContext dummyContext       = createMock(IFlockContext.class);
		
		final BackedModelValue mockOriginalModelValue    = createMock("OriginalValue",   BackedModelValue.class);
		final BackedModelValue mockEquivalentModelValue  = createMock("EquivalentValue", BackedModelValue.class);

		
		// Expectations
		
		expect(mockOriginalModelValue.getEquivalentIn(dummyMigratedModel, dummyContext))
			.andReturn(mockEquivalentModelValue);
		
		expect(mockEquivalentModelValue.unwrap())
			.andReturn(null);
		
		replay(dummyMigratedModel, dummyContext, mockOriginalModelValue, mockEquivalentModelValue);
		
		
		// Verification
		
		assertEquals(new CollectionOfModelValues(dummyMigratedModel),
		             new CollectionOfModelValues(dummyModel, mockOriginalModelValue).getEquivalentIn(dummyMigratedModel, dummyContext));
		
		verify(dummyMigratedModel, dummyContext, mockOriginalModelValue, mockEquivalentModelValue);
	}
	
	
	private static void assertEolCollectionsEqual(EolCollection expected, EolCollection actual) {
		assertEquals(expected.getStorage(), actual.getStorage());
	}
	
	private static EolCollection toEolCollection(Object... element) {
		return new EolSequence(Arrays.asList(element));
	}
}
