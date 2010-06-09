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
package org.eclipse.epsilon.concordance.reporter.model;

import static org.junit.Assert.assertEquals;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.epsilon.common.dt.test.util.TestThatUsesAProject;
import org.eclipse.epsilon.concordance.dt.ResourceCategoriser;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ResourceCategoriserTests extends TestThatUsesAProject {

	@BeforeClass
	public static void setupOnce() throws CoreException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new EcoreResourceFactoryImpl());
	}
	
	@AfterClass
	public static void teardownOnce() throws CoreException {
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().remove("ecore");
	}

	private final ResourceCategoriser categoriser = new ResourceCategoriser();
	
	@Test
	public void resourceWithRegisteredMetamodelExtensionShouldBeAModel() throws CoreException {
		assertEquals(true, categoriser.isModel(createEmptyFile(project, "test.ecore")));
	}
	
	@Test
	public void resourceWithXmiExtensionShouldBeAModel() throws CoreException {
		assertEquals(true, categoriser.isModel(createEmptyFile(project, "test.xmi")));
	}
	
	@Test
	public void resourceWithModelExtensionShouldBeAModel() throws CoreException {
		assertEquals(true, categoriser.isModel(createEmptyFile(project, "test.model")));

	}
	
	@Test
	public void otherResourceShouldNotBeAModel() throws CoreException {
		assertEquals(false, categoriser.isModel(createEmptyFile(project, "test.java")));

	}
}
