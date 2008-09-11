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

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.launching.EpsilonLaunchConfigurationDelegate;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.IEolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class EolLaunchConfigurationDelegate extends EpsilonLaunchConfigurationDelegate {
	
	// TODO : Remove some duplication between LaunchConfigurationDelegates
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor progressMonitor) throws CoreException {
		
		//new Exception().printStackTrace(System.err);
		
		EpsilonConsole.getInstance().clear();
		
		IEolModule module = createEolModule();
		//EolProgram engine = new EolProgram();
		//module.getContext().setDefaultDebugStream(EpsilonConsole.getInstance().getDebugStream());
		//module.getContext().setDefaultErrorStream(EpsilonConsole.getInstance().getErrorStream());
		
		//ArrayList list = new ArrayList();
		//list.add(1.2f);
		//list.add(2);
		//list.add(3);
		//module.getContext().getScope().put(Variable.createReadOnlyVariable("list",list));
		//engine.getContext().setDefaultDebugStream(ConsoleUtil.getInstance().getPrintStream());
		boolean parsed = false;
		
		String fileName = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString() + configuration.getAttribute(EolLaunchConfigurationAttributes.SOURCE, "");
		
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
			module.execute();
		} catch (EolRuntimeException e) {
			e.printStackTrace();
			module.getContext().getErrorStream().println(e.toString());
			/*
			ListIterator li = module.getContext().getScope().getFrames();
			while (li.hasNext()){
				Frame frame = (Frame) li.next();
				String f = "  at " + frame.getLabel() + " " + frame.getType();
				if (frame.getEntryPoint() != null) {
					EolAst ast = (EolAst) frame.getEntryPoint();
					String file = "unknown";
					if (ast.getFile() != null) file = ast.getFile().getAbsolutePath();
					f += " (" + file + "@" + ast.getLine() + ":" + ast.getColumn() + ")";
				}
				module.getContext().getDefaultErrorStream().println(f);
			}*/
			//e.printStackTrace(EpsilonConsole.getInstance().getErrorStream());
			//EpsilonConsole.getInstance().reportException(e);
			//ConsoleUtil.getInstance().getPrintStream().println(e.toString());
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
