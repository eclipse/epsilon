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

import org.junit.BeforeClass;
import org.junit.Test;

public class ContainedObjects extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Person {" +
	                                       "	migrated.name := original.name + ' Smith';" +
	                                       "}";
	
	private static final String originalModel = "Families {"                        +
	                                            "	Family {"                       +
	                                            "		members: Person \"p\" {"    +
	                                            "                	name: \"John\"" +
	                                            "                }"                 +
	                                            "	}"                              +
	                                            "}";
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("family", "Family.all.first");
		migrated.setVariable("person", "Person.all.first");
	}
	
	@Test
	public void migratedShouldContainOnePerson() {
		migrated.assertEquals(1, "Person.all.size()");
	}
	
	@Test
	public void familyShouldContainPerson() {
		migrated.assertTrue("family.members.includes(person)");
	}
	
	@Test
	public void migratedPersonShouldHaveCorrectName() {
		migrated.assertEquals("John Smith", "person.name");
	}
}
