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

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.EclipseExecutionController;
import org.eclipse.epsilon.common.dt.launching.EpsilonLaunchConfigurationAttributes;
import org.eclipse.epsilon.common.dt.launching.extensions.ModelTypeExtension;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.profiling.Profiler;
import org.eclipse.epsilon.profiling.ProfilingExecutionListener;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.dt.ExtensionPointToolNativeTypeDelegate;
import org.eclipse.epsilon.eol.dt.userinput.JFaceUserInput;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.control.ExecutionController;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinter;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;


public class EclipseContextManager {
	
	
	public static void teardown(IEolContext context, IProgressMonitor progressMonitor) {
		context.getModelRepository().dispose();
		context.getExecutorFactory().getExecutionController().dispose();
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
		} catch (CoreException e) {
			LogUtil.log(e);
		}
	}
	
	public static void teardown(IEolContext context) {
		context.getModelRepository().dispose();
		context.getExecutorFactory().getExecutionController().dispose();
		try {
			ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);
		} catch (CoreException e) {
			LogUtil.log(e);
		}
	}
	
	public static void setup(IEolContext context) {
		loadPrettyPrinters(context);
		loadIo(context);
		context.getNativeTypeDelegates().add(new ExtensionPointToolNativeTypeDelegate());		
	}
	
	public static void setup(IEolContext context, IProgressMonitor progressMonitor, boolean profilingEnabled, boolean resetProfiler) {
		ExecutionController executionController = new EclipseExecutionController(progressMonitor);
		context.getExecutorFactory().setExecutionController(executionController);
		if (profilingEnabled) {
			context.getExecutorFactory().addExecutionListener(new ProfilingExecutionListener());
			
			Display.getDefault().asyncExec(new Runnable() {

				@Override
				public void run() {
					try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView("org.eclipse.epsilon.profiling.dt.ProfilerView");
					}
					catch (Exception ex) {ex.printStackTrace();}
				}
				
			});
			
			if (resetProfiler) {
				Profiler.INSTANCE.reset();
			}
		}
		setup(context);
	}
	
	public static void setup(IEolContext context, ILaunchConfiguration configuration, IProgressMonitor progressMonitor, ILaunch launch) throws EolRuntimeException {
		setup(context, configuration, progressMonitor, launch, true);
	}
	
	public static void setup(IEolContext context, ILaunchConfiguration configuration, IProgressMonitor progressMonitor, ILaunch launch, boolean loadModels) throws EolRuntimeException {
		if (loadModels) {
			loadModels(context,configuration,progressMonitor);
		}
		
		boolean profilerEnabled = false;
		boolean resetProfiler = false;
		
		try {
			profilerEnabled = configuration.getAttribute(EpsilonLaunchConfigurationAttributes.PROFILING_ENABLED, false);
			resetProfiler = configuration.getAttribute(EpsilonLaunchConfigurationAttributes.RESET_PROFILER, false);
		}
		catch (CoreException e) {}
		
		setup(context, progressMonitor, profilerEnabled, resetProfiler);
	}
	
	private static void loadIo(IEolContext context) {
		context.setOutputStream(EpsilonConsole.getInstance().getDebugStream());
		context.setErrorStream(EpsilonConsole.getInstance().getErrorStream());
		context.setWarningStream(EpsilonConsole.getInstance().getWarningStream());
		
		//context.setUserInput(new EpsilonConsoleUserInput());		
		context.setUserInput(new JFaceUserInput(context.getPrettyPrinterManager()));
	}
	
	private static void loadPrettyPrinters(IEolContext context) {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint("org.eclipse.epsilon.common.dt.prettyPrinter");
		IConfigurationElement[] configurationElements =  extensionPoint.getConfigurationElements();
		for (int i=0;i<configurationElements.length; i++){
			IConfigurationElement configurationElement = configurationElements[i];
			PrettyPrinter prettyPrinter;
			try {
				prettyPrinter = (PrettyPrinter) configurationElement.createExecutableExtension("class");
				context.getPrettyPrinterManager().addPrettyPrinter(prettyPrinter);
			} catch (CoreException e) {
				//PDE.log(e);
			}
		}
	}
	
	private static void loadModels(IEolContext context, ILaunchConfiguration configuration, IProgressMonitor progressMonitor) {
		String subtask = "Loading models";
		progressMonitor.subTask(subtask);
		progressMonitor.beginTask(subtask, 100);
		
		//String workspacePath = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString();
		
		List<?> models = null;
		
		try {
			models = configuration.getAttribute("models", new ArrayList<Object>());
		} catch (CoreException e1) {
			e1.printStackTrace(context.getErrorStream());
		}
		
		ListIterator<?> li = models.listIterator();
		
		while (li.hasNext()){
			String modelDescriptor = li.next().toString();
			StringProperties properties = new StringProperties();
			properties.load(modelDescriptor);
			
			IModel model = null;

			try {
				model = ModelTypeExtension.forType(properties.getProperty("type")).createModel();
				model.load(properties, EclipseUtil.getWorkspacePath());
				context.getModelRepository().addModel(model);
			} catch (Exception e) {
				e.printStackTrace();
				EpsilonConsole.getInstance().getErrorStream().print(e.toString());
				LogUtil.log(e);
			}
		}
		
		progressMonitor.done();		
	}
	
	/*
	private void loadTools(EolContext context, ILaunchConfiguration configuration, IProgressMonitor progressMonitor) throws EolRuntimeException {
		String subtask = "Loading tools";
		progressMonitor.subTask(subtask);
		progressMonitor.beginTask(subtask, 100);
		
		List tools = null;
		
		try {
			tools = configuration.getAttribute("tools", new ArrayList());
		} catch (CoreException e1) {
			e1.printStackTrace(context.getErrorStream());
		}
		
		ListIterator li = tools.listIterator();
		
		//while (li.hasNext()){
			//String toolDescriptor = li.next().toString();
			//StringProperties properties = new StringProperties();
			//properties.load(toolDescriptor);
			
			//ToolExtension extension = ToolExtension.forClass(properties.getProperty("class"));
			
			//Object tool = extension.createTool();
			//if (tool instanceof Tool){
			//	((Tool) tool).setContext(context);
			//}
			
			//context.getScope().put(Variable.createReadOnlyVariable(properties.getProperty("name"), tool));
		}
		
		progressMonitor.done();		
	}
	*/
}
