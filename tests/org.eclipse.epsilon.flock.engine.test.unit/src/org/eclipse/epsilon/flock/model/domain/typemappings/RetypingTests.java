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
package org.eclipse.epsilon.flock.model.domain.typemappings;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;

import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext.EquivalentFactory;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Test;

public class RetypingTests {

	@Test
	public void createEquivalenceShouldDelegateToFactoryToCreateEquivalent() throws FlockRuntimeException {
		final Retyping retyping = new Retyping(null, new LinkedList<String>(), "Person", "Salesperson");
		
		final EquivalentFactory factory     = mock(EquivalentFactory.class);
		final ModelElement      equivalent = mock(ModelElement.class);

		when(factory.createModelElementInMigratedModel("Salesperson"))
			.thenReturn(equivalent);
		
		
		final Equivalence equivalence = retyping.createEquivalence(dummyExecutor(), dummyExecution(), dummyOriginalModelElement(), factory);
		
		verify(factory).createModelElementInMigratedModel("Salesperson");
		assertEquals(equivalent, equivalence.getEquivalent());
	}

	private EolExecutor dummyExecutor() {
		return mock(EolExecutor.class);
	}

	private FlockExecution dummyExecution() {
		return mock(FlockExecution.class);
	}
	
	private ModelElement dummyOriginalModelElement() {
		return mock(ModelElement.class);
	}
}
