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

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.PackageObject;
import org.junit.BeforeClass;
import org.junit.Test;

public class GenerateTopLevelClassObject {

	private static final SpecGenerator generator = new SpecGenerator();
	
	@BeforeClass
	public static void setup() {
		generator.initialise();
		generator.generateTopLevelClassObject("f", "foo");
	}
	
	@Test
	public void packageShouldContainOneClassObject() {
		assertEquals(1, getFirstPackage().getClassObjects().size());
	}
	
	@Test
	public void classObjectShouldHaveCorrectIdentifier() {
		assertEquals("f", getFirstClassObject().getIdentifier());
	}
	
	@Test
	public void classObjectShouldHaveCorrectType() {
		assertEquals("foo", getFirstClassObject().getType());
	}
	
	@Test
	public void currentClassObjectShouldBeTheNewClassObject() {
		assertEquals(getFirstClassObject(), generator.getCurrentClassObject());
	}
	
	@Test(expected=IllegalStateException.class)
	public void cannotCreateNestedTopLevelClassObject() {
		generator.generateTopLevelClassObject("b", "bar");
	}
	
	
	private static PackageObject getFirstPackage() {
		return generator.getSpec().getObjects().get(0);
	}
	
	private static ClassObject getFirstClassObject() {
		return getFirstPackage().getClassObjects().get(0);
	}
}
