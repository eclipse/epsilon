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
import java.util.Collection;
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
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.common.util.OperatingSystem;

public class EmfUtil {
		
	public static EStructuralFeature getEStructuralFeature(EClass eClass, String featureName) {
		try {
			EStructuralFeature feature = eClass.getEStructuralFeature(featureName);
						
			if (feature == null) {
				final EClass documentRoot = ExtendedMetaData.INSTANCE.getDocumentRoot(eClass.getEPackage());

				if (documentRoot != null) {
					feature = documentRoot.getEStructuralFeature(featureName);
				}
			}
			
			return feature;
		}
			catch (Throwable t) {
				t.printStackTrace();
				return null;
		}
	}
	
    public static URI createPlatformResourceURI(String s) {
        final URI uri = fixUriForOperatingSystem(s, URI.createURI(s));

        if (uri.scheme() == null) {
            return URI.createPlatformResourceURI(s, true);
        
        } else {
        	return uri;
        }
    }
    
    public static URI createFileBasedURI(String s) {
    	final URI uri = fixUriForOperatingSystem(s, URI.createURI(s));
        
    	if (uri.scheme() == null) {
            return URI.createFileURI(s);
        
        } else {
        	return uri;
        }
    }

	private static URI fixUriForOperatingSystem(String s, URI uri) {
		if (uri.scheme() != null) {
        	// If we are under Windows and s starts with x: it is an absolute path
        	if (OperatingSystem.isWindows() && uri.scheme().length() == 1) {
        		return URI.createFileURI(s);
        	}
        }
//      // Handle paths that start with / under Unix e.g. /local/foo.txt
//      else if (OperatingSystem.isUnix() && s.startsWith("/")) { 
//         return URI.createFileURI(s);
//      }
        	
        return uri;
	}
	
	public static String getFile(URI uri) {
		if (uri.isFile()) {
			return uri.toFileString();
		}
		else {
			return uri.toString();
		}
	}
	
	public static EPackage getTopEPackage(EObject object) {
		return getTopEPackage(object.eClass().getEPackage());
	}
	
	public static void collectDependencies(EPackage ePackage, List<EPackage> dependencies) {
		Collection<EObject> crossReferencedElements = EcoreUtil.ExternalCrossReferencer.find(ePackage.eResource()).keySet();
		
		for (Object crossReferencedElement : crossReferencedElements) {
			
			if (crossReferencedElement instanceof EClassifier) {
				EClassifier eClass = (EClassifier) crossReferencedElement;
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
	
	public static void initialiseResourceFactoryRegistry() {
		final Map<String, Object> etfm = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
		
		if (!etfm.containsKey("*")) {
			etfm.put("*", new XMIResourceFactoryImpl());
		}
	}
	
	public static List<EPackage> register(URI uri, EPackage.Registry registry) throws Exception {
		
		List<EPackage> ePackages = new ArrayList<EPackage>();
		
		initialiseResourceFactoryRegistry();

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getPackageRegistry().put(EcorePackage.eINSTANCE.getNsURI(),
				EcorePackage.eINSTANCE);
	
		Resource metamodel = resourceSet.createResource(uri);
		metamodel.load(Collections.EMPTY_MAP);
		
		setDataTypesInstanceClasses(metamodel);

		Iterator<EObject> it = metamodel.getAllContents();
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
				registry.put(p.getNsURI(), p);
				metamodel.setURI(URI.createURI(p.getNsURI()));
				ePackages.add(p);
			}
		}
		
		return ePackages;
		
	}

	protected static void setDataTypesInstanceClasses(Resource metamodel) {
		Iterator<EObject> it = metamodel.getAllContents();
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
				if (instanceClass.trim().length() > 0) {
					eDataType.setInstanceClassName(instanceClass);
				}
			}
		}
	}

	public static List<EClass> getAllEClassesFromSameMetamodelAs(EModelElement metamodelElement) {
		return getAllModelElementsOfType(metamodelElement, EClass.class);
	}
	
	public static Collection<EClassifier> getAllEClassifiers(EPackage epackage) {
		Collection<EClassifier> allEClassifiers = new ArrayList<EClassifier>();
		allEClassifiers.addAll(epackage.getEClassifiers());
		for (EPackage subpackage : epackage.getESubpackages()) {
			allEClassifiers.addAll(getAllEClassifiers(subpackage));
		}
		return allEClassifiers;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends EObject> List<T> getAllModelElementsOfType(EObject modelElement, Class<T> type) {		
		final List<T> results = new LinkedList<T>();
		
		if (modelElement.eResource() != null) {
			final TreeIterator<EObject> iterator = modelElement.eResource().getAllContents();
			
			while (iterator.hasNext()) {
				final EObject object = iterator.next();
				
				if (type.isInstance(object))
					results.add((T)object);
			}
		}
		
		return Collections.unmodifiableList(results);
	}
	
	
	
	private final static URI DEFAULT_URI = URI.createFileURI("foo.ecore");
	
	public static Resource createResource() {
		return createResource(DEFAULT_URI);
	}
	
	public static Resource createResource(URI uri) {
		return createResource(null, uri);
	}
	
	public static Resource createResource(EObject rootObject) {
		return createResource(rootObject, DEFAULT_URI);
	}
	
	public static Resource createResource(EObject rootObject, URI uri) {
		final ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new EcoreResourceFactoryImpl());

		final Resource resource = resourceSet.createResource(uri);
		
		if (rootObject != null) {
			resource.getContents().add(rootObject);
		}
		
		return resource;
	}
	
	public static <T extends EObject> T clone(T object) {
		final T cloned = (T)EcoreUtil.copy(object);
		org.eclipse.epsilon.emc.emf.EmfUtil.createResource(cloned);
		return cloned;
	}
}
