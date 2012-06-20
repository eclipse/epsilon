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
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.models.IReflectiveModel;

public class EmfModel extends AbstractEmfModel implements IReflectiveModel {
	
	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * When paired with "true", external references will be resolved during loading.
	 * Otherwise, external references are not resolved.
	 * 
	 * Paired with "true" by default.
	 */
	public static final String PROPERTY_EXPAND = "expand";

	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * When paired with "true", the metamodel is loaded from the URI stored in
	 * {@link #PROPERTY_FILE_BASED_METAMODEL_URI}.
	 * Otherwise, the metamodel is loaded from the EPackage registry using
	 * the namespace URI stored in {@link #PROPERTY_METAMODEL_URI}.
	 * 
	 * Paired with "false" by default.
	 */
	public static final String PROPERTY_IS_METAMODEL_FILE_BASED = "isMetamodelFileBased";
	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * This key is paired with the namespace URI of the metamodel to which this model conforms.
	 * This key is used only when {@link #PROPERTY_IS_METAMODEL_FILE_BASED} is paired with "false".
	 */
	public static final String PROPERTY_METAMODEL_URI = "metamodelUri";
	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * This key is paired with a {@link URI} that can be used to locate the metamodel to which this model conforms.
	 * This key is used only when {@link #PROPERTY_IS_METAMODEL_FILE_BASED} is paired with "true". 
	 */
	public static final String PROPERTY_FILE_BASED_METAMODEL_URI = "fileBasedMetamodelUri";
	/**
	 * @deprecated Replaced by
	 *             {@link #PROPERTY_FILE_BASED_METAMODEL_URI}.
	 *              This property will be removed in a future release of Epsilon.
	 */
	@Deprecated
	public static final String PROPERTY_METAMODEL_FILE = "metamodelFile";
	
	/**
	 * One of the keys used to construct the first argument to {@link EmfModel#load(StringProperties, String)}.
	 * 
	 * This key is paired with a {@link URI} that can be used to locate this model.
	 * This key must always be paired with a value.
	 */
	public static final String PROPERTY_MODEL_URI = "modelUri";
	/**
	 * @deprecated  Replaced by
	 *              {@link #PROPERTY_MODEL_URI}.
	 *              This property will be removed in a future release of Epsilon.
	 */
	@Deprecated
	public static final String PROPERTY_MODEL_FILE = "modelFile";
	
	
	protected String metamodelUri;
	protected List<EPackage> packages;
	protected boolean isMetamodelFileBased;
	protected URI modelUri = null;
	protected URI metamodelFileUri = null;
	protected boolean useExtendedMetadata = false;
	
	
	/**
	 * Load the model using the set of properties specified by the first argument.
	 * 
	 * @see #PROPERTY_MODEL_URI
	 * @see #PROPERTY_IS_METAMODEL_FILE_BASED
	 * @see #PROPERTY_EXPAND
	 * @see <a href="https://bugs.eclipse.org/bugs/show_bug.cgi?id=341481">Rationale for deprecating the FILE properties</a>.
	 */
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {
		PropertyMigrator.migrateDeprecatedProperties(properties);	
		
		super.load(properties, basePath);
		this.metamodelUri = properties.getProperty(PROPERTY_METAMODEL_URI);
		this.expand = properties.getBooleanProperty(PROPERTY_EXPAND, true);
		this.isMetamodelFileBased = properties.getBooleanProperty(PROPERTY_IS_METAMODEL_FILE_BASED, false);
		
		this.modelUri = URI.createURI(properties.getProperty(PROPERTY_MODEL_URI));
		
		if (isMetamodelFileBased) {
			this.metamodelFileUri = URI.createURI(properties.getProperty(PROPERTY_FILE_BASED_METAMODEL_URI));
		}
		
		load();
	}

	/**
	 * Used for backwards-compatibility with existing Eclipse launch configurations.
	 * 
	 * See #341481
	 */
	static class PropertyMigrator {
		public static void migrateDeprecatedProperties(StringProperties properties) {
			migrateModelFileProperty(properties);
			migrateMetamodelFileProperty(properties);
		}
		
		private static void migrateModelFileProperty(StringProperties properties) {
			migrateUriValue(properties, PROPERTY_MODEL_FILE, PROPERTY_MODEL_URI);
		}
		
		private static void migrateMetamodelFileProperty(StringProperties properties) {
			migrateUriValue(properties, PROPERTY_METAMODEL_FILE, PROPERTY_FILE_BASED_METAMODEL_URI);
		}

		private static void migrateUriValue(StringProperties properties, String oldProperty, String newProperty) {
			if (properties.hasValueFor(oldProperty) && !properties.hasValueFor(newProperty)) {
				final String oldValue = properties.getProperty(oldProperty);
				final URI    newValue = EmfUtil.createPlatformResourceURI(oldValue);
				
				properties.put(newProperty, newValue);
			}
		}
	}
	
	
	protected void loadModel() throws EolModelLoadingException {
		loadModelFromUri();
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
	
	public void loadModelFromUri() throws EolModelLoadingException {
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
		determinePackagesFrom(resourceSet);
		
		for (EPackage ep : packages) {
			String nsUri = ep.getNsURI();
			if (nsUri == null || nsUri.trim().length() == 0) {
				nsUri = ep.getName();
			}
			resourceSet.getPackageRegistry().put(nsUri, ep);
		}
		resourceSet.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		
		model = resourceSet.createResource(modelUri);
		
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

	private void determinePackagesFrom(ResourceSet resourceSet) throws EolModelLoadingException {
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
			
			if (ePackage == null)
				throw new EolModelLoadingException(new IllegalArgumentException("Could not locate a metamodel with the URI '" + metamodelUri + "'. Please ensure that this metamodel has been registered with Epsilon."), this);
			
			packages.add(ePackage);
			EmfUtil.collectDependencies(ePackage, packages);
		}
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
		return EmfUtil.getFile(modelUri);
		//return null;
		//return modelFile;
		//return getModelFileUri().toString();
	}

	public URI getModelFileUri() {
		return modelUri;
	}

	public void setModelFileUri(URI modelFileUri) {
		this.modelUri = modelFileUri;
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
		this.modelUri = URI.createFileURI(modelFile);
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

	public boolean hasProperty(String type, String property) throws EolModelElementTypeNotFoundException {
		return getPropertiesOf(type).contains(property);
	}

	@Override
	public String toString() {
		return "EmfModel [name=" + getName() + "]";
	}

}
