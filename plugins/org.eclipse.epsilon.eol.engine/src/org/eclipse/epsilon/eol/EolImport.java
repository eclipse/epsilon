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
package org.eclipse.epsilon.eol;

import java.io.File;
import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.commons.module.AbstractModuleElement;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.UriUtil;


public class EolImport extends AbstractModuleElement{
	
	protected IModule module;
	protected boolean loaded = false;
	protected boolean found = false;
	
	public EolImport(AST ast, IModule module){
		setAst(ast);
		this.module = module;
	}
	
	public void load(URI baseUri) {
		//module = new EolLibraryModuleImpl();
		try {
			//String path = ast.getFirstChild().getText();
			File file = new File(getPath());
			
			if (file.isAbsolute()) {
				if (!file.exists()) return;
				
				module.parse(file);
			} else {
				module.parse(UriUtil.resolve(getPath(), baseUri));
			}
			
			found = true;
			if (module.getParseProblems().size() == 0) {
				loaded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//TODO: Show the helpers under the imports
	public List getChildren() {
		if (!loaded) return Collections.EMPTY_LIST;
		else return module.getChildren();
		//return Collections.EMPTY_LIST;
	}
	
	@Override
	public String toString(){
		return "import '" + ast.getFirstChild().getText() + "'";
	}
	
	public boolean isLoaded() {
		return loaded;
	}
	
	public boolean isFound() {
		return found;
	}
	
	public IModule getModule() {
		return module;
	}
	
	public String getPath() {
		return ast.getFirstChild().getText();
	}
	
}
