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
package org.eclipse.epsilon.hutn.dt.util;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;
import org.eclipse.epsilon.hutn.dt.markers.MarkerManager;

public class HutnBuilderHelper {
	
	private final IFile file;
	private final IProgressMonitor monitor;
	
	private IHutnModule hutnModule;
	private IPath base;
	private IResource parent;
	
	public HutnBuilderHelper(IFile file) {
		this(file, null);
	}
	
	public HutnBuilderHelper(IFile file, IProgressMonitor monitor) {
		this.file    = file;
		this.monitor = monitor;
	}

	public static IHutnModule initialiseHutnModule(IFile file) {
		final IHutnModule hutnModule = new HutnModule();
				
		hutnModule.setConfigFileDirectory(WorkspaceUtil.getAbsolutePath(file.getParent()));
		
		return hutnModule;
	}
	
	public void buildHutn() {
		try {
			hutnModule = initialiseHutnModule(file);
			
			if (hutnModule.parse(file.getRawLocationURI())) {
				base   = file.getLocation().removeFileExtension();
				parent = file.getParent();
				
				final List<File> generatedFiles = hutnModule.storeEmfModel(parent.getLocation().toFile(), // eg: /../ScratchPad/
				                                                           getFileName(base, "model"),    // eg: Output.model
				                                                           getFileName(base, "ecore"));   // eg: Inferred.metamodel
				
				for (File generatedFile : generatedFiles) {
					LogUtil.logInfo("Generated " + generatedFile);
				}
				
				parent.refreshLocal(IResource.DEPTH_ONE, monitor);
				
				removeMarkersFromModelFile();
				parent.refreshLocal(IResource.DEPTH_ONE, monitor);

			} else {
				EpsilonConsole.getInstance().getErrorStream().println(hutnModule.getParseProblems());
			}	
		} catch (Exception e) {
			EpsilonConsole.getInstance().getErrorStream().println(e.toString());
			e.printStackTrace();
		}
	}
	
	private void removeMarkersFromModelFile() throws CoreException {
		final String modelFile = hutnModule.getModelFile() == null ? 
				                         getFileName(base, "model") :
				                         hutnModule.getModelFile();
				
				                
		final IPath modelPathFromProject = parent.getFullPath().removeFirstSegments(1).append(modelFile);
		new MarkerManager(file.getProject().getFile(modelPathFromProject)).removeMarkers();
	}
	
	private static String getFileName(IPath base, String extension) {
		return base.addFileExtension(extension).toFile().getName();
	}
}
