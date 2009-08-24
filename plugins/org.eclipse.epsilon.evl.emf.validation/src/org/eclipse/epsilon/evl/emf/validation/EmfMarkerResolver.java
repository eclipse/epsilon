/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.evl.emf.validation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Path;
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

	public boolean canResolve(IMarker marker) {
		try {
			return marker.getType().equals("org.eclipse.emf.ecore.diagnostic");
		} catch (CoreException e) {
			return false;
		}
	}

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
		final String filePath = getElementResourceLocation(marker);
		
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePath));
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
	
	protected String getElementResourceLocation(IMarker marker) {		
		final String location = getAbsoluteElementId(marker).split("#")[0];

		if (location.startsWith("platform:/resource")) {
			return location.split("platform:/resource")[1];
		} else {
			return location;
		}
	}
	
	public String getRelativeElementId(IMarker marker) {
		String[] parts = getAbsoluteElementId(marker).split("#");
		return parts[1];
	}
	
	public String getAbsoluteElementId(IMarker marker) {
		return marker.getAttribute("uri", "");
	}

	public String getMessage(IMarker marker) {
		return marker.getAttribute("message", "");
	}

}
