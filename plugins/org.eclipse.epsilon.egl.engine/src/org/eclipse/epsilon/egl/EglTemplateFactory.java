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
package org.eclipse.epsilon.egl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.epsilon.commons.util.UriUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.util.FileUtil;

public class EglTemplateFactory {

	protected final IEglContext context;
	
	protected URI root;
	
	private URI    templateRoot;
	private String templateRootPath;
	
	
	public EglTemplateFactory() {
		this.context = new EglContext(this);
	}
	
	public EglTemplateFactory(IEglContext context) {
		this.context = context;
	}
	
	
	public IEglContext getContext() {
		return context;
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
	
		/**
	 * Added Steffen to fix an issue in initial loading of templates from the
	 * module adapter.
	 * 
	 * Loads an EglTemplate for the EGL code stored in the indicated file.
	 * 
	 * Subclasses should override {@link #createTemplate(String, URI)}, rather
	 * than this method, unless they wish to alter the way in which IOExceptions
	 * are handled.
	 * 
	 * @param file
	 * @return
	 * @throws EglRuntimeException
	 */
	public EglTemplate load(File file) throws EglRuntimeException {
		final String name = name(file.getAbsolutePath());
		
		try {
			return createTemplate(name, UriUtil.fileToUri(file));

		} catch (IOException e) {
			final String reason;

			if (e instanceof FileNotFoundException)
				reason = "Template not found";
			else
				reason = "Could not process";

			if (context.getModule() == null)
				throw new EglRuntimeException(reason + " '" + name + "'", e);
			else
				throw new EglRuntimeException(reason + " '" + name + "'", e, context.getModule().getAst());
		} catch (URISyntaxException e) {
			if (context.getModule() == null)
				throw new EglRuntimeException("Could not process '" + name + "'", e);
			else
				throw new EglRuntimeException("Could not process '" + name + "'", e, context.getModule().getAst());
		}
	}

	/**
	 * Loads an EglTemplate for the EGL code stored in the file at path.
	 * 
	 * Subclasses should override {@link #createTemplate(String, URI)}, rather
	 * than this method, unless they wish to alter the way in which IOExceptions
	 * are handled.
	 * 
	 * @param path
	 * @return
	 * @throws EglRuntimeException
	 */
	public EglTemplate load(String path) throws EglRuntimeException {
		try {
			return createTemplate(name(path), resolveTemplate(path));
			
		} catch (IOException e) {
			final String reason;
			
			if (e instanceof FileNotFoundException)
				reason = "Template not found";
			else
				reason = "Could not process";
			
			if (context.getModule() == null)
				throw new EglRuntimeException(reason + " '" + name(path) + "'", e);
			else
				throw new EglRuntimeException(reason + " '" + name(path) + "'", e, context.getModule().getAst());
		}
	}
	
	/**
	 * Loads an EglTemplate for the EGL code stored in the given resource.
	 * 
	 * Subclasses should override {@link #createTemplate(String, URI)}, rather
	 * than this method, unless they wish to alter the way in which IOExceptions
	 * are handled.
	 * 
	 * @param path
	 * @return
	 * @throws EglRuntimeException
	 */
	public EglTemplate load(URI resource) throws EglRuntimeException {
		final String name = resource.toString(); // FIXME better name for URIs
		try {
			return createTemplate(name, resource);
			
		} catch (IOException e) {
			final String reason;
			
			if (e instanceof FileNotFoundException)
				reason = "Template not found";
			else
				reason = "Could not process";
			
			if (context.getModule() == null)
				throw new EglRuntimeException(reason + " '" + name + "'", e);
			else
				throw new EglRuntimeException(reason + " '" + name + "'", e, context.getModule().getAst());
		}
	}
	
	/**
	 * Prepares an EGL template that will execute the given
	 * EGL source code. Subclasses should override 
	 * {@link #createTemplate(String)}, rather than this method,
	 * as this method may, in the future, acquire additional
	 * responsibilities, such as exception handling.
	 * 
	 * @param code
	 * @return
	 */
	public EglTemplate prepare(String code) {
		return createTemplate(code);
	}

	/**
	 * Creates a template for the EGL source code located in
	 * the given resource. Subclasses may override to create different
	 * types of template.
	 * 
	 * @param name Short name of the template, used in outline views.
	 * @param resource The full location of the EGL source code.
	 * @return
	 * @throws IOException
	 */
	protected EglTemplate createTemplate(String name, URI resource) throws IOException {
		return new EglTemplate(name, resource, context);
	}
	
	/**
	 * Creates a template for the given EGL source code.
	 * Subclasses may override to create different types of template.
	 * 
	 * @param code
	 * @return
	 */
	protected EglTemplate createTemplate(String code) {
		return new EglTemplate(code, context);
	}
	
	
	@Override
	public String toString() {
		final String root = templateRoot == null ? "" : templateRoot.toString();
		return "TemplateFactory: root='" + root + "'";
	}
}