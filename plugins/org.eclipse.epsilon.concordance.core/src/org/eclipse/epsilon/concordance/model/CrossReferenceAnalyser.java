/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.model;

import static org.eclipse.emf.ecore.util.EcoreUtil.getURI;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.common.dt.util.LogUtil;

public class CrossReferenceAnalyser {

	private final Model sourceModel;
	private final Set<CrossReference> xrefs = new HashSet<CrossReference>();
	
	public CrossReferenceAnalyser(Model source) {
		this.sourceModel = source;
	}
	
	public Set<CrossReference> determineCrossReferences() {
		try {
			//Profiler.INSTANCE.start("DetermineCrossReferences");
			
			for (EObject object : sourceModel.getAllContents(true)) {
				determineCrossReferencesFrom(object);
			}
			
			//Profiler.INSTANCE.stop("DetermineCrossReferences");
			
		} catch (IOException e) {
			LogUtil.log("Error encountered while trying to determine cross references for: " + sourceModel, e);
		}
		
		return xrefs;
	}

	private void determineCrossReferencesFrom(EObject source) {
		for (EReference reference : source.eClass().getEAllReferences()) {
			if (isCrossReference(reference)) {				
				for (EObject target : getReferencedValues(source, reference)) {
					addCrossReference(reference, source, target);
				}
			}
		}
	}
	
	
	private boolean isCrossReference(EReference reference) {
		return reference.isChangeable()   &&
		       !reference.isContainment() &&
		       !reference.isDerived()     && 
		       !oppositeIsContainment(reference);
	}
	
	private boolean oppositeIsContainment(EReference reference) {
		return reference.getEOpposite() != null && reference.getEOpposite().isContainment();
	}


	@SuppressWarnings("unchecked")
	private Collection<EObject> getReferencedValues(EObject eObject, EReference reference) {
		final Object value = eObject.eGet(reference, false);
		final Collection<EObject> values;
		
		if (reference.isMany()) {
			values = (Collection<EObject>)value;
		
		} else { 
			values = new ArrayList<EObject>();

			if (value != null)
				values.add((EObject) value);
		}
				
		return values;
	}
	
	
	private void addCrossReference(EReference reference, EObject source, EObject target) {
		if (hasNoResource(target) || isInternalReference(source, target))
			return;
		
		xrefs.add(new CrossReference(new ModelElement(sourceModel,    getURI(source).fragment(), getLabel(source)),
		                             new ModelElement(getURI(target), getLabel(target)),
		                             reference.getName())
		);
	}

	private boolean hasNoResource(EObject target) {
		return !target.eIsProxy() && target.eResource() == null;
	}
	
	private boolean isInternalReference(EObject source, EObject target) {
		return !target.eIsProxy() && target.eResource().equals(source.eResource());
	}

	private String getLabel(EObject eObject) {
		final EStructuralFeature feature = eObject.eClass().getEStructuralFeature("name");
		
		final String type = eObject.eClass().getName();
		
		final String name;
		
		if (feature == null || eObject.eGet(feature) == null) {
			name = "<unnamed>";
		} else {
			name = eObject.eGet(feature).toString();
		}
		
		return type + " " + name;
	}
}
