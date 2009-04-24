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
package org.eclipse.epsilon.hutn.xmi.dt.actions;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.epsilon.common.dt.actions.AbstractObjectActionDelegate;
import org.eclipse.epsilon.common.dt.console.EpsilonConsole;
import org.eclipse.epsilon.hutn.xmi.HutnXmiBridgeException;
import org.eclipse.epsilon.hutn.xmi.Xmi2Hutn;
import org.eclipse.jface.action.IAction;

public class GenerateHutn extends AbstractObjectActionDelegate {

	private IFile file;
	private String hutn;
	
	@Override
	public void run(IAction action) {
		try {
			if (getFirstElementInSelection() instanceof IFile) {
				file = (IFile)getFirstElementInSelection();
				
				generateHutn();
				storeHutnInFile();
				
				refreshProject();
			}
			
		} catch (Exception e) {
			EpsilonConsole.getInstance().getErrorStream().println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
	
	private void generateHutn() throws HutnXmiBridgeException {
		hutn = new Xmi2Hutn(file.getRawLocationURI()).getHutn();
	}
	
	
	private void storeHutnInFile() throws UnsupportedEncodingException, CoreException {
		final IFile hutnFile = file.getProject().getFile(file.getParent().getProjectRelativePath().toString() + "/" + getFilePrefix() + ".hutn");
		
		final InputStream hutnStream = new ByteArrayInputStream(hutn.getBytes("UTF-8"));
		
		if (hutnFile.exists()) {
			hutnFile.setContents(hutnStream, IResource.NONE, null);
		} else {
			hutnFile.create(hutnStream, IResource.NONE, null);
		}
	}
	
	private String getFilePrefix() {
		return file.getLocation().removeFileExtension().lastSegment();
	}
	
	
	private void refreshProject() throws CoreException {
		file.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
	}

}
