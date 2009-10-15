/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.hutn.xmi.dt.startup;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.dt.markers.MarkerManager;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.ui.IStartup;

public class CheckConformanceOnStartup implements IStartup {

	public void earlyStartup() {
		new ConformanceChecker().schedule();
	}

	private static class ConformanceChecker extends Job {
		
		public ConformanceChecker() {
			super("Checking conformance to registered metamodel of each model in the workspace.");
		}

		public IStatus run(IProgressMonitor monitor) {
			try {
				checkConformaceToRegisteredMetamodelOfEveryModelInTheWorkspace(monitor);
	
			} catch (Exception e) {
				LogUtil.log("Error whilst running task to check conformance to registered metamodel of each model in the workspace.", e);
			}
			
			return Status.OK_STATUS;
		}
		
		private void checkConformaceToRegisteredMetamodelOfEveryModelInTheWorkspace(IProgressMonitor monitor) throws CoreException, HutnXmiBridgeException {
			final Collection<IFile> modelFiles = new FileLocator(modelFileExtensions()).findAllMatchingFiles(workspaceRoot());

			monitor.beginTask("Checking conformance to registered metamodel of each model in the workspace.", modelFiles.size());
			
			for (IFile modelFile : modelFiles) {
				if (monitor.isCanceled())
					break;
				
				monitor.subTask("Checking conformance to registered metamodel of " + modelFile);
				checkConformanceToRegisteredMetamodelOf(modelFile);
				monitor.worked(1);
			}
			
			monitor.done();
		}


		private void checkConformanceToRegisteredMetamodelOf(IFile file) throws CoreException, HutnXmiBridgeException {		
			final Collection<ParseProblem> conformanceProblems = new Xmi2Hutn(file.getRawLocationURI()).checkConformanceWithRegisteredMetamodel();
			new MarkerManager(file).replaceErrorMarkers(conformanceProblems);
		}


		private Collection<String> modelFileExtensions() {			
			final Collection<String> modelFileExtensions = new LinkedList<String>();
			
			modelFileExtensions.addAll(RegisteredMetamodels.getInstance().getFileExtensionsOfAllRegisteredMetamodels());
			modelFileExtensions.add("model");
			
			// remove extensions that provide their own migration handling
			modelFileExtensions.remove("ecore");
			modelFileExtensions.remove("ecorediag");
			modelFileExtensions.remove("ecore2xml");
			modelFileExtensions.remove("ecore2ecore");
			modelFileExtensions.remove("genmodel");

			modelFileExtensions.remove("gmfgen");
			modelFileExtensions.remove("gmfgraph");
			modelFileExtensions.remove("gmfmap");
			modelFileExtensions.remove("gmftool");
			
			modelFileExtensions.remove("uml");
			modelFileExtensions.remove("history");
			
			return modelFileExtensions;
		}

		
		private IWorkspaceRoot workspaceRoot() {
			return ResourcesPlugin.getWorkspace().getRoot();
		}
	}
}
