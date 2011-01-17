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


public class ReuseMigrationForAbstractType extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate NamedElement {" +
	                                       "	migrated.name := original.name + ' Smith';" +
	                                       "}";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "   Pet {"               +
	                                            "       name: \"Fido\""  +
	                                            "   }"                   +
	                                            "}";
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("person", "Person.all.first");
		migrated.setVariable("pet",    "Pet.all.first");
	}
	
	@Test
	public void migratedPersonShouldHaveCorrectName() {
		migrated.assertEquals("John Smith", "person.name");
	}
	
	@Test
	public void migratedPetShouldHaveCorrectName() {
		migrated.assertEquals("Fido Smith", "pet.name");
	}
}
