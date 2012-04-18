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

import org.eclipse.epsilon.flock.engine.test.acceptance.util.FlockAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class SeveralRulesForSameType extends FlockAcceptanceTest {

	private static final String strategy = "migrate Person " +
	                                       "when: ' '.isSubstringOf(original.name) {" +
	                                       "	migrated.name := original.name.split(' ').first;" +
	                                       "}" +
	                                       "migrate Person " +
	                                       "when: original.name.isUndefined() {" +
	                                       "	migrated.name := 'John';" +
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
	public void personForWhomNoRulesApplyIsUnchanged() {
		migrated.assertEquals("Jack", "jack.name");
	}
	
	@Test
	public void personForWhomFirstRuleAppliesHasNoSurname() {
		migrated.assertEquals("Joe", "joe.name");
	}
	
	@Test
	public void personForWhomSecondRuleAppliesHasName() {
		migrated.assertEquals("John", "john.name");
	}
}
