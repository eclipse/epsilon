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
package org.eclipse.epsilon.migration.emc.wrappers;

import static org.junit.Assert.assertEquals;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.expect;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.hutn.test.model.families.DogBreed;
import org.eclipse.epsilon.migration.execution.Equivalences;
import org.junit.Test;

public class EnumValueTests {

	private static final Model     dummyModel  = createMock(Model.class);
	private static final EnumValue value       = new EnumValue(dummyModel, DogBreed.LABRADOR);
	
	@Test
	public void unwrapShouldReturnUnderlyingModelObject() {
		assertEquals(DogBreed.LABRADOR, value.unwrap());
	}
	
	@Test
	public void getEquivalentShouldCreateEquivalentValue() throws CopyingException, EolEnumerationValueNotFoundException {
		final Model mockMigratedModel        = createMock(Model.class);
		final Equivalences dummyEquivalences = createMock(Equivalences.class);
		
		// Expectations
		
		expect(mockMigratedModel.getEquivalent(DogBreed.LABRADOR))
			.andReturn(DogBreed.POODLE);
		
		replay(mockMigratedModel);
		
		
		// Verification
		
		assertEquals(new EnumValue(mockMigratedModel, DogBreed.POODLE),
		             value.getEquivalentIn(mockMigratedModel, dummyEquivalences));
		
		verify(mockMigratedModel);
	}
}
