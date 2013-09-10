/*******************************************************************************
 * Copyright (c) 2013 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.engine.test.acceptance.preandpost;

import org.eclipse.epsilon.flock.engine.test.acceptance.util.FlockAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class PreAndPostBlocks extends FlockAcceptanceTest {

	private static final String strategy = "pre {" +
	                                       "  var surname = 'Smith';" +
	                                       "} " +
	                                       "migrate Person {" +
	                                       "	migrated.name := original.name + ' ' + surname;" +
	                                       "} " + 
	                                       "post { " +
	                                       "  var first = Migrated!Person.all.first; " +
	                                       "  first.name = first.name + '-Brown';" +
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
		migrated.assertEquals("John Smith-Brown", "person.name");
	}
}
