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
package org.eclipse.epsilon.flock.execution;

import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.Body;
import org.junit.Before;
import org.junit.Test;

public class MigrateRuleBasedEquivalenceTests {

	private final ModelElement  dummyOriginal   = createMock("DummyOriginal",   ModelElement.class);
	private final ModelElement  dummyEquivalent = createMock("DummyEquivalent", ModelElement.class);
	private final IFlockContext dummyContext    = createMock("DummyContext", IFlockContext.class);
	
	private final Body mockBody = createMock("MockExecutableBlock", Body.class);
	
	private final Equivalence equivalence = new MigrateRuleBasedEquivalence(dummyContext, dummyOriginal, dummyEquivalent, mockBody);
	
	@Before
	public void setup() {
		reset(mockBody, dummyOriginal, dummyEquivalent, dummyContext);
	}
	
	
	@Test
	public void shouldDelegateToRule() throws FlockRuntimeException {
		// Expectations
			
		mockBody.applyTo(dummyOriginal, dummyEquivalent, dummyContext);
		
		replay(mockBody, dummyOriginal, dummyEquivalent, dummyContext);
		
		
		// Verification
		
		equivalence.applyStrategyToPopulateEquivalence();
		
		verify(mockBody, dummyOriginal, dummyEquivalent, dummyContext);
	}
}
