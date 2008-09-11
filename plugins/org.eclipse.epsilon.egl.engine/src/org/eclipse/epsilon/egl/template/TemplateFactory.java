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
package org.eclipse.epsilon.egl.template;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.commons.util.UriUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.types.EglTemplate;
import org.eclipse.epsilon.egl.util.FileUtil;

public class TemplateFactory {

	protected final IEglContext context;
	
	protected URI root;
	
	private URI    templateRoot;
	private String templateRootPath;
	
	
	public TemplateFactory(IEglContext context) {
		this.context = context;
	}
	
	public void setRoot(URI root) {
		this.root = root;
	}
	
	public String getTemplateRoot() {
		return templateRootPath;
	}
	
	public void setTemplateRoot(String path) throws EglRuntimeException {
		templateRootPath = path;
		templateRoot     = resolveRoot(path);
	}
	
	protected URI resolveRoot(String path) throws EglRuntimeException {
		try {
			path = UriUtil.encode(path, true);
			return UriUtil.resolve(path, root);
			
		} catch (URISyntaxException e) {
			throw new EglRuntimeException("Could not resolve path: "+path, e, context.getModule().getAst());
		}
	}
	
	protected URI resolveTemplate(String path) throws EglRuntimeException {
		try {
			path = UriUtil.encode(path, false);
			return UriUtil.resolve(path, templateRoot, root);
			
		} catch (URISyntaxException e) {
			throw new EglRuntimeException("Could not resolve path: "+path, e, context.getModule().getAst());
		}
	}
	
	protected String name(String path) {
		String name = path;
		 
		 if (templateRootPath != null)
			 name = new File(templateRootPath).getPath() + FileUtil.FILE_SEP + name;
		 
		 return name;
	}
	
	public void imitate(TemplateFactory other) {
		root             = other.root;
		templateRoot     = other.templateRoot;
		templateRootPath = other.templateRootPath;
	}


	public EglTemplate load(String path) throws EglRuntimeException {
		return new EglTemplate(name(path), resolveTemplate(path), context);
	}
	
	@Override
	public String toString() {
		final String root = templateRoot == null ? "" : templateRoot.toString();
		return "TemplateFactory: root='" + root + "'";
	}
}
