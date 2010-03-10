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

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.Model;
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;

public abstract class AbstractEmfModel extends Model {
	
	//DONE : Improve support for file-based metamodels
	//FIXME : If the user wants, they can load it as a local copy
	//DONE : Re-implement the isTypeOf and isKindOf locally
	
	protected Resource modelImpl;
	protected boolean cachingEnabled = true;
	protected boolean expand = true;

	public abstract void load() throws EolModelLoadingException;
	
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
		modelImpl.getResourceSet().getPackageRegistry().put(nsUri, EPackage.Registry.INSTANCE.get(nsUri));
	}
	
	protected Registry getPackageRegistry() {
		return modelImpl.getResourceSet().getPackageRegistry();
	}
	
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException {
		
		for (Object pkg : getPackageRegistry().values()) {
			if (pkg instanceof EPackage) {
				EPackage ePackage = (EPackage) pkg;
				for (EClassifier classifier : ePackage.getEClassifiers()) {
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
		return EmfUtil.getEStructuralFeature(eObject.eClass(), property) != null;

	}
	
	protected void printPackages() {
		System.err.println("---" + this.name + "---");
		for(Object object : getPackageRegistry().values()) {
			System.err.println(object);
		}
		System.err.println("---------------");
	}
	
	//TODO : Throw the exception if size == 0 check the allContents for the class
	private Map<EClass, List<EObject>> allOfTypeCache = new HashMap<EClass, List<EObject>>();
	public Collection<EObject> getAllOfType(String type) throws EolModelElementTypeNotFoundException {
		
		List<EObject> allOfType = null;
		
		if (cachingEnabled) {
			allOfType = allOfTypeCache.get(type);
		}
		
		EClass eClass = null;
		
		if (allOfType == null || !cachingEnabled){
			allOfType = new ArrayList<EObject>();
			for (EObject eObject : allContents()) {
				if (eObject.eClass().getName().equals(type) || getFullyQualifiedName(eObject.eClass()).equals(type)){
					allOfType.add(eObject);
					eClass = eObject.eClass();
				}
			}
		}
		
		if (cachingEnabled && eClass != null) {
			allOfTypeCache.put(eClass, allOfType);
		}
		
		return allOfType;
	}
	
	
	Map<String, EClass> eClassCache = new HashMap<String, EClass>();
	public EClass classForName(String name) throws EolModelElementTypeNotFoundException {
		
		if (eClassCache.containsKey(name)) {
			return eClassCache.get(name);
		}
		
		EClass eClass = classForName(name, getPackageRegistry());
		
		//EClass eClass = classForName(name, EPackage.Registry.INSTANCE);
		//if (eClass == null) {
		//	eClass = classForName(name, EPackage.Registry.INSTANCE);
		//}
		
		if (eClass != null) {
			eClassCache.put(name, eClass);
			return eClass;
		}
 		
		throw new EolModelElementTypeNotFoundException(this.name, name);
		
	}
	
	protected EClass classForName(String name, Registry registry) {
		EClass eClass = null;
		for (Object pkg : registry.values()) {
			if (pkg instanceof EPackage) {
				
				/*
				System.err.println("EPackage: " + ((EPackage) pkg).getName());
				for (EClassifier c : ((EPackage) pkg).getEClassifiers()) {
					System.err.println("EClass : " + c.getName());
				}
				*/
				
				eClass = findMetaClass(name, (EPackage) pkg);
				if (eClass != null) {
					return eClass;
				}
			}
		}
		return null;
	}
	
	//TODO: Change cache to <EClass, List<EObject>>
	private Map<EClass, List<EObject>> allOfKindCache = new HashMap<EClass, List<EObject>>();
	public Collection<EObject> getAllOfKind(String type) throws EolModelElementTypeNotFoundException {
		
		EClass eClass = classForName(type);
		List<EObject> allOfKind = null; 
		
		if (cachingEnabled){
			allOfKind = allOfKindCache.get(eClass);
		}
		
		if (allOfKind == null || !cachingEnabled){
			allOfKind = new ArrayList<EObject>();
			for (EObject eObject : allContents()) {
				//if (eClass.isSuperTypeOf(eObject.eClass())){
				if (eClass.isInstance(eObject)){
					allOfKind.add(eObject);
				}
			}
			if (cachingEnabled) {
				allOfKindCache.put(eClass, allOfKind);
			}
		}
		return allOfKind;
	}
	
	protected Collection<EObject> allInstances = null;
	public Collection<EObject> allContents(){
		if (allInstances == null || !cachingEnabled){
			allInstances = new ArrayList<EObject>();
			if (!expand) {
				Iterator<EObject> it = modelImpl.getAllContents();
				while (it.hasNext()){
					allInstances.add(it.next());
				}
			}
			else {
				final List<Resource> resources;
				
				if (modelImpl.getResourceSet() == null) {
					resources = new ArrayList<Resource>();
					resources.add(modelImpl);
				} else {
					resources = modelImpl.getResourceSet().getResources();
				}
					
				for (Resource resource : resources) {
					Iterator<EObject> it = resource.getAllContents();
					while (it.hasNext()){
						allInstances.add(it.next());
					}
				}
			}
		}
		return allInstances;
		
	}
	
	public Object createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		
		EClass eClass = classForName(type);
		//if (eClass == null) throw new EolModelElementTypeNotFoundException(this.getName(), type);
		if (eClass.isAbstract()) throw new EolNotInstantiableModelElementTypeException(this.name, type);
		
		EObject instance = eClass.getEPackage().getEFactoryInstance().create(eClass);
		modelImpl.getContents().add(instance);
		addToCache(eClass, instance);
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

	// TODO : Add support for fully qualified class names
	protected void addToCache(EClass eClass, EObject newInstance) {
		//EClass eClass = newInstance.eClass();	
		if (allInstances != null) {
			allInstances.add(newInstance);
		}
		if (allOfTypeCache.containsKey(eClass)) {
			allOfTypeCache.get(eClass).add(newInstance);
		}
		if (allOfKindCache.containsKey(eClass)) {
			allOfKindCache.get(eClass).add(newInstance);
		}
		for (EClass eSuperType : eClass.getEAllSuperTypes()) {
			if (allOfKindCache.containsKey(eSuperType)) {
				allOfKindCache.get(eSuperType).add(newInstance);
			}
		}
	}
	
	protected void removeFromCache(EObject instance) {

		EClass eClass = instance.eClass();
		
		if (allInstances != null) {
			allInstances.remove(instance);
		}
		if (allOfTypeCache.containsKey(eClass)) {
			allOfTypeCache.get(eClass).remove(instance);
		}
		if (allOfKindCache.containsKey(eClass)) {
			allOfKindCache.get(eClass).remove(instance);
		}
		for (EClass eSuperType : eClass.getEAllSuperTypes()) {
			if (allOfKindCache.containsKey(eSuperType)) {
				allOfKindCache.get(eSuperType).remove(instance);
			}
		}
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
	
	/*
	public EClass findMetaClass2(String name, EPackage container){
		Iterator it = container.eAllContents();
		while (it.hasNext()){
			Object next = it.next();
			if (next instanceof EClass && ((EClass) next).getName().equals(name)){
				return (EClass) next;
			}
		}
		return null;
	}
	*/
	
	public EClass findMetaClass(String name, EPackage container){
		
		boolean absolute = name.indexOf("::") > -1;
		
		for (EClassifier eClassifier : container.getEClassifiers()) {
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
		
		for (EPackage ePackage : container.getESubpackages()) {
			EClass eClass = findMetaClass(name, ePackage);
			if (eClass!=null) { return eClass; }
		}
		
		return null;
	}
	
	public void deleteElement(Object instance) {		
		if (instance instanceof EObject){
			EObject eObject = (EObject) instance;
			EcoreUtil.delete(eObject);
			if (cachingEnabled) {
				removeFromCache(eObject);
				List<EObject> contents = new ArrayList<EObject>();
				Iterator<EObject> contentsIterator = eObject.eAllContents();
				while (contentsIterator.hasNext()) {
					contents.add(contentsIterator.next());
				}
				for (EObject content : contents) {
					deleteElement(content);
				}
				contents.clear();
			}
			//clearCache();
		}
	}

	public boolean owns(Object instance) {
		
		if (instance instanceof EObject) {
			EObject eObject = (EObject) instance;
			if (expand) {
				return EcoreUtil.isAncestor(modelImpl.getResourceSet(), eObject);
			}
			else {
				return EcoreUtil.isAncestor(modelImpl, eObject);
			}
		}
		
		return  false;
		
		//if (instance instanceof EObject){
		//	EObject eObject = (EObject) instance;
		//	return EcoreUtil.isAncestor(modelImpl.getResourceSet(), eObject);
			// if (eObject.eResource() == null || eObject.eResource() == modelImpl) return true;
		//}
		//return false;
		
		
	}
	
	public boolean store(String fileName) {
		return store(EmfUtil.createURI(fileName));
	}
	
	// If expand == true, save the other resources in the 
	// resource set as well
	// See how we can run store inside a WorkbenchModificationOperation
	public boolean store(URI uri) {

		try {
			modelImpl.setURI(uri);
			modelImpl.save(null);
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
	
	//TODO : See if we can unload the model to save memory
	@Override
	public void dispose() {
		super.dispose();
		clearCache();
		//modelImpl.unload();
		//resourceMap.remove("platform:/resource" + relativeModelFile);
		if (modelImpl != null) {
			//modelImpl.unload();
			EmfModelResourceFactory.getInstance().removeCachedResource(modelImpl.getURI());
			modelImpl = null;
		}
	}
	
	public Resource getModelImpl() {
		return modelImpl;
	}
	
	public void setModelImpl(Resource modelImpl) {
		this.modelImpl = modelImpl;
	}

	//FIXME : If resource set = null look only in modelImpl
	public Object getElementById(String id) {
		for (Resource resource : modelImpl.getResourceSet().getResources()) {
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

	public boolean isInstantiable(String type) {
		try {
			return !classForName(type).isAbstract();
		} catch (EolModelElementTypeNotFoundException e) {
			return false;
		}
	}
	
	public void diagnostics() {
		for (Object p : getPackageRegistry().values()) {
			System.err.println(((EPackage)p).getNsURI());
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
	
	public void clearCache(){
		if (cachingEnabled) {
			if (allInstances != null) {
				allInstances.clear();
				allInstances = null;
			}
			allOfKindCache.clear();
			allOfTypeCache.clear();
		}
	}

	public boolean isModelElement(Object instance) {
		return instance instanceof EObject;
	}

	public boolean isCachingEnabled() {
		return cachingEnabled;
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

	public void setCachingEnabled(boolean cachingEnabled) {
		this.cachingEnabled = cachingEnabled;
	}

	public void setExpand(boolean expand) {
		this.expand = expand;
	}
}
