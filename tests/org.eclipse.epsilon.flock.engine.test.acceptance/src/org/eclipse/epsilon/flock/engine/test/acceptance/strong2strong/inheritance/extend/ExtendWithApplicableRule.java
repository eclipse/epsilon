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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.inheritance.extend;

import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class ExtendWithApplicableRule extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "migrate NamedElement when: original.name.isUndefined() {" +
	                                       "	migrated.name := 'Joe Bloggs';" +
	                                       "}" +
	                                       "migrate NamedElement when: original.name.isDefined() {" +
	                                       "	migrated.name := original.name + ' Smith';" +
	                                       "}" +
	                                       "migrate Person extends NamedElement\n";
	
	private static final String originalModel = "Families {"             +
	                                            "	Person {"            +
	                                            "		name: \"John\""  +
	                                            "	}"                   +
	                                            "	Person {"            +
	                                            "	}"                   +
	                                            "}";
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, originalModel);
		
		migrated.setVariable("john",                    "Person.all.selectOne(p|p.name.startsWith('John')");
		migrated.setVariable("previouslyUnnamedPerson", "Person.all.selectOne(p|p!=john);");
	}
	
	@Test
	public void namedPersonShouldHaveSurname() {
		migrated.assertEquals("John Smith", "john.name");
	}
	
	@Test
	public void unnamedPersonShouldHaveName() {
		migrated.assertEquals("Joe Bloggs", "previouslyUnnamedPerson.name");
	}
}
