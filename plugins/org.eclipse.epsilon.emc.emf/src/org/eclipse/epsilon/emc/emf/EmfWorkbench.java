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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EmfWorkbench {
	
	private ResourceSet resourceSet;
	
	public static void main(String[] args) throws Exception{
		
		System.err.println(EcorePackage.eNS_URI);
		
		if (true) return;
		
		//EmfWorkbench wb = new EmfWorkbench();
		//wb.start();
		
		//Map etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		//if(!etfm.containsKey("*")) {
		//	etfm.put("*", new XMIResourceFactoryImpl());
		//}
		
		//System.out.println(EPackage.Registry.INSTANCE.getEPackage("http://www.eclipse.org/emf/2002/Ecore"));
		
		String basePath = "E:\\Projects\\Eclipse\\3.3.e\\workspace\\org.eclipse.epsilon.eol.cs2as\\src\\org\\epsilon\\eol\\cs2as\\";
		
		
		EmfModel m1 = new EmfModel();
		
		//StringProperties sp = new StringProperties();
		//sp.put(EmfModel.PROPERTY_MODEL_FILE, basePath + "VM.model");
		//sp.put(EmfModel.PROPERTY_METAMODEL_FILE, basePath + "EOL.ecore");
		//sp.put(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED, "true");
		//sp.put(EmfModel.PROPERTY_METAMODEL_URI, "EOL");
		///sp.put(EmfModel.PROPERTY_IS_METAMODEL_FILE_BASED, "false");
		//sp.put(EmfModel.PROPERTY_EXPAND, "true");
		//sp.put(EmfModel.PROPERTY_READONLOAD, "true");
		//sp.put(EmfModel.PROPERTY_STOREONDISPOSAL, "false");
		
		//model.load(sp, null);
		
		m1.setModelFile(basePath + "VM.model");
		m1.setMetamodelFile(basePath + "EOL.ecore");
		m1.setMetamodelFileBased(true);
		m1.setReadOnLoad(true);
		
		m1.load();
		

		System.err.println(m1.getAllOfKind("Type").size());
		
		
		EmfModel m2 = new EmfModel();
		
		m2.setModelFile(basePath + "EOL.ecore");
		m2.setMetamodelUri(EcorePackage.eNS_URI);
		m2.setMetamodelFileBased(false);
		m2.setReadOnLoad(true);
		
		m2.load();
		
		System.err.println(m2.getAllOfType("EClass").size());
		
	}
	
	protected static String relative2absolute(String relative) {
		return "";
	}
	
	public void start() throws Exception{
		//System.out.println(getMetamodel("resources/ATL-0.2.ecore").getContents());
		/*
		Resource model = getModel("resources/sample-ATL-0.2.ecore", "resources/ATL-0.2.ecore");
		Iterator it = model.getAllContents();
		while (it.hasNext()){
			System.out.println(it.next());
		}
		*/
		
		EmfModel model = new EmfModel();
		//model.setMetamodel(false);
		//model.setModelFile("resources/sample-ATL-0.2.ecore");
		//model.setMetamodelFile("resources/ATL-0.2.ecore");
		model.load();
		
		//System.out.println(model.getAllOfType("Element").size());
		//System.out.println(model.getAllInstances().size());
		
	}
	
	public Resource getModel(String modelFile, String metamodelFile){

		Map etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
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
		
		Iterator it =  metamodel.getContents().iterator();
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
		Map etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
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
