package org.eclipse.epsilon.evl.emf.validation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

public class EmfMarkerResolver implements IEvlMarkerResolver {

	@Override
	public boolean canResolve(IMarker marker) {
		try {
			return marker.getType().equals("org.eclipse.emf.ecore.diagnostic");
		} catch (CoreException e) {
			return false;
		}
	}

	@Override
	public EObject resolve(IMarker marker) {
		EObject self = null;
		ResourceSet resourceSet = getEditingDomain(marker).getResourceSet();
		for (Resource resource : resourceSet.getResources()) {
			EObject temp = resource.getEObject(getRelativeElementId(marker));
			if (temp != null) {
				self = temp;
				break;
			}
		}
		return self;
	}
	
	public EditingDomain getEditingDomain(IMarker marker) {
		String filePath = getElementResourceLocation(marker);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(getElementResourceLocation(marker)));
		String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(filePath).getId();
		IEditorPart part = null;
		
		try {
			part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new FileEditorInput(file), editorId, false);
		} catch (PartInitException e1) {
			return null;
		}
		
		return getEditingDomain(part);

	}
	
	public EditingDomain getEditingDomain(IEditorPart editor) {
		if (editor instanceof IEditingDomainProvider) {
			return ((IEditingDomainProvider) editor).getEditingDomain();
		}
		else {
			return null;
		}		
	}
	
	public String getElementResourceLocation(IMarker marker) {
		String[] parts = getAbsoluteElementId(marker).split("#");
		URI uri = URI.createURI(parts[0]);
		//System.err.println("EMF " + parts[0]);
		return uri.toPlatformString(true);
		
	}
	
	public String getRelativeElementId(IMarker marker) {
		String[] parts = getAbsoluteElementId(marker).split("#");
		return parts[1];
	}
	
	@Override
	public String getAbsoluteElementId(IMarker marker) {
		return marker.getAttribute("uri", "");
	}

	@Override
	public String getMessage(IMarker marker) {
		return marker.getAttribute("message", "");
	}

}
