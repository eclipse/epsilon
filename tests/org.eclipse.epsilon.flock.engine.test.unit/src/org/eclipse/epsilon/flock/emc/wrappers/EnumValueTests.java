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
package org.eclipse.epsilon.flock.emc.wrappers;

import static org.easymock.EasyMock.expect;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.emc.wrappers.EnumValue;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;
import org.eclipse.epsilon.hutn.test.model.families.DogBreed;
import org.junit.Test;

public class EnumValueTests {

	private static final Model     dummyModel  = createMock(Model.class);
	private static final EnumValue value       = new EnumValue(dummyModel, DogBreed.LABRADOR);
	
	@Test
	public void unwrapShouldReturnUnderlyingModelObject() {
		assertEquals(DogBreed.LABRADOR, value.unwrap());
	}
	
	@Test
	public void getEquivalentShouldCreateEquivalentValue() throws ConservativeCopyException, EolEnumerationValueNotFoundException {
		final Model               mockMigratedModel = createMock(Model.class);
		final ConservativeCopyContext dummyContext      = createMock(ConservativeCopyContext.class);
		
		// Expectations
		
		expect(mockMigratedModel.getEquivalent(DogBreed.LABRADOR))
			.andReturn(DogBreed.POODLE);
		
		replay(mockMigratedModel);
		
		
		// Verification
		
		assertEquals(new EnumValue(mockMigratedModel, DogBreed.POODLE),
		             value.getEquivalentIn(mockMigratedModel, dummyContext));
		
		verify(mockMigratedModel);
	}
}
