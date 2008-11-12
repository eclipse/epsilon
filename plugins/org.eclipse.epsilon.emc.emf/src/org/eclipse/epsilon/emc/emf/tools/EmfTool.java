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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.epsilon.emc.emf.EmfModelResourceSet;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.tools.AbstractTool;

public class EmfTool extends AbstractTool{
	
	/*
	public void getAllContents(EObject o) {
		
		//System.err.println(o.eAllContents() instanceof List);
		
		EObject lim = null;
		Iterator<?> it = o.eAllContents();
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.createResource(null);
		while (it.hasNext()) {
			context.getOutputStream().println(it.next());
		}
	}
	*/
	/*
	public Resource putInNewResource(EObject eObject) {
		ResourceSet rs = new ResourceSetImpl();
		EPackage ePackage = eObject.eClass().getEPackage();
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(ePackage.getNsURI(), ePackage);
		Resource r = rs.createResource(URI.createFileURI(""));
		r.getContents().add(eObject);
		return r;
	}
	*/
	
	public EcoreUtil getECoreUtil() {
		return new EcoreUtil();
	}
	
	public Map<EObject, Collection<EStructuralFeature.Setting>> getCrossReferences(Object eObject) {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(eObject);
		return CrossReferencer.find(list);
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
	
	public EPackage getEPackage(String nsUri) {
		return EPackage.Registry.INSTANCE.getEPackage(nsUri);
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
