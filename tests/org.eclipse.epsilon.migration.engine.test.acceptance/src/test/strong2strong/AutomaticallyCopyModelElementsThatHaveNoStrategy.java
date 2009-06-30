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
package test.strong2strong;

import static org.eclipse.epsilon.migration.engine.test.util.builders.EAttributeBuilder.anEAttribute;
import static org.eclipse.epsilon.migration.engine.test.util.builders.EClassBuilder.anEClass;
import static org.eclipse.epsilon.migration.engine.test.util.builders.MetamodelBuilder.aMetamodel;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.junit.BeforeClass;
import org.junit.Test;

public class AutomaticallyCopyModelElementsThatHaveNoStrategy extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Person {" +
	                                       "	target.name := original.name + ' Smith';" +
	                                       "}";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "   Dog {"               +
	                                            "       name: \"Fido\""  +
	                                            "   }"                   +
	                                            "}";
	
	private static final EPackage evolvedMetamodel = aMetamodel()
	                                                 	.with(anEClass().named("Person").
	                                                 		with(anEAttribute().
	                                                 			named("name").
	                                                 			withType(EcorePackage.eINSTANCE.getEString())
	                                               			)
	                                               		)
	                                               		.with(anEClass().named("Dog").
	                                                 		with(anEAttribute().
	                                                 			named("name").
	                                                 			withType(EcorePackage.eINSTANCE.getEString())
	                                               			)
	                                               		).build();
	
	@BeforeClass
	public static void setup() throws Exception {
		migrate(strategy, originalModel, evolvedMetamodel);
		
		migrated.setVariable("person", "Person.all.first");
		migrated.setVariable("dog",    "Dog.all.first");
	}
	
	@Test
	public void migratedPersonShouldHaveNewName() {
		migrated.assertEquals("John Smith", "person.name");
	}
	
		@Test
	public void migratedDogShouldHaveOldName() {
		migrated.assertDefined("dog");
		migrated.assertEquals("Fido", "dog.name");
	}
}
