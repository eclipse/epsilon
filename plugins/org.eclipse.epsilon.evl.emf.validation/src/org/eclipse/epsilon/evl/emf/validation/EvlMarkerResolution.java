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

import java.util.Collections;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.evl.EvlFixInstance;
import org.eclipse.ui.IMarkerResolution;

public class EvlMarkerResolution implements IMarkerResolution {
	
	protected String label;
	protected EvlFixInstance fix;
	protected String elementId;
	protected String modelName;
	
	public EvlMarkerResolution(String elementId, EvlFixInstance fix, String modelName) {
		try {
			this.label = fix.getTitle();
			this.fix = fix;
			this.elementId = elementId;
			this.modelName = modelName;
		} catch (EolRuntimeException e) {
			e.printStackTrace();
		}
	}

	public String getLabel() {
		return label;
	}

	public void run(IMarker marker) {
		
		EObject self = EvlMarkerResolverManager.INSTANCE.resolve(marker); //getEObject(elementId);
		
		try {
			
			fix.setSelf(self);
			InMemoryEmfModel model = new InMemoryEmfModel(modelName, self.eResource());
			fix.getContext().getModelRepository().addModel(model);
			
			EvlMarkerResolverManager.INSTANCE.getEditingDomain(marker).getCommandStack().execute(new ExecuteEvlFixCommand(fix, model));
			
			// 286126 - save resource so that any open GMF diagram editors are automatically refreshed
			// see also: http://dev.eclipse.org/newslists/news.eclipse.modeling.gmf/msg04508.html
			//self.eResource().save(Collections.EMPTY_MAP);
			self.eResource().setModified(true);
			
			model.dispose();
			marker.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//protected EditingDomain domain;
	/*
	private EObject getEObject(String elementId) {
		
		EObject self = null;
		String[] parts = elementId.split("#");
		
		URI uri = URI.createURI(parts[0]);
		String filePath = uri.toPlatformString(true);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(filePath));
		String editorId = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(filePath).getId();
		IEditorPart part = null;
		
		try {
			part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new FileEditorInput(file), editorId);
		} catch (PartInitException e1) {
			return null;
		}
		
		if (part instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) part).getEditingDomain();
			ResourceSet resourceSet = ((IEditingDomainProvider) part).getEditingDomain().getResourceSet();
			Resource resource = resourceSet.getResources().get(0);
			self = resource.getEObject(parts[1]);
		}
		
		return self;
		
	}
	*/
}
