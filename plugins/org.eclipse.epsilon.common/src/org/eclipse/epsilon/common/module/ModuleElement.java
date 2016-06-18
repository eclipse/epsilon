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
