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
package org.eclipse.epsilon.migration.model;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.CommonToken;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.migration.parse.MigrationParser;
import org.junit.Test;

public class MigrationStrategyLoaderTest {

	@Test
	public void empty() {
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(null);
		
		assertEquals(0, strategy.numberOfRules());
	}
	
	@Test
	public void basicMigrationRule() {
		final AST body = createBody();
		final AST rule = createMigrationRuleAst("Person", null, null, body);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(rule);
		
		assertEquals(1, strategy.numberOfRules());
		assertEquals(new MigrationRule("Person", "Person", null, body), strategy.getRule(0));
	}
	
	@Test
	public void migrationRuleWithToPart() {
		final AST body = createBody();
		final AST rule = createMigrationRuleAst("Animal", "Dog", null, body);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(rule);
		
		assertEquals(1, strategy.numberOfRules());
		assertEquals(new MigrationRule("Animal", "Dog", null, body), strategy.getRule(0));
	}
	
	@Test
	public void migrationRuleWithGuard() {
		final AST body  = createBody();
		final AST guard = createGuard();
		final AST rule = createMigrationRuleAst("Person", null, guard, body);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(rule);
		
		assertEquals(1, strategy.numberOfRules());
		assertEquals(new MigrationRule("Person", "Person", guard, body), strategy.getRule(0));
	}
	
	@Test
	public void migrationRuleWithToPartAndGuard() {
		final AST body  = createBody();
		final AST guard = createGuard();
		final AST rule = createMigrationRuleAst("Animal", "Dog", guard, body);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(rule);
		
		assertEquals(1, strategy.numberOfRules());
		assertEquals(new MigrationRule("Animal", "Dog", guard, body), strategy.getRule(0));
	}
	
	
	
	private static MigrationStrategy runMigrationStrategyLoaderOn(AST migrationStrategy) {
		return new MigrationStrategyLoader(migrationStrategy).run();
	}
	
	private static AST createMigrationRuleAst(String originalType, String targetType, AST guard, AST block) {
		final AST rule = createAST(MigrationParser.MIGRATE, "MIGRATE");
		rule.addChild(createAST(MigrationParser.NAME, originalType));
		
		if (targetType != null)
			rule.addChild(createAST(MigrationParser.NAME, targetType));
		
		if (guard != null)
			rule.addChild(guard);
		
		rule.addChild(block);
		
		return rule;
	}
	
	private static AST createGuard() {
		return createAST(MigrationParser.BOOLEAN, "true");
	}
	
	private static AST createBody() {
		return createAST(MigrationParser.BLOCK, "BLOCK");
	}
	
	private static AST createAST(int token, String text) {
		return new AST(new CommonToken(token, text), null);
	}
}
