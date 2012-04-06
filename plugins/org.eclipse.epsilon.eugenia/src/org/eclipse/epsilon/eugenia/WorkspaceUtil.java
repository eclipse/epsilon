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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;

public class WorkspaceUtil {
	
	public static IFile getFile(String path) {
		try {
			return ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(
					new java.net.URI(path))[0];
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public static void waitFor(String path) {
		try {
			IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(new java.net.URI(path));
			for (IFile file : files) {
				while (!file.exists()) {
					file.getParent().refreshLocal(1, null);
				}
			}
			return;
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
