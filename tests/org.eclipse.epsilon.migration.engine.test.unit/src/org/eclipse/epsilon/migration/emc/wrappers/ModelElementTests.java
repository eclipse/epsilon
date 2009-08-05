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
package org.eclipse.epsilon.migration.emc.wrappers;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.migration.execution.Equivalences;
import org.eclipse.epsilon.migration.execution.exceptions.ConservativeCopyException;
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
	
	@Test
	public void getEquivalentShouldDelegateToEquivalences() throws ConservativeCopyException {
		final Model        dummyMigratedModel = createMock(Model.class);
		final Equivalences mockEquivalences   = createMock(Equivalences.class);
		
		
		// Expectations
		
		expect(mockEquivalences.getEquivalent(element))
			.andReturn(new ModelElement(dummyMigratedModel, "bar"));
		
		replay(dummyMigratedModel, mockEquivalences);
		
		
		// Verification
		
		assertEquals(new ModelElement(dummyMigratedModel, "bar"),
		             element.getEquivalentIn(dummyMigratedModel, mockEquivalences));
		
		verify(dummyMigratedModel, mockEquivalences);
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
		
		final Model        dummyOriginalModel       = createMock(Model.class);
		final Equivalences dummyEquivalences        = createMock(Equivalences.class);
		
		
		// Expectations
		
		expect(mockModel.getPropertiesOf("foo"))
			.andReturn(Arrays.asList("name", "age"));
		
		expect(mockOriginalModelElement.getProperties())
			.andReturn(Arrays.asList("name", "address"));
		
		final AttributeValue nameValue = new AttributeValue(dummyOriginalModel, "John Smith");		
		
		expect(mockOriginalModelElement.getValueOfProperty("name"))
			.andReturn((ModelValue)nameValue);

		mockModel.setValueOfProperty("foo", "name", nameValue);
		
		replay(mockModel, dummyOriginalModel, mockOriginalModelElement, dummyEquivalences);


		// Verification
		
		element.conservativelyCopyPropertiesFrom(mockOriginalModelElement, dummyEquivalences);
				
		verify(mockModel, dummyOriginalModel, mockOriginalModelElement, dummyEquivalences);
	}
}
