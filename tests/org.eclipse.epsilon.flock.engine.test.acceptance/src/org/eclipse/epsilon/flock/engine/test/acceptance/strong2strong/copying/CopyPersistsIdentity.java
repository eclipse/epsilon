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
package org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.copying;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.flock.engine.test.acceptance.strong2strong.Strong2StrongMigrationAcceptanceTest;
import org.junit.BeforeClass;
import org.junit.Test;


public class CopyPersistsIdentity extends Strong2StrongMigrationAcceptanceTest {

	private static final String strategy = "";

	private static final String originalModel = "Families {"             +
	                                            "	Person \"a\" {"      +
	                                            "		name: \"Alice\"" +
	                                            "	}"                   +
	                                            "   Person \"b\" {"      +
	                                            "		name: \"Bob\""   +
	                                            "	}"                   +
	                                            "   Person \"c\" {"      +
	                                            "		name: \"Carol\"" +
	                                            "	}"                   +
	                                            "}";
	
	private static XMIResource migratedResource;
	
	@BeforeClass
	public static void setup() throws Exception {
		migrateFamiliesToFamilies(strategy, addIdentities(originalModel));
		
		migratedResource = (XMIResource) migrated.getResource();
	}
	
	private static AbstractEmfModel addIdentities(String originalmodel2) {
		final AbstractEmfModel model = hutnToFamily(originalModel);
		final XMIResource resource = (XMIResource) model.getModelImpl();
		
		resource.setID(resource.getContents().get(0), "alice");
		resource.setID(resource.getContents().get(1), "bob");
		
		return model;
	}

	@Test
	public void identityShouldBeCopiedForElementsWithAnIdentity() {
		assertEquals("alice", identityOfMigratedElement(0));
		assertEquals("bob",   identityOfMigratedElement(1));
	}
	
	@Test
	public void identityShouldBeNullForElementsWithoutAnIdentity() {
		assertEquals(null, identityOfMigratedElement(2));
	}

	private static String identityOfMigratedElement(int index) {
		return migratedResource.getID(migratedResource.getContents().get(index));
	}
}
