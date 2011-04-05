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
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugTarget;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.models.ModelRepository;

public abstract class EpsilonLaunchConfigurationDelegate extends LaunchConfigurationDelegate {

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		if (!super.saveBeforeLaunch(configuration, mode, monitor)) {
		    return false;
		}
		return super.preLaunchCheck(configuration, mode, monitor);
	}
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		launch(configuration, mode, launch, progressMonitor, createModule(), createDebugger(), EolLaunchConfigurationAttributes.SOURCE, true, true);
	}
	
	public boolean launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEolExecutableModule module, EolDebugger debugger, String lauchConfigurationSourceAttribute, boolean setup, boolean disposeModelRepository) throws CoreException {
		
		if (setup) EpsilonConsole.getInstance().clear();
		
		if (!parse(module, lauchConfigurationSourceAttribute, configuration, mode, launch, progressMonitor)) return false;
		
		EolDebugTarget target = null;
		
		try { 
			EclipseContextManager.setup(module.getContext(),configuration, progressMonitor, launch, setup);
			preExecute(module);
			String subtask = "Executing";
			progressMonitor.subTask(subtask);
			progressMonitor.beginTask(subtask, 100);
			
			if ("run".equalsIgnoreCase(mode)) {
				module.execute();
			}
			else {
				// Copy launch configuration attributes to launch
				Map configurationAttributes = configuration.getAttributes();
				for (Object key : configurationAttributes.keySet()) {
					launch.setAttribute(key + "", configurationAttributes.get(key) + "");
				}
				
				debugger.setModule(module);
				target = new EolDebugTarget(launch, module, debugger, lauchConfigurationSourceAttribute);
				debugger.setTarget(target);
				launch.addDebugTarget(target);
				target.debug();
			}
			
			postExecute(module);
			
		} catch (EolRuntimeException e) {
			e.printStackTrace();
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
			return false;
		}
		finally{
			if (target != null) {
				target.terminate();
				if (!disposeModelRepository) launch.removeDebugTarget(target);
			}
			teardown(module.getContext(), disposeModelRepository);
		}
		
		progressMonitor.done();
		
		return true;
	}
	
	public abstract IEolExecutableModule createModule();
	
	protected void preExecute(IEolExecutableModule module) {}
	
	protected void postExecute(IEolExecutableModule module) {}
	
	protected EolDebugger createDebugger() {
		return new EolDebugger();
	}
	
	//TODO: Report parse errors better
	protected boolean parse(IModule module, String sourceAttribute, ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		String subTask = "";
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(configuration.getAttribute(sourceAttribute, "")));
		String fileName = file.getRawLocation().toOSString();
		
		subTask = "Parsing " + fileName;
		progressMonitor.subTask(subTask);
		progressMonitor.beginTask(subTask, 100);
		
		boolean parsed = false;
		
		try {
			parsed = module.parse(new File(fileName));
		} catch (Exception e) {
			e.printStackTrace(EpsilonConsole.getInstance().getErrorStream());
			return false;
		}
		
		progressMonitor.done();
		
		if (!parsed){
			for (ParseProblem problem : module.getParseProblems()) {
				EpsilonConsole.getInstance().getErrorStream().println(problem.toString());
			}
		}

		return parsed;
		
	}
	
	public void teardown(IEolContext context, boolean disposeModelRepository) {
		if (disposeModelRepository) context.getModelRepository().dispose();
		context.getExecutorFactory().getExecutionController().dispose();
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			LogUtil.log(e);
		}
	}
	
}
