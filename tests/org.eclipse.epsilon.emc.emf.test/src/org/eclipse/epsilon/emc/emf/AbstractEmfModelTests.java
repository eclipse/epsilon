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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.junit.BeforeClass;
import org.junit.Test;
public class AbstractEmfModelTests {

	private static AbstractEmfModel emfModel;
	private static EPackage pkg;
	private static EClass cls;
	
	@BeforeClass
	public static void setup() {
		pkg = EcoreFactory.eINSTANCE.createEPackage();
		cls = EcoreFactory.eINSTANCE.createEClass();
	
		emfModel = new InMemoryEmfModel(EmfUtil.createResource(pkg));
	}
	
	@Test
	public void getTypeNameOf() {
		assertEquals("EPackage", emfModel.getTypeNameOf(pkg));
		assertEquals("EClass",   emfModel.getTypeNameOf(cls));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getTypeNameOfForPlainJavaObject() {
		emfModel.getTypeNameOf("foo");
	}
	
	
	@Test
	public void getPropertiesOf() {
		assertTrue(emfModel.getPropertiesOf(pkg).contains("name"));
		assertTrue(emfModel.getPropertiesOf(pkg).contains("eClassifiers"));
		assertFalse(emfModel.getPropertiesOf(pkg).contains("age"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void getPropertiesOfForPlainJavaObject() {
		emfModel.getPropertiesOf("foo");
	}
}
