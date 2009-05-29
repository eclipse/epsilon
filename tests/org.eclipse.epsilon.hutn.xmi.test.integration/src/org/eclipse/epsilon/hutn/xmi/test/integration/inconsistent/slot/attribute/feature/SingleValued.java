/*******************************************************************************
 * Copyright (c) 2008 The University of York.
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
package org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.slot.attribute.feature;

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;

import java.io.IOException;

import org.eclipse.epsilon.hutn.model.hutn.AttributeSlot;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class SingleValued extends HutnXmiBridgeIntegrationTest {
	
	@BeforeClass
	public static void setup() throws IOException {
		integrationTestWithModelAsRoot("<contents xsi:type=\"families:Family\" xmi:id=\"_KJh0YBhKEd6d_-caKAfnUw\" numberOfCars=\"2\"/>");
	}
	
	@Test
	public void numberOfCarsSlot() {
		slotTest(getFirstSlotOfFamily(), AttributeSlot.class, "numberOfCars", 2);
	}
}
