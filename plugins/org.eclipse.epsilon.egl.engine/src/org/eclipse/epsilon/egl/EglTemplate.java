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

import java.net.URI;

import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.internal.EglModule;
import org.eclipse.epsilon.egl.merge.DefaultMerger;
import org.eclipse.epsilon.egl.merge.Merger;
import org.eclipse.epsilon.egl.spec.EglTemplateSpecification;
import org.eclipse.epsilon.egl.status.ProtectedRegionWarning;
import org.eclipse.epsilon.egl.traceability.Template;

public class EglTemplate extends AbstractEglTemplate {

	protected final String name;
	protected final Template template;
	
	private String contents = "";
	private boolean processed = false;
	
	// For tests
	protected EglTemplate(URI path, IEglContext context) throws Exception {
		this(EglTemplateSpecification.fromResource(path.toString(), path), context);
	}

	public EglTemplate(EglTemplateSpecification spec, IEglContext context) throws Exception {
		this(spec.getName(), context, spec.createTemplate());
		
		spec.parseInto(module);
	}
	
	private EglTemplate(String name, IEglContext context, Template template) {
		super(new EglModule(context));
		
		this.name     = name;
		this.template = template;
	}
	
	public String getName() {
		return name;
	}

	public void populate(String name, Object value) {
		template.addVariable(name, value);
	}
	
	public String process() throws EglRuntimeException {			
		contents = module.execute(template);
		
		processed = true;

		return contents;
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
		module.getContext().addStatusMessage(warning);
	}
	
	protected String getContents() {
		return contents;
	}
	
	protected boolean isProcessed() {
		return processed;
	}

	// TODO merge traceability template class into here?
}
