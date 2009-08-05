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
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;

import org.eclipse.epsilon.migration.execution.Equivalences;
import org.eclipse.epsilon.migration.execution.exceptions.ConservativeCopyException;
import org.junit.Test;

public class AttributeValueTests {

	private static final Model          dummyModel  = createMock(Model.class);
	private static final AttributeValue value       = new AttributeValue(dummyModel, "foo");
	
	@Test
	public void unwrapShouldReturnUnderlyingModelObject() {
		assertEquals("foo", value.unwrap());
	}
	
	@Test
	public void getEquivalentShouldCreateEquivalentValue() throws ConservativeCopyException {
		final Model dummyMigratedModel       = createMock(Model.class);
		final Equivalences dummyEquivalences = createMock(Equivalences.class);
		
		// Expectations
		replay(dummyMigratedModel, dummyEquivalences);
		
		
		// Verification
		
		assertEquals(new AttributeValue(dummyMigratedModel, "foo"),
		             value.getEquivalentIn(dummyMigratedModel, dummyEquivalences));
		
		verify(dummyMigratedModel, dummyEquivalences);
	}
}
