/*********************************************************************
* Copyright (c) 2019 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.emc.simulink.model;

import java.io.File;

import org.eclipse.epsilon.emc.simulink.engine.MatlabEngine;
import org.eclipse.epsilon.eol.models.IModel;

public interface IGenericSimulinkModel extends IModel {

	void setEngineJarPath(String engineJarPath);

	String getEngineJarPath();

	void setLibraryPath(String libraryPath);

	String getLibraryPath();

	void setMatlabPath(String matlabPath);
	
	String getMatlabPath();
	
	MatlabEngine getEngine();

	void setFile(File file);

	File getFile();

}
