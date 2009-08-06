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
package test.strong2strong.copying;

import org.junit.BeforeClass;
import org.junit.Test;

import test.strong2strong.Strong2StrongMigrationAcceptanceTest;

public class ConservativelyCopyModelElementsThatHaveARule extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate Family { "    +
	                                       "	migrated.numberOfChildren := original.numberOfChildren + 1;" +
	                                       "}";

	private static final String originalModel = "Families {"                  +
	                                            "	Family {"                 +
	                                            "		name: \"The Smiths\"" +
	                                            "       members: Person \"p\" { name: \"John\" } " +
	                                            "		numberOfChildren: 2"  +
	                                            "	}"                        +
	                                            "}";
		
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("family", "Family.all.first");
	}
	
	@Test
	public void shouldProduceOneFamily() {
		migrated.assertEquals(1, "Family.all.size");
	}
	
	@Test
	public void numberOfChildrenShouldBeMigrated() {
		migrated.assertEquals(3, "family.numberOfChildren");
	}
	
	@Test
	public void nameShouldBeCopied() {
		migrated.assertEquals("The Smiths", "family.name");
	}
	
	@Test
	public void membersShouldBeCopied() {
		migrated.assertEquals(1,      "family.members.size");
		migrated.assertEquals("John", "family.members.first.name");
	}
}
