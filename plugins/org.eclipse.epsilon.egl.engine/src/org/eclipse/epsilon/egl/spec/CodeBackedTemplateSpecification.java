/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.spec;

import java.net.URI;
import java.util.Collection;

import org.eclipse.epsilon.egl.execute.control.ITemplateExecutionListener;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.incremental.IncrementalitySettings;
import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.IImportManager;

class CodeBackedTemplateSpecification extends EglTemplateSpecification {

	private final String code;
	
	protected CodeBackedTemplateSpecification(String code, Formatter defaultFormatter, IncrementalitySettings incrementalitySettings, IImportManager importManager, Collection<ITemplateExecutionListener> listeners) {
		super("Anonymous", defaultFormatter, incrementalitySettings, importManager, listeners);
		
		this.code = code;
	}
	
	@Override
	public Template createTemplate() {
		return new Template();
	}
	
	@Override
	public void parseInto(IEglModule module) throws Exception {
		module.parse(code);
	}

	@Override
	public URI getURI() {
		return null;
	}	
}
