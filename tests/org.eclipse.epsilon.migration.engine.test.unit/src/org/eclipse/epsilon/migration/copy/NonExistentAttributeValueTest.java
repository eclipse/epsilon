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
package org.eclipse.epsilon.migration.copy;

import static org.eclipse.epsilon.hutn.test.model.factories.DogFactory.createDog;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.hutn.test.model.families.Dog;
import org.eclipse.epsilon.migration.emc.wrappers.CopyingException;
import org.junit.BeforeClass;
import org.junit.Test;

public class NonExistentAttributeValueTest extends AbstractCopyTest {
	
	private static final Dog dog = createDog("Lassie");
	
	@BeforeClass
	public static void setup() throws CopyingException, EolRuntimeException {
		final EPackage targetMetamodel = aMetamodel()
		                                 	.with(anEClass().named("Dog"))
                                       	 .build();
		
		copyTest(targetMetamodel, "Dog", dog);
	}
	
	@Test
	public void copyIsADog() {
		checkCopy("Dog");
	}
}