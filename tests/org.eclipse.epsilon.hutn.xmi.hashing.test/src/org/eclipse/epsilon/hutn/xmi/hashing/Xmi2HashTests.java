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
package org.eclipse.epsilon.hutn.xmi.hashing;

import static org.junit.Assert.assertEquals;

import org.eclipse.epsilon.hutn.test.model.HutnTestWithFamiliesMetaModel;
import org.eclipse.epsilon.hutn.test.model.families.FamiliesPackage;
import org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore.EPackageHasher;
import org.junit.Test;

public class Xmi2HashTests extends HutnTestWithFamiliesMetaModel {
		
	@Test
	public void hashForFamiliesModelIsSameAsForFamiliesEcore() throws HutnXmiBridgeHashingException {
		final int expected = EPackageHasher.getInstance().hashSafely(FamiliesPackage.eINSTANCE);
		final int actual   = new Xmi2Hash(constructXmiForModel("", "")).calculateMetamodelHash();
		
		assertEquals(expected, actual);
	}
	
	private static String constructXmiForModel(String attributes, String contents) {
		final StringBuilder builder = new StringBuilder();
		
		builder.append("<?xml version=\"1.0\" encoding=\"ASCII\"?>");
		builder.append('\n');
		
		builder.append("<families:Model xmi:version=\"2.0\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:families=\"families\" xmi:id=\"_I6yJURhKEd6d_-caKAfnUw\" ");
		builder.append(attributes);
		builder.append(">");
		builder.append('\n');
		
		builder.append(contents);
		builder.append('\n');
		builder.append("</families:Model>");
		
		return builder.toString();
	}
}
