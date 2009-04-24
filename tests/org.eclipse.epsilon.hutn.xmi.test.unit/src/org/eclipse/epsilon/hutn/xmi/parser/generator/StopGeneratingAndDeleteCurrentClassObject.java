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
package org.eclipse.epsilon.hutn.xmi.parser.generator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.eclipse.epsilon.hutn.model.hutn.ClassObject;
import org.junit.Before;
import org.junit.Test;

public class StopGeneratingAndDeleteCurrentClassObject {

	private SpecGenerator generator;
	
	@Before
	public void setup() {
		generator = new SpecGenerator();
		generator.initialise();
		generator.generateTopLevelClassObject("p", "parent");
	}
	
	@Test
	public void parentShouldNoLongerContainSlot() {
		final ClassObject parent = generator.getCurrentClassObject();
		
		generator.generateContainedClassObject("f", "foos", "foo");
		generator.stopGeneratingAndDeleteCurrentClassObject();
		
		assertEquals(parent, generator.getCurrentClassObject());
		assertNull(generator.getCurrentClassObject().findSlot("foos"));
	}
	
	@Test
	public void shouldWorkForTopLevelClassObject() {
		generator.stopGeneratingCurrentClassObject();
		
		assertEquals(null, generator.getCurrentClassObject());
	}
}
