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

public class Operation extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Person {" +
	                                       "	migrated.name := original.name.smithise();" +
	                                       "}" +
	                                       "" +
	                                       "operation String smithise() {" +
	                                       "	return self + ' Smith';" +
	                                       "}";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "}";
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("person", "Person.all.first");
	}
	
	@Test
	public void migratedShouldHaveCorrectName() {
		migrated.assertEquals("John Smith", "person.name");
	}
}
