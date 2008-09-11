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
package org.eclipse.epsilon.antlr.postprocessor.model;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.commons.util.FileUtil;

public class AntlrAstMetamodel {

	private AntlrAstMetamodel() {}
	
	public static File getMetaModelFile() {
		return FileUtil.getFile("AntlrAst.ecore", AntlrAstMetamodel.class);
	}
	
	public static URI getMetaModelUri() {
		return URI.createFileURI(getMetaModelFile().getAbsolutePath());
	}
}
