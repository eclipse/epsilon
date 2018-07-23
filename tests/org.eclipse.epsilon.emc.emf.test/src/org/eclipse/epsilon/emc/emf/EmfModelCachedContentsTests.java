/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.emf;

import static org.junit.Assert.assertEquals;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.Test;

public class EmfModelCachedContentsTests {

	protected EmfModel createEmptyModel() throws EolModelLoadingException {
		final EmfModel model = new EmfModel();
		model.setModelFile("dummy.xmi");
		model.setMetamodelUri(EcorePackage.eINSTANCE.getNsURI());
		model.setReadOnLoad(false);
		model.setStoredOnDisposal(false);
		model.load();
		return model;
	}

	@Test
	public void emptyModel() throws Exception {
		final EmfModel model = createEmptyModel();
		assertEquals(0, model.allContents().size());
	}

	@Test
	public void manageThroughModel() throws Exception {
		final EmfModel model = createEmptyModel();
		assertEquals(0, model.allContents().size());
		final EObject eClass = model.createInstance("EClass");
		assertEquals(1, model.allContents().size());
		model.deleteElement(eClass);
		assertEquals(0, model.allContents().size());
	}

	@Test
	public void manageExternally() throws Exception {
		final EmfModel model = createEmptyModel();
		assertEquals(0, model.allContents().size());

		final EClass eClass = EcorePackage.eINSTANCE.getEcoreFactory().createEClass();
		model.getResource().getContents().add(eClass);
		assertEquals(1, model.allContents().size());

		model.getResource().getContents().remove(eClass);
		assertEquals(0, model.allContents().size());
	}
	
}
