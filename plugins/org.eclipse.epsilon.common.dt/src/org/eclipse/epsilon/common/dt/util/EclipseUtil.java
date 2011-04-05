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
package org.eclipse.epsilon.common.dt.util;

import java.io.File;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public class EclipseUtil {

	public EclipseUtil() {
		super();
	}
	
	public static IResource[] getAllResources() {
		try {
			IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for (IProject project : projects) {
				
			}
			return null;
		}
		catch (Exception ex) {
			return new IResource[]{};
		}
	}
	
	public static String getWorkspacePath()  {
		return ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString();
	}
	
	public static String getWorkspaceFileAbsolutePath(String workspacePath) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(workspacePath)).getLocation().toOSString();
	}
	
	public static void openEditorAt(File file, int line, int column, boolean highlightLine) {
		
		if (file == null) return;
		
		String fileName = file.getAbsolutePath();
		
		IFile iFile = (IFile) ResourcesPlugin.getWorkspace().getRoot().findFilesForLocation(new Path(fileName))[0];
		
		openEditorAt(iFile, line, column, highlightLine);
		
	}
	
	public static void openEditorAt(final IFile file, final int line, final int column, final boolean highlightLine) {
		
		if (file == null) return;
		
		final FileEditorInput fileinput=new FileEditorInput(file);
		
		final IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
		
		PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {

			public void run() {
				try {
					
					int realLine = line;
					if (realLine == 0) realLine = 1;
					
					AbstractTextEditor editor = (AbstractTextEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(fileinput,desc.getId(), false);		
					IDocument doc = editor.getDocumentProvider().getDocument(fileinput);
					
					if (highlightLine) {
						editor.selectAndReveal(doc.getLineOffset(realLine - 1),doc.getLineLength(realLine - 1) - 1);
					}
					else {
						editor.selectAndReveal(doc.getLineOffset(realLine - 1) + column - 1,0);
					}
					//TODO : Make it highlight lines
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}				
			}
			
		});
		
	}

}
