/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.spec;

import java.io.File;
import java.net.URI;
import java.util.Collection;

import org.eclipse.epsilon.egl.execute.control.ITemplateExecutionListener;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.incremental.IncrementalitySettings;
import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.egl.traceability.Template;


class DirtyResourceBackedTemplateSpecification extends EglTemplateSpecification {

	private final String latestCode;
	private final URI resource;
	
	protected DirtyResourceBackedTemplateSpecification(String name, String latestCode, URI resource, Formatter defaultFormatter, IncrementalitySettings incrementalitySettings, Collection<ITemplateExecutionListener> listeners) {
		super(name, defaultFormatter, incrementalitySettings, listeners);
		
		this.latestCode = latestCode;
		this.resource = resource;
	}

	public Template createTemplate() {
		return new Template(getName(), resource);
	}
	
	public void parseInto(IEglModule module) throws Exception {
		module.parse(latestCode, new File(resource));
	}

	public URI getURI() {
		return resource;
	}	
}
