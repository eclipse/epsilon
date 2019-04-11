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

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolEvaluator;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;

public abstract class FlexmiTests {
	
	protected FlexmiResource loadResource(String filename, String... metamodels) throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("flexmi", new FlexmiResourceFactory());
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(), EcorePackage.eINSTANCE);
		
		for (String metamodel : metamodels) {
			List<EPackage> ePackages = EmfUtil.register(URI.createURI(FlexmiTestSuite.class.getResource("models/" + metamodel)
					.toURI().toString()), resourceSet.getPackageRegistry());
		}
		
		for (Object ePackage : resourceSet.getPackageRegistry().values()) {
			System.out.println(ePackage);
		}
		
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
	
	protected void assertNoWarnings(String model, String... metamodels) throws Exception {
		FlexmiResource resource = loadResource(model, metamodels);
		for (Diagnostic d : resource.getWarnings()) System.out.println(d.getMessage());
		assertEquals(0, resource.getWarnings().size());
	}
}
