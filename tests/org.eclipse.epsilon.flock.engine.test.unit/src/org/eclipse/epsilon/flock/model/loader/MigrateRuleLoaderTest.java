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
package org.eclipse.epsilon.flock.model.loader;

import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createBody;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createGuard;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createMigrateRuleAst;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRule;
import org.junit.Test;

public class MigrateRuleLoaderTest {

	@Test
	public void basicMigrateRule() {
		final AST body    = createBody();
		final AST ruleAst = createMigrateRuleAst("Person", null, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(new MigrateRule("Person", null, body), rule);
	}
	
	@Test
	public void migrateRuleWithGuard() {
		final AST body    = createBody();
		final AST guard   = createGuard();
		final AST ruleAst = createMigrateRuleAst("Person", guard, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(new MigrateRule("Person", guard.getFirstChild(), body), rule);
	}
	
	private static MigrateRule runMigrationRuleLoaderOn(AST rule) {
		return new MigrateRuleLoader(rule).run();
	}
}
