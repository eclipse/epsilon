/*******************************************************************************
 * Copyright (c) 2011-2018 The University of York, Aston University.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 *     Antonio Garcia-Dominguez - add tests for fragmented models
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.junit.Test;

public class EmfModelLoadTests {

	/**
	 * @see https://bugs.eclipse.org/bugs/show_bug.cgi?id=366578
	 */
	@Test(expected=EolModelLoadingException.class)
	public void unregisteredMetamodelResultsInEpsilonException() throws Exception {
		final File modelOnDisk = FileUtil.getFile("Simple.uml", EmfModelLoadTests.class);
		
		EmfModelFactory.getInstance().loadEmfModel("UML", modelOnDisk, "http://www.eclipse.org/uml2/3.0.0/UML");	
	}

	@Test
	public void fragmentedModelSizeWithoutExpand() throws Exception {
		// Isolate this test from others in terms of caching
		CachedResourceSet.getCache().clear();

		EmfModel model = createFragmentedModel();
		model.setExpand(false);
		model.load();
		assertEquals("Contents for cross-file containment should work with expand=false", 2, model.allContents().size());
		model.dispose();
		assertEquals(0, CachedResourceSet.getCache().getItems().size());
	}

	@Test
	public void fragmentedModelSizeWithExpand() throws Exception {
		// Isolate this test from others in terms of caching
		CachedResourceSet.getCache().clear();

		EmfModel model = createFragmentedModel();
		model.setExpand(true);
		model.load();
		assertEquals("Contents for cross-file containment should work with expand=true", 2, model.allContents().size());
		model.dispose();
		assertEquals(0, CachedResourceSet.getCache().getItems().size());
	}

	@Test
	public void expandFalseWithCachingResolvesProxies() throws Exception {
		EmfModel model = createHControlModel();
		model.setExpand(false);
		model.setCachingEnabled(true);
		model.load();

		// Adding the eAdapter makes EMF go through direct and indirect contents
		assertEquals(20, countWithoutResolving(model));

		model.dispose();
	}

	@Test
	public void expandFalseWithNoCachingLeavesProxiesUnresolved() throws Exception {
		EmfModel model = createHControlModel();
		model.setExpand(false);
		model.setCachingEnabled(false);
		model.load();

		// HControl1.xmi only has 1 real object and 7 proxies inside it
		assertEquals(8, countWithoutResolving(model));

		model.dispose();
	}

	protected int countWithoutResolving(EmfModel model) {
		int itSize = 0;
		for (TreeIterator<Object> it = EcoreUtil.getAllContents(model.getResource(), false); it.hasNext(); ) {
			Object eob = it.next();
			System.out.println(eob);
			itSize++;
		}
		return itSize;
	}

	protected EmfModel createHControlModel() {
		File fEcore = FileUtil.getFile("xml/fragmented/WT_DesignPatterns.ecore", getClass());
		File fXMI = FileUtil.getFile("xml/fragmented/HControl1/HControl1.xmi", getClass());
		EmfModel model = EmfModelFactory.getInstance().createEmfModel("Model", fXMI, fEcore);
		return model;
	}

	protected EmfModel createFragmentedModel() {
		File fXMI = FileUtil.getFile("tree-0.xmi", EmfModelLoadTests.class);
		File fEcore = FileUtil.getFile("Tree.ecore", EmfModelLoadTests.class);
		return EmfModelFactory.getInstance().createEmfModel("Tree", fXMI, fEcore);
	}
	
	protected EmfModel createTrainModel() {
		File fXMI = FileUtil.getFile("railway-batch-1.xmi", EmfModelLoadTests.class);
		File fXcore = FileUtil.getFile("railway.xcore", EmfModelLoadTests.class);
		return EmfModelFactory.getInstance().createEmfModel("train", fXMI, fXcore);
	}
	
}
