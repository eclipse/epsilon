package org.eclipse.epsilon.examples.picto.xtext.domainmodel.picto;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.epsilon.picto.dom.Picto;
import org.eclipse.epsilon.picto.dom.PictoFactory;
import org.eclipse.epsilon.picto.source.EglPictoSource;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.workspace.WorkspaceLockAccess.Result;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

public class DmodelPictoSource extends EglPictoSource {
	
	@Override
	protected Picto getRenderingMetadata(IEditorPart editorPart) {
		Picto metadata = PictoFactory.eINSTANCE.createPicto();
		metadata.setTransformation("platform:/plugin/org.eclipse.epsilon.examples.picto.xtext.domainmodel.picto/dmodel.egx");
		return metadata;
	}

	@Override
	protected Resource getResource(IEditorPart editorPart) {
		XtextEditor editor = (XtextEditor) editorPart;
		final XtextResourceHolder holder = new XtextResourceHolder();
		editor.getDocument().readOnly(new IUnitOfWork<Result, XtextResource>() {
			public Result exec(XtextResource state) throws Exception {
				holder.setResource(state);
				return null;
			};
		});
		
		return holder.getResource();
	}

	@Override
	protected IFile getFile(IEditorPart editorPart) {
		IEditorInput editorInput = ((XtextEditor) editorPart).getEditorInput();
		if (editorInput instanceof IFileEditorInput) {
			return ((IFileEditorInput) editorInput).getFile();
		}
		return null;
	}

	@Override
	protected boolean supportsEditorType(IEditorPart editorPart) {
		return editorPart instanceof XtextEditor && 
			editorPart.getTitle().endsWith(".dmodel");
	}
	
	@Override
	public void showElement(String id, String uri, IEditorPart editor) {}

}
