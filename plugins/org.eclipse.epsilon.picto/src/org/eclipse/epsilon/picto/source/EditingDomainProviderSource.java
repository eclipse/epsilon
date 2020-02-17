/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto.source;

import java.util.Arrays;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.presentation.EcoreEditor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

public class EditingDomainProviderSource extends ExternalMetadataSource {

	@Override
	public Resource getResource(IEditorPart editorPart) {
		return ((IEditingDomainProvider) editorPart).getEditingDomain().getResourceSet().getResources().get(0);
	}

	@Override
	public boolean supports(IEditorPart editorPart) {
		return editorPart instanceof IEditingDomainProvider;
	}

	@Override
	public IFile getFile(IEditorPart editorPart) {
		IEditorInput input = editorPart.getEditorInput();
		if (input instanceof IFileEditorInput) {
			return ((IFileEditorInput)input).getFile();
		}
		else 
			return null;
	}

	@Override
	public void showElement(String id, String uri, IEditorPart editor) {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().activate(editor);
		IEditingDomainProvider editingDomainProvider = (IEditingDomainProvider) editor;
		Resource resource = editingDomainProvider.getEditingDomain().getResourceSet().getResource(URI.createURI(uri), true);
		EObject eObject = resource.getEObject(id);
		if (editor instanceof EcoreEditor) {
			((EcoreEditor) editor).setSelectionToViewer(Arrays.asList(eObject));
			editor.setFocus();
		}
	}
 
}
