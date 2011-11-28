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
package org.eclipse.epsilon.egl.dt.traceability.editor;


import java.io.File;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.epsilon.egl.dt.traceability.fine.emf.textlink.TextlinkPackage;
import org.eclipse.epsilon.emc.emf.EmfModel;
import org.eclipse.epsilon.emc.emf.EmfModelFactory;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.ui.part.FileEditorInput;

// FIXME duplication with ModelLinkStarter

public class TextLinkEditorStarter extends EditorPart {

	@Override
	public void doSave(IProgressMonitor monitor) {

	}

	@Override
	public void doSaveAs() {

	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		setSite(site);
		setInput(input);
		startTraceAwareEditor();
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public void createPartControl(Composite parent) {

	}

	protected void startTraceAwareEditor() throws PartInitException {
		final PartInitException[] ex = new PartInitException[1];
		final TextLinkEditorStarter starter = this;
		
		Display.getDefault().asyncExec(new Runnable() {

			public void run() {
				getSite().getPage().closeEditor(starter, false);
				try {
					final FileEditorInput editorInput = (FileEditorInput)starter.getEditorInput();
					final EmfModel textlinkModel = EmfModelFactory.getInstance().loadEmfModel("Textlink",
					                                                                          new File(editorInput.getPath().toOSString()),
					                                                                          TextlinkPackage.eINSTANCE);
					getSite()
							.getPage()
							.openEditor(
									new FileEditorInputConverter(new TextLinkModel(textlinkModel, editorInput.getName())).convert(),
									"org.eclipse.epsilon.egl.dt.traceability.editor.EglTraceAwareEditor");
					

				} catch (Exception e) {
					ex[0] = new PartInitException("Error encountered whilst loading Textlink model at: " + starter.getEditorInput());
				}
			}

		});
		
		if (ex[0] != null) {
			throw ex[0];
		}
	}

	@Override
	public void setFocus() {

	}

}
