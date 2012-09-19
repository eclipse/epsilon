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
package org.eclipse.epsilon.hutn.model.hutnAntlrAst;

import java.io.File;

import org.eclipse.emf.common.util.URI;
import org.eclipse.epsilon.common.util.FileUtil;

public class HutnAntlrAstMetamodel {

	private HutnAntlrAstMetamodel() {}
	
	public static File getMetaModelFile() {
		return FileUtil.getFile("AntlrAst.ecore", HutnAntlrAstMetamodel.class);
	}
	
	public static URI getMetaModelUri() {
		return URI.createURI(HutnAntlrAstMetamodel.class.getResource("AntlrAst.ecore").toString());
	}
}
