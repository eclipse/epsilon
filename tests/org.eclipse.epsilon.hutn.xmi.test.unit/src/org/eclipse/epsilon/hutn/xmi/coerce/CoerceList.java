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

import java.util.Arrays;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.junit.Test;

public class CoerceList extends AbstractCoercionTest {

	private static EList<Object> list(Object... elements) {
		return new BasicEList<Object>(Arrays.asList(elements));
	}
	
	@Test
	public void sameValues() {
		coercionTest(list(10, 11, 12), list("10", "11", "12"));
	}
	
	@Test
	public void differentValues() {
		coercionTest(list("10.5", "false", "12"), list("10.5", "false", "12"));
	}
	
	@Test
	public void floatsWithInt() {
		coercionTest(list("10.5", "12", "12.5"), list("10.5", "12", "12.5"));
	}
	
	@Test
	public void emptyList() {
		coercionTest(list(), list());
	}
}
