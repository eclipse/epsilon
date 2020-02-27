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

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.epsilon.picto.PictoSource;
import org.eclipse.epsilon.picto.dom.Picto;
import org.eclipse.epsilon.picto.dom.PictoFactory;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public abstract class SimpleSource implements PictoSource {

	public abstract String getFormat();
	
	public abstract String getFileExtension();
	
	@Override
	public Picto getRenderingMetadata(IEditorPart editorPart) {
		Picto metadata = PictoFactory.eINSTANCE.createPicto();
		metadata.setTemplate(getFile(editorPart).getLocation().toOSString());
		metadata.setFormat(getFormat());
		return metadata;
	}

	@Override
	public Resource getResource(IEditorPart editorPart) {
		return new ResourceImpl();
	}

	@Override
	public boolean supports(IEditorPart editorPart) {
		IFile file = getFile(editorPart);
		if (file == null) return false;
		return file.getLocation().getFileExtension().equalsIgnoreCase(getFileExtension());
	}

	@Override
	public IFile getFile(IEditorPart editorPart) {
		if (editorPart.getEditorInput() instanceof IFileEditorInput) {
			IFileEditorInput input = (IFileEditorInput)editorPart.getEditorInput();
			return input.getFile();
		}
		return null;
	}
	
	@Override
	public void showElement(String id, String uri, IEditorPart editor) {
		throw new UnsupportedOperationException();
	}
	
}
