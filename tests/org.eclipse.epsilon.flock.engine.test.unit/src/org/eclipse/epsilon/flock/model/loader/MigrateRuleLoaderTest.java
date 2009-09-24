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
import org.eclipse.epsilon.flock.model.MigrateRule;
import org.junit.Test;

public class MigrateRuleLoaderTest {

	@Test
	public void basicMigrateRule() {
		final AST body    = createBody();
		final AST ruleAst = createMigrateRuleAst("Person", null, null, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(new MigrateRule("Person", "Person", null, body), rule);
	}
	
	@Test
	public void migrateRuleWithToPart() {
		final AST body    = createBody();
		final AST ruleAst = createMigrateRuleAst("Animal", "Dog", null, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(new MigrateRule("Animal", "Dog", null, body), rule);
	}
	
	@Test
	public void migrateRuleWithGuard() {
		final AST body    = createBody();
		final AST guard   = createGuard();
		final AST ruleAst = createMigrateRuleAst("Person", null, guard, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(new MigrateRule("Person", "Person", guard.getFirstChild(), body), rule);
	}
	
	@Test
	public void migrateRuleWithToPartAndGuard() {
		final AST body    = createBody();
		final AST guard   = createGuard();
		final AST ruleAst = createMigrateRuleAst("Animal", "Dog", guard, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(new MigrateRule("Animal", "Dog", guard.getFirstChild(), body), rule);
	}
	
	@Test
	public void shorthandMigrateRule() {
		final AST ruleAst = createMigrateRuleAst("Animal", "Dog", null, null);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(new MigrateRule("Animal", "Dog", null, null), rule);
	}
	
	@Test
	public void shorthandMigrateRuleWithGuardPart() {
		final AST guard   = createGuard();
		final AST ruleAst = createMigrateRuleAst("Animal", "Dog", guard, null);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(new MigrateRule("Animal", "Dog", guard.getFirstChild(), null), rule);
	}
	
	private static MigrateRule runMigrationRuleLoaderOn(AST rule) {
		return new MigrateRuleLoader(rule).run();
	}
}
