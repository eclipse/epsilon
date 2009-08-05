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
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.eclipse.epsilon.migration.emc.wrappers.Model;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.junit.Before;
import org.junit.Test;

public class MigrationContextTests {

	private final Model                   mockOriginalModel = createMock(Model.class);
	private final MigrationStrategyRunner mockRunner        = createMock(MigrationStrategyRunner.class);
	
	private final IMigrationContext context = new MigrationContext(mockRunner, mockOriginalModel);
	
	@Before
	public void setup() {
		reset(mockRunner, mockOriginalModel);
	}
	
	
	@Test
	public void getUnwrappedEquivalentShouldWrapModelElementAndDelegateToRunner() throws MigrationExecutionException {	
		final ModelElement dummyOriginalModelElement  = createMock(ModelElement.class);
		final ModelElement mockEquivalentModelElement = createMock(ModelElement.class);;
		
		
		// Expectations		
		
		expect(mockOriginalModel.owns("dummy model element"))
			.andReturn(true);
		
		expect(mockOriginalModel.wrapModelElement("dummy model element"))
			.andReturn(dummyOriginalModelElement);
		
		expect(mockRunner.getEquivalent(dummyOriginalModelElement))
			.andReturn(mockEquivalentModelElement);
		
		expect(mockEquivalentModelElement.unwrap())
			.andReturn("dummy equivalent model element");
		
		replay(mockOriginalModel, mockRunner, mockEquivalentModelElement);
		
		
		// Verification
		assertEquals("dummy equivalent model element", context.getUnwrappedEquivalent("dummy model element"));
		
		verify(mockOriginalModel, mockRunner, mockEquivalentModelElement);
	}
	
	@Test
	public void getUnwrappedEquivalentShouldReturnNullWhenArgumentIsNotAModelElement() throws MigrationExecutionException {			
		// Expectations	
		
		expect(mockOriginalModel.owns("dummy model element"))
			.andReturn(false);
		
		replay(mockOriginalModel, mockRunner);
		
		
		// Verification
		assertNull(context.getUnwrappedEquivalent("dummy model element"));
		
		verify(mockOriginalModel, mockRunner);
	}
}
