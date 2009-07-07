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
package org.eclipse.epsilon.migration.model.loader;

import static org.eclipse.epsilon.migration.model.loader.LoaderTestHelper.createBody;
import static org.eclipse.epsilon.migration.model.loader.LoaderTestHelper.createMigrationRuleAst;
import static org.eclipse.epsilon.migration.model.loader.LoaderTestHelper.createMigrationStrategyAst;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.migration.model.ExecutableMigrationRule;
import org.eclipse.epsilon.migration.model.MigrationStrategy;
import org.junit.Test;

public class MigrationStrategyLoaderTest {

	@Test
	public void empty() {
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(createMigrationStrategyAst());
		
		assertEquals(0, strategy.numberOfRules());
	}
	
	@Test
	public void basicMigrationRule() {
		final AST body = createBody();
		final AST rule = createMigrationRuleAst("Person", null, null, body);
		
		final AST strategyAst = createMigrationStrategyAst(rule);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(strategyAst);
		
		assertEquals(1, strategy.numberOfRules());
		assertEquals(new ExecutableMigrationRule("Person", "Person", null, body), strategy.getRule(0));
	}
	
	
	@Test
	public void severalRules() {
		final AST personBody = createBody();
		final AST personRule = createMigrationRuleAst("Person", null, null, personBody);
		
		final AST animalBody = createBody();
		final AST animalRule = createMigrationRuleAst("Animal", null, null, animalBody);
		
		final AST strategyAst = createMigrationStrategyAst(personRule, animalRule);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(strategyAst);
		
		assertEquals(2, strategy.numberOfRules());
		assertEquals(new ExecutableMigrationRule("Person", "Person", null, personBody), strategy.getRule(0));
		assertEquals(new ExecutableMigrationRule("Animal", "Animal", null, animalBody), strategy.getRule(1));
	}
	
	private static MigrationStrategy runMigrationStrategyLoaderOn(AST strategy) {
		return new MigrationStrategyLoader(strategy).run();
	}
}
