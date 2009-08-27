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
package org.eclipse.epsilon.migration.execution;

import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.eclipse.epsilon.migration.model.MigrationRule;
import org.junit.Before;
import org.junit.Test;

public class RuleBasedEquivalenceTests {

	private final ModelElement      dummyOriginal   = createMock("DummyOriginal",   ModelElement.class);
	private final ModelElement      dummyEquivalent = createMock("DummyEquivalent", ModelElement.class);
	private final IMigrationContext dummyContext    = createMock("DummyContext", IMigrationContext.class);
	
	private final MigrationRule mockRule = createMock("MockRule", MigrationRule.class);
	
	private final Equivalence equivalence = new RuleBasedEquivalence(dummyContext, dummyOriginal, dummyEquivalent, mockRule);
	
	@Before
	public void setup() {
		reset(mockRule, dummyOriginal, dummyEquivalent, dummyContext);
	}
	
	
	@Test
	public void shouldDelegateToRule() throws MigrationExecutionException {
		// Expectations
			
		mockRule.applyTo(dummyOriginal, dummyEquivalent, dummyContext);
		
		replay(mockRule, dummyOriginal, dummyEquivalent, dummyContext);
		
		
		// Verification
		
		equivalence.applyStrategyToPopulateEquivalence();
		
		verify(mockRule, dummyOriginal, dummyEquivalent, dummyContext);
	}
}
