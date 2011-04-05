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
package org.eclipse.epsilon.etl.dt.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.etl.EtlModule;
import org.eclipse.epsilon.etl.IEtlModule;

public class EtlLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	/*
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		
		EpsilonConsole.getInstance().clear();
		
		IEtlModule module = new EtlModule();
		
		if (!parse(module, EolLaunchConfigurationAttributes.SOURCE, configuration, mode, launch, progressMonitor)) return;
		
		try { 
			String subTask = "Transforming...";
			progressMonitor.subTask(subTask);
			progressMonitor.beginTask(subTask, 100);
			
			EclipseContextManager.setup(module.getContext(),configuration, progressMonitor, launch);
			module.execute();
			progressMonitor.done();
			
		} catch (EolRuntimeException e) {
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
		}
		finally{
			EclipseContextManager.teardown(module.getContext(), progressMonitor);
		}
		
	}
	*/
	
	@Override
	public IEolExecutableModule createModule() {
		return new EtlModule();
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EtlDebugger();
	}
	
}

