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
package org.eclipse.epsilon.egl.traceability;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.common.util.UriUtil;

public class Template extends Container<Content<Template>> {
	
	private final List<Variable> variables = new LinkedList<Variable>();
	
	public Template() {
		this(null, "", null);
	}
	
	public Template(URI uri) {
		this(null, uri == null ? "" : UriUtil.getName(uri), uri);
	}
	
	public Template(String name) {
		this(name, null);
	}
	
	public Template(String name, URI uri) {
		this(null, name, uri);
	}
	
	protected Template(Template parent, String name, URI uri) {
		super(parent, name, uri);
	}
	
	public OutputFile addOutputFile(String name, URI uri) {
		final OutputFile outputFile = new OutputFile(this, name, uri);
		super.add(outputFile);
		return outputFile;
	}
	
	public OutputFile addOutputFile(URI uri) {
		if (uri == null)
			throw new NullPointerException("uri cannot be null");
		
		return addOutputFile(UriUtil.getName(uri), uri);
	}
	
	public Template addTemplate(String name, URI uri) {
		final Template template = new Template(this, name, uri);
		super.add(template);
		return template;
	}
	
	public Template addTemplate(URI uri) {
		if (uri == null)
			throw new NullPointerException("uri cannot be null");
		
		return addTemplate(UriUtil.getName(uri), uri);
	}
	
	public Variable addVariable(String name, Object value) {
		final Variable variable = new Variable(this, name, value);
		super.add(variable);
		variables.add(variable);
		return variable;
	}
	
	public Collection<Variable> getVariables() {
		return Collections.unmodifiableCollection(variables);
	}
	
	public Collection<OutputFile> getOutputFiles() {
		final Collection<OutputFile> outputFiles = new LinkedList<OutputFile>();
		
		for (Content<Template> child : contents) {
			if (child instanceof OutputFile) {
				outputFiles.add((OutputFile)child);
			}
		}
		
		return outputFiles;
	}
}
