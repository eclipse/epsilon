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
package org.eclipse.epsilon.flock.model.checker;

import static org.mockito.Mockito.*;

import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Test;

public class IgnoredPropertiesCheckerTests {

	private final MigrationStrategyCheckingContext context = mock(MigrationStrategyCheckingContext.class);
	
	@Test
	public void ignoringAnUnknownPropertyProducesAWarning() throws FlockRuntimeException {
		when(context.isPropertyInOriginalMetamodel("Person", "unknownProperty"))
			.thenReturn(false);
		
		new IgnoredPropertyChecker("Person", context).check("unknownProperty");
		
		verify(context).addWarning("The unknownProperty property should be ignored, " + 
		                           "but there is no unknownProperty property defined for Person in the original metamodel.");
	}
	
	@Test
	public void ignoringAnKnownPropertyDoesNotProduceAWarning() throws FlockRuntimeException {
		when(context.isPropertyInOriginalMetamodel("Person", "knownProperty"))
			.thenReturn(true);
		
		new IgnoredPropertyChecker("Person", context).check("knownProperty");
		
		verify(context, never()).addWarning(anyString());
	}
}
