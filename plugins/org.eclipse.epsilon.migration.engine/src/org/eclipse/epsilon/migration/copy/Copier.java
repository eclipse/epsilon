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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.migration.execution.Equivalences;

public class Copier {
	
	private final IModel originalModel;
	private final IModel targetModel;
	private final Equivalences equivalences;
	
	private ModelElement original;
	private ModelElement copy;
	
	public Copier(IModel originalModel, IModel targetModel, Equivalences equivalences) {
		this.originalModel = originalModel;
		this.targetModel   = targetModel;
		this.equivalences  = equivalences;
	}
	
	public void copy(Object original, Object copy) throws CopyingException {	
		this.original = new ModelElement(originalModel, original);
		this.copy     = new ModelElement(targetModel,   copy);
	
		copyProperties();
	}
	
	private void copyProperties() throws CopyingException {
		for (String property : original.getProperties()) {
			copyProperty(property);
		}
	}

	// TODO should be an error when equivalentFeature is null and value is non-empty and non-null?
	private void copyProperty(String property) throws CopyingException {
		try {
			final Object originalValue = original.getProperty(property);
			final Object copiedValue;
			
			if (copy.knowsAboutProperty(property)) {
				
				if (originalValue instanceof Enumerator) {
					copiedValue = getEquivalentEnumerationValue((Enumerator)originalValue);
				
				} else if (originalValue instanceof EolCollection && collectionContainsOnlyOriginalModelElements((EolCollection)originalValue)) {
					copiedValue = getEquivalentModelElements((EolCollection)originalValue);
				
				} else if (originalModel.isModelElement(originalValue) && equivalences.hasEquivalent(originalValue)) {
					copiedValue = equivalences.getEquivalent(originalValue);
				
				} else {
					copiedValue = originalValue;
				}
							
				copy.setProperty(property, copiedValue);
			}
			
		} catch (EolRuntimeException e) {
			throw new CopyingException("Exception encountered while reading or writing a property value.", e);
		}
	}
	
	private boolean collectionContainsOnlyOriginalModelElements(EolCollection collection) {
		for (Object element : collection.getStorage()) {
			if (!originalModel.isModelElement(element)) {
				return false;
			}
		}
		
		return true;
	}
	
	private Object getEquivalentEnumerationValue(Enumerator originalValue) throws CopyingException {
		try {
			final String enumeration;
			
			if (originalValue instanceof EEnumLiteral) {
				enumeration = ((EEnumLiteral)originalValue).getEEnum().getName();
			} else {
				enumeration = originalValue.getClass().getSimpleName();
			}
			
			return targetModel.getEnumerationValue(enumeration, originalValue.getName());
			
		} catch (EolEnumerationValueNotFoundException e) {
			throw new CopyingException("Could not find in target model an enumeration value equivalent to: " + originalValue, e);
		}
	}

	private EolCollection getEquivalentModelElements(EolCollection originalModelElements) throws CopyingException {
		return new EolSequence(equivalences.getEquivalents(originalModelElements.getStorage()));
	}
}