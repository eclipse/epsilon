/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.workflow.tasks;

import java.io.File;

import org.eclipse.epsilon.egl.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.FileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.TemplateFactoryModuleAdapter;
import org.eclipse.epsilon.eol.IEolExecutableModule;

public class EglTask extends ExecutableModuleTask {
	
	protected File target;
	
	@Override
	protected IEolExecutableModule createModule() {
		return new TemplateFactoryModuleAdapter(new FileGeneratingTemplateFactory());
	}

	@Override
	protected void examine() throws Exception {
		if (target!=null) {
			final EglFileGeneratingTemplate template = (EglFileGeneratingTemplate)result;
			template.generate(target.getAbsolutePath());
		}
	}

	@Override
	protected void initialize() throws Exception {}

	public File getTarget() {
		return target;
	}

	public void setTarget(File output) {
		this.target = output;
	}
	
}
