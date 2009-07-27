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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.hutn.test.model.families.Dog;
import org.eclipse.epsilon.hutn.test.model.families.Person;
import org.eclipse.epsilon.migration.execution.ExecutionContext;
import org.junit.Before;
import org.junit.Test;

public class MigrationStrategyTest {
	
	private final ExecutionContext context = new FakeExecutionContext();
	
	private final ExecutableMigrationRule personRule              = new ExecutableMigrationRule("Person", null, null, null);
	private final ExecutableMigrationRule personToSalespersonRule = new ExecutableMigrationRule("Person", "Salesperson", null, null);
	
	private final Person person = createPerson();
	private final Dog    dog    = createDog();
	
	private MigrationStrategy strategy;
	
	@Before
	public void setup() {
		strategy = new MigrationStrategy();
	}
	
	@Test
	public void returnsDefaultMigrationRuleWhenNoRules() {
		checkRuleFor(person, new NoOpMigrationRule());
	}
	
	@Test
	public void returnsApplicableRule() {
		configureStrategy(personRule);
		checkRuleFor(person, personRule);
	}
	
	@Test
	public void returnsFirstApplicableRule() {
		configureStrategy(personRule, personToSalespersonRule);
		checkRuleFor(person, personRule);
	}
	
	@Test
	public void returnsDefaultMigrationRuleWhenNoApplicableRules() {
		configureStrategy(personRule);
		checkRuleFor(dog, new NoOpMigrationRule());
	}

	private void configureStrategy(ExecutableMigrationRule... rules) {
		strategy.addRules(rules);
	}
	
	private void checkRuleFor(EObject original, MigrationRule expectedRule) {
		final MigrationRule actualRule = strategy.getFirstApplicableRuleFor(original, context);
		assertEquals(expectedRule, actualRule);
	}
}
