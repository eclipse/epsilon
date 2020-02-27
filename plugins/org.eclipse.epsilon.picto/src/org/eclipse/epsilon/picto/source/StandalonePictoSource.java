package org.eclipse.epsilon.picto.source;

import org.eclipse.epsilon.picto.dom.Picto;
import org.eclipse.ui.IEditorPart;

public class StandalonePictoSource extends SimpleSource {

	@Override
	public String getFormat() {
		return null;
	}

	@Override
	public String getFileExtension() {
		return "picto";
	}
	
	@Override
	public Picto getRenderingMetadata(IEditorPart editorPart) {
		return new EditingDomainProviderSource().getRenderingMetadata(getFile(editorPart));
	}
	
	@Override
	public boolean supports(IEditorPart editorPart) {
		if (!super.supports(editorPart)) return false;
		Picto picto = new EditingDomainProviderSource().getRenderingMetadata(getFile(editorPart));
		return picto != null && picto.isStandalone();
	}
	
	
	
}
