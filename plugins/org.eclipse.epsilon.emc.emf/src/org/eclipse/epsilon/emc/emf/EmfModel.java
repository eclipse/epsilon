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
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.models.IReflectiveModel;

public class EmfModel extends AbstractEmfModel implements IReflectiveModel {
	
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
		}
	}
	
	public void loadModel() throws EolModelLoadingException {
		ResourceSet resourceSet = new EmfModelResourceSet(); //new ResourceSetImpl();
		
		//Factory defaultFactory = Resource.Factory.Registry.INSTANCE.getFactory(modelFileUri);
		
		//if (defaultFactory instanceof XMIResourceFactoryImpl) {
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", EmfModelResourceFactory.getInstance());
		
		//}
		
		/*
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
		}
		*/
		
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
		
		model = resourceSet.createResource(modelFileUri);
		
		//EcoreResourceFactoryImpl f;
		
		if (this.readOnLoad){
			try {
				model.load(null);
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

	
	public Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException {
		final Collection<String> properties = new LinkedList<String>();
		
		for (EStructuralFeature feature : featuresForType(type)) {
			properties.add(feature.getName());
		}
		
		return properties;
	}
	
	private EList<EStructuralFeature> featuresForType(String type) throws EolModelElementTypeNotFoundException {
		return classForName(type).getEAllStructuralFeatures();
	}
	
	@Override
	public IReflectivePropertySetter getPropertySetter() {
		return new EmfPropertySetter();
	}
}
