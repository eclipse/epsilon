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
package org.eclipse.epsilon.egl.internal;

import java.util.List;

import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.formatter.Formatter;
import org.eclipse.epsilon.egl.model.EglMarkerSection;
import org.eclipse.epsilon.eol.IEolModule;

public interface IEglModule extends IEolModule {
	
	public EglPreprocessorModule getPreprocessorModule();
	
	public List<EglMarkerSection> getMarkers();
	
	public IEglContext getContext();
	
	public EglResult execute(EglTemplate template, Formatter postprocessor) throws EglRuntimeException;
}
