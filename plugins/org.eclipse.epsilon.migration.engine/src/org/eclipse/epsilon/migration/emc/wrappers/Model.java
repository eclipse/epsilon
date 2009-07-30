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

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolCollection;

public class Model {
	
	private final IModel underlyingModel;
	
	public Model(IModel underlyingModel) {
		this.underlyingModel = underlyingModel;
	}

	ModelValue<?> wrapValue(Object value) {
		if (value instanceof ModelValue<?>) {
			return (ModelValue<?>)value;
		
		} else if (value instanceof Enumerator) {
			return new EnumValue(this, (Enumerator)value);
			
		} else if (underlyingModel.isModelElement(value)) {
			return toModelElement(value);
		
		} else if(value instanceof EolCollection) {
			return new CollectionOfModelValues(this, ((EolCollection)value));  
		
		} else {
			return new AttributeValue(this, value);
		}
	}
	
	public ModelElement createInstance(String typeName) throws EolRuntimeException {
		return toModelElement(underlyingModel.createInstance(typeName));
	}
	
	public Iterable<ModelElement> allContents() {
		final Collection<ModelElement> modelElements = new LinkedList<ModelElement>();
		
		for (Object unwrappedModelElement : underlyingModel.allContents()) {
			modelElements.add(toModelElement(unwrappedModelElement));
		}
		
		return modelElements;
	}
	
	private ModelElement toModelElement(Object object) {
		if (!underlyingModel.isModelElement(object)) 
			throw new IllegalArgumentException("Object is not an element of this model: " + object);
		
		return new ModelElement(this, object);
	}
	

	public String getTypeNameOf(Object instance) {
		return underlyingModel.getTypeNameOf(instance);
	}
	
	public boolean knowsAboutProperty(Object instance, String property) {
		return underlyingModel.knowsAboutProperty(instance, property);
	}

	public Collection<String> getPropertiesOf(Object instance) {
		return underlyingModel.getPropertiesOf(instance);
	}

	public ModelValue<?> getValueOfProperty(Object underlyingModelObject, String property) throws EolRuntimeException {
		return wrapValue(underlyingModel.getPropertyGetter().invoke(underlyingModelObject, property));
	}

	public void setValueOfProperty(Object underlyingModelObject, String property, ModelValue<?> value) throws EolRuntimeException {
		final IPropertySetter setter = underlyingModel.getPropertySetter();
		setter.setObject(underlyingModelObject);
		setter.setProperty(property);
		setter.invoke(value.unwrap());
	}

	public Enumerator getEquivalent(Enumerator original) throws EolEnumerationValueNotFoundException {
		final String enumeration;
		
		if (original instanceof EEnumLiteral) {
			enumeration = ((EEnumLiteral)original).getEEnum().getName();
		} else {
			enumeration = original.getClass().getSimpleName();
		}
		
		return (Enumerator)underlyingModel.getEnumerationValue(enumeration, original.getName());
	}
}
