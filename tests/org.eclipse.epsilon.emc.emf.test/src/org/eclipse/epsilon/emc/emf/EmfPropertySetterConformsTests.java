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
package org.eclipse.epsilon.emc.emf;

import static org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder.MANY;
import static org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.test.util.builders.emf.EClassBuilder.anEClass;
import static org.eclipse.epsilon.test.util.builders.emf.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolString;
import org.eclipse.epsilon.test.util.builders.emf.EAttributeBuilder;
import org.eclipse.epsilon.test.util.builders.emf.EClassBuilder;
import org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder;
import org.junit.Before;
import org.junit.Test;

public class EmfPropertySetterConformsTests {
	
	private static MetamodelBuilder metamodelBuilder;
	
	@Before
	public void setup() {
		metamodelBuilder = aMetamodel();
	}
	
	
	// Single values
	
	@Test
	public void singleValueForSingleValuedFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("name")
		                                   	.withBounds(0, 1)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();
		
		assertTrue(checkConformance(feature, new EolString("foo")));
	}
	
	@Test
	public void singleValueForManyValuedFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(0, EAttributeBuilder.MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();
		
		assertTrue(checkConformance(feature, (new EolString("foo"))));
	}
	
	@Test
	public void singleValueOfWrongType() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("age")
		                                   	.withBounds(1, 1)
		                                   	.withType(EcorePackage.eINSTANCE.getEInt())
		                                   .build();
		
		assertFalse(checkConformance(feature, new EolString("foo")));
	}
	
	
	// Reference values
	
	@Test
	public void singleReferenceValue() throws EolIllegalPropertyException {
		final EClass referenced = anEClass().build();
		
		final EStructuralFeature feature = anEReference()
		                                   	.named("age")
		                                   	.references(1, 1, referenced)
		                                   .build();
		
		assertTrue(checkConformance(feature, instantiateClass(referenced)));
	}
	
	@Test
	public void singleReferenceValueOfWrongType() throws EolIllegalPropertyException {
		final EClass referenced = anEClass().build();
		final EClass another    = anEClass().build();
		
		final EStructuralFeature feature = anEReference()
		                                   	.named("age")
		                                   	.references(1, 1, referenced)
		                                   .build();
		
		assertFalse(checkConformance(feature, instantiateClass(another)));
	}
	
	@Test
	public void singleReferenceValueOfSubType() throws EolIllegalPropertyException {
		final EClass referenced = anEClass().build();
		final EClass subtype    = anEClass().subclasses(referenced).build();
		
		final EStructuralFeature feature = anEReference()
		                                   	.named("age")
		                                   	.references(1, 1, referenced)
		                                   .build();
		
		assertTrue(checkConformance(feature, instantiateClass(subtype)));
	}
	
	
	// Collection values
	
	@Test
	public void collectionValueForManyValuedFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(0, MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();

		assertTrue(checkConformance(feature, new EolSequence(Arrays.asList(new EolString("foo"), new EolString("bar")))));
	}
	
	@Test
	public void collectionValueSameSizeAsUpperboundOfFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(0, 2)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();

		assertTrue(checkConformance(feature, new EolSequence(Arrays.asList(new EolString("foo"), new EolString("bar")))));
	}
	
	@Test
	public void collectionValueSmallerThanUpperboundOfFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(0, 3)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();

		assertTrue(checkConformance(feature, new EolSequence(Arrays.asList(new EolString("foo"), new EolString("bar")))));
	}
	
	@Test
	public void collectionValueSameSizeAsLowerboundOfFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(1, MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();

		assertTrue(checkConformance(feature, new EolSequence(Arrays.asList(new EolString("foo")))));
	}
	
	@Test
	public void collectionValueLargerThanLowerboundOfFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(1, MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();

		assertTrue(checkConformance(feature, new EolSequence(Arrays.asList(new EolString("foo"), new EolString("bar")))));
	}
		
	@Test
	public void collectionValueForSingleValuedFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("name")
		                                   	.withBounds(0, 1)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();
		
		assertFalse(checkConformance(feature, new EolSequence(Arrays.asList(new EolString("foo"), new EolString("bar")))));
	}
	
	@Test
	public void collectionValueLargerThanUpperboundOfFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(0, 2)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();

		assertFalse(checkConformance(feature, new EolSequence(Arrays.asList(new EolString("foo"), new EolString("bar"), new EolString("baz")))));
	}
	
	@Test
	public void collectionValueSmallerThanLowerboundOfFeature() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(1, MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();

		assertFalse(checkConformance(feature, new EolSequence()));
	}
	
	@Test
	public void collectionValuesAllOfWrongType() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("lotteryNumbers")
		                                   	.withBounds(0, MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEInt())
		                                   .build();

		assertFalse(checkConformance(feature, new EolSequence(Arrays.asList(new EolString("foo"), new EolString("bar")))));
	}
	
	@Test
	public void collectionValuesOneOfWrongType() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("lotteryNumbers")
		                                   	.withBounds(0, MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEInt())
		                                   .build();

		assertFalse(checkConformance(feature, new EolSequence(Arrays.asList(new EolInteger(15), new EolString("fourty two"), new EolInteger(2)))));
	}
	
	@Test
	public void collectionValuesOneOfWrongReferenceType() throws EolIllegalPropertyException {
		final EClass referenced = anEClass().build();
		final EClass wrongType  = anEClass().build();

		
		final EStructuralFeature feature = anEReference()
		                                   	.named("references")
		                                   	.references(0, MANY, referenced)
		                                   .build();

		assertFalse(checkConformance(feature, new EolSequence(Arrays.asList((referenced), instantiateClass(wrongType), instantiateClass(referenced)))));
	}
	
	
	// Illegal property values
	
	@Test(expected=EolIllegalPropertyException.class)
	public void illegalObject() throws EolIllegalPropertyException {
		createSetterFor("foo", "names").conforms(new EolString("foo"));
	}
	
	@Test(expected=EolIllegalPropertyException.class)
	public void illegalProperty() throws EolIllegalPropertyException {		
		final EObject objectWithNoSlots = instantiateClass();
		createSetterFor(objectWithNoSlots, "names").conforms(new EolString("foo"));
	}
	
	
	private static boolean checkConformance(EStructuralFeature feature, Object value) throws EolIllegalPropertyException {
		return createSetterFor(feature).conforms(value);
	}

	private static EmfPropertySetter createSetterFor(EStructuralFeature feature) {
		return createSetterFor(instantiateClass(feature), feature.getName());
	}

	private static EObject instantiateClass(EStructuralFeature... features) {
		final EClassBuilder clsBuilder = anEClass();
		
		for (EStructuralFeature feature : features) {
			clsBuilder.with(feature);
		}
		
		return instantiateClass(clsBuilder.build());
	}

	private static EObject instantiateClass(EClass cls) {
		return metamodelBuilder.with(cls).build().getEFactoryInstance().create(cls);
	}

	private static EmfPropertySetter createSetterFor(Object object, String featureName) {
		final EmfPropertySetter setter = new EmfPropertySetter();
		setter.setObject(object);
		setter.setProperty(featureName);
		return setter;
	}
}
