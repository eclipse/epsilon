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

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;

public class ModelElement extends BackedModelValue<Object> {
	
	private final ModelType type;
	
	ModelElement(Model model, ModelType type, Object underlyingModelElement) {
		super(model, underlyingModelElement);
		this.type = type;
	}
	
	@Override
	public ModelValue<?> getEquivalentIn(Model model, ConservativeCopyContext context) {
		// context.getEquivalent might be null, so ensure return value is wrapped
		return isExternal() ? this : model.wrap(context.getEquivalent(this));
	}
	
	private boolean isExternal() {
		return !model.owns(underlyingModelObject);
	}

	public ModelType getType() {
		return type;
	}

	public String getTypeName() {
		return type.getName();
	}
	
	public boolean isKindOf(String originalType) {
		return model.isKindOf(underlyingModelObject, originalType);
	}
	
	public void copyIdentityFrom(ModelElement original) {
		setIdentity(original.getIdentity());
	}
	
	String getIdentity() {
		return model.getIdentity(underlyingModelObject);
	}
	
	void setIdentity(String identity) {
		model.setIdentity(underlyingModelObject, identity);
	}
	
	public void conservativelyCopyPropertiesFrom(ModelElement original, ConservativeCopyContext context) throws ConservativeCopyException {		
		try {			
			for (String propertyName : this.getPropertiesSharedWith(original)) {
				conservativelyCopyPropertyFrom(original, propertyName, context);
			}
			
		} catch (EolModelElementTypeNotFoundException e) {
			throw new ConservativeCopyException("Exception encountered while determining properties shared between " + original + " and " + this, e);
		}
	}

	private void conservativelyCopyPropertyFrom(ModelElement original, String propertyName, ConservativeCopyContext context) throws ConservativeCopyException {
		try {
			final ModelValue<?> originalValue   = original.getValueOfProperty(propertyName);
			final ModelValue<?> equivalentValue = originalValue.getEquivalentIn(model, context);
			
			if (conforms(propertyName, equivalentValue))
				setValueOfProperty(propertyName, equivalentValue);
		
		} catch (EolRuntimeException e) {
			throw new ConservativeCopyException("Exception encountered while copying '" + propertyName + "' from " + original + " to " + this, e);
		}
	}

	Collection<String> getPropertiesSharedWith(ModelElement element) throws EolModelElementTypeNotFoundException {
		return type.getPropertiesSharedWith(element.getType());
	}
	
	ModelValue<?> getValueOfProperty(String property) throws EolRuntimeException {
		return model.getValueOfProperty(underlyingModelObject, property);
	}
	
	boolean conforms(String property, ModelValue<?> value) throws EolRuntimeException {
		return model.conforms(underlyingModelObject, property, value);
	}
	
	void setValueOfProperty(String property, ModelValue<?> value) throws EolRuntimeException {
		try {
			model.setValueOfProperty(underlyingModelObject, property, value);
		} catch (Exception e) {
			// TODO - note circumstances in which this block is entered and guard with appropriate checks 
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return "<" + model.getStringRepresentationOf(underlyingModelObject) + ">";
	}
}
