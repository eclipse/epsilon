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

package org.eclipse.epsilon.concordance.analysis;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.epsilon.concordance.index.CrossReference;

public class ResourceAnalyzer {
	
	public ResourceAnalytics analyzeResource(IFile resource) throws Exception {
		
		ResourceAnalytics analytics = new ResourceAnalytics();
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource r = resourceSet.createResource(URI.createPlatformResourceURI(resource.getFullPath().toOSString(), true));
				
		r.load(null);
		EcoreUtil.resolveAll(r);
		
		for (EObject root : r.getContents()) {
			findCrossReferencesImpl(root, analytics);
		}
		
		return analytics;
	}
	
	public void findCrossReferencesImpl(EObject eObject, ResourceAnalytics analytics) {
		analytics.getElementIds().add(eObject.eResource().getURIFragment(eObject));
		
		for (EReference ref : eObject.eClass().getEAllReferences()) {
			
			if (ref.isContainment()) continue;
			if (ref.isDerived()) continue;
			if (!ref.isChangeable()) continue;
			
			EReference opposite = ref.getEOpposite();
			if (opposite != null) {
				if (opposite.isContainment()) continue;
			}
			
			Collection<Object> values = null;
			if (ref.isMany() ) {
				values = (Collection<Object>) eObject.eGet(ref, false);
			}
			else {
				values = new ArrayList<Object>();
				Object value = eObject.eGet(ref, false);
				if (value != null) values.add(value);
			}
			
			System.err.println("Values = " + values.size());
			
			for (Object value : values) {
				
				EObject e = (EObject) value;
				
				if (e.eResource() == null) {System.err.println("Null resource " + value);continue;}
				
				CrossReference reference = new CrossReference();
				
				reference.setSourceElementId(eObject.eResource().getURIFragment(eObject));
				reference.setSourceResource(eObject.eResource().getURI().toString());
				reference.setSourceLabel(getLabel(eObject));
				reference.setTargetElementId(e.eResource().getURIFragment(e));
				reference.setTargetResource(e.eResource().getURI().toString());
				reference.setTargetLabel(getLabel(e));
				reference.setFeature(ref.getName());
				reference.setDangling(false);
				reference.setTag("");
				analytics.getCrossReferences().add(reference);
			}
			
		}
		
		for (EObject child : eObject.eContents()) {
			findCrossReferencesImpl(child, analytics);
		}
	}

	protected String getLabel(EObject eObject) {
		
		String label = eObject.eClass().getName();
		EStructuralFeature sf = eObject.eClass().getEStructuralFeature("name");
		if (sf != null) { 
			label = label + " " + eObject.eGet(sf);
		}
		else {
			label = label + " " + "<unnamed>";
		}
		return label;
	}
}
 