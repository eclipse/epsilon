package org.eclipse.epsilon.picto.source;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

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

}
