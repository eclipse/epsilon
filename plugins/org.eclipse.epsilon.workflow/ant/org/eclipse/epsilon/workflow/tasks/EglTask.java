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
import java.io.FileWriter;

import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;

public class EglTask extends ExecutableModuleTask {
	
	protected File target;
	
	@Override
	protected IEolExecutableModule createModule() {
		return new EglTemplateFactoryModuleAdapter(new EglFileGeneratingTemplateFactory());
	}

	@Override
	protected void examine() throws Exception {
		if (target!=null) {
			FileWriter fw = new FileWriter(target);
			fw.write(String.valueOf(result));
			fw.flush();
			fw.close();
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
	
	@Override
	protected EolDebugger createDebugger() {
		return new EolDebugger();
	}

}
