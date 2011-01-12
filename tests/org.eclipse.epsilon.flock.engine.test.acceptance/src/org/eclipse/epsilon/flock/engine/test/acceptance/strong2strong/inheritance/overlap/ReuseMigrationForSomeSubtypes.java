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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.overlap;

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class ReuseMigrationForSomeSubtypes extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate NamedElement when: not original.isKindOf(Dog) {" +
	                                       "	migrated.name := original.name + ' Smith';" +
	                                       "}";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "   Pet {"               +
	                                            "       name: \"Tom\""   +
	                                            "   }"                   +
	                                            "   Dog {"               +
	                                            "       name: \"Fido\""  +
	                                            "   }"                   +
	                                            "}";
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("person", "Person.all.first");
		migrated.setVariable("pet",    "Pet.all.selectOne(p|p.name.startsWith('Tom'))");
		migrated.setVariable("dog",    "Dog.all.first");
	}
	
	@Test
	public void migratedPersonShouldHaveCorrectName() {
		migrated.assertEquals("John Smith", "person.name");
	}
	
	@Test
	public void migratedPetShouldHaveCorrectName() {
		migrated.assertEquals("Tom Smith", "pet.name");
	}
	
	@Test
	public void migratedDogShouldHaveCorrectName() {
		migrated.assertEquals("Fido", "dog.name");
	}
}
