package org.eclipse.epsilon.picto.source;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.epsilon.common.dt.util.EclipseUtil;
import org.eclipse.epsilon.common.dt.util.LogUtil;
import org.eclipse.epsilon.flexmi.EObjectLocation;
import org.eclipse.epsilon.flexmi.FlexmiResource;
import org.eclipse.epsilon.flexmi.FlexmiResourceFactory;
import org.eclipse.epsilon.flexmi.dt.FlexmiEditor;
import org.eclipse.epsilon.picto.PictoMetadata;
import org.eclipse.epsilon.picto.PictoSource;
import org.eclipse.ui.IEditorPart;
import org.w3c.dom.ProcessingInstruction;

public class FlexmiSource implements PictoSource {

	@Override
	public PictoMetadata getRenderingMetadata(IEditorPart editorPart) {
		FlexmiResource resource = (FlexmiResource) getResource(editorPart);
		ProcessingInstruction renderProcessingInstruction = (ProcessingInstruction) ((FlexmiResource) resource).
					getProcessingInstructions().stream().filter(p -> p.getTarget().startsWith("render-")).findFirst().orElse(null);
		if (renderProcessingInstruction != null) {
			PictoMetadata metadata = new PictoMetadata();
			metadata.setFormat(renderProcessingInstruction.getTarget().substring("render-".length()));
			metadata.setFile(renderProcessingInstruction.getData().trim());
			return metadata;
		}
		return null;
	}

	@Override
	public Resource getResource(IEditorPart editorPart) {
		IFile file = getFile(editorPart);
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new FlexmiResourceFactory());
		Resource resource = resourceSet.createResource(URI.createFileURI(file.getLocation().toOSString()));
		try {
			resource.load(null);
			return resource;
		} catch (IOException e) {
			LogUtil.log(e);
		}
		return null;
	}

	@Override
	public boolean supports(IEditorPart editorPart) {
		return editorPart instanceof FlexmiEditor;
	}

	@Override
	public IFile getFile(IEditorPart editorPart) {
		return ((FlexmiEditor) editorPart).getFile();
	}
	
	@Override
	public void showElement(String id, String uri, IEditorPart editor) {
		EObject eObject = getResource(editor).getEObject(id);
		FlexmiResource resource = (FlexmiResource) eObject.eResource();
		EObjectLocation location = resource.getEObjectTraceManager().getLine(eObject);
		
		try {
			EclipseUtil.openEditorAt(new File(new java.net.URI(location.getUri().toString())), location.getLine(), 0, false);
		} catch (URISyntaxException e) {
			LogUtil.log(e);
		}
		
	}
	
}
