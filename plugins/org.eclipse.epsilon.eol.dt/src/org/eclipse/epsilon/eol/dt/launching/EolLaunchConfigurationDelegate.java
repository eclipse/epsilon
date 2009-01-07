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
package org.eclipse.epsilon.eol.dt.launching;
 
import java.io.File;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.IProcess;
import org.eclipse.debug.internal.ui.viewers.update.DebugTargetProxy;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.debug.EolBreakpoint;
import org.eclipse.epsilon.eol.dt.debug.EolDebugTarget;
import org.eclipse.epsilon.eol.dt.debug.EolProcess;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	// TODO : Remove some duplication between LaunchConfigurationDelegates
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		
		EpsilonConsole.getInstance().clear();
		
		IEolModule module = createEolModule();
		boolean parsed = false;
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, "")));
		String fileName = file.getRawLocation().toOSString();
		
		ArrayList<EolBreakpoint> breakpoints = new ArrayList<EolBreakpoint>();
		
		if (mode.equalsIgnoreCase("debug")) {
			IBreakpoint[] allBreakPoints = DebugPlugin.getDefault().getBreakpointManager().getBreakpoints("eol.debugModel");
			for (IBreakpoint breakpoint : allBreakPoints) {
				if (breakpoint.getMarker().getResource().equals(file)){
					breakpoints.add((EolBreakpoint) breakpoint);
				}
			}
		}
		
		String subtask = "Parsing " + fileName;
		progressMonitor.subTask(subtask);
		progressMonitor.beginTask(subtask, 100);
		
		try {
			parsed = module.parse(new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
			EpsilonConsole.getInstance().getErrorStream().println(e.getMessage());
			return;
		}
		
		progressMonitor.done();
		
		if (!parsed){
			
			for (ParseProblem problem : module.getParseProblems()) {
				EpsilonConsole.getInstance().getErrorStream().println(problem.toString());
			}
			return;
		}
		
		try { 
			EclipseContextManager.setup(module.getContext(),configuration, progressMonitor, launch);
			subtask = "Executing";
			progressMonitor.subTask(subtask);
			progressMonitor.beginTask(subtask, 100);

			if (mode.equals(ILaunchManager.DEBUG_MODE)) { 
				IDebugTarget target = new EolDebugTarget(launch, module);
				launch.addDebugTarget(target);
			}
			else {
				module.execute();
			}
			
			//module.execute();
		} catch (EolRuntimeException e) {
			e.printStackTrace();
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
		}
		finally{
			//engine.getContext().getModelRepository().shutdown();
			EclipseContextManager.teardown(module.getContext());
		}
		
		progressMonitor.done();
	}
	
	public IEolModule createEolModule() {
		return new EolModule();
	}
	
}
