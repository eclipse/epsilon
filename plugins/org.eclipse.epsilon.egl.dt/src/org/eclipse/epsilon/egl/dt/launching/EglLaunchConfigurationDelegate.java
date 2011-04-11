/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.dt.launching;

import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.APPEND_TO_FILE;
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.GENERATE_TO;
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.GENERATE_TO_CONSOLE;
import static org.eclipse.epsilon.egl.dt.launching.EglLaunchConfigurationAttributes.OUTPUT_FILE_PATH;

import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.EglTemplateFactoryModuleAdapter;
import org.eclipse.epsilon.egl.dt.views.CurrentTemplate;
import org.eclipse.epsilon.egl.execute.context.EglContext;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.util.FileUtil;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class EglLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {

	@Override
	public IEolExecutableModule createModule() {
		return new EglTemplateFactoryModuleAdapter(new EglFileGeneratingTemplateFactory());
	}
	
	@Override
	protected void preExecute(final IEolExecutableModule module) throws CoreException, EolRuntimeException {
		super.preExecute(module);
		final Display display = PlatformUI.getWorkbench().getDisplay();
		display.syncExec(new Runnable() {

			public void run() {
				module.getContext().setOutputStream(EpsilonConsole.getInstance().newPrintStream(display.getSystemColor(SWT.COLOR_DARK_MAGENTA)));	
			}
			
		});
	}
	
	@Override
	protected void postExecute(IEolExecutableModule module) throws CoreException, EolRuntimeException {
		super.postExecute(module);
		String output = StringUtil.toString(result);
		
		if (output!=null && output.length() > 0) {
			if (configuration.getAttribute(GENERATE_TO, GENERATE_TO_CONSOLE) == GENERATE_TO_CONSOLE) {
				EpsilonConsole.getInstance().getDebugStream().println(output);
			} else {
				// FIXME use the template to write to file?
				final String outputFilePath = configuration.getAttribute(OUTPUT_FILE_PATH, "");
				
				if (outputFilePath.length() > 0) {
					try {
						final boolean appendToFile = configuration.getAttribute(APPEND_TO_FILE, false);
						final String verb = appendToFile ? "appended" : "generated";
						
						final String workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString();
						FileUtil.write(workspaceLocation + outputFilePath, output, appendToFile);
						EpsilonConsole.getInstance().getInfoStream().println("Output " + verb + " to " + outputFilePath);
						
					} catch (IOException e) {
						module.getContext().getErrorStream().println("Could not write to " + outputFilePath + ":");
						module.getContext().getErrorStream().print('\t');
						module.getContext().getErrorStream().println(e);
					}
				}
			}
		}
		
		for (StatusMessage message : ((EglContext) module.getContext()).getStatusMessages())
			EpsilonConsole.getInstance().getInfoStream().println(message);
		
		CurrentTemplate.getInstance().setTemplate(((EglContext) module.getContext()).getBaseTemplate());
		
	}
	
	/*
	protected String output = null;
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {

		EpsilonConsole.getInstance().clear();
		
		//final EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();
		
		IEolExecutableModule module  =
		
		String subTask = "";
		
		final String workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString();
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, "")));
		String fileName = file.getRawLocation().toOSString();
		
		//final String fileName          = workspaceLocation + configuration.getAttribute(SOURCE, "");
		
		// Parse
		subTask = "Parsing " + fileName;
		progressMonitor.subTask(subTask);
		progressMonitor.beginTask(subTask, 100);
		
		final EglFileGeneratingTemplate template;
		
		try {
			// FIXME cast is smelly
			template = (EglFileGeneratingTemplate) factory.load(new File(fileName));
		} catch (EglRuntimeException e) {
			e.printStackTrace(EpsilonConsole.getInstance().getErrorStream());
			return;
		}
		
		progressMonitor.done();
		
		if (!template.getParseProblems().isEmpty()){
			for (ParseProblem problem : template.getParseProblems()){
				EpsilonConsole.getInstance().getErrorStream().println(problem);
			}
			return;
		}
		
		// Start executing
		
		try { 
			subTask = "Generating...";
			progressMonitor.subTask(subTask);
			progressMonitor.beginTask(subTask, 100);
			EclipseContextManager.setup(factory.getContext(),configuration, progressMonitor, launch);
			
			final Display display = PlatformUI.getWorkbench().getDisplay();
			display.syncExec(new Runnable() {

				public void run() {
					factory.getContext().setOutputStream(EpsilonConsole.getInstance().newPrintStream(display.getSystemColor(SWT.COLOR_DARK_MAGENTA)));	
				}
				
			});
			
			EolDebugTarget target = null;
			
			if ("run".equalsIgnoreCase(mode)) {
				output = template.process();
			}
			else {
				// Copy launch configuration attributes to launch
				Map configurationAttributes = configuration.getAttributes();
				for (Object key : configurationAttributes.keySet()) {
					launch.setAttribute(key + "", configurationAttributes.get(key) + "");
				}
				EolDebugger debugger = new EolDebugger();
				target = new EolDebugTarget(launch, template, debugger, "source");
				debugger.setTarget(target);
				launch.addDebugTarget(target);
				target.debug();
			}
			
			if (output!=null && output.length() > 0) {
				if (configuration.getAttribute(GENERATE_TO, GENERATE_TO_CONSOLE) == GENERATE_TO_CONSOLE) {
					EpsilonConsole.getInstance().getDebugStream().println(output);
				} else {
					// FIXME use the template to write to file?
					final String outputFilePath = configuration.getAttribute(OUTPUT_FILE_PATH, "");
					
					if (outputFilePath.length() > 0) {
						try {
							final boolean appendToFile = configuration.getAttribute(APPEND_TO_FILE, false);
							final String verb = appendToFile ? "appended" : "generated";
							
							FileUtil.write(workspaceLocation + outputFilePath, output, appendToFile);
							EpsilonConsole.getInstance().getInfoStream().println("Output " + verb + " to " + outputFilePath);
							
						} catch (IOException e) {
							factory.getContext().getErrorStream().println("Could not write to " + outputFilePath + ":");
							factory.getContext().getErrorStream().print('\t');
							factory.getContext().getErrorStream().println(e);
						}
					}
				}
			}
			
			for (StatusMessage message : factory.getContext().getStatusMessages())
				EpsilonConsole.getInstance().getInfoStream().println(message);
			
			CurrentTemplate.getInstance().setTemplate(factory.getContext().getBaseTemplate());
			
			// Refresh the workspace
			//ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
			
			progressMonitor.done();
			
		} catch (EolRuntimeException e) {
			factory.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
			
		} finally {
			//module.getContext().getModelRepository().dispose();
			EclipseContextManager.teardown(factory.getContext());
		}
		
	}
	
	//FIXME: EGL doesn't reuse the EpsilonLaunchConfiguration
	@Override
	public IEolExecutableModule createModule() {
		return null;
	}*/
}

