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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.epsilon.eol.types.EolCollection;

class ModelValueWrapper {

	private final Model model;
	
	ModelValueWrapper(Model model) {
		this.model = model;
	}
	
	ModelValue<?> wrapValue(Object value) {
		if (value instanceof BackedModelValue<?>) {
			return (BackedModelValue<?>)value;
		
		} else if (value instanceof Enumerator) {
			return new EnumValue(model, (Enumerator)value);
			
		} else if (model.isModelElement(value)) {
			return wrapModelElement(value);
		
		} else if(value instanceof EolCollection) {
			return new CollectionOfModelValues(model, wrapValues((EolCollection)value));  
		
		} else {
			return new AttributeValue(model, value);
		}
	}
	
	ModelElement wrapModelElement(Object object) {
		if (!model.isModelElement(object)) 
			throw new IllegalArgumentException("Object is not an element of this model: " + object);
		
		return new ModelElement(model, object);
	}
	
	private Collection<ModelValue<?>> wrapValues(EolCollection underlyingModelObjects) {
		final Collection<ModelValue<?>> modelValues = new LinkedList<ModelValue<?>>();
		
		for (Object underlyingModelObject : underlyingModelObjects.getStorage()) {
			modelValues.add(model.wrap(underlyingModelObject));
		}
		
		return modelValues;
	}
}
