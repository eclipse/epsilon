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

import org.junit.Test;

public class CoerceStringToBoolean extends AbstractCoercionTest {

	@Test
	public void truue() {
		coercionTest(true, "true");
	}
	
	@Test
	public void faalse() {
		coercionTest(false, "false");
	}
	
	@Test
	public void stringContainingBooleanValue() {
		coercionTest("truely", "truely");
	}
	
	@Test
	public void stringContainingBooleanValuedWord() {
		coercionTest("that's true you know", "that's true you know");
	}
}
