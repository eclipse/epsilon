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

import java.util.Arrays;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.emc.wrappers.ModelValue;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.equivalences.TypeBasedEquivalence;
import org.eclipse.epsilon.flock.equivalences.TypeBasedEquivalence.ConservativeCopy;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.rules.IgnoredProperties;
import org.junit.Test;

public class TypeBasedEquivalenceTests {

	private final EolExecutor             executor     = mock(EolExecutor.class);
	private final ModelElement            original     = mock(ModelElement.class);
	private final ModelElement            equivalent   = mock(ModelElement.class);
	private final ConservativeCopyContext context      = mock(ConservativeCopyContext.class);
	
	private final Equivalence equivalence = new TypeBasedEquivalence(executor, original, equivalent);
	
	@Test
	public void automaticallyPopulateEquivalentShouldPreserveIdentity() throws FlockRuntimeException {		
		equivalence.automaticallyPopulateEquivalent(context, new IgnoredProperties());
		
		verify(equivalent).copyIdentityFrom(original);

	}
	
	@Test
	public void conservativeCopyShouldCopySharedProperties() throws EolRuntimeException {		
		when(original.getPropertiesSharedWith(equivalent))
			.thenReturn(Arrays.asList("name", "age"));
		
		conservativelyCopyAllProperties();
		
		verify(equivalent).conservativelySetValueForProperty(any(ModelValue.class), eq("name"), eq(context));
		verify(equivalent).conservativelySetValueForProperty(any(ModelValue.class), eq("age"), eq(context));
		verify(equivalent, never()).conservativelySetValueForProperty(any(ModelValue.class), eq("sex"), eq(context));
	}
	
	@Test
	public void conservativeCopyShouldNotCopyIgnoredProperties() throws EolRuntimeException {		
		when(original.getPropertiesSharedWith(equivalent))
			.thenReturn(Arrays.asList("name", "age"));
	
		conservativelyCopyAllPropertiesExcept("name");
		
		verify(equivalent, never()).conservativelySetValueForProperty(any(ModelValue.class), eq("name"), eq(context));
		verify(equivalent).conservativelySetValueForProperty(any(ModelValue.class), eq("age"), eq(context));
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void conservativeCopyShouldDelegateToContextToFindEquivalentValue() throws EolRuntimeException {				
		final ModelValue<?> originalValue = mock(ModelValue.class);
		final ModelValue<?> equivalentValue = mock(ModelValue.class);
		
		when(original.getValueOfProperty("name"))
			.thenReturn((ModelValue)originalValue);
		
		when(context.getEquivalentValue(originalValue))
			.thenReturn((ModelValue)equivalentValue);
		
		new ConservativeCopy(context).copyProperty("name", original, equivalent);
		
		verify(context).getEquivalentValue(originalValue);
		verify(equivalent).conservativelySetValueForProperty(equivalentValue, "name", context);
	}

	
	private void conservativelyCopyAllProperties() throws ConservativeCopyException {
		conservativelyCopyAllPropertiesExcept();
	}
	
	private void conservativelyCopyAllPropertiesExcept(String... ignoredProperties) throws ConservativeCopyException {
		new ConservativeCopy(context, new IgnoredProperties(ignoredProperties)).copyProperties(original, equivalent);
	}
}
