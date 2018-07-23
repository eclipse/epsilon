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
import static org.easymock.classextension.EasyMock.reset;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.junit.Before;
import org.junit.Test;

public class ModelTypeTests {

	private static final Model     mockModel = createMock(Model.class);
	private static final ModelType type      = new ModelType(mockModel, "dummy", "dummy");	
	@Before
	public void resetDummyModel() {
		reset(mockModel);
	}
	
	@Test
	public void propertiesSharedWithShouldKeepOnlyThosePropertiesKnownByBothTypes() throws EolModelElementTypeNotFoundException {
		final ModelType mockOtherType = createMock(ModelType.class);
		
		// Expectations

		expect(mockModel.getPropertiesOf("dummy"))
			.andReturn(Arrays.asList("name", "age"));
		
		expect(mockOtherType.getProperties())
			.andReturn(Arrays.asList("name", "address"));
		
		replay(mockModel, mockOtherType);
		
		
		// Verification
		
		assertEquals(Arrays.asList("name"),
		             type.getPropertiesSharedWith(mockOtherType));
		
		verify(mockModel, mockOtherType);
	}
}
