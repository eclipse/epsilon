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
package org.eclipse.epsilon.eol.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmptyModelTests {

	private static final IModel empty = new EmptyModel();
	
	@Test
	public void containsNoObjects() {
		assertEquals(0, empty.allContents().size());
	}
	
	@Test
	public void containsNoTopLevelObjects() {
		assertEquals(0, empty.contents().size());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void exceptionForGetTypeNameOf() {
		empty.getTypeNameOf("foo");
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void exceptionForGetPropertiesOf() {
		empty.getPropertiesOf("foo");
	}
}
