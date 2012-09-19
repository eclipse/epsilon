/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.test.models;

import java.io.File;

import org.eclipse.epsilon.common.util.FileUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public enum Model {
	OOInstance("OO", "OOInstance.ecore", "OO.ecore");
	
	private final String modelName;
	private final File modelFile;
	private final File metaModelFile;
	
	private Model(String modelName, String modelFileName, String metaModelFileName) {
		this.modelName = modelName;

		modelFile     = FileUtil.getFile(modelFileName,     Model.class);
		metaModelFile = FileUtil.getFile(metaModelFileName, Model.class);
	}
	
	public EmfModel loadEmfModel() throws EolModelLoadingException {
		return EmfModelFactory.getInstance().loadEmfModel(modelName, modelFile, metaModelFile);
	}
}
