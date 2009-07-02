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

import static org.eclipse.epsilon.hutn.test.model.factories.DogFactory.createDog;
import static org.eclipse.epsilon.hutn.test.model.factories.PersonFactory.createPerson;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.hutn.test.model.families.Dog;
import org.eclipse.epsilon.hutn.test.model.families.Person;
import org.eclipse.epsilon.migration.MigrationContext;
import org.eclipse.epsilon.migration.copy.Copier;
import org.eclipse.epsilon.migration.copy.CopierFactory;
import org.junit.Before;
import org.junit.Test;

public class MigrationStrategyTest {
	
	private final MigrationContext context = new MigrationContext();
	
	private final Person person = createPerson();
	private final Dog    dog    = createDog();
	
	private MockCopier copier;
	private MigrationStrategy strategy;
	private MockMigrationRule rule;
	
	@Before
	public void setup() {
		strategy = new MigrationStrategy(new CopierFactory() {

			@Override
			public Copier createCopier(EObject original, AbstractEmfModel targetModel) {
				copier = new MockCopier(original);
				return copier;
			}
			
		});
		
		rule = new MockMigrationRule("Person");
		strategy.addRule(rule);
	}
	
	@Test
	public void delegatesToApplicableRule() {	
		strategy.migrate(person, context);
		
		assertTrue("rule.migrate was not called", rule.migrateCalled);
		
		assertEquals("person was not copied", person, copier.copied);
	}
	
	@Test
	public void delegatesToOnlyFirstApplicableRule() {
		final MockMigrationRule secondRule = new MockMigrationRule("Person");
		strategy.addRule(secondRule);
		
		strategy.migrate(person, context);
		
		assertTrue("firstRule.migrate was not called",                rule.migrateCalled);
		assertFalse("secondRule.migrate should not have been called", secondRule.migrateCalled);
		
		assertEquals("person was not copied", person, copier.copied);
	}
	
	@Test
	public void delegatesToCopierWhenNoApplicableRule() {
		strategy.migrate(dog, context);
		
		assertFalse("rule.migrate should not have been called", rule.migrateCalled);
		assertEquals("dog was not copied", dog, copier.copied);
	}
	
	@Test
	public void delegatesToCopierWhenApplicableRule() {
		strategy.migrate(person, context);
		
		assertEquals("person was not copied", person, copier.copied);
		assertTrue("rule.migrate was not called", rule.migrateCalled);
	}
	
	private static class MockMigrationRule extends MigrationRule {
		
		public MockMigrationRule(String originalType) {
			super(originalType, originalType, null, null);
		}

		public boolean migrateCalled = false;
		
		@Override
		public void migrate(EObject original, EObject target, MigrationContext context) {
			migrateCalled = true;
		}
	}
	
	public static class MockCopier extends Copier {

		public EObject copied;
		public boolean copyCalled;
		
		public MockCopier(EObject original) {
			super(original, null);
		}
		
		@Override
		public EObject copy(String targetType) {
			copied = original;
			return original;
		}
	}
}
