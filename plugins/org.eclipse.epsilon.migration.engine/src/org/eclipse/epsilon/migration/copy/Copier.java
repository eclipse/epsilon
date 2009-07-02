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
package org.eclipse.epsilon.migration.copy;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;

public class Copier {
	
	protected final EObject original;
	protected final AbstractEmfModel targetModel;
	
	private EObject copy;
	
	public Copier(EObject original, AbstractEmfModel targetModel) {
		this.original    = original;
		this.targetModel = targetModel;
	}
	
	public EObject copy() throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		return copy(original.eClass().getName());
	}

	public EObject copy(String targetType) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException {
		copy = (EObject)targetModel.createInstance(targetType);
		
		for (EStructuralFeature feature : original.eClass().getEAllStructuralFeatures()) {
			copyFeature(feature);
		}
		
		return copy;
	}

	private void copyFeature(EStructuralFeature feature) {
		final EStructuralFeature equivalentFeature = copy.eClass().getEStructuralFeature(feature.getName());

		// TODO should be an error when equivalentFeature is null and value is non-empty and non-null?
		if (equivalentFeature != null && equivalentFeature.isChangeable())
			copy.eSet(equivalentFeature, original.eGet(feature));
	}

}