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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

public class EmfUtil {
	
	public static EStructuralFeature getEStructuralFeature(EClass eClass, String featureName) {
		try {
			EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
			
			//System.err.println(eClass + "-" + featureName + "-" + feature);
			
			if (feature == null) {
				feature = ExtendedMetaData.INSTANCE.getDocumentRoot(
					eClass.getEPackage()).getEStructuralFeature(featureName);
			}
			return feature;
		}
			catch (Throwable t) {
				t.printStackTrace();
				return null;
		}
	}
	
	public static EPackage getTopEPackage(EObject object) {
		return getTopEPackage(object.eClass().getEPackage());
	}
	
	public static void collectDependencies(EPackage ePackage, List dependencies) {
		Map m = EcoreUtil.ExternalCrossReferencer.find(ePackage.eResource());
		
		for (Object key : m.keySet()) {
			
			//System.err.println(key);
			
			if (key instanceof EClassifier) {
				EClassifier eClass = (EClassifier) key;
				EPackage referencedPackage = eClass.getEPackage();
				if (referencedPackage != null) {
					EPackage topEPackage = getTopEPackage(referencedPackage);
					if (!dependencies.contains(topEPackage)) {
						dependencies.add(topEPackage);
						collectDependencies(topEPackage, dependencies);
					}
				}
			}
		}
	}
	
	public static EPackage getTopEPackage(EPackage ePackage) {
		EPackage top = ePackage;
		while (top.getESuperPackage()!=null) {
			top = top.getESuperPackage();
		}
		return top;
	}
	
	//protected HashMap<URI, List<EPackage>> cache = new HashMap<URI, List<EPackage>>();
	
	public static List<EPackage> register(URI uri, EPackage.Registry registry) throws Exception {
		
		List<EPackage> ePackages = new ArrayList();
		
		// File f = new File(fileName);
		
		/*
		if (!f.isAbsolute()) {
			fileName = ResourcesPlugin.getWorkspace().getRoot()
					.getRawLocation().toPortableString()
					+ fileName;
		}
*/
		Map etfm = Resource.Factory.Registry.INSTANCE
				.getExtensionToFactoryMap();
		if (!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(),
				EcorePackage.eINSTANCE);
		
		// resourceSet.getPackageRegistry().putAll(EPackage.Registry.INSTANCE);
		
		// System.err.println(resourceSet.getResource(URI.createPlatformResourceURI(fileName, false), true));
		
		//try {
			//metamodel.load(new FileInputStream(fileName), Collections.EMPTY_MAP);
			
			//URI uri = URI.createFileURI(fileName);
			
			//URI uri = URI.createPlatformResourceURI(fileName, true);
			
		
			Resource metamodel = resourceSet.createResource(uri);
		
			//System.err.println(uri);
		
			//metamodel = resourceSet.getResource(uri,false);
			
			
			metamodel.load(Collections.EMPTY_MAP);
			
			//metamodel = resourceSet.getResource(URI.createPlatformResourceURI(fileName, false), true);
		//} catch (IOException e) {
		//	throw e;
			//EmfUtilPlugin.getDefault().getLog().log(new Status());
		//}
		// e.printStackTrace();
		// MessageDialog.openError(null,"Error", e.toString());
		// return;
		// }

		setDataTypesInstanceClasses(metamodel);

		//Iterator it = metamodel.getContents().iterator();
		Iterator it = metamodel.getAllContents();
		while (it.hasNext()) {
			Object next = it.next();
			if (next instanceof EPackage) {
				EPackage p = (EPackage) next;
				
				if (p.getNsURI() == null || p.getNsURI().trim().length() == 0) {
					if (p.getESuperPackage() == null) {
						p.setNsURI(p.getName());
					}
					else {
						p.setNsURI(p.getESuperPackage().getNsURI() + "/" + p.getName());
					}
				}
				
				if (p.getNsPrefix() == null || p.getNsPrefix().trim().length() == 0) {
					if (p.getESuperPackage() != null) {
						if (p.getESuperPackage().getNsPrefix()!=null) {
							p.setNsPrefix(p.getESuperPackage().getNsPrefix() + "." + p.getName());
						}
						else {
							p.setNsPrefix(p.getName());
						}
					}
				}
				
				if (p.getNsPrefix() == null) p.setNsPrefix(p.getName());
				//EPackage.Registry.INSTANCE.put(p.getNsURI(), p);
				registry.put(p.getNsURI(), p);
				metamodel.setURI(URI.createURI(p.getNsURI()));
				ePackages.add(p);
			}
		}
		
		return ePackages;
		
	}

	protected static void setDataTypesInstanceClasses(Resource metamodel) {
		Iterator it = metamodel.getAllContents();
		while (it.hasNext()) {
			EObject eObject = (EObject) it.next();
			if (eObject instanceof EEnum) {
				// ((EEnum) eObject).setInstanceClassName("java.lang.Integer");
			} else if (eObject instanceof EDataType) {
				EDataType eDataType = (EDataType) eObject;
				String instanceClass = "";
				if (eDataType.getName().equals("String")) {
					instanceClass = "java.lang.String";
				} else if (eDataType.getName().equals("Boolean")) {
					instanceClass = "java.lang.Boolean";
				} else if (eDataType.getName().equals("Integer")) {
					instanceClass = "java.lang.Integer";
				} else if (eDataType.getName().equals("Float")) {
					instanceClass = "java.lang.Float";
				} else if (eDataType.getName().equals("Double")) {
					instanceClass = "java.lang.Double";
				}
				eDataType.setInstanceClassName(instanceClass);
			}
		}
	}

	public static List<EClass> getAllEClassesFromSameMetamodelAs(EModelElement metamodelElement) {
		return getAllModelElementsOfType(metamodelElement, EClass.class);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> getAllModelElementsOfType(EObject modelElement, Class<T> type) {		
		final List<T> results = new LinkedList<T>();
		
		final TreeIterator<EObject> iterator = modelElement.eResource().getAllContents();
		
		while (iterator.hasNext()) {
			final EObject object = iterator.next();
			
			if (type.isInstance(object))
				results.add((T)object);
		}
		
		return Collections.unmodifiableList(results);
	}
	
}
