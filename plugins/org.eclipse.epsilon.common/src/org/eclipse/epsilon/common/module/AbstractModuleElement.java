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
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.Token;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.Region;


public abstract class AbstractModuleElement implements ModuleElement {
	
	protected List<Comment> comments = new ArrayList<Comment>();
	protected ModuleElement parent;
	protected List<ModuleElement> children = new ArrayList<ModuleElement>();
	protected URI uri;
	protected IModule module;
	protected Region region = new Region();
	
	public AbstractModuleElement() {}
	
	public AbstractModuleElement(ModuleElement parent) {
		parent.getChildren().add(this);
		this.parent = parent;
	}
	
	@Override
	public void build(AST cst, IModule module) {
		for (Token commentToken : cst.getCommentTokens()) {
			Comment comment = new Comment(commentToken);
			comment.setUri(cst.getUri());
			comments.add(comment);
		}
	}
	
	public List<Comment> getComments() {
		return comments;
	}
	
	public String getDebugInfo() { return ""; }
	
	@Override
	public List<ModuleElement> getChildren() {
		return children;
	}

	@Override
	public void setUri(URI uri) {
		this.uri = uri;
	}

	@Override
	public void setModule(IModule module) {
		this.module = module;
	}

	@Override
	public Region getRegion() {
		return region;
	}

	@Override
	public IModule getModule() {
		return module;
	}

	@Override
	public File getFile() {
		if (uri != null && "file".equals(uri.getScheme())) {
			return new File(uri);
		}
		return null;
	}

	@Override
	public URI getUri() {
		return uri;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	@Override
	public void setParent(ModuleElement parent) {
		this.parent = parent;
	}
	
	@Override
	public ModuleElement getParent() {
		return parent;
	}
}
