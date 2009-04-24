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
package org.eclipse.epsilon.hutn.xmi.test.integration.identifiers;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.eclipse.epsilon.hutn.model.hutn.ReferenceSlot;
import org.eclipse.epsilon.hutn.xmi.test.integration.HutnXmiBridgeIntegrationTest;
import org.junit.BeforeClass;
import org.junit.Test;

public class IdentifiersBasedOnTypes extends HutnXmiBridgeIntegrationTest {
	
	@BeforeClass
	public static void setup() throws IOException {
		integrationTestWithModelAsRoot("<contents xsi:type=\"families:Family\" xmi:id=\"_HFEnoCT9Ed6m9JDbGM4gGg\" pets=\"_JYTOgCT9Ed6m9JDbGM4gGg _HigxkCT9Ed6m9JDbGM4gGg _IgdnkCT9Ed6m9JDbGM4gGg\"/>" + 
		                               "<contents xsi:type=\"families:Pet\" xmi:id=\"_HigxkCT9Ed6m9JDbGM4gGg\"/>" + 
		                               "<contents xsi:type=\"families:Pet\" xmi:id=\"_IgdnkCT9Ed6m9JDbGM4gGg\"/>" +
		                               "<contents xsi:type=\"families:Dog\" xmi:id=\"_JYTOgCT9Ed6m9JDbGM4gGg\"/>");	}
	
	@Test
	public void family() {
		assertEquals("Family1", getFamily().getIdentifier());
	}
	
	@Test
	public void firstPet() {
		assertEquals("Pet1", getFirstSlotOfModel().getValues().get(1).getIdentifier());
	}
		
	@Test
	public void secondPet() {
		assertEquals("Pet2", getFirstSlotOfModel().getValues().get(2).getIdentifier());
	}
		
	@Test
	public void dog() {
		assertEquals("Dog1", getFirstSlotOfModel().getValues().get(3).getIdentifier());
	}
	
	@Test
	public void slot() {
		assertEquals("Dog1", ((ReferenceSlot)getFirstSlotOfFamily()).getValues().get(0));
		assertEquals("Pet1", ((ReferenceSlot)getFirstSlotOfFamily()).getValues().get(1));
		assertEquals("Pet2", ((ReferenceSlot)getFirstSlotOfFamily()).getValues().get(2));
	}
}
