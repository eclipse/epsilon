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

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.junit.Test;

public class TypedConstructCheckerTests {

	private final MigrationStrategyCheckingContext context = mock(MigrationStrategyCheckingContext.class);

	@Test
	public void ruleForTypeNotKnownToOriginalMetamodelProducesAWarning() {
		when(context.isTypeInOriginalMetamodel("UnknownType"))
			.thenReturn(false);
		
		new ClassifierTypedConstructChecker("UnknownType", context).check();
		
		verify(context).addWarning("Rule defined for migrating instances of UnknownType, " +
		                           "but no type UnknownType was found in the original metamodel.");
	}
	
	
	@Test
	public void ruleForTypeKnownToOriginalMetamodelDoesNotProduceWarning() {
		when(context.isTypeInOriginalMetamodel("KnownType"))
			.thenReturn(true);
	
		new ClassifierTypedConstructChecker("KnownType", context).check();
	
		verify(context, never()).addWarning(anyString());
	}
}
