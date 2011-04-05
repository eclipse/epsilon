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

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplate;
import org.eclipse.epsilon.egl.EglFileGeneratingTemplateFactory;
import org.eclipse.epsilon.egl.dt.views.CurrentTemplate;
import org.eclipse.epsilon.egl.exceptions.EglRuntimeException;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.util.FileUtil;
import org.eclipse.epsilon.eol.IEolExecutableModule;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class EglLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {

		EpsilonConsole.getInstance().clear();
		
		final EglFileGeneratingTemplateFactory factory = new EglFileGeneratingTemplateFactory();

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
			
			final String output = template.process();
			
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
	}
}

