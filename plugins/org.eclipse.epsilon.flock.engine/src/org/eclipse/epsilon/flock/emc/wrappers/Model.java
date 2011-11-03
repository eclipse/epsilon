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
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.epsilon.emc.emf.AbstractEmfModel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.execute.introspection.IReflectivePropertySetter;
import org.eclipse.epsilon.eol.execute.prettyprinting.PrettyPrinterManager;
import org.eclipse.epsilon.eol.models.IReflectiveModel;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;

public class Model {
	
	private final IReflectiveModel underlyingModel;
	private final PrettyPrinterManager printer;
	private final ModelValueWrapper wrapper;
	
	public Model(IReflectiveModel underlyingModel, PrettyPrinterManager printer) {
		this.underlyingModel = underlyingModel;
		this.printer         = printer;
		this.wrapper         = new ModelValueWrapper(this);
	}
	
	// Used by tests to customise wrapper
	Model(IReflectiveModel underlyingModel, ModelValueWrapper wrapper) {
		this.underlyingModel = underlyingModel;
		this.printer         = new PrettyPrinterManager();
		this.wrapper         = wrapper;
	}
	
	// Used by tests that don't wish to supply a printer print manager
	Model(IReflectiveModel underlyingModel) {
		this(underlyingModel, new PrettyPrinterManager());
	}
	
	
	public ModelElement createInstance(String typeName) throws EolRuntimeException {
		return wrapModelElement(underlyingModel.createInstance(typeName));
	}
	
	public boolean hasType(String typeName) {
		return underlyingModel.hasType(typeName);
	}
	
	public boolean isInstantiable(String typeName) {
		return underlyingModel.isInstantiable(typeName);
	}
	
	public boolean hasProperty(String type, String property) throws EolRuntimeException {
		return underlyingModel.hasProperty(type, property);
	}
	
	public Iterable<ModelElement> allContents() {
		final Collection<ModelElement> modelElements = new LinkedList<ModelElement>();
		
		for (Object unwrappedModelElement : underlyingModel.allContents()) {
			modelElements.add(wrapModelElement(unwrappedModelElement));
		}
		
		return modelElements;
	}
	
	public boolean owns(ModelElement element) {
		return owns(element.unwrap());
	}
	
	public boolean owns(Object unwrappedElement) {
		return underlyingModel.owns(unwrappedElement);
	}
	
	public ModelValue<?> wrap(Object value) {
		return wrapper.wrapValue(value);
	}
	
	ModelElement wrapModelElement(Object object) {
		return wrapper.wrapModelElement(object);
	}
	
	boolean isModelElement(Object object) {
		return underlyingModel.isModelElement(object);
	}

	String getTypeNameOf(Object underlyingModelElement) {
		return underlyingModel.getFullyQualifiedTypeNameOf(underlyingModelElement);
	}
	
	boolean isKindOf(Object underlyingModelElement, String originalType) {
		try {
			return underlyingModel.isOfKind(underlyingModelElement, originalType);
			
		} catch (EolModelElementTypeNotFoundException e) {
			return false;
		}
	}
	
	boolean knowsAboutProperty(Object underlyingModelElement, String property) {
		return underlyingModel.knowsAboutProperty(underlyingModelElement, property);
	}

	Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException {
		return underlyingModel.getPropertiesOf(type);
	}

	ModelValue<?> getValueOfProperty(Object underlyingModelElement, String property) throws EolRuntimeException {
		return wrapper.wrapValue(underlyingModel.getPropertyGetter().invoke(underlyingModelElement, property));
	}

	void setValueOfProperty(Object underlyingModelElement, String property, ModelValue<?> value) throws EolRuntimeException {
		final IReflectivePropertySetter setter = underlyingModel.getPropertySetter();
		setter.setObject(underlyingModelElement);
		setter.setProperty(property);
		setter.invoke(setter.coerce(value.unwrap()));
	}
	
	boolean conforms(Object underlyingModelElement, String property, ModelValue<?> value) throws EolRuntimeException {
		final IReflectivePropertySetter setter = underlyingModel.getPropertySetter();
		setter.setObject(underlyingModelElement);
		setter.setProperty(property);
		return setter.conforms(value.unwrap());
	}
	
	String getStringRepresentationOf(Object underlyingModelObject) {
		return printer.print(underlyingModelObject);
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
	
	public Object getUnwrappedEquivalent(Object unwrappedModelElement, Model otherModel, ConservativeCopyContext context) throws ConservativeCopyException {
		return wrap(unwrappedModelElement).getUnwrappedEquivalentIn(otherModel, context);
	}

	/**
	 * If the underlying model is an AbstractEmfModel and isExpand returns true, this
	 * method turns off expansion, and returns true.
	 * 
	 * If the underlying model is not an AbstractEmfModel, this method does nothing
	 * and returns false.
	 * 
	 * If the underlying model an AbstractEmfModel and isExpand returns false, this method
	 * does nothing and returns false.
	 * 
	 * @return true if and only if isExpand was changed from true to false
	 */
	public boolean ensureExpandIsOff() {
		if (!(underlyingModel instanceof AbstractEmfModel))
			return false;
		
		final AbstractEmfModel underlyingEmfModel = (AbstractEmfModel) underlyingModel;
			
		if (!underlyingEmfModel.isExpand())
			return false;
		
		underlyingEmfModel.setExpand(false);
		return true;
	}

	public String getIdentity(Object underlyingModelObject) {
		return underlyingModel.getElementId(underlyingModelObject);
	}
	
	public void setIdentity(Object underlyingModelObject, String newIdentity) {
		underlyingModel.setElementId(underlyingModelObject, newIdentity);
	}
}
