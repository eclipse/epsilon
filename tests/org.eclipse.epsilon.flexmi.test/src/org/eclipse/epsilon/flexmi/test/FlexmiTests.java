/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.flexmi.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;

public abstract class FlexmiTests {
	
	protected FlexmiResource loadResource(String filename) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("flexmi", new FlexmiResourceFactory());
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		FlexmiResource resource = (FlexmiResource) resourceSet.createResource(URI.createURI(FlexmiTestSuite.class.getResource("models/" + filename).toURI().toString()));
		resource.load(null);
		return resource;
	}
	
	protected void assertEval(String expression, Object result, String modelFileName) throws Exception {
		InMemoryEmfModel model = new InMemoryEmfModel(loadResource(modelFileName));
		EolEvaluator evaluator = new EolEvaluator(model);
		assertEquals(result, evaluator.evaluate(expression));
	}
	
	protected void assertWarning(String message, int line, String modelFileName) throws Exception {
		assertTrue(loadResource(modelFileName).getWarnings().stream().
				anyMatch(w -> w.getMessage().contains(message) && w.getLine() == line));
	}
	
}
