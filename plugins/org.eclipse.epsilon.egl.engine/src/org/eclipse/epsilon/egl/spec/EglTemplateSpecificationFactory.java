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

public class EglTemplateSpecificationFactory {

	private final Formatter defaultFormatter;
	
	public EglTemplateSpecificationFactory(Formatter defaultFormatter) {
		this.defaultFormatter = defaultFormatter;
	}
	
	public EglTemplateSpecification fromCode(String code) {
		return new CodeBackedTemplateSpecification(code, defaultFormatter);
	}

	public EglTemplateSpecification fromResource(String name, URI resource) {
		return new ResourceBackedTemplateSpecification(name, resource, defaultFormatter);
	}

	public EglTemplateSpecification fromDirtyResource(String name, String latestCode, URI resource) {
		return new DirtyResourceBackedTemplateSpecification(name, latestCode, resource, defaultFormatter);
	}
}
