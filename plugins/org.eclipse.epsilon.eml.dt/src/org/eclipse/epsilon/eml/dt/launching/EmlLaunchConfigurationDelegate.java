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
package org.eclipse.epsilon.eml.dt.launching;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.ecl.EclModule;
import org.eclipse.epsilon.ecl.IEclModule;
import org.eclipse.epsilon.ecl.trace.MatchTrace;
import org.eclipse.epsilon.eml.EmlModule;
import org.eclipse.epsilon.eml.execute.context.IEmlContext;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EmlLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		
		EpsilonConsole.getInstance().clear();
		EmlModule module = new EmlModule();
		
		if (!parse(module, EolLaunchConfigurationAttributes.SOURCE, configuration, mode, launch, progressMonitor)) return;
		
		// Start executing
		
		try { 
			String subTask = "Merging...";
			progressMonitor.subTask(subTask);
			progressMonitor.beginTask(subTask, 100);
			
			EclipseContextManager.setup(module.getContext() ,configuration, progressMonitor, launch);
			module.getContext().setMatchTrace(
					launchEcl(configuration, mode, launch, progressMonitor, module.getContext())
					.getReduced()
			);
			module.execute();
			progressMonitor.done();
			
		} catch (EolRuntimeException e) {
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
		}
		finally{
			//module.getContext().getModelRepository().dispose();
			EclipseContextManager.teardown(module.getContext());
		}
		
	}
	
	public MatchTrace launchEcl(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEmlContext context) throws CoreException {
		
		EpsilonConsole.getInstance().clear();
		
		IEclModule module = new EclModule();
		module.getContext().setOutputStream(context.getOutputStream());
		module.getContext().setErrorStream(context.getErrorStream());
		
		if (!parse(module, EmlLaunchConfigurationAttributes.ECL_SOURCE, configuration, mode, launch, progressMonitor)) return null;
		
		// Start executing
		
		try { 
			String subTask = "Comparing...";
			progressMonitor.subTask(subTask);
			progressMonitor.beginTask(subTask, 100);
			
			module.getContext().setModelRepository(context.getModelRepository());
			module.getContext().setIntrospectionManager(context.getIntrospectionManager());
			module.getContext().setNativeTypeDelegates(context.getNativeTypeDelegates());
			
			module.execute();
			progressMonitor.done();
			return module.getContext().getMatchTrace();
			
		} catch (EolRuntimeException e) {
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
			return null;
		}
		
	}
}
