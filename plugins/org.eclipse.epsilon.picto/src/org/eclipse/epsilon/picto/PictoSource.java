package org.eclipse.epsilon.picto;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.ui.IEditorPart;

public interface PictoSource {

	public PictoMetadata getRenderingMetadata(IEditorPart editorPart);
	
	public Resource getResource(IEditorPart editorPart);
	
	public boolean supports(IEditorPart editorPart);
	
	public IFile getFile(IEditorPart editorPart);
	
}
