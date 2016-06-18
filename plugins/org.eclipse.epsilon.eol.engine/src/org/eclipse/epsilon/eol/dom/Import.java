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
package org.eclipse.epsilon.eol.dom;

import java.io.File;
import java.net.URI;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.UriUtil;
import org.eclipse.epsilon.eol.IEolLibraryModule;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class Import extends AbstractModuleElement {
	
	private IEolLibraryModule parentModule;
	private IModule importedModule;
	private boolean loaded = false;
	private boolean found = false;
	protected StringLiteral pathLiteral;
	
	public Import() {}
	
	public void setParentModule(IEolLibraryModule parentModule) {
		this.parentModule = parentModule;
	}
	
	public void setImportedModule(IModule importedModule) {
		this.importedModule = importedModule;
	}
	
	public IModule getImportedModule() {
		return importedModule;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		pathLiteral = (StringLiteral) module.createAst(cst.getFirstChild(), this);
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
					ancestor = ancestor.getParentModule()) {
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
	
	@Override
	public String toString(){
		return "import '" + getPath() + "'";
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
	
	public StringLiteral getPathLiteral() {
		return pathLiteral;
	}
	
	public void setPathLiteral(StringLiteral pathLiteral) {
		this.pathLiteral = pathLiteral;
	}
	
	public String getPath() {
		return pathLiteral.getValue();
	}
	
	public void setContext(IEolContext context) {
		if (importedModule instanceof IEolLibraryModule) {
			IEolLibraryModule module = (IEolLibraryModule) importedModule;
			module.setContext(context);
			for (Import import_ : module.getImports()) {
				import_.setContext(context);
			}
		}
	}
	
}
