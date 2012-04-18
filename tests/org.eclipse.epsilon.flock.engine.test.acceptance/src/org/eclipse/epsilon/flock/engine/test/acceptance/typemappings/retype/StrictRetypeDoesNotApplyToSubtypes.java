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
package org.eclipse.epsilon.flock.engine.test.acceptance.typemappings.retype;

import org.eclipse.epsilon.flock.engine.test.acceptance.util.FlockAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class StrictRetypeDoesNotApplyToSubtypes extends FlockAcceptanceTest {

	private static final String strategy = "@strict" + "\n" +
	                                       "retype Pet to Family";

	private static final String originalModel = "Families {"            +
	                                            "	Pet {"              +
	                                            "		name: \"Tom\""  +
	                                            "	}"                  +
	                                            "	Dog {"              +
	                                            "		name: \"Fido\"" +
	                                            "	}"                  +
	                                            "}";

	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("tom",  "NamedElement.all.selectOne(e|e.name == 'Tom')");
		migrated.setVariable("fido", "NamedElement.all.selectOne(e|e.name == 'Fido')");
	}

	@Test
	public void petsShouldBeRetyped() {
		migrated.assertInstanceOf("Family", "tom");
	}

	@Test
	public void dogsShouldNotBeRetyped() {
		migrated.assertInstanceOf("Dog", "fido");
	}
}
