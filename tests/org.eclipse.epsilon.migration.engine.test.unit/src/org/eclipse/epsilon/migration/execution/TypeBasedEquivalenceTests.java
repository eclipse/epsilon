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
import org.junit.Before;
import org.junit.Test;

public class TypeBasedEquivalenceTests {

	private final ModelElement      dummyOriginal = createMock("DummyOriginal",  ModelElement.class);
	private final IMigrationContext dummyContext  = createMock("DummyContext", IMigrationContext.class);
	
	private final ModelElement mockEquivalent = createMock("MockEquivalent", ModelElement.class);
	
	private final Equivalence equivalence = new TypeBasedEquivalence(dummyContext, dummyOriginal, mockEquivalent);
	
	@Before
	public void setup() {
		reset(mockEquivalent, dummyOriginal, dummyContext);
	}
	
	
	@Test
	public void shouldDelegateToCopy() throws MigrationExecutionException {
		// Expectations
		
		mockEquivalent.conservativelyCopyPropertiesFrom(dummyOriginal, dummyContext);
		
		replay(mockEquivalent, dummyOriginal, dummyContext);
		
		
		// Verification
		
		equivalence.automaticallyPopulateEquivalence();
		
		verify(mockEquivalent, dummyOriginal, dummyContext);
	}
}
