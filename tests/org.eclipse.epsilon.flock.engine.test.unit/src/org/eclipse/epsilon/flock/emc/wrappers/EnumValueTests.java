/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.execute.exceptions.ConservativeCopyException;
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
	public void getEquivalentShouldCreateEquivalentValue() throws ConservativeCopyException, EolRuntimeException {
		final Model               mockMigratedModel = createMock(Model.class);
		final ConservativeCopyContext dummyContext      = createMock(ConservativeCopyContext.class);
		
		// Expectations
		
		expect(mockMigratedModel.getEquivalentEnumerationValue(DogBreed.LABRADOR))
			.andReturn(DogBreed.POODLE);
		
		replay(mockMigratedModel);
		
		
		// Verification
		
		assertEquals(new EnumValue(mockMigratedModel, DogBreed.POODLE),
		             value.getEquivalentIn(mockMigratedModel, dummyContext));
		
		verify(mockMigratedModel);
	}
}
