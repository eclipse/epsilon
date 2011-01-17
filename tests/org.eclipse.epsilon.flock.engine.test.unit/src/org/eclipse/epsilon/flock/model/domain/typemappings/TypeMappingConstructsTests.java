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
package org.eclipse.epsilon.flock.model.domain.typemappings;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.epsilon.flock.equivalences.factory.EquivalenceFactory;
import org.eclipse.epsilon.flock.execution.TypeMappingContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.junit.Before;
import org.junit.Test;

public class TypeMappingConstructsTests {

	private final TypeMappingContext context = mock(TypeMappingContext.class);
	
	private final TypeMappingConstruct applicable        = mock(TypeMappingConstruct.class);
	private final TypeMappingConstruct anotherApplicable = mock(TypeMappingConstruct.class);
	private final TypeMappingConstruct inapplicable      = mock(TypeMappingConstruct.class);
	
	@Before
	public void setup() throws FlockRuntimeException {
		when(context.isEligibleFor(applicable)).thenReturn(true);
		when(context.isEligibleFor(anotherApplicable)).thenReturn(true);
		
		when(context.isEligibleFor(inapplicable)).thenReturn(false);
	}
	
	@Test
	public void shouldUseApplicableTypeMappingConstruct() throws FlockRuntimeException {
		final TypeMappingConstructs typeMappingConstructs = new TypeMappingConstructs(applicable);
		
		typeMappingConstructs.createEquivalence(context);
		
		verify(context).createEquivalenceUsing(applicable);
	}
	
	@Test
	public void shouldUseFirstApplicableTypeMappingConstruct() throws FlockRuntimeException {
		final TypeMappingConstructs typeMappingConstructs = new TypeMappingConstructs(inapplicable, applicable);
				
		typeMappingConstructs.createEquivalence(context);
		
		verify(context, never()).createEquivalenceUsing(inapplicable);
		verify(context).createEquivalenceUsing(applicable);
	}
	
	@Test
	public void shouldUseOnlyTheFirstApplicableTypeMappingConstruct() throws FlockRuntimeException {
		final TypeMappingConstructs typeMappingConstructs = new TypeMappingConstructs(applicable, anotherApplicable);
		
		typeMappingConstructs.createEquivalence(context);
		
		verify(context).createEquivalenceUsing(applicable);
		verify(context, never()).createEquivalenceUsing(anotherApplicable);
	}
	
	@Test
	public void shouldUseDefaultFactoryWhenNoTypeMappingsAreApplicable() throws FlockRuntimeException {
		final EquivalenceFactory equivalenceFactory = mock(EquivalenceFactory.class);	
		final TypeMappingConstructs typeMappingConstructs = new TypeMappingConstructs(equivalenceFactory);		
		
		typeMappingConstructs.createEquivalence(context);
		
		verify(context).createEquivalenceUsing(equivalenceFactory);
	}
}
