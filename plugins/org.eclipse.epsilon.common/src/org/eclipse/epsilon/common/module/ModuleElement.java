/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.common.module;

import java.io.File;
import java.net.URI;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.Region;

public interface ModuleElement {
	
	public File getFile();
	
	public URI getUri();

	public void setUri(URI uri);

	public void setModule(IModule module);
	
	public void build(AST cst, IModule module);
	
	public Region getRegion();
	
	public void setRegion(Region region);
	
	public ModuleElement getParent();
	
	public void setParent(ModuleElement moduleElement);
	
	public List<ModuleElement> getChildren();
	
	public IModule getModule();
	
}
