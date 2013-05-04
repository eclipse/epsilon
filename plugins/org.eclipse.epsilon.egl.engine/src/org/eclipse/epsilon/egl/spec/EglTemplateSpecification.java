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
import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.egl.traceability.Template;

public abstract class EglTemplateSpecification {

	private final String name;
	private final Formatter defaultFormatter;
	
	protected EglTemplateSpecification(String name, Formatter defaultFormatter) {
		this.name = name;
		this.defaultFormatter = defaultFormatter;
	}
	
	public String getName() {
		return name;
	}
	
	public Formatter getDefaultFormatter() {
		return defaultFormatter;
	}

	public abstract Template createTemplate();
	public abstract void parseInto(IEglModule module) throws Exception;
	public abstract URI getURI();
}
