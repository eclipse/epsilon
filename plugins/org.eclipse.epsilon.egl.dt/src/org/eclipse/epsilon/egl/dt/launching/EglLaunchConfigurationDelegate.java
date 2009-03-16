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
import static org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes.SOURCE;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.commons.util.UriUtil;
import org.eclipse.epsilon.egl.IEglModule;
import org.eclipse.epsilon.egl.EglModule;
import org.eclipse.epsilon.egl.dt.views.CurrentTemplate;
import org.eclipse.epsilon.egl.status.StatusMessage;
import org.eclipse.epsilon.egl.util.FileUtil;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;

public class EglLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {

		EpsilonConsole.getInstance().clear();
		
		final IEglModule module = new EglModule();

		boolean parsed = false;
		String subTask = "";
		
		final String workspaceLocation = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString();
		final String fileName          = workspaceLocation + configuration.getAttribute(SOURCE, "");
		final File   file              = new File(fileName);
		
		// Parse
		subTask = "Parsing " + fileName;
		progressMonitor.subTask(subTask);
		progressMonitor.beginTask(subTask, 100);
		
		try {
			parsed = module.parse(file);
		} catch (IOException e) {
			e.printStackTrace(EpsilonConsole.getInstance().getErrorStream());
			return;
		}
		
		progressMonitor.done();
		
		if (!parsed){
			for (ParseProblem problem : module.getParseProblems()){
				EpsilonConsole.getInstance().getErrorStream().println(problem);
			}
			return;
		}
		
		// Start executing
		
		try { 
			subTask = "Generating...";
			progressMonitor.subTask(subTask);
			progressMonitor.beginTask(subTask, 100);
			EclipseContextManager.setup(module.getContext(),configuration, progressMonitor, launch);
			
			final Display display = PlatformUI.getWorkbench().getDisplay();
			display.syncExec(new Runnable() {

				public void run() {
					module.getContext().setOutputStream(EpsilonConsole.getInstance().newPrintStream(display.getSystemColor(SWT.COLOR_DARK_MAGENTA)));	
				}
				
			});
			
			final String output = module.execute();
			
			if (output!=null && output.length() > 0) {
				if (configuration.getAttribute(GENERATE_TO, GENERATE_TO_CONSOLE) == GENERATE_TO_CONSOLE) {
					EpsilonConsole.getInstance().getDebugStream().println(output);
				} else {
					final String outputFilePath = configuration.getAttribute(OUTPUT_FILE_PATH, "");
					
					if (outputFilePath.length() > 0) {
						try {
							final boolean appendToFile = configuration.getAttribute(APPEND_TO_FILE, false);
							final String verb = appendToFile ? "appended" : "generated";
							
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
			
			for (StatusMessage message : module.getContext().getStatusMessages())
				EpsilonConsole.getInstance().getInfoStream().println(message);
			
			CurrentTemplate.getInstance().setTemplate(module.getContext().getTemplate());
			
			// Refresh the workspace
			//ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IResource.DEPTH_INFINITE, progressMonitor);
			
			progressMonitor.done();
			
		} catch (EolRuntimeException e) {
			module.getContext().getErrorStream().println(e.toString());
			progressMonitor.setCanceled(true);
			
		} finally {
			//module.getContext().getModelRepository().dispose();
			EclipseContextManager.teardown(module.getContext());
		}
		
	}
}

