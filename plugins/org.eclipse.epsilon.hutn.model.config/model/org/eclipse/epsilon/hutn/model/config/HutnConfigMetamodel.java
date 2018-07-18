/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.hutn.model.config;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.util.FileUtil;

public class HutnConfigMetamodel {

	private HutnConfigMetamodel() {}
	
	public static File getMetaModelFile() {
		return FileUtil.getFile("HUTNConfig.ecore", HutnConfigMetamodel.class);
	}
	
	public static URI getMetaModelUri() {
		return URI.createURI(HutnConfigMetamodel.class.getResource("HUTNConfig.ecore").toString());
	}
	
	public static File getDefaultConfigModelFile() {
		return FileUtil.getFile("DefaultConfig.model", HutnConfigMetamodel.class);
	}
	
	public static URI getDefaultConfigModelUri() {
		return URI.createURI(HutnConfigMetamodel.class.getResource("DefaultConfig.model").toString());
	}
}
