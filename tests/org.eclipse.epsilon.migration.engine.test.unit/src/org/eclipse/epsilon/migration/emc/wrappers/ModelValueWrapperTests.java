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

import static junit.framework.Assert.assertTrue;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.EasyMock.isA;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.eclipse.epsilon.migration.test.unit.easymock.matchers.OneOfCollection.oneOf;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.hutn.test.model.families.DogBreed;
import org.junit.Test;

public class ModelValueWrapperTests {
	
	@Test
	public void wrapValue() {
		wrapValueTest("a model value", AttributeValue.class);
	}
	
	@Test
	public void wrapModelElement() {		
		wrapValueTest("dummy model element", ModelElement.class, "dummy model element");
	}
	
	@Test
	public void wrapCollectionOfValues() {
		final CollectionOfModelValues wrappedValues = wrapValueTest(new EolSequence(Arrays.asList("a model value", "dummy model element")),
		                                                            CollectionOfModelValues.class,
		                                                            "dummy model element");
		
		for (ModelValue<?> wrappedValue : wrappedValues) {
			if (wrappedValue.unwrap().equals("dummy model element")) {
				assertWrappedValueTypeEquals(ModelElement.class, wrappedValue);
			} else {
				assertWrappedValueTypeEquals(AttributeValue.class, wrappedValue);
			}
		}
	}
	
	@Test
	public void wrapEnumerationValue() {
		wrapValueTest(DogBreed.LABRADOR, EnumValue.class);
	}
	
	@Test
	public void wrapingAWrappedValueShouldNotReturnADoublyWrappedValue() {
		final ModelValue<?> wrappedValue = wrapValue("a model value");
		
		// Unwrapping a doubly wrapped value is the same as unwrapping a wrapped value
		assertEquals(wrappedValue.unwrap(), wrapValue(wrappedValue).unwrap());
	}	
	
	
	
	private static <T extends ModelValue<?>> T wrapValueTest(Object unwrappedValue, Class<T> expectedWrappedType, Object... modelElements) {	
		final ModelValue<?> wrappedValue = wrapValue(unwrappedValue, modelElements);
		
		assertWrappedValueTypeEquals(expectedWrappedType, wrappedValue);
		
		return expectedWrappedType.cast(wrappedValue);
	}
	
	private static ModelValue<?> wrapValue(Object unwrappedValue, Object... modelElements) {	
		final ModelValueWrapper wrapper = new ModelValueWrapper(createModelStubWithModelElements(modelElements));
		
		return wrapper.wrapValue(unwrappedValue);
	}

	private static <T extends ModelValue<?>> void assertWrappedValueTypeEquals(Class<T> expectedWrappedType, ModelValue<?> wrappedValue) {
		assertTrue("Expected an instance of <" + expectedWrappedType.getCanonicalName() + "> " +
		           "but was " + (wrappedValue == null ? "null" : "an instance of <" + wrappedValue.getClass().getCanonicalName() + ">"),
		           expectedWrappedType.isInstance(wrappedValue));
	}
	
	
	@SuppressWarnings("unchecked")
	private static Model createModelStubWithModelElements(Object... modelElements) {
		final Model modelStub = createMock(Model.class);
		
		// Return true for any object contained in modelElements
		expect(modelStub.isModelElement(oneOf(Arrays.asList(modelElements))))
			.andReturn(true);
		expectLastCall().anyTimes();
		
		// And return false for any object not contained in modelElements
		expect(modelStub.isModelElement(isA(Object.class)))
			.andReturn(false);
		expectLastCall().anyTimes();
		
		// CollectionOfModelValues will use model to wrap values
		expect(modelStub.wrapValue(oneOf(Arrays.asList(modelElements))))
			.andReturn((BackedModelValue)new ModelElement(modelStub, "dummy model element"));
		expectLastCall().anyTimes();
		
		expect(modelStub.wrapValue(isA(Object.class)))
			.andReturn((BackedModelValue)new AttributeValue(modelStub, "dummy wrapped value"));
		expectLastCall().anyTimes();
		
		replay(modelStub);
		
		return modelStub;
	}
}
