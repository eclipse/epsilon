/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.hutn.dt.editor;

import org.eclipse.epsilon.util.emf.EmfRegistryManager;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.editors.text.TextEditor;

public class HutnEditor extends TextEditor {
		 
	private final HutnSourceViewerConfiguration configuration = new HutnSourceViewerConfiguration(this);
	
	public HutnEditor() {
		setSourceViewerConfiguration(configuration);
		setDocumentProvider(new HutnDocumentProvider());
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		super.init(site, input);
		
		// Force registration of meta-models
		EmfRegistryManager.getInstance();
		
		// Detect keywords and syntax highlight document
		configuration.reconcile(getDocument());
	}
	
	private IDocument getDocument() {
		return getEditorInput() == null ? null : getDocumentProvider().getDocument(getEditorInput());
	}
}
