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
package org.eclipse.epsilon.evl.dt.launching;

import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.dt.views.ValidationViewFixer;

public class EvlLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	/*
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, final IProgressMonitor progressMonitor) throws CoreException {
		
		EpsilonConsole.getInstance().clear();
		
		final IEvlModule module = new EvlModule();
		if (!parse(module, EolLaunchConfigurationAttributes.SOURCE, configuration, mode, launch, progressMonitor)) return ;
		
		// Start executing
		
		try { 
			String subTask = "Validating...";
			progressMonitor.subTask(subTask);
			progressMonitor.beginTask(subTask, 100);
			EclipseContextManager.setup(module.getContext(),configuration, progressMonitor, launch);
			module.setUnsatisfiedConstraintFixer(new ValidationViewFixer());
			module.execute();
			progressMonitor.done();
		} catch (EolRuntimeException e) {
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
		}
		finally {
			EclipseContextManager.teardown(module.getContext());
		}
		
	}*/
	
	@Override
	public IEolExecutableModule createModule() {
		return new EvlModule();
	}
	
	@Override
	protected EolDebugger createDebugger() {
		return new EvlDebugger();
	}
	
	@Override
	protected void preExecute(IEolExecutableModule module) {
		super.preExecute(module);
		System.err.println("Setting fixer...");
		((EvlModule)module).setUnsatisfiedConstraintFixer(new ValidationViewFixer());
	}
	
}

