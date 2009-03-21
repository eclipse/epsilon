/**
 * *******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 * ******************************************************************************
 *
 * $Id: Enumerations.java,v 1.1 2008/08/08 17:19:01 louis Exp $
 */
package org.eclipse.epsilon.hutn.generate.model;

import static org.eclipse.epsilon.hutn.test.unit.util.IntermediateUtil.*;

import org.eclipse.epsilon.hutn.exceptions.HutnGenerationException;
import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.junit.BeforeClass;
import org.junit.Test;

public class Enumerations extends HutnModelGeneratorTest {

	private static ClassObject createDog(String name, String breed) {
		return createClass(name, "Dog", createAttributeSlot("name", name), createAttributeSlot("breed", breed));
	}
	
	@BeforeClass
	public static void generateModel() throws HutnGenerationException {
		model = modelGeneratorTest(createSpec("families", createPackage(createDog("Fido", "labrador"), createDog("Lassie", "poodle"))));
		
		model.setVariable("fido",   "Dog.allInstances().selectOne(d|d.name='Fido')");
		model.setVariable("lassie", "Dog.allInstances().selectOne(d|d.name='Lassie')");
	}

	@Test
	public void modelShouldHaveTwoPets() {
		model.assertEquals(2, "Pet.allInstances().size()");
	}
	
	@Test
	public void fidoShouldBeALabrador() {
		model.assertEquals("DogBreed#labrador", "fido.breed");
	}
	
	@Test
	public void lassieShouldBeAPoodle() {
		model.assertEquals("DogBreed#poodle", "lassie.breed");
	}
}
