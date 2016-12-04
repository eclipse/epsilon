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
package org.eclipse.epsilon.common.dt.launching.dialogs;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ContainerSelectionDialog;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;

public class BrowseWorkspaceUtil {
	
	public static String browseContainerPath(Shell shell, String title, String message){
		
		IPath container = browseContainer(shell, title, message);
		if (container != null) {
			return container.toString();
		}
		else {
			return null;
		}
	}
	
	public static IPath browseContainer(Shell shell, String title, String message){
		
		ContainerSelectionDialog dialog = new ContainerSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), true, message);
		
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.open();
		
		if (dialog.getReturnCode() == Window.OK){
			IPath path = (IPath) dialog.getResult()[0];
			return path;
		}
		else {
			return null;
		}
	}
	
	public static String browseFilePath(Shell shell, String title, String message, String filter, Image image){
		
		IFile file = browseFile(shell, title, message, filter, image);
		if (file != null) {
			return file.getFullPath().toString();
		}
		else {
			return null;
		}
	}
	
	public static IFile browseFile(Shell shell, String title, String message, String filter, Image image){
		
		ResourceListSelectionDialog dialog = new ResourceListSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), IResource.DEPTH_INFINITE | IResource.FILE );
		dialog.setTitle(title);
		dialog.setMessage(message);
		dialog.open();
		
		if (dialog.getReturnCode() == Window.OK){
			IFile f = (IFile) dialog.getResult()[0];
			return f;
		}
		else {
			return null;
		}
	}
	
}
