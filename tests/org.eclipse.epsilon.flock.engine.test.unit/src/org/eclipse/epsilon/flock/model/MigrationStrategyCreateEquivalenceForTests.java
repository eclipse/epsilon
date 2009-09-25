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
package org.eclipse.epsilon.flock.model;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.Equivalence;
import org.eclipse.epsilon.flock.execution.EquivalenceCreator;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Before;
import org.junit.Test;

public class MigrationStrategyCreateEquivalenceForTests {
		
	private final ModelElement  dummyOriginalModelElement = createMock("DummyOriginalModelElement", ModelElement.class);
	private final IFlockContext dummyContext              = createMock("DummyContext", IFlockContext.class);
	private final Equivalence   dummyEquivalence          = createMock("DummyEquivalence", Equivalence.class);
	
	private MigrateRule applicableRule;
	private MigrateRule inapplicableRule;
	private MigrateRule rule;

	@Before
	public void setup() {
		applicableRule   = createApplicableRule();
		inapplicableRule = createInapplicableRule();
		rule             = createRuleThatIsNotTestedForApplicability();
	}
	
	private MigrateRule createRuleThatIsNotTestedForApplicability() {
		final MigrateRule rule = createMock("RuleThatIsNotTestedForApplicability", MigrateRule.class);
		
		replay(rule);
		
		return rule;
	}

	private MigrateRule createInapplicableRule() {
		final MigrateRule inapplicable = createRule("InapplicableRule", false);
		
		replay(inapplicable);
		
		return inapplicable;
	}

	private MigrateRule createApplicableRule() {
		final MigrateRule applicable = createRule("ApplicableRule", true);
		
		try {
			expect(applicable.createEquivalence(dummyOriginalModelElement, dummyContext))
				.andReturn(dummyEquivalence);

		} catch (FlockRuntimeException e) {
			e.printStackTrace();
		}
		
		replay(applicable);
		
		return applicable;
	}

	private MigrateRule createRule(String name, boolean applicable) {
		try {
			final MigrateRule rule = createMock(name, MigrateRule.class);
			
			expect(rule.appliesFor(dummyOriginalModelElement, dummyContext))
				.andReturn(applicable);
			
			return rule;
			
		} catch (FlockRuntimeException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	@Test
	public void shouldDelegateToApplicableRule() throws FlockRuntimeException {
		final MigrationStrategy strategy = new MigrationStrategy(applicableRule);
		
		// Verification
		
		assertEquals(dummyEquivalence, strategy.createEquivalenceFor(dummyOriginalModelElement, dummyContext));
		
		verify(applicableRule);
	}


	@Test
	public void shouldDelegateOnlyToFirstApplicableRule() throws FlockRuntimeException {
		final MigrationStrategy strategy = new MigrationStrategy(applicableRule, rule);
		
		// Verification
		
		assertEquals(dummyEquivalence, strategy.createEquivalenceFor(dummyOriginalModelElement, dummyContext));
		
		verify(applicableRule, rule);
	}
	
	
	@Test
	public void shouldNotDelegateToInapplicableRule() throws FlockRuntimeException {
		final MigrationStrategy strategy = new MigrationStrategy(inapplicableRule, applicableRule);	
		
		// Verification
		
		assertEquals(dummyEquivalence, strategy.createEquivalenceFor(dummyOriginalModelElement, dummyContext));
		
		verify(inapplicableRule, applicableRule);
	}
	
	@Test
	public void shouldDelegateToCopyRuleWhenNoApplicableRules() throws FlockRuntimeException {
		final EquivalenceCreator mockDefaultEquivalenceCreator = createMock("MockDefaultEquivalenceCreator", EquivalenceCreator.class);
		
		expect(mockDefaultEquivalenceCreator.createEquivalence(dummyOriginalModelElement, dummyContext))
			.andReturn(dummyEquivalence);
		
		replay(mockDefaultEquivalenceCreator);
		
		
		final MigrationStrategy strategy = new MigrationStrategy(inapplicableRule);
		
		strategy.setDefaultEquivalenceCreator(mockDefaultEquivalenceCreator);
		
		// Verification
		
		assertEquals(dummyEquivalence, strategy.createEquivalenceFor(dummyOriginalModelElement, dummyContext));
		
		verify(inapplicableRule, mockDefaultEquivalenceCreator);
	}
}
