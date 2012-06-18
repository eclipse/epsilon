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
package org.eclipse.epsilon.emc.emf;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EmfModelResourceFactory extends XMIResourceFactoryImpl {
	
	protected static EmfModelResourceFactory instance;
	protected HashMap<String, Resource> resourceMap;
	
	public static EmfModelResourceFactory getInstance() {
		if (instance == null) {
			instance = new EmfModelResourceFactory();
		}
		return instance;
	}
	
	private EmfModelResourceFactory() {
		resourceMap = new HashMap<String, Resource>();
	}
	
	@Override
	public Resource createResource(URI uri) {
		
		if (resourceMap.containsKey(uri.toString())) {
			return resourceMap.get(uri.toString());
		}
		else {
			
			Factory resourceFactory = Resource.Factory.Registry.INSTANCE.getFactory(uri);
			
			Resource resource = null;
			
			if (resourceFactory != null && resourceFactory.getClass() != XMIResourceFactoryImpl.class) {
				resource = resourceFactory.createResource(uri);
			}
			else {
				resource = new EmfXMIResource(uri);
			}
			
			if (resource instanceof XMLResource) {
				configure((XMLResource)resource);
			}
			
			resource.setTrackingModification(false);
			resourceMap.put(uri.toString(), resource);
			return resource;
			
		}
	}
	
	public void configure(XMLResource resource) {
		Map<Object, Object> loadOptions = resource.getDefaultLoadOptions();
		//loadOptions.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
		//loadOptions.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
		loadOptions.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
	}
	
	public void removeCachedResource(URI uri) {
		
		Resource toRemove = resourceMap.get(uri.toString());
		
		if (toRemove != null) {
			safeRemove(toRemove);
		}
	}
	
	protected void safeRemove(Resource toRemove) {
		
		if (!resourceMap.containsValue(toRemove)) return;
		boolean shouldRemove = true;
		for (Resource resource : resourceMap.values()) {
			if (resource.getResourceSet() != null 
					&& toRemove.getResourceSet() != null
					&& resource.getResourceSet() != toRemove.getResourceSet() 
					&& resource.getResourceSet().getResources().contains(toRemove)) {
				
				shouldRemove = false;
				break;
			}
		}
		if (shouldRemove) {

			resourceMap.remove(toRemove.getURI().toString());
			try {
				toRemove.unload();
			}
			catch (Exception ex) {}
			
			if (toRemove.getResourceSet() != null) {
				for (Resource resource : toRemove.getResourceSet().getResources()) {
					safeRemove(resource);
				}
			}
		}
	}
	
	protected String toString(String header) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(header + "\r\n");
		for (String key : resourceMap.keySet()) {
			buffer.append("+ " + key + "->" + resourceMap.get(key) + "\r\n");
		}
		return buffer.toString();
	}
	
}
