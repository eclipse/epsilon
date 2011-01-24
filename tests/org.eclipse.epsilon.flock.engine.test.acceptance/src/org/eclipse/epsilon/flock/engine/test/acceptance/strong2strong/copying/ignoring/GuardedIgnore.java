/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying.ignoring;

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class GuardedIgnore extends Strong2StrongMigrationAcceptanceTest {
	
	private static final String strategy = "migrate Family ignoring numberOfChildren " +
	                                       "when: original.members.isEmpty()";

	private static final String originalModel = "Families {"                  +
	                                            "	Family {"                 +
	                                            "		name: \"The Smiths\"" +
	                                            "       members: Person \"p\" { name: \"John\" } " +
	                                            "		numberOfChildren: 1"  +
	                                            "	}"                        +
	                                            "	Family {"                 +
	                                            "		name: \"The Does\""   +
	                                            "		numberOfChildren: 2"  +
	                                            "	}"                        +
	                                            "}";

	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);

		migrated.setVariable("smiths", "Family.all.selectOne(f|f.name == 'The Smiths')");
		migrated.setVariable("does",   "Family.all.selectOne(f|f.name == 'The Does')");
	}


	@Test
	public void ignoredPropertyIsIgnoredWhenGuardHolds() {
		migrated.assertEquals(0, "does.numberOfChildren");
	}

	@Test
	public void ignoredPropertyIsCopiedWhenGuardDoesNotHold() {
		migrated.assertEquals(1, "smiths.numberOfChildren");
	}
}
