/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.test.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.epsilon.emc.emf.InMemoryEmfModel;
import org.eclipse.epsilon.eol.EolModule;

public class ResourceComparator {
	
	protected HashMap<EObject, EObject> matches = new HashMap<EObject, EObject>();
	protected HashMap<EObject, EObject> tempMatches = new HashMap<EObject, EObject>();
	
	protected Resource createResource() {
		ResourceSet rs = new ResourceSetImpl();
		rs.getPackageRegistry().put(EcorePackage.eNS_URI, EcorePackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("*", new XMIResourceFactoryImpl());
		Resource r = rs.createResource(URI.createFileURI("dummy"));
		EObject copy = EcoreUtil.copy(EcorePackage.eINSTANCE);
		r.getContents().add(copy);
		return r;
	}
	
	public boolean compare(Resource r1, Resource r2) {
		
		List<EObject> all1 = getAllContents(r1);
		List<EObject> all2 = getAllContents(r2);
		
		if (all1.size() != all2.size()) return false;
		
		int i = 0;
		for (EObject o1 : all1) {
			EObject o2 = all2.get(i);
			i++;
			
			if (!o1.eClass().equals(o2.eClass())) return false;
			
			for (EAttribute attr : o1.eClass().getEAllAttributes()) {
				
				if (attr.isDerived()) continue;
				
				Object v1 = o1.eGet(attr);
				Object v2 = o2.eGet(attr);
				
				if (v1 == null && v2 == null) continue;
				if (v1 == null || v2 == null) return false;
				
				if (!v1.equals(v2)) return false;
				
			}
			
			for (EReference ref : o1.eClass().getEAllReferences()) {
				
				if (ref.isDerived()) continue;
				
				if (ref.isMany()) {
					EList<?> cv1 = (EList<?>) o1.eGet(ref);
					EList<?> cv2 = (EList<?>) o2.eGet(ref);
					
					int j = 0;
					for (Object v1 : cv1) {
						if (all1.indexOf(v1) != all2.indexOf(cv2.get(j))) return false;
						j++;
					}
				}
				else {
					Object v1 = o1.eGet(ref);
					Object v2 = o2.eGet(ref);
					
					if (v1 == null && v2 == null) continue;
					if (v1 == null || v2 == null) return false;					
					
					if (all1.indexOf(v1) != all2.indexOf(v2)) return false;
					
				}
				
			}
			
		}
		
		return true;
	}
	
	protected List<EObject> getAllContents(Resource r) {
		
		ArrayList<EObject> allContents = new ArrayList<EObject>();
		Iterator<EObject> it = r.getAllContents();
		while (it.hasNext()) {
			allContents.add(it.next());
		}
		return allContents;
	}
	
}
