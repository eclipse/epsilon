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

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.eclipse.epsilon.hutn.model.hutn.HutnFactory;
import org.eclipse.epsilon.hutn.unparser.internal.AbstractSlotUnparserTest;
import org.junit.BeforeClass;

public class ReferencedClassObject extends AbstractSlotUnparserTest {
	
	@BeforeClass
	public static void setup() {
		final ClassObject co = HutnFactory.eINSTANCE.createClassObject();
		co.setType("Person");
		co.setIdentifier("John");
		
		referenceSlotTest("familyFriends",
		                  new ClassObject[] {co},
		                  new String[] {"Person \"John\""});
	}
}
