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
package org.eclipse.epsilon.flock.engine.test.acceptance.rules;

import static org.eclipse.epsilon.test.util.builders.emf.MetamodelBuilder.aMetamodel;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.flock.engine.test.acceptance.util.FlockAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class RuleForDeletedType extends FlockAcceptanceTest {

	private static final String strategy = "migrate Person {" +
	                                       "   migrated.println();" +
	                                       "}";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "}";
	
	@BeforeClass
	public static void setup() throws Exception {
		final EPackage empty = aMetamodel().build();
		migrateFamiliesTo(empty, strategy, originalModel);
	}
	
	@Test
	public void migratedModelIsEmpty() {
		migrated.assertEquals(0, "Migrated.allContents().size()");
	}
	
	@Test
	public void shouldIncludeWarning() throws Exception {
		final String message = "Rule defined for migrating instances of families::Person but " +
		                       "that type cannot be instantiated in the evolved metamodel.";
		
		assertThat(result.getWarnings(), contains(message));
	}
}
