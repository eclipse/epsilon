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
package org.eclipse.epsilon.hutn.unparser.packageObject;

import static org.eclipse.epsilon.hutn.test.util.IntermediateUtil.createClassObject;
import static org.eclipse.epsilon.hutn.test.util.IntermediateUtil.createPackageObject;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.unparser.internal.AbstractPackageObjectUnparserTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class PackageObjectWithManyClassObjects extends AbstractPackageObjectUnparserTest {

	@BeforeClass
	public static void setup() {
		packageObjectUnparserTest(createPackageObject("families",
		                                              createClassObject("John",       "Person"),
		                                              createClassObject("The Smiths", "Family"),
		                                              createClassObject("Pet")));
	}
	
	@Test
	public void hasOneClassObject() {
		assertEquals(3, numberOfClassObjects());
	}
	
	@Test
	public void hasJohnAsFirstClassObject() {
		assertEquals("Person \"John\" {}", classObject(0));
	}
	
	@Test
	public void hasSmithsAsFirstClassObject() {
		assertEquals("Family \"The Smiths\" {}", classObject(1));
	}
	
	@Test
	public void hasAPetAsFirstClassObject() {
		assertEquals("Pet  {}", classObject(2));
	}
}
