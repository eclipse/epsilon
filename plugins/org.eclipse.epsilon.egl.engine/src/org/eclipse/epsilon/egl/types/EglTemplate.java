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
package org.eclipse.epsilon.egl.types;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;

import org.eclipse.epsilon.egl.IEglModule;
import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.merge.DefaultMerger;
import org.eclipse.epsilon.egl.merge.Merger;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class EglTemplate {

	protected final IEglModule module;
	protected final String name;
	
	private String contents = "";
	private boolean processed = false;
	
	protected final IEglContext callersContext;
	
	// For tests
	protected EglTemplate(URI path, IEglContext callersContext) throws EglRuntimeException {
		this(path.toString(), path, callersContext);
	}
	
	public EglTemplate(String name, URI template, IEglContext callersContext) throws EglRuntimeException {
		this.name = name;
		this.callersContext = callersContext;
		this.module = new EglModule(callersContext);
		
		try {	
			module.parse(template);
		} catch (IOException ex) {
			String message = "Could not process";
			
			if (ex instanceof FileNotFoundException)
				message = "Template not found";
			
			throw new EglRuntimeException(message + " '" + name + "'", ex, callersContext.getModule().getAst());
		}
		
		module.getContext().setTemplate(new Template(name, template));
	}

	public void populate(String name, Object value) {
		module.getContext().getFrameStack().put(Variable.createReadOnlyVariable(name, value));
		module.getContext().getTemplate().addVariable(name, value);
	}
	
	public String process() throws EglRuntimeException {	
		try {
			contents = module.execute();

			callersContext.getTemplate().add(module.getContext().getTemplate());			
			
			processed = true;

			return contents;
			
		} catch (EglRuntimeException ex) {
			throw new EglRuntimeException("Could not process '" + name + "'", ex, callersContext.getModule().getAst());
		}
	}
	
	public String merge(String existing) throws EglRuntimeException {
		if (!isProcessed()) process();
		 
		final Merger merger = new DefaultMerger(module.getContext().getPartitioner(),
				                                contents,
				                                existing);
		
		final String result = merger.merge();
		
		for (ProtectedRegionWarning warning : merger.getMergeWarnings()) {
			addProtectedRegionWarning(warning);
		}
		
		return result;
	}
	
	protected void addProtectedRegionWarning(ProtectedRegionWarning warning) {
		callersContext.addStatusMessage(warning);
	}
	
	protected String getContents() {
		return contents;
	}
	
	protected boolean isProcessed() {
		return processed;
	}
}
