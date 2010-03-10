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

import java.io.File;
import java.io.IOException;
import java.net.URI;

import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.execute.context.IEglContext;
import org.eclipse.epsilon.egl.traceability.Template;
import org.eclipse.epsilon.eol.IEolLibraryModule;

public interface IEglModule extends IEolLibraryModule {

	public IEglContext getContext();
	
	public boolean parse(String code);
	
	public boolean parse(URI uri) throws IOException;
	
	public boolean parse(File file) throws IOException;
	
	public String execute() throws EglRuntimeException;
	
	public String execute(Template template) throws EglRuntimeException;
}
