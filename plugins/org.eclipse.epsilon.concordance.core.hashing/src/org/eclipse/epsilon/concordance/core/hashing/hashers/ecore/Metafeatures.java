/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.concordance.core.hashing.hashers.ecore;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EStructuralFeature;

class Metafeatures {

	private final List<String> metafeatureNames;
	
	public Metafeatures(String... featureNames) {
		this.metafeatureNames = Arrays.asList(featureNames);
	}
	
	Iterable<Object> getValuesToHashFrom(EModelElement metamodelElement) {
		final List<Object> valuesToHash = new LinkedList<>();
				
		for (String metafeatureName : metafeatureNames) {
			valuesToHash.add(getValueOfMetafeatureFrom(metamodelElement, metafeatureName));
		}
		
		return valuesToHash;
	}
	
	private static Object getValueOfMetafeatureFrom(EModelElement metamodelElement, String metafeatureName) {
		final EStructuralFeature metafeature = getMetafeatureFrom(metamodelElement, metafeatureName);
		
		return metafeature == null ? null : metamodelElement.eGet(metafeature);
	}
	
	private static EStructuralFeature getMetafeatureFrom(EModelElement metamodelElement, String metafeatureName) {
		return metamodelElement.eClass().getEStructuralFeature(metafeatureName);
	}
}
