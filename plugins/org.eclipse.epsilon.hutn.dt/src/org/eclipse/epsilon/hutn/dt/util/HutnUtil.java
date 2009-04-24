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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.hutn.HutnModule;
import org.eclipse.epsilon.hutn.IHutnModule;

public abstract class HutnUtil {
	
	private HutnUtil() {}

	public static IHutnModule initialiseHutnModule(IFile file) {
		final IHutnModule hutnModule = new HutnModule();
				
		hutnModule.setConfigFileDirectory(WorkspaceUtil.getAbsolutePath(file.getParent()));
		
		return hutnModule;
	}
	
	public static void buildHutn(IResource resource) {
		buildHutn(resource, null);
	}
	
	public static void buildHutn(IResource resource, IProgressMonitor monitor) {
		try {
			if (resource instanceof IFile && "hutn".equals(resource.getFileExtension())) {
				final IFile file = (IFile)resource;
				
				final IHutnModule hutnModule = initialiseHutnModule(file);
				
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
					file.getParent().refreshLocal(IResource.DEPTH_ONE, monitor);

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
