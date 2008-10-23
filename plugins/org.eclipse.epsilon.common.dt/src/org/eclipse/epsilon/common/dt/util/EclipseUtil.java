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
	
	public static void openEditorAt(File file, int line, int column, boolean highlightLine) {
		
		if (file == null) return;
		
		String fileName = file.getAbsolutePath();
		//String workbenchPath = ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toOSString();
		//String relateivePath = fileName.replace(workbenchPath,"");
		
		//if (relateivePath.equalsIgnoreCase(fileName)) {
			//File outside the workspace
		//	ResourcesPlugin.getWorkspace().getRoot().findFilesForLocation(new Path)
		//}
		
		//IFile res=(IFile)ResourcesPlugin.getWorkspace().getRoot().
		//findMember(new Path(relateivePath));
		//findMember(new Path(fileName));
		
		IFile res=(IFile)ResourcesPlugin.getWorkspace().getRoot().findFilesForLocation(new Path(fileName))[0];
		
		if (res == null) return;
		
		FileEditorInput fileinput=new FileEditorInput(res);
		IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(fileName);
		try {
			AbstractTextEditor editor = (AbstractTextEditor) PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(fileinput,desc.getId());		
			IDocument doc = editor.getDocumentProvider().getDocument(fileinput);
			
			if (line == 0) line = 1;
			
			if (highlightLine) {
				editor.selectAndReveal(doc.getLineOffset(line - 1),doc.getLineLength(line - 1) - 1);
			}
			else {
				editor.selectAndReveal(doc.getLineOffset(line - 1) + column - 1,0);
			}
			//TODO : Make it highlight lines
		}
		catch (Exception ex) {
			// Ignore
		}
	}
	
}
