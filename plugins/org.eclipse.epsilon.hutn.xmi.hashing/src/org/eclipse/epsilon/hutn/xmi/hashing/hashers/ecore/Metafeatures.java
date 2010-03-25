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
package org.eclipse.epsilon.hutn.xmi.hashing.hashers.ecore;

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
		final List<Object> valuesToHash = new LinkedList<Object>();
				
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
