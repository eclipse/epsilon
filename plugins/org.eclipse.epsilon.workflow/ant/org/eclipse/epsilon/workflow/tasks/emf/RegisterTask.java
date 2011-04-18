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
package org.eclipse.epsilon.workflow.tasks.emf;

import java.io.File;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.emc.emf.EmfUtil;
import org.eclipse.epsilon.util.emf.EmfRegistryManager;
import org.eclipse.epsilon.workflow.tasks.EpsilonTask;

public class RegisterTask extends EpsilonTask {
	
	protected File file;
	protected boolean permanently = false;
	
	@Override
	public void executeImpl() throws BuildException {
		if (!file.exists()) {
			fail("File " + file.getAbsolutePath() + " doesn't exist", null);
		}
		
		try {
			EmfUtil.register(URI.createFileURI(file.getAbsolutePath()), EPackage.Registry.INSTANCE);
			if (permanently) {
			    // Map the absolute path to this file to an IFile
			    java.net.URI location = file.toURI();
			    IFile[] workspaceFiles
			      = ResourcesPlugin.getWorkspace().getRoot()
			                       .findFilesForLocationURI(location);
			    if (workspaceFiles.length == 0) {
			      fail("File " + file.getAbsolutePath()
			           + " is not available in the current workspace", null);
			    }
			    else {
			      // getFullPath() returns the workspace relative path
			      // addMetamodel needs (as it uses URI#createPlatformResourceURI)
				  EmfRegistryManager.getInstance().addMetamodel(
				      workspaceFiles[0].getFullPath().toString());
			    }
			}
		} catch (Exception e) {
			fail(e.getMessage(), e);
		}

	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public boolean isPermanently() {
		return permanently;
	}

	public void setPermanently(boolean permanently) {
		this.permanently = permanently;
	}
	
	
	
}
