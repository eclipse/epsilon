/*******************************************************************************
 * Copyright (c) 2008-2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - model comparison
 ******************************************************************************/
package org.eclipse.epsilon.emc.emf;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.epsilon.emc.emf.transactions.EmfModelTransactionSupport;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.CachedModel;
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;

public abstract class AbstractEmfModel extends CachedModel<EObject> {
	
	//DONE : Improve support for file-based metamodels
	//FIXME : If the user wants, they can load it as a local copy
	//DONE : Re-implement the isTypeOf and isKindOf locally
	
	protected Resource modelImpl;
	protected boolean expand = true;
	Map<String, EClass> eClassCache = new HashMap<String, EClass>();
	
	protected InputStream getInputStream(String file) throws IOException {
		
		if (file.startsWith("bundleresource:") || file.startsWith("platform:")) {
			URL url = new URL(file);
			return url.openConnection().getInputStream();
		}
		else {
			return new FileInputStream(file);
		}
		
	}
	
	protected void setDataTypesInstanceClasses(Resource metamodel){
		Iterator<EObject> it = metamodel.getAllContents();
		while (it.hasNext()) {
			EObject eObject = it.next();
			if (eObject instanceof EEnum){
				//TODO : See if we really need this
				//((EEnum) eObject).setInstanceClassName("java.lang.Integer");
			}
			else if (eObject instanceof EDataType){
				EDataType eDataType = (EDataType) eObject;
				String instanceClass = "";
				if (eDataType.getName().equals("String")){
					instanceClass = "java.lang.String";
				}
				else if (eDataType.getName().equals("Boolean")){
					instanceClass = "java.lang.Boolean";
				}
				else if (eDataType.getName().equals("Integer")){
					instanceClass = "java.lang.Integer";
				}
				else if (eDataType.getName().equals("Float")){
					instanceClass = "java.lang.Float";
				}
				else if (eDataType.getName().equals("Double")){
					instanceClass = "java.lang.Double";
				}
				eDataType.setInstanceClassName(instanceClass);
			}
		}
	}
	
	public void addMetamodelUri(String nsUri) {
		getPackageRegistry().put(nsUri, EPackage.Registry.INSTANCE.get(nsUri));
	}
	
	protected Registry registry = null;

	/**
	 * Get the (cached) package registry belonging to the model implementation,
	 * if no registry is available the global one is provided
	 * 
	 * @return the (global) package registry
	 */
	protected Registry getPackageRegistry() {
		
		if (registry == null) {
			if (modelImpl.getResourceSet() == null) {
				registry = EPackage.Registry.INSTANCE;
				//new EPackageRegistryImpl();
				//registry.put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
			}
			else {
				// By default getPackageRegistry() returns/creates a registry backed by the global registry
				registry = modelImpl.getResourceSet().getPackageRegistry();
			}
		}
		
		return registry;
	}
	
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		
		for (Object pkg : getPackageRegistry().values()) {

			if (pkg instanceof EPackage /*|| pkg instanceof EPackage.Descriptor*/) {
				EPackage ePackage = null;
				
				//if (pkg instanceof EPackage) {
					ePackage = (EPackage) pkg;
				//}
				//else {
				//	ePackage = ((EPackage.Descriptor) pkg).getEPackage();
				//}
				
				for (EClassifier classifier : EmfUtil.getAllEClassifiers(ePackage)) {
				//for (EClassifier classifier : ePackage.getEClassifiers()) {
					if (classifier instanceof EEnum && 
							(((EEnum) classifier).getName().equals(enumeration) ||
							getFullyQualifiedName(classifier).equals(enumeration))){
						EEnum eEnum = (EEnum) classifier;
						EEnumLiteral literal = eEnum.getEEnumLiteral(label);
						
						if (literal != null) return literal.getInstance();
					}
				}
			}
		}
		
		throw new EolEnumerationValueNotFoundException(enumeration,label,this.getName());
	}
	
	@Override
	public boolean knowsAboutProperty(Object instance, String property) {
		if (!owns(instance)) return false;
		EObject eObject = (EObject) instance;		
		return knowsAboutProperty(eObject, property);
	}

	protected boolean knowsAboutProperty(EObject instance, String property) {
		return EmfUtil.getEStructuralFeature(instance.eClass(), property) != null;
	}
	
	//TODO : Throw the exception if size == 0 check the allContents for the class
	protected Collection<EObject> getAllOfTypeFromModel(String type) throws EolModelElementTypeNotFoundException {
		final EClass eClass = classForName(type);
		final List<EObject> allOfType = new ArrayList<EObject>();
			
		for (EObject eObject : allContents()) {
			if (eObject.eClass() == eClass){
				allOfType.add(eObject);
			}
		}

		return allOfType;
	}
	
	public Object getCacheKeyForType(String type) throws EolModelElementTypeNotFoundException {
		return classForName(type);
	}

	public EClass classForName(String name) throws EolModelElementTypeNotFoundException {
		if (name != null) {
			if (eClassCache.containsKey(name)) {
				return eClassCache.get(name);
			}

			EClass eClass = classForName(name, getPackageRegistry());
			if (eClass != null) {
				eClassCache.put(name, eClass);
				return eClass;
			}
		}
 		
		throw new EolModelElementTypeNotFoundException(this.name, name);
	}
	
	protected EClass classForName(String name, Registry registry) {	
		boolean absolute = name.indexOf("::") > -1;

		for (Object pkg : registry.values()) {
			if (pkg instanceof EPackage) {
				EClass eClass = classForName(name, absolute, pkg);
				if (eClass != null) {
					return eClass;
				}
			}
		}
		return null;
	}

	private EClass classForName(String name, boolean absolute, Object pkg) {
		for (EClassifier eClassifier : EmfUtil.getAllEClassifiers((EPackage)pkg)) {
			if (eClassifier instanceof EClass) {
				String eClassifierName = "";
				if (absolute) {
					eClassifierName = getFullyQualifiedName(eClassifier);
				}
				else {
					eClassifierName = eClassifier.getName();
				}
				
				if (eClassifierName.compareTo(name) == 0) {
					return (EClass) eClassifier;
				}
			}
		}
		return null;
	}
	
	protected Collection<EObject> getAllOfKindFromModel(String kind) throws EolModelElementTypeNotFoundException {
		final EClass eClass = classForName(kind);
		final List<EObject> allOfKind = new ArrayList<EObject>();
		
		for (EObject eObject : (Collection<EObject>)allContents()) {
			if (eClass.isInstance(eObject)){
				allOfKind.add(eObject);
			}
		}
		
		return allOfKind;
	}
	
	protected Collection<EObject> allContentsFromModel(){
		final List<EObject> allInstances = new ArrayList<EObject>();
		
		for (Resource resource : getResources()) {
			Iterator<EObject> it = resource.getAllContents();
			while (it.hasNext()){
				allInstances.add(it.next());
			}
		}
		
		/*
		if (!expand) {
			Iterator<EObject> it = modelImpl.getAllContents();
			while (it.hasNext()){
				allInstances.add(it.next());
			}
		
		} else {
			final List<Resource> resources;
			
			if (modelImpl.getResourceSet() == null) {
				resources = new ArrayList<Resource>();
				resources.add(modelImpl);
			} else {
				resources = modelImpl.getResourceSet().getResources();
			}
				
			
		}*/
			
		return allInstances;
	}
	
	protected EObject createInstanceInModel(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		
		EClass eClass = classForName(type);
		//if (eClass == null) throw new EolModelElementTypeNotFoundException(this.getName(), type);
		if (eClass.isAbstract()) throw new EolNotInstantiableModelElementTypeException(this.name, type);
		
		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		modelImpl.getContents().add(instance);
		instance.eAdapters().add(new ContainmentChangeAdapter(instance, modelImpl));
		return instance;
		
	}
	
	protected EmfModelTransactionSupport transactionSupport;
	@Override
	public IModelTransactionSupport getTransactionSupport() {
		if (transactionSupport == null) {
			transactionSupport = new EmfModelTransactionSupport(this);
		}
		return transactionSupport;
	}
	
	protected int instancesCount(Resource r){
		int i = 0;
		Iterator<EObject> ite = r.getAllContents();
		while (ite.hasNext()){
			ite.next();
			i++;
		}
		return i;
	}
		
	protected boolean deleteElementInModel(Object instance) throws EolRuntimeException {		
		if (!(instance instanceof EObject))
			return false;
		
		EObject eObject = (EObject) instance;
		EcoreUtil.delete(eObject);

		List<EObject> contents = new ArrayList<EObject>();
		Iterator<EObject> contentsIterator = eObject.eAllContents();
		while (contentsIterator.hasNext()) {
			contents.add(contentsIterator.next());
		}
		for (EObject content : contents) {
			deleteElement(content);
		}
		contents.clear();
		//clearCache();
		return true;
	}

	public boolean owns(Object instance) {
		
		if (instance instanceof EObject) {
			EObject eObject = (EObject) instance;
			Resource eObjectResource = eObject.eResource();
			
			if (eObjectResource == null) return false;
			
			if (expand) {
				return modelImpl.getResourceSet() == eObjectResource.getResourceSet();
			}
			else {
				return modelImpl == eObjectResource;
			}
		}
		
		return  false;
		
	}
	
	public boolean store(String fileName) {
		return store(EmfUtil.createPlatformResourceURI(fileName));
	}
	
	// If expand == true, save the other resources in the 
	// resource set as well
	// See how we can run store inside a WorkbenchModificationOperation
	public boolean store(URI uri) {
		URI oldUri = modelImpl.getURI();

		try {
			modelImpl.setURI(uri);
			modelImpl.save(null);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {
			modelImpl.setURI(oldUri);
		}

		return true;
	}
	
	public boolean store(OutputStream os) {
		if (modelImpl == null) return false;
		
		try {
			modelImpl.save(os, null);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//TODO : See if we can unload the model to save memory
	@Override
	public void disposeModel() {
		//modelImpl.unload();
		//resourceMap.remove("platform:/resource" + relativeModelFile);
		registry = null;
		if (modelImpl != null) {
			//modelImpl.unload();
			EmfModelResourceFactory.getInstance().removeCachedResource(modelImpl.getURI());
			modelImpl = null;
		}

		eClassCache.clear();
	}

	public Resource getResource() {
		return modelImpl;
	}
	
	public void setResource(Resource resource) {
		this.modelImpl = resource;
	}
	
	/**
	 * @deprecated Use getResource() instead
	 */
	public Resource getModelImpl() {
		return modelImpl;
	}
	
	public void setModelImpl(Resource modelImpl) {
		this.modelImpl = modelImpl;
	}

	protected List<Resource> getResources() {
		List<Resource> resources = new ArrayList<Resource>();
		if (expand && modelImpl.getResourceSet() != null) {
			resources.addAll(modelImpl.getResourceSet().getResources());
		}
		else {
			resources.add(modelImpl);
		}
		return resources;
	}
	
	public Object getElementById(String id) {
		for (Resource resource : getResources()) {
			Object instance = resource.getEObject(id);
			if (instance != null) return instance;
		}
		return null;
	}

	public String getElementId(Object instance) {
		EObject eObject = (EObject) instance;
		
		if (eObject.eResource() instanceof XMIResource){
			String id = ((XMIResource) eObject.eResource()).getID(eObject);
			if (id != null && id.trim().length() > 0) return id;
		}
		
		if (eObject.eResource() instanceof XMLResource){
			return ((XMLResource) eObject.eResource()).getURIFragment(eObject);
		}
		
		return "";
	}
	
	public void setElementId(Object instance, String newId) {
		if (newId == null || newId.isEmpty())
			return;
		
		/* I think that, quite sensibly, EMF does not all URI
		 * fragments to be set on an XML resource. Also, we
		 * don't want a URI fragment to be used as an XMI ID
		 */
		if (isUriFragment(newId))
			return;
		
		
		EObject eObject = (EObject) instance;
		
		if (eObject.eResource() instanceof XMIResource) {
			((XMIResource) eObject.eResource()).setID(eObject, newId);
		}
	}
	
	private boolean isUriFragment(String newId) {
		return newId.startsWith("/") || newId.startsWith("#/");
	}
	

	@Override
	public IPropertyGetter getPropertyGetter() {
		return new EmfPropertyGetter();
	}

	@Override
	public IPropertySetter getPropertySetter() {
		return new EmfPropertySetter();
	}
	
	public Object getTypeOf(Object instance) {
		return ((EObject) instance).eClass();
	}
	
	public String getTypeNameOf(Object instance) {
		if (!isModelElement(instance))
			throw new IllegalArgumentException("Not a valid EMF model element: " + instance + " (" + instance.getClass().getCanonicalName() + ") ");
	
		return ((EClass)getTypeOf(instance)).getName();
	}
	
	public String getFullyQualifiedTypeNameOf(Object instance) {
		if (!isModelElement(instance))
			throw new IllegalArgumentException("Not a valid EMF model element: " + instance + " (" + instance.getClass().getCanonicalName() + ") ");
		
		return getFullyQualifiedName(((EClass)getTypeOf(instance)));
	}
	
	public Collection<String> getAllTypeNamesOf(Object instance) {
		final Collection<String> allTypeNames = new ArrayList<String>();
		
		if (isModelElement(instance)) {
			final EClass type = (EClass)getTypeOf(instance);
			
			allTypeNames.add(type.getName());
			
			for (EClass supertype : type.getEAllSuperTypes()) {
				allTypeNames.add(supertype.getName());
			}
		}
		
		return allTypeNames;
	}

	public boolean isInstantiable(String type) {
		try {
			return !classForName(type).isAbstract();
		} catch (EolModelElementTypeNotFoundException e) {
			return false;
		}
	}
	
	public boolean hasType(String type) {
		try {
			// Speed things up
			if (eClassCache.containsKey(type)) return true;
			
			classForName(type);
			return true;
		} catch (EolModelElementTypeNotFoundException e) {
			return false;
		}
	}
	
	protected String getFullyQualifiedName(EClassifier eClassifier) {
		String fullyQualifiedName = eClassifier.getName();
		EPackage parent = eClassifier.getEPackage();
		while (parent != null) {
			fullyQualifiedName = parent.getName() + "::" + fullyQualifiedName;
			parent = parent.getESuperPackage();
		}
		return fullyQualifiedName;
	}

	public boolean isModelElement(Object instance) {
		return instance instanceof EObject;
	}

	public boolean isExpand() {
		return expand;
	}

	@Override
	public boolean isOfKind(Object instance, String metaClass)
			throws EolModelElementTypeNotFoundException {
		
		EClass eClass = classForName(metaClass);
		return eClass.isInstance(instance);
	}

	@Override
	public boolean isOfType(Object instance, String metaClass)
			throws EolModelElementTypeNotFoundException {
		
		EClass eClass = classForName(metaClass);
		
		if (instance instanceof EObject) {
			EObject eObject = (EObject) instance;
			return eClass == eObject.eClass();
		}
		return false;
	}
	
	public Object getContainerOf(Object object) {
		if (object instanceof EObject) {
			return ((EObject) object).eContainer();
		}
		
		return null;
	}

	public void setExpand(boolean expand) {
		this.expand = expand;
	}
}
