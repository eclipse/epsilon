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
package org.eclipse.epsilon.hutn.xmi.coerce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.hutn.xmi.coerce.ValueCoercer;
import org.eclipse.epsilon.hutn.xmi.util.EmfUtil;

public abstract class AbstractCoercionTest {

	protected static void coercionTest(Object expected, Object value) {
		coercionTest(expected, value, EmfUtil.createResource());
	}
	
	protected static void coercionTest(Object expected, Object value, Resource resource) {
		final Object coercedValue = new ValueCoercer(resource).coerce(value);
		
		assertEquals(expected, coercedValue);
		assertTrue("Expected an instance of: " +
		           expected.getClass().getCanonicalName() + " " +
		           "but was: " + 
		           coercedValue.getClass().getCanonicalName(),
		           expected.getClass().isInstance(coercedValue));
	}
}
