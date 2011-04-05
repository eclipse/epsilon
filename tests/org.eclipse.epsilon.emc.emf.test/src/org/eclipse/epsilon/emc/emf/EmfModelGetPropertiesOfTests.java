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
package org.eclipse.epsilon.emc.emf;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.junit.Test;

public class EmfModelGetPropertiesOfTests {

	@Test
	public void getPropertiesOf() throws EolModelElementTypeNotFoundException {
		final EmfModel emfModel = new InMemoryEmfModel(EmfUtil.createResource(EcoreFactory.eINSTANCE.createEPackage()));
		
		assertTrue(emfModel.getPropertiesOf("EPackage").contains("name"));
		assertTrue(emfModel.getPropertiesOf("EPackage").contains("eClassifiers"));
		assertFalse(emfModel.getPropertiesOf("EPackage").contains("age"));
	}
	
	@Test(expected=EolModelElementTypeNotFoundException.class)
	public void getPropertiesOfForUnknownType() throws EolModelElementTypeNotFoundException {
		final EmfModel emfModel = new InMemoryEmfModel(EmfUtil.createResource(EcoreFactory.eINSTANCE.createEPackage()));

		emfModel.getPropertiesOf("foo");
	}
}
