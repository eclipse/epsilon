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
package org.eclipse.epsilon.epl.dt.launching;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.epl.EplModule;

public class EplLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	@Override
	public IEolExecutableModule createModule() {
		return new EplModule();
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EplDebugger();
	}
	
	@Override
	public void aboutToExecute(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module) throws Exception {
		super.aboutToExecute(configuration, mode, launch, progressMonitor, module);
		EplModule eplModule = (EplModule) module;
		
		eplModule.setMaxLoops(configuration.getAttribute(EplLaunchConfigurationAttributes.MAX_LOOPS, EplModule.INFINITE));
		eplModule.setRepeatWhileMatches(configuration.getAttribute(EplLaunchConfigurationAttributes.REPEAT_WHILE_MATCHES_FOUND, false));
		
	}
	
	@Override
	public void executed(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module, Object result) throws Exception {
		// TODO Auto-generated method stub
		super.executed(configuration, mode, launch, progressMonitor, module, result);
		this.result = null;
	}
}

