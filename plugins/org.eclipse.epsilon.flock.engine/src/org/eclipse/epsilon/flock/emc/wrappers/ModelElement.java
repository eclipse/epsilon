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
package org.eclipse.epsilon.flock.emc.wrappers;

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;

public class ModelElement extends BackedModelValue<Object> {
	
	ModelElement(Model model, Object underlyingModelElement) {
		super(model, underlyingModelElement);
	}
	
	@Override
	public ModelValue<?> getEquivalentIn(Model model, IFlockContext context) {
		// context.getEquivalent might be null, so ensure return value is wrapped
		return model.wrap(context.getEquivalent(this));
	}

	public String getTypeName() {
		return model.getTypeNameOf(underlyingModelObject);
	}
	
	public boolean isKindOf(String originalType) {
		return model.isKindOf(underlyingModelObject, originalType);
	}
	
	public void conservativelyCopyPropertiesFrom(ModelElement original, IFlockContext context) throws ConservativeCopyException {
		try {
			for (String propertyName : getPropertiesSharedWith(original)) {				
				final ModelValue<?> originalValueOfProperty = original.getValueOfProperty(propertyName);
				
				final ModelValue<?> migratedValue = originalValueOfProperty.getEquivalentIn(model, context);
				
				try {
					this.setValueOfProperty(propertyName, migratedValue);
				} catch (Exception e) {
					// TODO - note circumstances in which this block is entered and guard
					//        setValueOfProperty statement with appropriate checks 
					e.printStackTrace();
				}
			}
		} catch (EolRuntimeException e) {
			throw new ConservativeCopyException("Exception encountered while reading or writing a property value.", e);
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
	
	@Override
	public String toString() {
		return "<" + model.getStringRepresentationOf(underlyingModelObject) + ">";
	}
}
