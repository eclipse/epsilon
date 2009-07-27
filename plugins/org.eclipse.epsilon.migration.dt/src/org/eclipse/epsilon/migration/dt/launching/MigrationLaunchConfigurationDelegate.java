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
package org.eclipse.epsilon.migration.dt.launching;

import java.io.File;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.dt.launching.EclipseContextManager;
import org.eclipse.epsilon.eol.dt.launching.EolLaunchConfigurationAttributes;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.migration.IMigrationModule;
import org.eclipse.epsilon.migration.MigrationContext;
import org.eclipse.epsilon.migration.MigrationModule;

public class MigrationLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	private ILaunchConfiguration launchConfig;
	private ILaunch launch;
	private IProgressMonitor monitor;

	private MigrationContext context;
	private IMigrationModule module; 
	
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		this.launchConfig = configuration;
		this.launch       = launch;
		this.monitor      = progressMonitor;
		
		try {
			EpsilonConsole.getInstance().clear();
			
			loadModels();

			if (parseSource()) {
				executeMigration();
				
			} else {
				printParseProblems();
			}
			
		} catch (Exception e) {
			reportException(e);
		
		} finally {
			teardownContext(progressMonitor);
		}
	}

	private void teardownContext(IProgressMonitor progressMonitor) {
		EclipseContextManager.teardown(context, progressMonitor);
	}

	private void reportException(Exception e) {
		EpsilonConsole.getInstance().getErrorStream().println(e.toString());
		monitor.setCanceled(true);
	}

	private void printParseProblems() {
		for (ParseProblem problem : module.getParseProblems()) {
			System.err.println(problem);
			EpsilonConsole.getInstance().getErrorStream().println(problem.toString());
		}
	}

	private void loadModels() throws EolRuntimeException {
		startingTask("Loading models");
		
		context = new MigrationContext();
		
		EclipseContextManager.setup(context, launchConfig, monitor, launch);
		
		// FIXME - need GUI to configure this
		context = new MigrationContext(context.getModelRepository().getModelByName("Original"),
		                               context.getModelRepository().getModelByName("Target"));
		
		finishedCurrentTask();
	}
	
	private boolean parseSource() throws Exception {
		module = new MigrationModule();
		
		final String fileName = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString() + launchConfig.getAttribute(EolLaunchConfigurationAttributes.SOURCE, "");
		
		startingTask("Parsing " + fileName);
		
		boolean parsed = module.parse(new File(fileName)) && module.getParseProblems().isEmpty();
				
		finishedCurrentTask();
		
		return parsed;
	}
	
	private void executeMigration() {
		startingTask("Migrating");

		module.execute(context);

		finishedCurrentTask();
	}
	
	
	private void startingTask(String task) {
		monitor.subTask(task);
		monitor.beginTask(task, 100);
	}
	
	private void finishedCurrentTask() {
		monitor.done();
	}
}

