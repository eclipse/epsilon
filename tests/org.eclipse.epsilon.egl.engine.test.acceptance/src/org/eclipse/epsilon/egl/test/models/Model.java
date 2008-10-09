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

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.emc.emf.EmfModel;

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
	
	public EmfModel getEmfModel() {
		final EmfModel model = new EmfModel();
		model.setModelFile(modelFile.getAbsolutePath());
		model.setMetamodelFile(metaModelFile.getAbsolutePath());
		model.setMetamodelFileBased(true);
		model.setName(modelName);
		return model;
	}
}
