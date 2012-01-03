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

import java.io.File;

import org.eclipse.epsilon.commons.util.FileUtil;
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
}
