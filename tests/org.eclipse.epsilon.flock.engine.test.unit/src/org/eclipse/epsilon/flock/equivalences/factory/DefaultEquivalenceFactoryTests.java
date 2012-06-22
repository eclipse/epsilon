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
package org.eclipse.epsilon.flock.equivalences.factory;

import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext.EquivalentFactory;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.equivalences.NoEquivalence;
import org.eclipse.epsilon.flock.equivalences.TypeBasedEquivalence;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Test;


public class DefaultEquivalenceFactoryTests {

	@Test
	public void shouldCreateATypeBasedEquivalenceWhenTypeConformsToEvolvedMetamodel() throws FlockRuntimeException {
		final EquivalentFactory equivalentFactory = mock(EquivalentFactory.class);
		
		when(equivalentFactory.typeConformsToEvolvedMetamodel(anyString())).thenReturn(true);
		
		assertThat(createEquivalence(equivalentFactory), is(instanceOf(TypeBasedEquivalence.class)));		
	}
	
	@Test
	public void shouldCreateANoEquivalenceWhenTypeDoesNotConformToEvolvedMetamodel() throws FlockRuntimeException {
		final EquivalentFactory equivalentFactory = mock(EquivalentFactory.class);
		
		when(equivalentFactory.typeConformsToEvolvedMetamodel(anyString())).thenReturn(false);
		
		assertThat(createEquivalence(equivalentFactory), is(instanceOf(NoEquivalence.class)));		
	}

	private Equivalence createEquivalence(final EquivalentFactory equivalentFactory) throws FlockRuntimeException {
		return DefaultEquivalenceFactory.getInstance().createEquivalence(mock(EolExecutor.class), mock(FlockExecution.class), mock(ModelElement.class), equivalentFactory);
	}
}
