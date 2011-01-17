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

import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createAnnotatedOperationAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createBlock;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createBody;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createDeletionAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createMigrateRuleAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createMigrationStrategyAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createOperationAst;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.createRetypingAst;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;
import org.eclipse.epsilon.flock.model.loader.MigrationStrategyLoader;
import org.junit.Test;

public class MigrationStrategyLoaderTest {

	@Test
	public void empty() {
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(createMigrationStrategyAst());
		
		assertEquals(0, strategy.getTypeMappingsAndRules().size());
	}
	
	@Test
	public void migrationRule() {
		final AST rule        = createMigrateRuleAst("Person", null, createBody());
		final AST strategyAst = createMigrationStrategyAst(rule);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(strategyAst);
		
		assertEquals(1, strategy.getTypeMappingsAndRules().size());
	}
	
	@Test
	public void deletion() {
		final AST rule        = createDeletionAst("Person");
		final AST strategyAst = createMigrationStrategyAst(rule);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(strategyAst);
		
		assertEquals(1, strategy.getTypeMappingsAndRules().size());
	}
	
	@Test
	public void retyping() {
		final AST rule        = createRetypingAst("Person", "Salesperson");
		final AST strategyAst = createMigrationStrategyAst(rule);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(strategyAst);
		
		assertEquals(1, strategy.getTypeMappingsAndRules().size());
	}
	
	@Test
	public void mixtureOfRulesAndTypeMappings() {
		final AST personRule     = createMigrateRuleAst("Person", null, createBody());
		final AST animalRule     = createMigrateRuleAst("Animal", null, createBody());
		final AST retyping       = createRetypingAst("Car", "Vehicle");
		final AST truckDeletion  = createDeletionAst("Truck");
		final AST donkeyDeletion = createDeletionAst("Donkey");

		final AST strategyAst = createMigrationStrategyAst(personRule, animalRule, retyping, truckDeletion, donkeyDeletion);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(strategyAst);
		
		assertEquals(5, strategy.getTypeMappingsAndRules().size());
	}
	
	@Test
	public void operationsShouldNotBeTreatedAsRulesOrTypeMappings() {
		final AST operationAst = createOperationAst("String", "inc", createBlock());
		final AST strategyAst  = createMigrationStrategyAst(operationAst);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(strategyAst);
		
		assertEquals(0, strategy.getTypeMappingsAndRules().size());
	}
	
	@Test
	public void annotatedOperationsShouldNotBeTreatedAsRulesOrTypeMappings() {
		final AST operationAst = createAnnotatedOperationAst("@cached", "String", "inc()", "{ self := self + 1; }");
		final AST strategyAst  = createMigrationStrategyAst(operationAst);
		
		final MigrationStrategy strategy = runMigrationStrategyLoaderOn(strategyAst);
		
		assertEquals(0, strategy.getTypeMappingsAndRules().size());
	}
	
	
	private static MigrationStrategy runMigrationStrategyLoaderOn(AST strategy) {
		return new MigrationStrategyLoader(strategy).run();
	}
}
