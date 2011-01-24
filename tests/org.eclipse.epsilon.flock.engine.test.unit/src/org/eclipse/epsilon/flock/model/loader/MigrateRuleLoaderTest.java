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

import static org.eclipse.epsilon.flock.model.domain.rules.MigrateRuleBuilder.anUntraceableMigrateRule;
import static org.eclipse.epsilon.flock.model.loader.LoaderTestHelper.*;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRule;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRuleBuilder;
import org.junit.Test;

public class MigrateRuleLoaderTest {

	private static final AST body = createBody();
	private static final AST guard   = createGuard();
	
	@Test
	public void basicMigrateRule() {
		final AST ruleAst = createMigrateRuleAst("Person", body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(personRule().build(), rule);
	}
	
	@Test
	public void migrateRuleWithGuard() {
		final AST ruleAst = createMigrateRuleWithGuardAst("Person", guard, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(personRule().withGuard(guard.getFirstChild()).build(), rule);
	}
	
	@Test
	public void migrateRuleWithAnIgnoredProperty() {
		final AST ignoredProperties = createIgnoredPropertiesAst("name");
		final AST ruleAst           = createMigrateRuleWithIgnoredPropertiesAst("Person", ignoredProperties, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(personRule().withIgnoredProperties("name").build(), rule);
	}
	
	@Test
	public void migrateRuleWithIgnoredProperties() {
		final AST ignoredProperties = createIgnoredPropertiesAst("name", "number", "address");
		final AST ruleAst           = createMigrateRuleWithIgnoredPropertiesAst("Person", ignoredProperties, body);
		
		final MigrateRule rule = runMigrationRuleLoaderOn(ruleAst);
		
		assertEquals(personRule().withIgnoredProperties("name", "number", "address").build(), rule);
	}
	
	
	private static MigrateRuleBuilder personRule() {
		return anUntraceableMigrateRule("Person").withBody(body);
	}
	
	private static MigrateRule runMigrationRuleLoaderOn(AST rule) {
		return new MigrateRuleLoader(rule).run();
	}
}
