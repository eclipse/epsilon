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
package org.eclipse.epsilon.hutn.unparser.packageObject;

import static org.eclipse.epsilon.hutn.test.util.HutnUtil.createPackageObject;
import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.unparser.internal.AbstractPackageObjectUnparserTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmptyPackageObject extends AbstractPackageObjectUnparserTest {

	@BeforeClass
	public static void setup() {
		packageObjectUnparserTest(createPackageObject("families"));
	}
	
	@Test
	public void hasNoClassObjects() {
		assertEquals(0, numberOfClassObjects());
	}
}
