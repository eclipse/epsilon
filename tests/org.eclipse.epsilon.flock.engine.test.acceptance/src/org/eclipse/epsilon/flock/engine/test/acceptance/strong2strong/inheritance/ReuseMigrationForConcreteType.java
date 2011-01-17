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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance;

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class ReuseMigrationForConcreteType extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Pet {" +
	                                       "	migrated.male := true;" +
	                                       "}";
	
	private static final String originalModel = "Families {"              +
	                                            "	Pet {"                +
	                                            "       name: \"Minnie\"" +
	                                            "		male: false"      +
	                                            "	}"                    +
	                                            "   Dog {"                +
	                                            "       name: \"Lassie\"" +
	                                            "		male: false"      +
	                                            "   }"                    +
	                                            "}";
	
	@BeforeClass
	public static void setup() throws Throwable {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("pet", "Pet.all.selectOne(p|p.name='Minnie')");
	}
	
	@Test
	public void migratedPetShouldHaveCorrectGender() {
		migrated.assertTrue("pet.male");
	}
	
	@Test
	public void migratedDogShouldHaveCorrectGender() {
		migrated.assertTrue("Dog.all.first.male");
	}
}
