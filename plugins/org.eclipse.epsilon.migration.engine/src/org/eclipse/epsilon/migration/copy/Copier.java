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

	public void copy(EObject object, AbstractEmfModel target) {
		try {
			final EObject copied = (EObject)target.createInstance(object.eClass().getName());
			
			for (EStructuralFeature feature : object.eClass().getEAllStructuralFeatures()) {
				final Object value = object.eGet(feature);
				
				final EStructuralFeature equivalentFeature = copied.eClass().getEStructuralFeature(feature.getName());

				if (equivalentFeature != null) // TODO should be an error when equivalentFeature is null?
					copied.eSet(equivalentFeature, value);
			}
		
		} catch (EolModelElementTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EolNotInstantiableModelElementTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
