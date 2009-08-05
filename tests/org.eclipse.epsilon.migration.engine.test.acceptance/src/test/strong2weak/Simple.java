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
package test.strong2weak;

import org.junit.BeforeClass;
import org.junit.Test;

public class Simple extends Strong2WeakMigrationAcceptanceTest {

	private static final String strategy = "migrate Person {" +
	                                       "	migrated.notAFeature := original.name;" +
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
	public void migratedShouldHaveName() {
		migrated.assertEquals("John", "person.name");
	}
	
	@Test
	public void migratedShouldHaveNotAFeatureSlot() {
		migrated.assertEquals("John", "person.notAFeature");
	}
}
