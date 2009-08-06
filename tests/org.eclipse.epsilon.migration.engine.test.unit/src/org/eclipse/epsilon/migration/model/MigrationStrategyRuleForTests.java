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

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.junit.Before;
import org.junit.Test;

public class MigrationStrategyRuleForTests {
		
	private final ModelElement      dummyOriginalModelElement = createMock("DummyOriginalModelElement", ModelElement.class);
	private final IMigrationContext dummyContext              = createMock("DummyContext", IMigrationContext.class);
	
	private MigrationRule applicableRule;
	private MigrationRule inapplicableRule;
	private MigrationRule rule;

	@Before
	public void setup() {
		applicableRule   = createApplicableRule();
		inapplicableRule = createInapplicableRule();
		rule             = createRuleThatIsNotTestedForApplicability();
	}
	
	private MigrationRule createRuleThatIsNotTestedForApplicability() {
		final MigrationRule rule = createMock("RuleThatIsNotTestedForApplicability", MigrationRule.class);
		
		replay(rule);
		
		return rule;
	}

	private MigrationRule createInapplicableRule() {
		return createRule("InapplicableRule", false);
	}

	private MigrationRule createApplicableRule() {
		return createRule("ApplicableRule", true);
	}

	private MigrationRule createRule(String name, boolean applicable) {
		try {
			final MigrationRule rule = createMock(name, MigrationRule.class);
			
			expect(rule.appliesFor(dummyOriginalModelElement, dummyContext))
				.andReturn(applicable);
			
			replay(rule);
			
			return rule;
			
		} catch (MigrationExecutionException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	@Test
	public void ruleForShouldReturnApplicableRule() throws MigrationExecutionException {
		final MigrationStrategy strategy = new MigrationStrategy(applicableRule);
		
		// Verification
		
		assertEquals(applicableRule, strategy.ruleFor(dummyOriginalModelElement, dummyContext));
		
		verify(applicableRule);
	}


	@Test
	public void ruleForShouldReturnFirstApplicableRule() throws MigrationExecutionException {
		final MigrationStrategy strategy = new MigrationStrategy(applicableRule, rule);
		
		// Verification
		
		assertEquals(applicableRule, strategy.ruleFor(dummyOriginalModelElement, dummyContext));
		
		verify(applicableRule, rule);
	}
	
	
	@Test
	public void ruleForShouldNotReturnInapplicableRule() throws MigrationExecutionException {
		final MigrationStrategy strategy = new MigrationStrategy(inapplicableRule, applicableRule);	
		
		// Verification
		
		assertEquals(applicableRule, strategy.ruleFor(dummyOriginalModelElement, dummyContext));
		
		verify(inapplicableRule, applicableRule);
	}
	
	@Test
	public void ruleForShouldReturnNullWhenNoApplicableRules() throws MigrationExecutionException {
		final MigrationStrategy strategy = new MigrationStrategy(inapplicableRule);
		
		// Verification
		
		assertNull(strategy.ruleFor(dummyOriginalModelElement, dummyContext));
		
		verify(inapplicableRule);
	}
}
