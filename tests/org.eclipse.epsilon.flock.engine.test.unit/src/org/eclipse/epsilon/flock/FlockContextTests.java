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
package org.eclipse.epsilon.flock;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.FlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.emc.wrappers.ModelValue;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Test;

public class FlockContextTests {

	@SuppressWarnings("unchecked")
	@Test
	public void getUnwrappedEquivalentShouldWrapModelElementAndDelegateToIt() throws FlockRuntimeException {
		final Model mockOriginalModel  = createMock(Model.class);
		final Model dummyMigratedModel = createMock(Model.class);
		
		final IFlockContext context = new FlockContext(mockOriginalModel, dummyMigratedModel);
		
		final ModelElement mockOriginalModelElement   = createMock(ModelElement.class);
		final ModelElement mockEquivalentModelElement = createMock(ModelElement.class);;
		
		
		// Expectations				
		expect(mockOriginalModel.wrap("dummy model element"))
			.andReturn((ModelValue)mockOriginalModelElement);
		
		expect(mockOriginalModelElement.getEquivalentIn(dummyMigratedModel, context))
			.andReturn((ModelValue)mockEquivalentModelElement);
		
		expect(mockEquivalentModelElement.unwrap())
			.andReturn("dummy equivalent model element");
		
		replay(mockOriginalModel, mockOriginalModelElement, mockEquivalentModelElement);
		
		
		// Verification
		assertEquals("dummy equivalent model element", context.getUnwrappedEquivalent("dummy model element"));
		
		verify(mockOriginalModel, mockOriginalModelElement, mockEquivalentModelElement);
	}
}
