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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.emc.emf.util.EListUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class Copier {
	
	private final AbstractEmfModel targetModel;
	
	private final List<Equivalence> equivalences = new LinkedList<Equivalence>();
	
	private EObject original;
	private EObject copy;
	
	public Copier(AbstractEmfModel targetModel) {
		this.targetModel = targetModel;
	}
	
	public List<Equivalence> deepCopy(EObject original) throws CopyingException {	
		try {
			this.original = original;
			equivalences.clear();
			
			
			copy = (EObject)targetModel.createInstance(original.eClass().getName());
			
			equivalences.add(new Equivalence(original, copy));
			
			for (EStructuralFeature feature : original.eClass().getEAllStructuralFeatures()) {
				copyFeature(feature);
			}
			
			return equivalences;
			
		} catch (EolRuntimeException e) {
			throw new CopyingException("Could not copy: " + original, e);	
		}
	}

	private void copyFeature(EStructuralFeature feature) throws CopyingException {
		final EStructuralFeature equivalentFeature = copy.eClass().getEStructuralFeature(feature.getName());

		// TODO should be an error when equivalentFeature is null and value is non-empty and non-null?
		if (equivalentFeature != null && equivalentFeature.isChangeable()) {
			
			if (equivalentFeature.getEType() instanceof EEnum) {
				// FIXME do something here
			} else {
			
				final Object value = original.eGet(feature);
				
				if (value instanceof EList<?>) {
					final EList<?> valueList = (EList<?>)value;
					
					if (EListUtil.elementsAreAllInstancesOf(valueList, EObject.class)) {
						final EList<EObject> copiedValues = new BasicEList<EObject>();
						
						for (EObject element : EListUtil.castElements(valueList, EObject.class)) {
							copiedValues.add(copyContainedEObject(element));
						}
						
						copy.eSet(equivalentFeature, copiedValues);
					}
				
				} else {
					if (value instanceof EObject) {
						copy.eSet(equivalentFeature, copyContainedEObject((EObject)value));
					
					} else {
						copy.eSet(equivalentFeature, value);
					}
				}
			}
		}
	}

	private EObject copyContainedEObject(EObject value) throws CopyingException {
		final List<Equivalence> nestedEquivalences = new Copier(targetModel).deepCopy(value);
		equivalences.addAll(nestedEquivalences);
		return nestedEquivalences.get(0).getCopy();
	}

}