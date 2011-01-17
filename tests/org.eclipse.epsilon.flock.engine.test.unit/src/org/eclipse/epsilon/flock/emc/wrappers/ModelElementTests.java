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

import static org.easymock.classextension.EasyMock.expect;
import static org.easymock.classextension.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.emc.wrappers.AttributeValue;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.emc.wrappers.ModelValue;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;
import org.junit.Before;
import org.junit.Test;

public class ModelElementTests {

	private static final Object       underlyingElement = "foo";
	private static final Model        mockModel         = createMock("mockModel", Model.class);
	private static final ModelType    mockModelType     = createMock(ModelType.class);
	private static final ModelElement element           = new ModelElement(mockModel, mockModelType, underlyingElement);
	
	@Before
	public void resetDummyModel() {
		reset(mockModel, mockModelType);
	}
	
	@Test
	public void unwrapShouldReturnUnderlyingModelObject() {
		assertEquals("foo", element.unwrap());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void getEquivalentShouldDelegateToEquivalencesWhenModelElementIsContainedInModel() throws ConservativeCopyException {
		final Model               mockMigratedModel = createMock("mockMigratedModel",Model.class);
		final ConservativeCopyContext mockContext       = createMock(ConservativeCopyContext.class);
		
		final ModelElement dummyMigratedModelElement = new ModelElement(mockMigratedModel, mockModelType, "bar");

		// Expectations
		expect(mockModel.owns(underlyingElement))
			.andReturn(true);
		
		expect(mockContext.getEquivalent(element))
			.andReturn(dummyMigratedModelElement);
		
		expect(mockMigratedModel.wrap(dummyMigratedModelElement))
			.andReturn((ModelValue)dummyMigratedModelElement);
		
		replay(mockModel, mockMigratedModel, mockContext);
		
		
		// Verification
		assertEquals(dummyMigratedModelElement,
		             element.getEquivalentIn(mockMigratedModel, mockContext));
		
		verify(mockModel, mockMigratedModel, mockContext);
	}
	
	@Test
	public void getEquivalentShouldReturnTheModelElementWhenItIsNotContainedInTheModel() throws ConservativeCopyException {
		final Model               dummyMigratedModel = createMock("mockMigratedModel",Model.class);
		final ConservativeCopyContext dummyContext       = createMock(ConservativeCopyContext.class);
		
		// Expectations
		expect(mockModel.owns(underlyingElement))
			.andReturn(false);
		
		replay(mockModel, dummyMigratedModel, dummyContext);
		
		
		// Verification
		assertEquals(element,
		             element.getEquivalentIn(dummyMigratedModel, dummyContext));
		
		verify(mockModel, dummyMigratedModel, dummyContext);
	}
	
	@Test
	public void copyConformantValue() throws ConservativeCopyException, EolRuntimeException {				
		final Model        dummyOriginalModel       = createMock(Model.class);
		final ModelType    dummyOriginalModelType   = createMock(ModelType.class);
		final ModelElement originalModelElementStub = createMock(ModelElement.class);		
		
		// Expectations
		expect(originalModelElementStub.getType())
			.andReturn(dummyOriginalModelType);
		
		expect(mockModelType.getPropertiesSharedWith(dummyOriginalModelType))
			.andReturn(Arrays.asList("name"));
		
				
		final AttributeValue nameValue = new AttributeValue(dummyOriginalModel, "John Smith");
		expect(originalModelElementStub.getValueOfProperty("name"));
		expectLastCall().andReturn(nameValue).anyTimes();
		
		expect(mockModel.conforms(underlyingElement, "name", nameValue)).andReturn(true);
		mockModel.setValueOfProperty(underlyingElement, "name", nameValue);
		
		replay(mockModel, mockModelType, dummyOriginalModel, originalModelElementStub);


		// Verification
		
		element.conservativelyCopyPropertiesFrom(originalModelElementStub, null);
				
		verify(mockModel, mockModelType, dummyOriginalModel, originalModelElementStub);
	}
	
	@Test
	public void doNotCopyNonConformantValue() throws ConservativeCopyException, EolRuntimeException {				
		final Model        dummyOriginalModel       = createMock(Model.class);
		final ModelType    dummyOriginalModelType   = createMock(ModelType.class);
		final ModelElement originalModelElementStub = createMock(ModelElement.class);		
		
		// Expectations
		expect(originalModelElementStub.getType())
			.andReturn(dummyOriginalModelType);
		
		expect(mockModelType.getPropertiesSharedWith(dummyOriginalModelType))
			.andReturn(Arrays.asList("name"));
		
				
		final AttributeValue nameValue = new AttributeValue(dummyOriginalModel, 14);
		expect(originalModelElementStub.getValueOfProperty("name"));
		expectLastCall().andReturn(nameValue).anyTimes();
		
		expect(mockModel.conforms(underlyingElement, "name", nameValue)).andReturn(false);
		
		replay(mockModel, mockModelType, dummyOriginalModel, originalModelElementStub);


		// Verification
		
		element.conservativelyCopyPropertiesFrom(originalModelElementStub, null);
				
		verify(mockModel, mockModelType, dummyOriginalModel, originalModelElementStub);
	}
	
	
	@Test
	public void copyIdentityDelgatesToGetAndSetIdentity() {
		final ModelElement mockOriginalModelElement = createMock(ModelElement.class);
		
		// Expectations
		expect(mockOriginalModelElement.getIdentity())
			.andReturn("an_identity");
		
		mockModel.setIdentity(underlyingElement, "an_identity");
				
		replay(mockModel, mockModelType, mockOriginalModelElement);


		// Verification
		
		element.copyIdentityFrom(mockOriginalModelElement);
				
		verify(mockModel, mockModelType, mockOriginalModelElement);
	}
}
