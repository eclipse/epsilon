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
import org.eclipse.epsilon.egl.internal.IEglModule;
import org.eclipse.epsilon.egl.traceability.Template;

public abstract class EglTemplateSpecification {

	private final String name;
	private final Formatter defaultFormatter;
	private final IncrementalitySettings incrementalitySettings;
	
	protected EglTemplateSpecification(String name, Formatter defaultFormatter, IncrementalitySettings incrementalitySettings) {
		this.name = name;
		this.defaultFormatter = defaultFormatter;
		this.incrementalitySettings = incrementalitySettings;
	}
	
	public String getName() {
		return name;
	}
	
	public Formatter getDefaultFormatter() {
		return defaultFormatter;
	}
	
	public IncrementalitySettings getIncrementalitySettings() {
		// Return a defensive copy, which can be safely modified for only this template
		return new IncrementalitySettings(incrementalitySettings);
	}

	public abstract Template createTemplate();
	public abstract void parseInto(IEglModule module) throws Exception;
	public abstract URI getURI();
}
