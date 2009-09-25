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
package org.eclipse.epsilon.hutn.unparser.slot;

import org.eclipse.epsilon.hutn.unparser.internal.AbstractSlotUnparserTest;
import org.junit.BeforeClass;

public class StringValueContainingQuotes extends AbstractSlotUnparserTest {
	
	@BeforeClass
	public static void setup() {
		attributeSlotTest("name", new Object[] {"John \"Invisible\" Doe"}, new String[] {"\"John \\\"Invisible\\\" Doe\""});
	}
}
