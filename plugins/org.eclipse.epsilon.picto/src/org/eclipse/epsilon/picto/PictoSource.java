/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.picto;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.picto.dom.Picto;
import org.eclipse.ui.IEditorPart;

public interface PictoSource {

	public Picto getRenderingMetadata(IEditorPart editorPart);
	
	public Resource getResource(IEditorPart editorPart);
	
	public boolean supports(IEditorPart editorPart);
	
	public IFile getFile(IEditorPart editorPart);
	
	public void showElement(String id, String uri, IEditorPart editor);
	
}
