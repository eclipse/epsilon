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

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.UriUtil;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EolImport extends AbstractModuleElement{
	
	private IEolLibraryModule parentModule;
	private IModule importedModule;
	private boolean loaded = false;
	private boolean found = false;
	
	public EolImport(AST ast, IEolLibraryModule parentModule, IModule importedModule) {
		setAst(ast);
		this.parentModule = parentModule;
		this.importedModule = importedModule;
	}
	
	public void load(URI baseUri) {
		try {
			final File file = new File(getPath());
			URI uri;
			
			if (file.isAbsolute()) {
				if (!file.exists()) return;
				uri = file.toURI();
			} else {
				uri = UriUtil.resolve(getPath(), baseUri);
			}

			// Detect and handle circular imports gracefully
			for (IEolLibraryModule ancestor = parentModule;
					ancestor != null && !found;
					ancestor = ancestor.getParent()) {
				if (ancestor.getSourceUri() != null && ancestor.getSourceUri().equals(uri)) {
					found = true;
					importedModule = ancestor;
				}
			}
			if (!found) {
				try {
					importedModule.parse(uri);
				} catch (Exception e) {
					// Useful for plugin developers: fall back on platform:/resource if platform:/plugin does not work
					if ("platform".equals(uri.getScheme()) && uri.getPath().startsWith("/plugin/")) {
						final String sNewURI = uri.toString().replaceFirst("/plugin/", "/resource/");
						uri = new URI(sNewURI);
						importedModule.parse(uri);
					}
					else {
						throw e;
					}
				}
			}
			
			found = true;
			if (importedModule.getParseProblems().size() == 0) {
				loaded = true;
			}
		} catch (Exception e) {
			// Ignore the exception. The import's loaded flag is still false
			// and it's up to the importing module to do something about it.
		}
	}
	
	//TODO: Show the helpers under the imports
	public List getChildren() {
		if (!loaded) return Collections.EMPTY_LIST;
		else return importedModule.getChildren();
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
		return importedModule;
	}
	
	public String getPath() {
		return ast.getFirstChild().getText();
	}
	
	public void setContext(IEolContext context) {
		if (importedModule instanceof IEolLibraryModule) {
			IEolLibraryModule module = (IEolLibraryModule) importedModule;
			module.setContext(context);
			for (EolImport import_ : module.getImports()) {
				import_.setContext(context);
			}
		}
	}
	
}
