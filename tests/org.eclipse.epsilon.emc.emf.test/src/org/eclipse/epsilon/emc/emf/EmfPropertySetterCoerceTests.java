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
import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolString;
import org.eclipse.epsilon.test.util.builders.emf.EClassBuilder;
import org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder;
import org.junit.Before;
import org.junit.Test;

public class EmfPropertySetterCoerceTests {
	
	private static MetamodelBuilder metamodelBuilder;
	
	@Before
	public void setup() {
		metamodelBuilder = aMetamodel();
	}
		
	@Test
	public void singleValueShouldNotBeChangedWhenPropertyIsSingleValued() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("name")
		                                   	.withBounds(0, 1)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();
		
		assertEquals(new EolString("foo"), coerce(feature, new EolString("foo")));
	}
	
	@Test
	public void singleValueShouldBecomeCollectionWhenPropertyIsMany() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("names")
		                                   	.withBounds(0, MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEString())
		                                   .build();
		
		assertEquals(new EolSequence(Arrays.asList(new EolString("foo"))),
		            coerce(feature, (new EolString("foo"))));
	}
	
	@Test
	public void collectionValueShouldNotBeChanged() throws EolIllegalPropertyException {
		final EStructuralFeature feature = anEAttribute()
		                                   	.named("age")
		                                   	.withBounds(0, MANY)
		                                   	.withType(EcorePackage.eINSTANCE.getEInt())
		                                   .build();
		
		assertEquals(new EolSequence(Arrays.asList(new EolInteger(14), new EolInteger(6))),
		            coerce(feature, new EolSequence(Arrays.asList(new EolInteger(14), new EolInteger(6)))));
	}
	
	
	// Illegal property values
	
	@Test(expected=EolIllegalPropertyException.class)
	public void illegalObject() throws EolIllegalPropertyException {
		createSetterFor("foo", "names").coerce(new EolString("foo"));
	}
	
	@Test(expected=EolIllegalPropertyException.class)
	public void illegalProperty() throws EolIllegalPropertyException {		
		final EObject objectWithNoSlots = instantiateClass();
		createSetterFor(objectWithNoSlots, "names").coerce(new EolString("foo"));
	}

	
	private static Object coerce(EStructuralFeature feature, Object value) throws EolIllegalPropertyException {
		return createSetterFor(feature).coerce(value);
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
