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
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.module.IModule;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.debug.EolDebugTarget;
import org.eclipse.epsilon.eol.dt.debug.EolDebugger;
import org.eclipse.epsilon.eol.exceptions.EolInternalException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public abstract class EpsilonLaunchConfigurationDelegate extends LaunchConfigurationDelegate implements EpsilonLaunchConfigurationDelegateListener {
	
	protected Object result = null;
	protected ILaunchConfiguration configuration = null;
	protected ArrayList<EpsilonLaunchConfigurationDelegateListener> listeners = null;
	
	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor) throws CoreException {
		if (!super.saveBeforeLaunch(configuration, mode, monitor)) {
		    return false;
		}
		return super.preLaunchCheck(configuration, mode, monitor);
	}
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		this.configuration = configuration;
		launch(configuration, mode, launch, progressMonitor, createModule(), createDebugger(), EolLaunchConfigurationAttributes.SOURCE, true, true);
	}
	
	public boolean launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor, IEolExecutableModule module, EolDebugger debugger, String lauchConfigurationSourceAttribute, boolean setup, boolean disposeModelRepository) throws CoreException {
		
		collectListeners();
		
		if (setup) EpsilonConsole.getInstance().clear();
		
		aboutToParse(configuration, mode, launch, progressMonitor, module);
		
		if (!parse(module, lauchConfigurationSourceAttribute, configuration, mode, launch, progressMonitor)) return false;
		
		EolDebugTarget target = null;
		
		try { 
			EclipseContextManager.setup(module.getContext(),configuration, progressMonitor, launch, setup);
			aboutToExecute(configuration, mode, launch, progressMonitor, module);
			String subtask = "Executing";
			progressMonitor.subTask(subtask);
			progressMonitor.beginTask(subtask, 100);
			
			if ("run".equalsIgnoreCase(mode)) {
				result = module.execute();
			}
			else if ("debug".equalsIgnoreCase(mode)){
				// Copy launch configuration attributes to launch
				Map<?,?> configurationAttributes = configuration.getAttributes();
				for (Object key : configurationAttributes.keySet()) {
					launch.setAttribute(key + "", configurationAttributes.get(key) + "");
				}

				final String name = launch.getAttribute(lauchConfigurationSourceAttribute);
				target = new EolDebugTarget(launch, module, debugger, name);
				debugger.setTarget(target);
				launch.addDebugTarget(target);
				result = target.debug();
			}
			
			executed(configuration, mode, launch, progressMonitor, module, result);
			
		} catch (Exception e) {
			e = EolRuntimeException.wrap(e);
			e.printStackTrace();
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
			return false;
		}
		finally{
			if (target != null) {
				if (!disposeModelRepository) launch.removeDebugTarget(target);
			}
			teardown(module.getContext(), disposeModelRepository);
		}
		
		progressMonitor.done();
		
		return true;
	}
	
	public abstract IEolExecutableModule createModule() throws CoreException;
	
	protected void collectListeners() {
		
		listeners = new ArrayList<EpsilonLaunchConfigurationDelegateListener>();
		
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.eol.dt.launchConfigurationExtension");
		IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
		for (int i=0;i<configurationElements.length; i++){
			IConfigurationElement configurationElement = configurationElements[i];
			
			try {
				EpsilonLaunchConfigurationDelegateListener listener = (EpsilonLaunchConfigurationDelegateListener) configurationElement.createExecutableExtension("listener");
				listeners.add(listener);
			}
			catch (CoreException e) {
				LogUtil.log(e);
			}
		}
	}
	
	@Override
	public void aboutToParse(ILaunchConfiguration configuration, String mode, 
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module) throws CoreException {
		
		preParse(module);
		for (EpsilonLaunchConfigurationDelegateListener listener : listeners) {
			listener.aboutToParse(configuration, mode, launch, progressMonitor, module);
		}
	}
	
	@Override
	public void aboutToExecute(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module) throws Exception {
		
		preExecute(module);
		for (EpsilonLaunchConfigurationDelegateListener listener : listeners) {
			listener.aboutToExecute(configuration, mode, launch, progressMonitor, module);
		}
	}
	
	@Override
	public void executed(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor progressMonitor,
			IEolExecutableModule module, Object result) throws Exception {
		
		postExecute(module);
		for (EpsilonLaunchConfigurationDelegateListener listener : listeners) {
			listener.executed(configuration, mode, launch, progressMonitor, module, result);
		}
	}
	
	protected void preParse(IEolExecutableModule module) {}
	
	protected void preExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {}
	
	protected void postExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {}
	
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
