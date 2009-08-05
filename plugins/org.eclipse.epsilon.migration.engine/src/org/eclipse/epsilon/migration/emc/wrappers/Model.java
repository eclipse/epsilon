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

public class Model {
	
	private final IModel underlyingModel;
	private final ModelValueWrapper wrapper;
	
	public Model(IModel underlyingModel) {
		this.underlyingModel = underlyingModel;
		this.wrapper         = new ModelValueWrapper(this);
	}
	
	// Used by tests
	Model(IModel underlyingModel, ModelValueWrapper wrapper) {
		this.underlyingModel = underlyingModel;
		this.wrapper         = wrapper;
	}
	
	public ModelElement createInstance(String typeName) throws EolRuntimeException {
		return wrapModelElement(underlyingModel.createInstance(typeName));
	}
	
	public Iterable<ModelElement> allContents() {
		final Collection<ModelElement> modelElements = new LinkedList<ModelElement>();
		
		for (Object unwrappedModelElement : underlyingModel.allContents()) {
			modelElements.add(wrapModelElement(unwrappedModelElement));
		}
		
		return modelElements;
	}
	
	ModelValue<?> wrapValue(Object value) {
		return wrapper.wrapValue(value);
	}
	
	private ModelElement wrapModelElement(Object object) {
		return wrapper.wrapModelElement(object);
	}
	
	boolean isModelElement(Object object) {
		return underlyingModel.isModelElement(object);
	}

	String getTypeNameOf(Object underlyingModelElement) {
		return underlyingModel.getTypeNameOf(underlyingModelElement);
	}
	
	boolean knowsAboutProperty(Object underlyingModelElement, String property) {
		return underlyingModel.knowsAboutProperty(underlyingModelElement, property);
	}

	Collection<String> getPropertiesOf(Object underlyingModelElement) {
		return underlyingModel.getPropertiesOf(underlyingModelElement);
	}

	ModelValue<?> getValueOfProperty(Object underlyingModelElement, String property) throws EolRuntimeException {
		return wrapper.wrapValue(underlyingModel.getPropertyGetter().invoke(underlyingModelElement, property));
	}

	void setValueOfProperty(Object underlyingModelElement, String property, ModelValue<?> value) throws EolRuntimeException {
		final IPropertySetter setter = underlyingModel.getPropertySetter();
		setter.setObject(underlyingModelElement);
		setter.setProperty(property);
		setter.invoke(value.unwrap());
	}

	Enumerator getEquivalent(Enumerator original) throws EolEnumerationValueNotFoundException {
		final String enumeration;
		
		if (original instanceof EEnumLiteral) {
			enumeration = ((EEnumLiteral)original).getEEnum().getName();
		} else {
			enumeration = original.getClass().getSimpleName();
		}
		
		return (Enumerator)underlyingModel.getEnumerationValue(enumeration, original.getName());
	}
}
