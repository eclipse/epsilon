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
package org.eclipse.epsilon.flock.equivalences;

import static org.mockito.Mockito.*;

import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.equivalences.TypeBasedEquivalence;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Test;

public class TypeBasedEquivalenceTests {

	private final ModelElement            original   = mock(ModelElement.class);
	private final ModelElement            equivalent = mock(ModelElement.class);
	private final ConservativeCopyContext context    = mock(ConservativeCopyContext.class);
	
	private final Equivalence equivalence = new TypeBasedEquivalence(original, equivalent);
	
	@Test
	public void automaticallyPopulateEquivalentShouldPreserveIdentity() throws FlockRuntimeException {		
		equivalence.automaticallyPopulateEquivalent(context);
		
		verify(equivalent).copyIdentityFrom(original);

	}
	
	@Test
	public void automaticallyPopulateEquivalentShouldPerformConservativeCopy() throws FlockRuntimeException {
		equivalence.automaticallyPopulateEquivalent(context);

		verify(equivalent).conservativelyCopyPropertiesFrom(original, context);
	}
}
