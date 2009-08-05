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
package org.eclipse.epsilon.migration;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.EquivalenceEstablisher;
import org.eclipse.epsilon.migration.execution.Equivalences;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.junit.Test;

public class MigrationStrategyRunnerTests {

	
	@Test
	public void getUnwrappedEquivalentShouldWrapModelElementAndDelegateToEquivalences() throws MigrationExecutionException {		
		final IMigrationContext mockContext = createMock(IMigrationContext.class);
		
		final MigrationStrategyRunner runner = new MigrationStrategyRunner(mockContext);
		
		final EquivalenceEstablisher mockEstablisher = createMock(EquivalenceEstablisher.class);
		
		final Equivalences mockEquivalences = createMock(Equivalences.class);
		
		
		final ModelElement dummyModelElement = createMock(ModelElement.class);
		final ModelElement dummyEquivalentModelElement = createMock(ModelElement.class);;
		
		
		// Expectations
		
		expect(mockEstablisher.establishEquivalences(mockContext))
			.andReturn(mockEquivalences);
		
		mockEquivalences.populateEachEquivalent(mockContext);
		
		
		expect(mockEquivalences.getEquivalent(dummyModelElement))
			.andReturn(dummyEquivalentModelElement);
		
		replay(mockEstablisher, mockContext, mockEquivalences, dummyEquivalentModelElement);
		
		
		// Verification
		
		runner.run(mockEstablisher);
		
		assertEquals(dummyEquivalentModelElement, runner.getEquivalent(dummyModelElement));
		
		verify(mockEstablisher, mockContext, mockEquivalences, dummyEquivalentModelElement);
	}
}
