/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.egl.test.acceptance.extensibility;

import java.io.IOException;
import java.net.URI;

import org.eclipse.epsilon.egl.EglTemplate;
import org.eclipse.epsilon.egl.FileGeneratingTemplateFactory;

public class CountingTemplateFactory extends FileGeneratingTemplateFactory {

	@Override
	protected EglTemplate createTemplate(String name, URI resource) throws IOException {
		return new CountingTemplate(name, resource, context, getOutputRootOrRoot(), outputRootPath);
	}

	@Override
	protected EglTemplate createTemplate(String code) {
		return new CountingTemplate(code, context, getOutputRootOrRoot(), outputRootPath);
	}

	
}
