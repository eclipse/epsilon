/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eugenia;

import java.net.URI;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.jface.action.IAction;

public class ClearGmfFileSetAction extends EugeniaActionDelegate {
	
	protected boolean clearGmfFiles = true;
	
	@Override
	public void runImpl(IAction action) throws Exception {
		delete(gmfFileSet.getGenModelPath());
		if (clearGmfFiles) {
			delete(gmfFileSet.getGmfGraphPath());
			delete(gmfFileSet.getGmfToolPath());
			delete(gmfFileSet.getGmfMapPath());
			delete(gmfFileSet.getGmfGenPath());
		}
		refresh();
	}
	
	public ClearGmfFileSetAction setClearGmfFiles(boolean clearGmfFiles) {
		this.clearGmfFiles = clearGmfFiles;
		return this;
	}
	
	@Override
	public EugeniaActionDelegateStep getStep() {
		return EugeniaActionDelegateStep.clean;
	}
	
	public void delete(String path) {
		try {
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(new URI(path));
			for (IFile file : files) {
				file.delete(true, new NullProgressMonitor());
			}
		} catch (Exception ex) {
			// Ignore
		}
	}
	
	@Override
	public String getBuiltinTransformation() {
		return null;
	}

	@Override
	public String getCustomizationTransformation() {
		return null;
	}

	@Override
	public List<IModel> getModels() throws Exception {
		return null;
	}

	@Override
	public String getTitle() {
		return "Cleaning up generating models";
	}
	
}
