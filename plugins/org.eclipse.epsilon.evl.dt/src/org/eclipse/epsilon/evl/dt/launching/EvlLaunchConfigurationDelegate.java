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
import org.eclipse.epsilon.evl.EvlModule;
import org.eclipse.epsilon.evl.IEvlModule;
import org.eclipse.epsilon.evl.dt.views.ValidationViewFixer;

public class EvlLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, final IProgressMonitor progressMonitor) throws CoreException {
		
		EpsilonConsole.getInstance().clear();
		
		final IEvlModule module = new EvlModule();
		//module.getContext().setDefaultDebugStream(EpsilonConsole.getInstance().getDebugStream());
		//module.getContext().setDefaultErrorStream(EpsilonConsole.getInstance().getErrorStream());
		boolean parsed = false;
		String subTask = "";
		
		String fileName = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString() + configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, "");
		
		subTask = "Parsing " + fileName;
		progressMonitor.subTask(subTask);
		progressMonitor.beginTask(subTask, 100);
		
		try {
			parsed = module.parse(new File(fileName));
		} catch (Exception e) {
			e.printStackTrace(EpsilonConsole.getInstance().getErrorStream());
			return;
		}
		
		progressMonitor.done();
		
		if (!parsed){
			for (ParseProblem problem : module.getParseProblems()) {
				EpsilonConsole.getInstance().getErrorStream().println(problem.toString());
			}
			return;
		}
		
		subTask = "Loading models";
		progressMonitor.subTask(subTask);
		progressMonitor.beginTask(subTask, 100);
			
		progressMonitor.done();
		
		// Start executing
		
		try { 
			subTask = "Validating...";
			progressMonitor.subTask(subTask);
			progressMonitor.beginTask(subTask, 100);
			EclipseContextManager.setup(module.getContext(),configuration, progressMonitor, launch);
			//module.setUnsatisfiedConstraintFixer(this);
			module.setUnsatisfiedConstraintFixer(new ValidationViewFixer());
			module.execute();
			progressMonitor.done();
		} catch (EolRuntimeException e) {
			module.getContext().getErrorStream().println(e.toString());
			//module.getContext().getModelRepository().dispose();
			progressMonitor.setCanceled(true);
		}
		finally {
			//module.getContext().getModelRepository().dispose();
			EclipseContextManager.teardown(module.getContext());
		}
		
	}
	/*
	public void fix(IEvlModule module) throws EolRuntimeException {
		IEvlContext context = module.getContext();
		IUserInput userInput = context.getUserInput();
		ListIterator li = context.getUnsatisfiedConstraints().listIterator();

		while (li.hasNext()){
			EvlUnsatisfiedConstraint unsatisfiedConstraint = (EvlUnsatisfiedConstraint) li.next();
			
			context.getOutputStream().println(unsatisfiedConstraint.getMessage());
			boolean fixIt = (unsatisfiedConstraint.getFixes().size() > 0) && userInput.confirm("Fix error?", true);
			
			if (fixIt) {
				EvlFixInstance fixInstance = (EvlFixInstance) userInput.choose(unsatisfiedConstraint.getMessage(),unsatisfiedConstraint.getFixes(), null);
				if (fixInstance != null) {
					fixInstance.perform();
				}
			}
		}
	}
	*/
}

