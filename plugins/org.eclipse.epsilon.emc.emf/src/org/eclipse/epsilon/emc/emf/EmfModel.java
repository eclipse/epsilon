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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.GenericXMLResourceFactoryImpl;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.emc.emf.bmi.BmiResourceFactory;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;

public class EmfModel extends AbstractEmfModel {
	
	public static final String PROPERTY_METAMODEL_URI = "metamodelUri";
	public static final String PROPERTY_EXPAND = "expand";
	public static final String PROPERTY_IS_METAMODEL_FILE_BASED = "isMetamodelFileBased";
	public static final String PROPERTY_MODEL_FILE = "modelFile";
	public static final String PROPERTY_METAMODEL_FILE = "metamodelFile";
	
	//DONE : Improve support for file-based metamodels
	//FIXME : If the user wants, they can load it as a local copy
	//DONE : Re-implement the isTypeOf and isKindOf locally
	
	protected String metamodelUri;
	//protected String metamodelFile;
	//protected String modelFile;
	protected List<EPackage> packages;
	protected boolean isMetamodelFileBased;
	protected URI modelFileUri = null;
	protected URI metamodelFileUri = null;
	protected boolean useExtendedMetadata = false;
	
	public void basicLoad(StringProperties properties, String basePath) throws EolModelLoadingException {
		super.load(properties, basePath);
	}
	
	public static void main(String[] args) {
		
		System.err.println(EmfUtil.createURI("c:/files/some.txt"));
		System.err.println(EmfUtil.createURI("/project1/some.txt"));
		System.err.println(EmfUtil.createURI("platform:/resource/project1/some.txt"));
		System.err.println(EmfUtil.createURI("bundle:/resource/project1/some.txt"));
		
		//diagnose(URI.createURI("platform:/resource/file.txt"));
		//diagnose(URI.createURI("c:/file.txt"));
		//diagnose(URI.createURI("resources/file.txt"));
		
	}
	
	static void diagnose(URI uri) {
		System.err.println("uri -> " + uri);
		System.err.println("uri.scheme() -> " + uri.scheme());
		System.err.println("uri.isArchive() -> " + uri.isArchive());
		System.err.println("uri.isPrefix() -> " + uri.isPrefix());
		System.err.println("uri.isPlatformPlugin() -> " + uri.isPlatformPlugin());
		System.err.println("uri.isHierarchical() -> " + uri.isHierarchical());
		System.err.println("uri.isPlatform() -> " + uri.isPlatform());
		System.err.println("uri.authority() -> " + uri.authority());
		System.err.println("uri.isFile() -> " + uri.isFile());
		System.err.println("uri.toFileString() -> " + uri.toFileString());
		System.err.println("uri.isRelative() -> " + uri.isRelative());
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		super.load(properties, basePath);
		this.metamodelUri = properties.getProperty(PROPERTY_METAMODEL_URI);
		this.expand = properties.getBooleanProperty(PROPERTY_EXPAND, true);
		this.isMetamodelFileBased = properties.getBooleanProperty(PROPERTY_IS_METAMODEL_FILE_BASED, false);
		//this.modelFile = StringUtil.toString(basePath) + properties.getProperty(PROPERTY_MODEL_FILE);
		//this.metamodelFile = StringUtil.toString(basePath) + properties.getProperty(PROPERTY_METAMODEL_FILE);
		
		String modelFile = properties.getProperty(PROPERTY_MODEL_FILE);
		String metamodelFile = properties.getProperty(PROPERTY_METAMODEL_FILE);
		
		this.modelFileUri = EmfUtil.createURI(modelFile);
		if (isMetamodelFileBased) {
			this.metamodelFileUri = EmfUtil.createURI(metamodelFile);
		}
		
		/*
		if (StringUtil.isEmpty(basePath)) {
			this.modelFileUri = URI.createFileURI(modelFile);
			if (isMetamodelFileBased) {
				this.metamodelFileUri = URI.createFileURI(metamodelFile);
			}
		}
		else {
			this.modelFileUri = URI.createPlatformResourceURI(properties.getProperty(PROPERTY_MODEL_FILE), true);
			if (isMetamodelFileBased) {
				this.metamodelFileUri = URI.createPlatformResourceURI(properties.getProperty(PROPERTY_METAMODEL_FILE), true);
			}
		}
		*/
		
		load();
	}
	
	@Override
	public void load() throws EolModelLoadingException {
		clearCache();
		loadModel();
		setupContainmentChangeListeners();
	}
	
	public void setupContainmentChangeListeners() {
		// Add a notification adapter to all objects in the model
		// so that they get moved when their containment changes
		
		if (modelImpl != null) {
			//Profiler.INSTANCE.start("Adding containment listeners");
			for (EObject eObject : allContents()) {
				boolean isAdapted = false;
				for (Adapter adapter : eObject.eAdapters()) {
					if (adapter instanceof ContainmentChangeAdapter) {
						isAdapted = true;
					}
				}
				if (!isAdapted){
					eObject.eAdapters().add(new ContainmentChangeAdapter(eObject, eObject.eResource()));
				}
			}
			//Profiler.INSTANCE.stop();
		}
	}
	
	public void loadModel() throws EolModelLoadingException {
		ResourceSet resourceSet = new EmfModelResourceSet(); //new ResourceSetImpl();
		
		Map<String, Object> etfm = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
		if(!etfm.containsKey("*")) {
			etfm.put("*", EmfModelResourceFactory.getInstance());
			etfm.put("xml", new GenericXMLResourceFactoryImpl());
			etfm.put("bim", new ResourceFactoryImpl() {
				@Override
				public Resource createResource(URI uri) {
					return new BinaryResourceImpl(uri);
				}
			});
			//etfm.put("bmi", new BmiResourceFactory());
		}
		
		if (EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI) == null) {
			EPackage.Registry.INSTANCE.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		}
		
		Resource model = null;
		packages = new ArrayList<EPackage>();
		
		if (isMetamodelFileBased) {
			
			List<EPackage> metamodelPackages;
			try {
				metamodelPackages = EmfUtil.register(metamodelFileUri, resourceSet.getPackageRegistry());
			} catch (Exception e) {
				throw new EolModelLoadingException(e,this);
			}
			
			for (EPackage metamodelPackage : metamodelPackages) {
				packages.add(metamodelPackage);
				EmfUtil.collectDependencies(metamodelPackage, packages);
			}
			
		}
		else {
			EPackage ePackage = EPackage.Registry.INSTANCE.getEPackage(metamodelUri);
			packages.add(ePackage);
			EmfUtil.collectDependencies(ePackage, packages);
		}
		
		for (EPackage ep : packages) {
			String nsUri = ep.getNsURI();
			if (nsUri == null || nsUri.trim().length() == 0) {
				nsUri = ep.getName();
			}
			resourceSet.getPackageRegistry().put(nsUri, ep);
		}
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		//for (String s : resourceSet.getPackageRegistry().keySet()) {
		//	System.err.println(s);
		//}
		
		model = resourceSet.createResource(modelFileUri);
		
		if (this.readOnLoad){
			try {
				HashMap<String, Object> options = new HashMap<String, Object>();
				options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
				options.put(XMLResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
				options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
				model.load(options);
				if (expand) {
					EcoreUtil.resolveAll(model);
				}
			} catch (IOException e) {
				throw new EolModelLoadingException(e, this);
			}
		}
		
		modelImpl = model;

	}

	public boolean store() {
		if (modelImpl == null) return false;
		
		try {
			modelImpl.save(null);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
		//return store(this.modelFile);
	}

	public String getMetamodelFile() {
		return EmfUtil.getFile(metamodelFileUri);
		//return null;
		//return metamodelFile;
	}

	public boolean isMetamodelFileBased() {
		return isMetamodelFileBased;
	}

	public String getMetamodelUri() {
		return metamodelUri;
	}

	public String getModelFile() {
		return EmfUtil.getFile(modelFileUri);
		//return null;
		//return modelFile;
		//return getModelFileUri().toString();
	}

	public URI getModelFileUri() {
		return modelFileUri;
	}

	public void setModelFileUri(URI modelFileUri) {
		this.modelFileUri = modelFileUri;
	}

	public URI getMetamodelFileUri() {
		return metamodelFileUri;
	}

	public void setMetamodelFileUri(URI metamodelFileUri) {
		this.metamodelFileUri = metamodelFileUri;
	}

	public void setMetamodelUri(String metamodelUri) {
		this.metamodelUri = metamodelUri;
	}

	public void setMetamodelFile(String metamodelFile) {
		//this.metamodelFile = metamodelFile;
		this.metamodelFileUri = URI.createFileURI(metamodelFile);
	}

	public void setModelFile(String modelFile) {
		//this.modelFile = modelFile;
		this.modelFileUri = URI.createFileURI(modelFile);
	}

	public void setMetamodelFileBased(boolean isMetamodelFileBased) {
		this.isMetamodelFileBased = isMetamodelFileBased;
	}
}
