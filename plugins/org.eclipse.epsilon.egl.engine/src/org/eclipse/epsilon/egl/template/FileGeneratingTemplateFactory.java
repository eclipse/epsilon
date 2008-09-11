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

import java.net.URI;

import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.types.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.types.EglTemplate;

public class FileGeneratingTemplateFactory extends TemplateFactory {
	
	private URI   outputRoot;
	private String outputRootPath;
	
	public FileGeneratingTemplateFactory(IEglContext context) {
		super(context);
	}
	
	public String getOutputRoot() {
		return outputRootPath;
	}
	
	public void setOutputRoot(String path) throws EglRuntimeException {
		outputRootPath = path;
		outputRoot     = resolveRoot(path);
	}
	
	@Override
	public void imitate(TemplateFactory other) {
		super.imitate(other);
		
		if (other instanceof FileGeneratingTemplateFactory) {
			final FileGeneratingTemplateFactory fgtf = (FileGeneratingTemplateFactory)other;
			outputRootPath = fgtf.outputRootPath;
			outputRoot     = fgtf.outputRoot;
		}
	}
	
	@Override
	public EglTemplate load(String path) throws EglRuntimeException {
		return new EglFileGeneratingTemplate(name(path),
		                                     resolveTemplate(path),
		                                     context,
		                                     outputRoot != null ? outputRoot : root,
		                                     outputRootPath);
	}
}
