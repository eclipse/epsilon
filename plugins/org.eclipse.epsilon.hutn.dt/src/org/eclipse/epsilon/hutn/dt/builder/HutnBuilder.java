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
package org.eclipse.epsilon.hutn.dt.builder;

import java.io.File;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;
import org.eclipse.epsilon.hutn.dt.util.WorkspaceUtil;

public class HutnBuilder extends IncrementalProjectBuilder {
	
	public static final String ID = "org.eclipse.epsilon.hutn.dt.builder.HutnBuilder";
	
	private void refreshWorkspace(IProgressMonitor monitor) {
		try {
			getProject().refreshLocal(IProject.DEPTH_INFINITE, monitor);
		} catch (CoreException e) {
			EpsilonConsole.getInstance().getErrorStream().append(e.toString());
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) {
		if (kind == IncrementalProjectBuilder.FULL_BUILD) {
			fullBuild(monitor);
		} else {
			IResourceDelta delta = getDelta(getProject());
			if (delta == null) {
				fullBuild(monitor);
			} else {
				incrementalBuild(delta, monitor);
			}
		}
		
		refreshWorkspace(monitor);
		
		return null;
	}

	private void incrementalBuild(IResourceDelta delta, final IProgressMonitor monitor) {
		try {
			delta.accept(new IResourceDeltaVisitor() {
				
				public boolean visit(IResourceDelta delta) {
					if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED)
						buildHutn(delta.getResource(), monitor);
					
					return true; // visit children too
				}
			});
			
		} catch (CoreException e) {
			EpsilonConsole.getInstance().getErrorStream().append(e.toString());
		}
	}

	private void fullBuild(final IProgressMonitor monitor) {
		try {
			System.err.println("full build");
			
			getProject().accept(new IResourceVisitor() {

				public boolean visit(IResource resource) throws CoreException {
					buildHutn(resource, monitor);
					return true; // visit children too
				}
				
			});
			
		} catch (CoreException e) {
			EpsilonConsole.getInstance().getErrorStream().println(e.toString());
		}
	}
	
	private static void buildHutn(IResource resource, IProgressMonitor monitor) {
		try {
			if (resource instanceof IFile && "hutn".equals(resource.getFileExtension())) {
				final IFile file = (IFile)resource;
				
				final IHutnModule hutnModule = new HutnModule();
				
				hutnModule.setConfigFileDirectory(WorkspaceUtil.getAbsolutePath(file.getParent()));
				
				if (hutnModule.parse(file.getRawLocationURI())) {
					final IPath modelPath = file.getLocation().removeFileExtension().addFileExtension("model");
					
					if (hutnModule.hasInferredMetaModel()) {
						final File metamodel = modelPath.removeFileExtension().addFileExtension("ecore").toFile();
						
						hutnModule.generateEmfMetaModel(metamodel);
						EpsilonConsole.getInstance().getInfoStream().println("Inferred " + metamodel);
						
						hutnModule.generateEmfModel(modelPath.toFile(), metamodel);
						
					} else {
						hutnModule.generateEmfModel(modelPath.toFile());
					}
					
					EpsilonConsole.getInstance().getInfoStream().println("Generated " + modelPath.toFile());
					file.getProject().getFile(modelPath).refreshLocal(0, monitor);

				} else {
					EpsilonConsole.getInstance().getErrorStream().println(hutnModule.getParseProblems());
				}
			}
			
		} catch (Exception e) {
			EpsilonConsole.getInstance().getErrorStream().println(e.toString());
			e.printStackTrace();
		}
	}
}
