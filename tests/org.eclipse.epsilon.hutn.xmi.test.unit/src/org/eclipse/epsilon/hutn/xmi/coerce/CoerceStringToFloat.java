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

public class CoerceStringToFloat extends AbstractCoercionTest {

	@Test
	public void floatingPointNumber() {
		coercionTest(2.6f, "2.6");
	}
	
	@Test
	public void twoDigitFloat() {
		coercionTest(12.3f, "12.3");
	}
	
	@Test
	public void twoDecimalPlaces() {
		coercionTest(54.36f, "54.36");
	}
	
	@Test
	public void wholeNumber() {
		coercionTest(10f, "10.0");
	}
	
	@Test
	public void zero() {
		coercionTest(0f, "0.0");
	}
	
	@Test
	public void fraction() {
		coercionTest(0.32f, ".32");
	}
	
	@Test
	public void negativeFloat() {
		coercionTest(-52.3f, "-52.3");
	}
	
	@Test
	public void negativeFraction() {
		coercionTest(-0.99f, "-.99");
	}
	
	@Test
	public void stringContainingFloat() {
		coercionTest("X3.300", "X3.300");
	}
}
