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

import static org.eclipse.epsilon.hutn.test.model.factories.FamilyFactory.createFamily;
import static org.eclipse.epsilon.hutn.test.model.factories.PetFactory.createPet;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EReferenceBuilder.anEReference;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import java.util.Arrays;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.hutn.test.model.families.Family;
import org.eclipse.epsilon.hutn.test.model.families.Pet;
import org.junit.BeforeClass;
import org.junit.Test;

public class ManyValuedReferenceTest extends AbstractCopyTest {
	
	private static Pet    dino       = createPet("Dino");
	private static Pet    babyPuss   = createPet("Baby Puss");

	private static Family flintstones = createFamily(dino, babyPuss);
	
	private static Object migratedDino, migratedBabyPuss;
	
	@BeforeClass
	public static void setup() throws CopyingException, EolRuntimeException {
		final EClass petClass = anEClass()
		                         .named("Pet")
		                         .with(anEAttribute()
		                        	.named("name")
		                        	.withType(EcorePackage.eINSTANCE.getEString()
		                         )	
		                        ).build();
       	

		final EPackage targetMetamodel = aMetamodel()
		                                 	.with(petClass)
		                                 	.with(anEClass()
		                                 		.named("Family")
		                                 		.with(anEReference().
		                                 				named("pets").
		                                 				references(0, -1, petClass)
		                                 		)
		                                 	)
		                                 .build();
		
		migratedDino     = addEquivalence(targetMetamodel, dino,     petClass);
		migratedBabyPuss = addEquivalence(targetMetamodel, babyPuss, petClass);
		
		copyTest(targetMetamodel, "Family", flintstones);
	}
	
	@Test
	public void copyIsAFamilyWithEquivalentPets() {
		checkCopy("Family", new Slot("pets", Arrays.asList(migratedDino, migratedBabyPuss)));
	}
}