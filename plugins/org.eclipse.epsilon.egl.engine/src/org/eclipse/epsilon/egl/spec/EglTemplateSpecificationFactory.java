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

import java.net.URI;

import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.incremental.IncrementalitySettings;

public class EglTemplateSpecificationFactory {

	private final Formatter defaultFormatter;
	private final IncrementalitySettings incrementalitySettings;
	
	public EglTemplateSpecificationFactory(Formatter defaultFormatter, IncrementalitySettings incrementalitySettings) {
		this.defaultFormatter = defaultFormatter;
		this.incrementalitySettings = incrementalitySettings;
	}
	
	public EglTemplateSpecification fromCode(String code) {
		return new CodeBackedTemplateSpecification(code, defaultFormatter, incrementalitySettings);
	}

	public EglTemplateSpecification fromResource(String name, URI resource) {
		return new ResourceBackedTemplateSpecification(name, resource, defaultFormatter, incrementalitySettings);
	}

	public EglTemplateSpecification fromDirtyResource(String name, String latestCode, URI resource) {
		return new DirtyResourceBackedTemplateSpecification(name, latestCode, resource, defaultFormatter, incrementalitySettings);
	}
}
