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
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.AttributeValue;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.emc.wrappers.ModelValue;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;
import org.junit.Before;
import org.junit.Test;

public class ModelElementTests {

	private static final Model        mockModel  = createMock(Model.class);
	private static final ModelElement element     = new ModelElement(mockModel, "foo");
	
	@Before
	public void resetDummyModel() {
		reset(mockModel);
	}
	
	@Test
	public void unwrapShouldReturnUnderlyingModelObject() {
		assertEquals("foo", element.unwrap());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getEquivalentShouldDelegateToEquivalences() throws ConservativeCopyException {
		final Model             mockMigratedModel = createMock(Model.class);
		final IFlockContext mockContext        = createMock(IFlockContext.class);
		
		final ModelElement dummyMigratedModelElement = new ModelElement(mockMigratedModel, "bar");

		// Expectations
		expect(mockContext.getEquivalent(element))
			.andReturn(dummyMigratedModelElement);
		
		expect(mockMigratedModel.wrap(dummyMigratedModelElement))
			.andReturn((ModelValue)dummyMigratedModelElement);
		
		replay(mockMigratedModel, mockContext);
		
		
		// Verification
		
		assertEquals(dummyMigratedModelElement,
		             element.getEquivalentIn(mockMigratedModel, mockContext));
		
		verify(mockMigratedModel, mockContext);
	}
	
	@Test
	public void propetiesSharedWithShouldKeepOnlyThosePropertiesKnownByBothModelElements() {
		final ModelElement mockModelElement = createMock(ModelElement.class);
		
		// Expectations

		expect(mockModel.getPropertiesOf("foo"))
			.andReturn(Arrays.asList("name", "age"));
		
		expect(mockModelElement.getProperties())
			.andReturn(Arrays.asList("name", "address"));
		
		replay(mockModel, mockModelElement);
		
		
		// Verification
		
		assertEquals(Arrays.asList("name"),
		             element.getPropertiesSharedWith(mockModelElement));
		
		verify(mockModel, mockModelElement);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void conservativelyCopyPropertiesFromShouldRetrieveEachPropertyValueAndConvertToEquivalent() throws ConservativeCopyException, EolRuntimeException {
		final ModelElement mockOriginalModelElement = createMock(ModelElement.class);
		
		final Model             dummyOriginalModel = createMock(Model.class);
		final IFlockContext dummyContext       = createMock(IFlockContext.class);
		
		
		// Expectations
		
		expect(mockModel.getPropertiesOf("foo"))
			.andReturn(Arrays.asList("name", "age"));
		
		expect(mockOriginalModelElement.getProperties())
			.andReturn(Arrays.asList("name", "address"));
		
		final AttributeValue nameValue = new AttributeValue(dummyOriginalModel, "John Smith");		
		
		expect(mockOriginalModelElement.getValueOfProperty("name"))
			.andReturn((ModelValue)nameValue);

		mockModel.setValueOfProperty("foo", "name", nameValue);
		
		replay(mockModel, dummyOriginalModel, mockOriginalModelElement, dummyContext);


		// Verification
		
		element.conservativelyCopyPropertiesFrom(mockOriginalModelElement, dummyContext);
				
		verify(mockModel, dummyOriginalModel, mockOriginalModelElement, dummyContext);
	}
}
