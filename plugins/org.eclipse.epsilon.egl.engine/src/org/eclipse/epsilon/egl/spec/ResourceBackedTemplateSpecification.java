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


class ResourceBackedTemplateSpecification extends EglTemplateSpecification {

	private final URI resource;
	
	protected ResourceBackedTemplateSpecification(String name, URI resource, Formatter defaultFormatter, IncrementalitySettings incrementalitySettings, Collection<ITemplateExecutionListener> listeners) {
		super(name, defaultFormatter, incrementalitySettings, listeners);
		
		this.resource = resource;
	}

	public Template createTemplate() {
		return new Template(getName(), resource);
	}
	
	public void parseInto(IEglModule module) throws Exception {
		module.parse(resource);
	}
	
	public URI getURI() {
		return resource;
	}
}
