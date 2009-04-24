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
package org.eclipse.epsilon.hutn.xmi.test.integration.inconsistent.object;

import static org.eclipse.epsilon.hutn.xmi.test.util.HutnTestUtil.slotTest;
import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;

import org.eclipse.epsilon.hutn.model.hutn.ContainmentSlot;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnknownStartTag extends HutnXmiBridgeIntegrationTest {
	
	@BeforeClass
	public static void setup() throws URISyntaxException {
		integrationTest("<?xml version=\"1.0\" encoding=\"ASCII\"?>" +
		                "<families:World xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:families=\"families\" xmi:id=\"_I6yJURhKEd6d_-caKAfnUw\">" +
		                "	<contents xsi:type=\"families:Family\" xmi:id=\"_cpcsYBeGEd6OrYL62CiH8g\" />" +
		                "</families:World>");
	}
	
	@Test
	public void modelIsOfTypeWorld() {
		assertEquals("World", getModel().getType());
	}
	
	@Test
	public void contentsSlot() {
		slotTest(getFirstSlotOfModel(), ContainmentSlot.class, "contents", "Family");
	}
}
