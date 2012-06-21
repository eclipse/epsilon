/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - add findIFile(AST) and openEditorAt(AST)
 ******************************************************************************/
package org.eclipse.epsilon.common.dt.util;

import java.io.File;
import java.net.URI;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.epsilon.common.dt.EpsilonCommonsPlugin;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.AbstractTextEditor;

public class EclipseUtil {

	private EclipseUtil() {}

	public static IFile findIFile(AST ast) {
		if (ast == null) {
			return null;
		}

		final IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		if (ast.getFile() != null) {
			final Path path = new Path(ast.getFile().getAbsolutePath());
			return workspaceRoot.getFileForLocation(path);
		}
		if (ast.getUri() != null) {
			try {
				final URI fileURI = FileLocator.toFileURL(ast.getUri().toURL()).toURI();
				final IFile[] files = workspaceRoot.findFilesForLocationURI(fileURI);
				if (files.length > 0) {
					return files[0];
				}
			} catch (Exception ex) {
				EpsilonCommonsPlugin.getDefault().logException(ex);
			}
		}

		return null;
	}

	public static String getWorkspacePath()  {
		return ResourcesPlugin.getWorkspace().getRoot().getRawLocation().toPortableString();
	}
	
	public static String getWorkspaceFileAbsolutePath(String workspacePath) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(workspacePath)).getLocation().toOSString();
	}

	public static void openEditorAt(AST astNode) {
		final IFile file = findIFile(astNode);
		if (file != null) {
			openEditorAt(file, astNode.getLine(), astNode.getColumn(), true);
		}
	}

	public static void openEditorAt(File file, int line, int column, boolean highlightLine) {
		if (file == null) return;
		IFile iFile = (IFile) ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(file.toURI())[0];
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
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}				
			}
		});
	}

}
