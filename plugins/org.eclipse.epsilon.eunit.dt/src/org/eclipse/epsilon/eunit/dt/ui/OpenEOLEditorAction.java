package org.eclipse.epsilon.eunit.dt.ui;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.dt.editor.EolEditor;
import org.eclipse.epsilon.eunit.dt.EUnitPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

abstract class OpenEOLEditorAction extends Action {
	public OpenEOLEditorAction() {
		super("Open in EOL editor");
	}

	protected void openInEOLEditor(AST astNode) {
		File astFile = astNode.getFile();

		IFile[] workspaceFiles = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(astFile.toURI());
		if (workspaceFiles.length > 0) {
			final IFile workspaceFile = workspaceFiles[0];

			final IWorkbench workbench = PlatformUI.getWorkbench();
			final IWorkbenchPage page = workbench.getActiveWorkbenchWindow().getActivePage();
			final IEditorDescriptor desc = workbench.getEditorRegistry().findEditor(EolEditor.ID);
			try {
				final IEditorPart editor = page.openEditor(new FileEditorInput(workspaceFile), desc.getId());
				if (editor instanceof ITextEditor) {
					final ITextEditor textEditor = (ITextEditor)editor;

					final IDocumentProvider provider = textEditor.getDocumentProvider();
					final IDocument document= provider.getDocument(textEditor.getEditorInput());

					// Lines reported by AST seem to be off by one
					int lineOffset = document.getLineOffset(astNode.getLine() - 1);
					textEditor.selectAndReveal(lineOffset + astNode.getColumn(), 0);

					Display.getDefault().asyncExec(new Runnable(){
						public void run() {
							page.activate(editor);
						}
					});
				}
			} catch (Exception e) {
				EUnitPlugin.getDefault().logException(e);
			}
		}
	}
}