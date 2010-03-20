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

import static org.eclipse.epsilon.hutn.xmi.dt.startup.ConformanceCheckingNature.hasConformanceCheckingNature;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.commons.parse.problem.ParseProblem;
import org.eclipse.epsilon.hutn.dt.markers.MarkerManager;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.epsilon.hutn.xmi.hashing.HutnXmiBridgeHashingException;
import org.eclipse.ui.IStartup;

public class CheckConformanceOnStartup implements IStartup {

	public void earlyStartup() {
		new ConformanceChecker().schedule();
	}

	private static class ConformanceChecker extends Job {		

		private final StringBuilder checked = new StringBuilder();
		private final StringBuilder skipped = new StringBuilder();
		
		public ConformanceChecker() {
			super("Checking conformance of models.");
		}

		public IStatus run(IProgressMonitor monitor) {
			try {
				checkConformanceOfModelsInProjectsWithConformanceCheckingNature(monitor);
			} catch (CoreException e) {
				LogUtil.log("Error whilst running task to check conformance of models.", e);
			}
			
			return Status.OK_STATUS;
		}
		
		private void checkConformanceOfModelsInProjectsWithConformanceCheckingNature(IProgressMonitor monitor) throws CoreException {
			final FileLocator modelFileLocator = new FileLocator(modelFileExtensions());
			
			for (IProject project : workspaceRoot().getProjects()) {
				if (hasConformanceCheckingNature(project)) {
					checkConformanceOf(modelFileLocator.findAllMatchingFiles(project), monitor);
				}
			}			
			
			printMessages();
			
			monitor.done();
		}

		private void checkConformanceOf(final Collection<IFile> modelFiles, IProgressMonitor monitor) {
			monitor.beginTask("Checking conformance of models.", modelFiles.size());
			
			for (IFile modelFile : modelFiles) {
				if (monitor.isCanceled())
					break;
				
				try {
					checkOrSkip(monitor, modelFile);
				} catch (Exception e) {
					LogUtil.log("Error whilst checking conformance of: " + modelFile, e);
				}
				
				monitor.worked(1);
			}
		}

		private void checkOrSkip(IProgressMonitor monitor, IFile modelFile) throws CoreException, HutnXmiBridgeException {
			if (metamodelHasChangedFor(modelFile)) {
				check(monitor, modelFile);
			
			} else {
				skip(monitor, modelFile);
			}
		}
		
		private boolean metamodelHasChangedFor(IFile modelFile) {
			try {
				return new ModelHashChecker(modelFile.getRawLocationURI()).hasHashChangedFor();
			
			} catch (HutnXmiBridgeHashingException e) {
				LogUtil.log("Error encountered while calculating hash for: " + modelFile, e);
				return true;
			}
		}
		
		private void check(IProgressMonitor monitor, IFile modelFile) throws CoreException, HutnXmiBridgeException {
			checked.append(modelFile);
			checked.append('\n');
			
			monitor.subTask("Checking conformance to registered metamodel of " + modelFile);
			
			checkConformanceToRegisteredMetamodelOf(modelFile);
		}
		
		private void skip(IProgressMonitor monitor, IFile modelFile) {
			skipped.append(modelFile);
			skipped.append('\n');
			
			monitor.subTask("Skipping conformance check (no metamodel changes) for " + modelFile);
		}
		
		private void printMessages() {
			if (checked.length() > 0) {
				printMessage("Checked conformance of the following models: " + checked);
			}
			
			if (skipped.length() > 0) {
				printMessage("Skipped conformance check of (no metamodel changes for) the following models: " + skipped);
			}
		}

		private void printMessage(String message) {
			EpsilonConsole.getInstance().getInfoStream().println(message);
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
