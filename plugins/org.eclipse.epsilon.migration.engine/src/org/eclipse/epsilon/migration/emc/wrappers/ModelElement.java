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
package org.eclipse.epsilon.migration.emc.wrappers;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.migration.execution.Equivalences;

public class ModelElement extends BackedModelValue<Object> {
	
	ModelElement(Model model, Object underlyingModelElement) {
		super(model, underlyingModelElement);
	}
	
	@Override
	ModelElement getEquivalentIn(Model model, Equivalences equivalences) {
		return equivalences.getEquivalent(this);
	}

	public String getTypeName() {
		return model.getTypeNameOf(underlyingModelObject);
	}
	
	public void conservativelyCopyPropertiesFrom(ModelElement original, Equivalences equivalences) throws CopyingException {
		try {
			for (String propertyName : getPropertiesSharedWith(original)) {
				final ModelValue<?> originalValueOfProperty = original.getValueOfProperty(propertyName);
				
				this.setValueOfProperty(propertyName, originalValueOfProperty.getEquivalentIn(model, equivalences));
			}
		} catch (EolRuntimeException e) {
			throw new CopyingException("Exception encountered while reading or writing a property value.", e);
		}
	}
	
	Collection<String> getPropertiesSharedWith(ModelElement other) {
		final Collection<String> filteredProperties = new LinkedList<String>(other.getProperties());
		
		filteredProperties.retainAll(getProperties());
	
		return filteredProperties;
	}

	Collection<String> getProperties() {
		return model.getPropertiesOf(underlyingModelObject);
	}
	
	ModelValue<?> getValueOfProperty(String property) throws EolRuntimeException {
		return model.getValueOfProperty(underlyingModelObject, property);
	}
	
	private void setValueOfProperty(String property, ModelValue<?> value) throws EolRuntimeException {
		model.setValueOfProperty(underlyingModelObject, property, value);
	}
}
