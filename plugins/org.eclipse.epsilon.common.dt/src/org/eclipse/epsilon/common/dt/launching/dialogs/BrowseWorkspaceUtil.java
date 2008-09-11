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

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.ResourceListSelectionDialog;
import org.eclipse.ui.model.BaseWorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class BrowseWorkspaceUtil {
	
	public static String browseFilePath(Shell shell, String title, String message, String filter, Image image){
		
		IFile file = browseFile(shell, title, message, filter, image);
		if (file != null) {
			return file.getFullPath().toString();
		}
		else {
			return null;
		}
	}
	/*
	public static IFile browseFile(Shell shell, String title, String message, String filter, Image image){
		ElementTreeSelectionDialog elementSelector = new ElementTreeSelectionDialog(shell, new WorkbenchLabelProvider() ,new BaseWorkbenchContentProvider());
		elementSelector.addFilter(new ExtensionViewerFilter(filter));
		elementSelector.setInput(ResourcesPlugin.getWorkspace().getRoot());
		elementSelector.setTitle(title);
		elementSelector.setMessage(message);
		elementSelector.setAllowMultiple(false);
		elementSelector.setImage(image);
		elementSelector.open();
		
		if (elementSelector.getReturnCode() == ElementTreeSelectionDialog.OK){
			IFile f = (IFile) elementSelector.getFirstResult();
			//return f.getLocation().toOSString();
			return f;
		}
		else {
			return null;
		}
	}
	*/
	public static IFile browseFile(Shell shell, String title, String message, String filter, Image image){
		
		ResourceListSelectionDialog elementSelector = new ResourceListSelectionDialog(shell, ResourcesPlugin.getWorkspace().getRoot(), IResource.DEPTH_INFINITE | IResource.FILE );
		//elementSelector.setElements(ResourcesPlugin.getWorkspace().getRoot().get)
		//elementSelector.addFilter(new ExtensionViewerFilter(filter));
		//elementSelector.setInput(ResourcesPlugin.getWorkspace().getRoot());
		elementSelector.setTitle(title);
		elementSelector.setMessage(message);
		//elementSelector.setAllowMultiple(false);
		//elementSelector.setImage(image);
		elementSelector.open();
		
		if (elementSelector.getReturnCode() == Window.OK){
			IFile f = (IFile) elementSelector.getResult()[0];
			//return f.getLocation().toOSString();
			return f;
		}
		else {
			return null;
		}
	}
	
	
	public static Object[] browseFiles(Shell shell, String title, String message, String filter, Image image){
		ElementTreeSelectionDialog elementSelector = new ElementTreeSelectionDialog(shell, new WorkbenchLabelProvider() ,new BaseWorkbenchContentProvider());
		elementSelector.addFilter(new ExtensionViewerFilter(filter));
		elementSelector.setInput(ResourcesPlugin.getWorkspace().getRoot());
		elementSelector.setTitle(title);
		elementSelector.setMessage(message);
		elementSelector.setAllowMultiple(true);
		elementSelector.setImage(image);
		elementSelector.open();
		
		if (elementSelector.getReturnCode() == Window.OK){
			//IFile f = (IFile) elementSelector.getFirstResult();
			return elementSelector.getResult();
			
		}
		else {
			return null;
		}
	}
	
	static class ExtensionViewerFilter extends ViewerFilter{
		
		String filter = "";
		
		public ExtensionViewerFilter(String filter){
			this.filter = filter;
		}
		
		@Override
		public boolean select(Viewer viewer, Object parentElement, Object element) {
			if (element instanceof IContainer) return true;
			if (element instanceof IResource){
				if (filter.length() > 0)
					return (((IResource) element).getName().endsWith(filter));
				else
					return true;
			}
			return false;
		}
		
	}
	
}
