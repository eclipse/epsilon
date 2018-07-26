/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
