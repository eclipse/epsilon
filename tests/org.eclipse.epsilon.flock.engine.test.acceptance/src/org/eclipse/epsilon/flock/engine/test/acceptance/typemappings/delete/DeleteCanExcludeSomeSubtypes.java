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
package org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.delete;

import org.eclipse.epsilon.flock.engine.test.acceptance.util.FlockAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class DeleteCanExcludeSomeSubtypes extends FlockAcceptanceTest  {
	
	private static final String strategy = "delete NamedElement when: not original.isKindOf(Original!Dog)";

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
	}

	@Test
	public void subtypesOfNamedElementShouldBeDeleted() {
		migrated.assertEquals(0, "NamedElement.all.select(e|e.name == \"John\").size()");
		migrated.assertEquals(0, "NamedElement.all.select(e|e.name == \"Tom\").size()");
	}

	@Test
	public void specifiedSubtypeShouldBeExcluded() {
		migrated.assertEquals("Fido", "Dog.all.first.name");
	}
}
