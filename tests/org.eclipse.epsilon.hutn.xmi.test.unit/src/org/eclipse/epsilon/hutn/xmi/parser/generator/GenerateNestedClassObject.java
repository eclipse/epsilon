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
package org.eclipse.epsilon.hutn.xmi.parser.generator;

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.junit.Before;
import org.junit.Test;

public class GenerateNestedClassObject extends HutnTestWithFamiliesMetaModel {

	private SpecGenerator generator;
	
	@Before
	public void setup() {
		generator = new SpecGenerator();
		generator.initialise("families");
	}
	
	@Test
	public void generatesNestedClassObject() {
		generator.generateTopLevelClassObject("f", "Family");
		generator.generateContainedClassObject("members", "p", "Person");
		
		assertEquals(1, getFirstPackage().getClassObjects().size());
		assertEquals(1, getFirstClassObject().getSlots().size());
		
		assertEquals("p", getNestedClassObject().getIdentifier());
		
		slotTest(getFirstClassObject().getSlots().get(0), ContainmentSlot.class, "members", "Person");
		
		assertEquals(getNestedClassObject(), generator.getCurrentClassObject());
	}
	
	@Test(expected=IllegalStateException.class)
	public void cannotCreateUnnestedContainedClassObject() {
		generator.generateContainedClassObject("members", "p", "Person");
	}
	
	@Test
	public void canInferTypeFromMetamodel() {
		generator.generateTopLevelClassObject("f", "Family");
		generator.generateContainedClassObject("members", "p");
		
		slotTest(getFirstClassObject().getSlots().get(0), ContainmentSlot.class, "members", "Person");
	}
	
	@Test
	public void inferTypeForNonContainment() {
		generator.generateTopLevelClassObject("f", "Family");
		generator.generateContainedClassObject("name", "n");
		
		slotTest(getFirstClassObject().getSlots().get(0), ContainmentSlot.class, "name", "UnknownType");
	}
	
	@Test
	public void cannotInferTypeForUnknownMetamodelFeature() {
		generator.generateTopLevelClassObject("f", "Family");
		generator.generateContainedClassObject("foobars", "x");
		
		slotTest(getFirstClassObject().getSlots().get(0), ContainmentSlot.class, "foobars", "UnknownType");
	}
	
	
	private PackageObject getFirstPackage() {
		return generator.getSpec().getObjects().get(0);
	}
	
	private ClassObject getFirstClassObject() {
		return getFirstPackage().getClassObjects().get(0);
	}
	
	private ClassObject getNestedClassObject() {
		return (ClassObject)getFirstClassObject().getSlots().get(0).getValues().get(0);
	}
}
