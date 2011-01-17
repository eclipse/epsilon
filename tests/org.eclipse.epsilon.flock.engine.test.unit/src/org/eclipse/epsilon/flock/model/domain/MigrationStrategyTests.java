/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.domain;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Collection;

import org.eclipse.epsilon.flock.model.domain.common.TypedAndGuardedConstruct;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRule;
import org.eclipse.epsilon.flock.model.domain.typemappings.Deletion;
import org.eclipse.epsilon.flock.model.domain.typemappings.Retyping;
import org.junit.Test;

public class MigrationStrategyTests {

	private final MigrateRule rule = mock(MigrateRule.class);
	private final Retyping retyping = mock(Retyping.class);
	private final Deletion deletion = mock(Deletion.class);
	
	
	@Test
	public void constructorAddsConstructs() {
		final MigrationStrategy strategy = new MigrationStrategy(retyping, rule, deletion);
		
		assertThat(strategy.getTypeMappingsAndRules(), containsInAnyOrder(retyping, rule, deletion));
	}
	
	@Test
	public void addRule() {
		final MigrationStrategy strategy = new MigrationStrategy();
		
		strategy.addRule(rule);
		
		
		final Collection<TypedAndGuardedConstruct> contents = strategy.getTypeMappingsAndRules();
		
		assertThat(contents, containsInAnyOrder((TypedAndGuardedConstruct)rule));
	}
	
	@Test
	public void addTypeMappingConstruct() {
		final MigrationStrategy strategy = new MigrationStrategy();
		
		strategy.addTypeMappingConstruct(retyping);
		strategy.addTypeMappingConstruct(deletion);
		
		
		final Collection<TypedAndGuardedConstruct> contents = strategy.getTypeMappingsAndRules();
		
		assertThat(contents, containsInAnyOrder((TypedAndGuardedConstruct)retyping,
		                                        (TypedAndGuardedConstruct)deletion));
	}
}
