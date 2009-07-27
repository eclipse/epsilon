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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolSequence;

public class Copier {
	
	private final IModel originalModel;
	private final IModel targetModel;
	
	private final List<Equivalence> equivalences = new LinkedList<Equivalence>();
	
	private Object original;
	private Object copy;
	
	public Copier(IModel originalModel, IModel targetModel) {
		this.originalModel = originalModel;
		this.targetModel   = targetModel;
	}
	
	public List<Equivalence> deepCopy(Object original) throws CopyingException {	
		this.original = original;
		equivalences.clear();
	
		copyObject(original);
	
		return equivalences;
	}
	
	private void copyObject(Object original) throws CopyingException {
		try {
			copy = targetModel.createInstance(originalModel.getTypeNameOf(original));
			equivalences.add(new Equivalence(original, copy));
			
			for (String feature : originalModel.getPropertiesOf(original)) {
				copyFeature(feature);
			}
			
		} catch (EolRuntimeException e) {
			throw new CopyingException("Could not copy: " + original, e);	
		}
	}

	// TODO should be an error when equivalentFeature is null and value is non-empty and non-null?
	private void copyFeature(String feature) throws CopyingException {
		final Object originalValue = getFeatureOfOriginal(feature);
		final Object copiedValue;
		
		if (targetModel.knowsAboutProperty(copy, feature)) {
				
			if (originalValue instanceof Enumerator) {
				copiedValue = getEquivalentEnumerationValue((Enumerator)originalValue);
			
			} else if (originalValue instanceof EolCollection && collectionContainsOnlyOriginalModelElements((EolCollection)originalValue)) {
				copiedValue = copyContainedObjects((EolCollection)originalValue);
			
			} else if (originalModel.owns(originalValue)) {
				copiedValue = copyContainedObject(originalValue);
			
			} else {
				copiedValue = originalValue;
			}
			
			setFeatureOfCopy(feature, copiedValue);
		}
	}

	private Object getFeatureOfOriginal(String feature) throws CopyingException {
		try {
			return originalModel.getPropertyGetter().invoke(original, feature);
		
		} catch (EolRuntimeException ex) {
			throw new CopyingException("Could not get the value of " + feature + " on " + original, ex);
		}
	}
	
	private void setFeatureOfCopy(String feature, Object value) throws CopyingException {
		try {
			final IPropertySetter setter = targetModel.getPropertySetter();
			setter.setObject(copy);
			setter.setProperty(feature);
			setter.invoke(value);
		
		} catch (EolRuntimeException ex) {
			throw new CopyingException("Could not set " + feature + " to " + value + " on " + copy, ex);
		}
	}
	
	private boolean collectionContainsOnlyOriginalModelElements(EolCollection collection) {
		for (Object element : collection.getStorage()) {
			if (!originalModel.owns(element)) {
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

	private EolCollection copyContainedObjects(EolCollection valueList) throws CopyingException {
		final EolCollection copiedValues = new EolSequence();
		
		for (Object element : valueList.getStorage()) {
			copiedValues.add(copyContainedObject(element));
		}
		
		return copiedValues;
	}

	private Object copyContainedObject(Object containedObject) throws CopyingException {
		final List<Equivalence> nestedEquivalences = new Copier(originalModel, targetModel).deepCopy(containedObject);
		equivalences.addAll(nestedEquivalences);
		return nestedEquivalences.get(0).getCopy();
	}

}