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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesFactory;
import org.eclipse.epsilon.migration.MigrationContext;
import org.eclipse.epsilon.migration.copy.Copier;
import org.junit.Before;
import org.junit.Test;

public class MigrationStrategyTest {
	
	private final MigrationContext context = new MigrationContext(null, null);
	
	private MockCopier copier;
	private MigrationStrategy strategy;
	private MockMigrationRule rule;
	
	@Before
	public void setup() {
		copier = new MockCopier();
		strategy = new MigrationStrategy(copier);
		rule = new MockMigrationRule("Person");
		
		strategy.addRule(rule);
	}
	
	@Test
	public void delegatesToApplicableRule() {	
		strategy.migrate(FamiliesFactory.eINSTANCE.createPerson(), context);
		
		assertTrue("rule.migrate was not called",              rule.migrateCalled);
		assertFalse("copier.copy should not have been called", copier.copyCalled);
	}
	
	@Test
	public void delegatesToAllApplicableRules() {
		final MockMigrationRule secondRule = new MockMigrationRule("Person");
		strategy.addRule(secondRule);
		
		strategy.migrate(FamiliesFactory.eINSTANCE.createPerson(), context);
		
		assertTrue("firstRule.migrate was not called",  rule.migrateCalled);
		assertTrue("secondRule.migrate was not called", secondRule.migrateCalled);
		
		assertFalse("copier.copy should not have been called", copier.copyCalled);
	}
	
	@Test
	public void delegatesToCopierWhenNoApplicableRuleSpecified() {
		strategy.migrate(FamiliesFactory.eINSTANCE.createDog(), context);
		
		assertFalse("rule.migrate should not have been called", rule.migrateCalled);
		assertTrue("copier.copy was not called", copier.copyCalled);
	}
	
	private static class MockMigrationRule extends MigrationRule {
		
		public MockMigrationRule(String originalType) {
			super(originalType, originalType, null, null);
		}

		public boolean migrateCalled = false;
		
		@Override
		public void migrate(EObject original, MigrationContext context) {
			migrateCalled = true;
		}
	}
	
	public static class MockCopier extends Copier {

		public boolean copyCalled;
		
		@Override
		public void copy(EObject object, AbstractEmfModel target) {
			copyCalled = true;
		}
	}
}
