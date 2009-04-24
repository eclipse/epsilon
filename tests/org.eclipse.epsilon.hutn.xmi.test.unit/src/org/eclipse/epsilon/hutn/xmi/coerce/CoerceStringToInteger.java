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

public class CoerceStringToInteger extends AbstractCoercionTest {

	@Test
	public void integer() {
		coercionTest(2, "2");
	}
	
	@Test
	public void twoDigitInteger() {
		coercionTest(19, "19");
	}
	
	@Test
	public void zero() {
		coercionTest(0, "0");
	}
	
	@Test
	public void negativeInteger() {
		coercionTest(-5, "-5");
	}
	
	@Test
	public void stringContainingInteger() {
		coercionTest("R2D2", "R2D2");
	}
}
