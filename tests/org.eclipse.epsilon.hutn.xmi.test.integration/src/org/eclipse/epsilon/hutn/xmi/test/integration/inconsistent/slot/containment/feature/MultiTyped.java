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
package org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.slot.containment.feature;

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;

import java.io.IOException;

import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class MultiTyped extends HutnXmiBridgeIntegrationTest {
	
	@BeforeClass
	public static void setup() throws IOException {
		integrationTestWithModelAsRoot("<elements xsi:type=\"families:Family\" xmi:id=\"_Ev2KMBhbEd6T2uYUGKXrWQ\"/>" +
		                    "<elements xsi:type=\"families:Person\" xmi:id=\"_cMvCsBhsEd6T2uYUGKXrWQ\"/>");
	}
	
	@Test
	public void elementsSlot() {
		slotTest(getFirstSlotOfModel(), ContainmentSlot.class, "elements", "Family", "Person");
	}
}
