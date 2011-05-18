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

import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;

public class EolTask extends ExecutableModuleTask {
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected IEolExecutableModule createModule() {
		return new EolModule();
	}

	@Override
	protected void examine() throws Exception {
		
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EolDebugger();
	}

}
