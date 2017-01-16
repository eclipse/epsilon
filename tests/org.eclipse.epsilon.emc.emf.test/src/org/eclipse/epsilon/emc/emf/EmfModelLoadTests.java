/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf;

import static org.junit.Assert.assertEquals;

import java.io.File;

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
		EmfModel model = createFragmentedModel();
		model.setExpand(false);
		model.load();
		assertEquals("Contents for cross-file containment should work with expand=false", 2, model.allContents().size());
		model.dispose();
	}

	@Test
	public void fragmentedModelSizeWithExpand() throws Exception {
		EmfModel model = createFragmentedModel();
		model.setExpand(true);
		model.load();
		assertEquals("Contents for cross-file containment should work with expand=true", 2, model.allContents().size());
		model.dispose();
	}

	protected EmfModel createFragmentedModel() {
		File fXMI = FileUtil.getFile("tree-0.xmi", EmfModelLoadTests.class);
		File fEcore = FileUtil.getFile("Tree.ecore", EmfModelLoadTests.class);
		return EmfModelFactory.getInstance().createEmfModel("Tree", fXMI, fEcore);
	}
}
