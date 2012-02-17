/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.commons.module;

import java.io.File;
import java.net.URI;

import org.eclipse.epsilon.commons.parse.AST;


public abstract class AbstractModuleElement implements ModuleElement{
	
	protected AST ast;
	protected File sourceFile;
	protected URI sourceUri;
	
	public AST getAst() {
		return ast;
	}
	
	public void setAst(AST ast) {
		this.ast = ast;
	} 
	
	public File getSourceFile() {
		return sourceFile;
	}
	
	public URI getSourceUri() {
		return sourceUri;
	}
	
	/*
	public void setSourceFile(File file) {
		this.sourceFile = file;
	}
	
	public File getSourceFile(){
		return sourceFile;
	}
	*/
}
