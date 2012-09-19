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
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;

import org.eclipse.epsilon.common.util.UriUtil;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.formatter.CompositeFormatter;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.formatter.NullFormatter;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecificationFactory;
import org.eclipse.epsilon.egl.util.FileUtil;

public class EglTemplateFactory {

	protected final IEglContext context;
	
	protected URI root;
	
	private URI    templateRoot;
	private String templateRootPath;
	
	private Formatter defaultFormatter = new NullFormatter();
	
	
	public EglTemplateFactory() {
		this.context = new EglContext(this);
	}
	
	public EglTemplateFactory(IEglContext context) {
		this.context = context;
	}
	
	public void setDefaultFormatter(Formatter defaultFormatter) {
		this.defaultFormatter = defaultFormatter;
	}
	
	public void setDefaultFormatters(Formatter... defaultFormatters) {
		setDefaultFormatters(Arrays.asList(defaultFormatters));
	}
	
	public void setDefaultFormatters(Collection<Formatter> defaultFormatters) {
		setDefaultFormatter(new CompositeFormatter(defaultFormatters));
	}
	
	public IEglContext getContext() {
		return context;
	}
	
	/**
	 * Sets the root of this template factory, unless it has already been set.
	 */
	public void initialiseRoot(URI root) {
		if (this.root == null)
			setRoot(root);
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
	 * Loads an EglTemplate for the EGL code stored in the indicated file.
	 * 
	 * Subclasses should override {@link #createTemplate(String, URI)}, rather
	 * than this method, unless they wish to alter the way in which a file is
	 * transformed into an EglTemplateSpecification
	 */
	public EglTemplate load(File file) throws EglRuntimeException {
		final String name = name(file.getAbsolutePath());
		
		try {
			return load(createTemplateSpecificationFactory().fromResource(name, UriUtil.fileToUri(file)));
		
		} catch (URISyntaxException e) {
			return handleFailedLoad(name, e);
		}
	}
	
	/**
	 * Loads an EglTemplate for the given EGL code as though it were
	 * contained in the given File. Used for parsing "dirty" code (which 
	 * has not yet been saved to disk).
	 * 
	 * Subclasses should override {@link #createTemplate(String, URI)}, rather
	 * than this method, unless they wish to alter the way in which a dirty 
	 * resource is transformed into an EglTemplateSpecification
	 */
	protected EglTemplate load(String code, File file) throws EglRuntimeException {
		final String name = name(file.getAbsolutePath());

		try {
			return load(createTemplateSpecificationFactory().fromDirtyResource(name, code, UriUtil.fileToUri(file)));
		
		} catch (URISyntaxException e) {
			return handleFailedLoad(name, e);
		}			
	}

	/**
	 * Loads an EglTemplate for the EGL code stored in the file at path.
	 * 
	 * Subclasses should override {@link #createTemplate(String, URI)}, rather
	 * than this method, unless they wish to alter the way in which a path is
	 * transformed into an EglTemplateSpecification
	 */
	public EglTemplate load(String path) throws EglRuntimeException {
		return load(createTemplateSpecificationFactory().fromResource(name(path), resolveTemplate(path)));
	}
	
	/**
	 * Loads an EglTemplate for the EGL code stored in the given resource.
	 * 
	 * Subclasses should override {@link #createTemplate(String, URI)}, rather
	 * than this method, unless they wish to alter the way in which a resource is
	 * transformed into an EglTemplateSpecification
	 */
	public EglTemplate load(URI resource) throws EglRuntimeException {
		final String name = resource.toString(); // FIXME better name for URIs
		
		return load(createTemplateSpecificationFactory().fromResource(name, resource));
	}

	/**
	 * Loads an EglTemplate from the given EglTemplateSpecification.
	 * 
	 * Subclasses should override {@link #createTemplate(String, URI)}, rather
	 * than this method, unless they wish to alter the way in which IOExceptions
	 * are handled.
	 */
	protected EglTemplate load(EglTemplateSpecification spec) throws EglRuntimeException {
		try {
			return createTemplate(spec);
			
		} catch (Exception e) {
			return handleFailedLoad(spec.getName(), e);
		}
	}
	
	private EglTemplate handleFailedLoad(final String name, Exception e) throws EglRuntimeException {
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
	
	/**
	 * Prepares an EGL template that will execute the given
	 * EGL source code. Subclasses should override 
	 * {@link #createTemplate(String)}, rather than this method,
	 * as this method may, in the future, acquire additional
	 * responsibilities, such as exception handling.
	 */
	public EglTemplate prepare(String code) throws Exception {
		return createTemplate(createTemplateSpecificationFactory().fromCode(code));
	}

	/**
	 * Creates a template from the given specification.
	 * Subclasses may override to create different types of template.
	 */
	protected EglTemplate createTemplate(EglTemplateSpecification spec) throws Exception {
		return new EglTemplate(spec, context);
	}

	private EglTemplateSpecificationFactory createTemplateSpecificationFactory() {
		return new EglTemplateSpecificationFactory(defaultFormatter);
	}
		
	@Override
	public String toString() {
		final String root = templateRoot == null ? "" : templateRoot.toString();
		return "TemplateFactory: root='" + root + "'";
	}
}