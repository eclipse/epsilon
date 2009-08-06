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
package test.strong2strong.rules;

import org.junit.BeforeClass;
import org.junit.Test;

import test.strong2strong.Strong2StrongMigrationAcceptanceTest;

public class SeveralRulesForSameType extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Person " +
	                                       "when: ' '.isSubstringOf(original.name) {" +
	                                       "	migrated.name := original.name;" +
	                                       "}" +
	                                       "migrate Person " +
	                                       "when: original.name.isDefined() {" +
	                                       "	migrated.name := original.name + ' Smith';" +
	                                       "}" +
	                                       "migrate Person {" +
	                                       "	migrated.name := 'John Doe';"   +
	                                       "}";
	
	private static final String originalModel = "Families {"                   +
	                                            "	Person {"                  +
	                                            "		name: \"Jack\""        +
	                                            "	}"                         +
	                                            "	Person {"                  +
	                                            "		name: \"Joe Bloggs\""  +
	                                            "	}"                         +
	                                            "	Person {"                  +
	                                            "	}"                         +
	                                            "}";
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("jack", "Person.all.selectOne(p|p.name.startsWith('Jack'))");
		migrated.setVariable("joe",  "Person.all.selectOne(p|p.name.startsWith('Joe'))");
		migrated.setVariable("john", "Person.all.selectOne(p|p.name.startsWith('John'))");
	}
	
	@Test
	public void personWithSurnameIsUnchanged() {
		migrated.assertEquals("Joe Bloggs", "joe.name");
	}
	
	@Test
	public void personWithoutSurnameNowHasSmithAsSurname() {
		migrated.assertEquals("Jack Smith", "jack.name");
	}
	
	@Test
	public void anonymousPersonIsNowNamedJohnDoe() {
		migrated.assertEquals("John Doe", "john.name");
	}
}
