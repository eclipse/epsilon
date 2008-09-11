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

import java.io.FileOutputStream;

import org.eclipse.epsilon.commons.util.FileUtil;
import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.eol.IEolExecutableModule;

public class EglTask extends ExecutableModuleTask {
	
	protected String target;
	
	@Override
	protected IEolExecutableModule createModule() {
		return new EglModule();
	}

	@Override
	protected void examine() throws Exception {
		if (target!=null) {
			String path = FileUtil.getAbsolutePath(getBaseDir().getAbsolutePath(), target);
			FileOutputStream fos = new FileOutputStream(path);
			String output = (((EglModule) module).getContext()).getOutputBuffer().toString();
			fos.write(output.getBytes());
			fos.flush();
			fos.close();
		}
	}

	@Override
	protected void initialize() throws Exception {
		
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String output) {
		this.target = output;
	}
	
}
