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
package org.eclipse.epsilon.emc.emf.tools;

import java.io.IOException;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.epsilon.emc.emf.EmfModelResourceSet;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.tools.AbstractTool;

public class EmfTool extends AbstractTool{
	
	public void getAllContents(EObject o) {
		
		//System.err.println(o.eAllContents() instanceof List);
		
		Iterator<?> it = o.eAllContents();
		
		while (it.hasNext()) {
			context.getOutputStream().println(it.next());
		}
	}
	
	public void createModel(EObject eObject, String name) {
		IModel model = context.getModelRepository().getModelByNameSafe(name);
		if (model == null) {
			model = new InMemoryEmfModel(name, eObject.eResource());
			context.getModelRepository().addModel(model);
		}
	}
	
	public void registerEPackage(EPackage ePackage) {
		EPackage.Registry.INSTANCE.put(ePackage.getNsURI(), ePackage);
	}
	
	public Object validate(EObject eObject) {
		return Diagnostician.INSTANCE.validate(eObject);
	}
	
	
	public boolean resourceExists(String uri) {
		return new EmfModelResourceSet().getURIConverter().exists(URI.createURI(uri, true), null);
	}
	
	public boolean modelElementExists(String uri) throws IOException {
		try {
			return getEObject(uri) != null;
		
		} catch (IllegalArgumentException e) {
			if (e.getMessage().endsWith("is not a valid feature")) {
				return false;
			
			} else {
				throw e;
			}
		}
	}
	
	public EObject getEObject(String uri) throws IOException {
		final String modelUri   = uri.split("#")[0];
		final String elementUri = uri.split("#")[1];
		
		final URI platformResourceUri = URI.createURI(modelUri, true);
		
		final Resource model = new EmfModelResourceSet().createResource(platformResourceUri);
		
		if (model == null) return null;
		
		model.load(null); // null, as we're not setting any load options
		
		return model.getEObject(elementUri);
	}
}
