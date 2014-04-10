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

import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EmfWorkbench {
	
	private ResourceSet resourceSet;
	
	public static void main(String[] args) throws Exception{
		
		String basePath = "E:\\Projects\\Eclipse\\3.3.e\\workspace\\org.eclipse.epsilon.eol.cs2as\\src\\org\\epsilon\\eol\\cs2as\\";
		
		
		EmfModel m1 = new EmfModel();
			
		m1.setModelFile(basePath + "VM.model");
		m1.setMetamodelFile(basePath + "EOL.ecore");
		m1.setMetamodelFileBased(true);
		m1.setReadOnLoad(true);
		
		m1.load();
		
		EmfModel m2 = new EmfModel();
		
		m2.setModelFile(basePath + "EOL.ecore");
		m2.setMetamodelUri(EcorePackage.eNS_URI);
		m2.setMetamodelFileBased(false);
		m2.setReadOnLoad(true);
		
		m2.load();
		
	}
	
	protected static String relative2absolute(String relative) {
		return "";
	}
	
	public void start() throws Exception{
		EmfModel model = new EmfModel();
		model.load();		
	}
	
	public Resource getModel(String modelFile, String metamodelFile){

		Map<String, Object> etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if(!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}
		
		resourceSet = new ResourceSetImpl();
		
		Resource metamodel = resourceSet.createResource(URI.createURI(""));
		
		try {
			metamodel.load(EmfWorkbench.class.getResourceAsStream(metamodelFile), Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Iterator<EObject> it =  metamodel.getContents().iterator();
		while (it.hasNext()){
			EPackage p = (EPackage) it.next();
			System.out.println(p.getNsURI());
			//etfm.put(p.getNsURI(), p);
			resourceSet.getPackageRegistry().put(p.getNsURI(), p);
		}
		
		Resource model = resourceSet.createResource(URI.createURI(""));
		
		try {
			model.load(EmfWorkbench.class.getResourceAsStream(modelFile), Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return model;
	}
	
	public Resource getMetamodel(String metamodelFile){
		Map<String, Object> etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		if(!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}
		
		resourceSet = new ResourceSetImpl();
		
		Resource metamodel = resourceSet.createResource(URI.createURI(""));
		
		try {
			metamodel.load(EmfWorkbench.class.getResourceAsStream(metamodelFile), Collections.EMPTY_MAP);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return metamodel;
	}
	
}
