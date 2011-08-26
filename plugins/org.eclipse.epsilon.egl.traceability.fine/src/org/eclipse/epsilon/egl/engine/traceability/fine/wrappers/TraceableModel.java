/*******************************************************************************
 * Copyright (c) 2011 The University of York.
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
package org.eclipse.epsilon.egl.engine.traceability.fine.wrappers;

import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.commons.util.StringProperties;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolEnumerationValueNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;


public class TraceableModel implements IModel {
	
	private final IModel delegate;
	
	public TraceableModel(IModel delegate) {
		this.delegate = delegate;
	}
	
	public IPropertyGetter getPropertyGetter() {
		return new TraceablePropertyGetter(delegate.getPropertyGetter());
	}
	
	
	// The following methods simply delegate to the member

	public void load(StringProperties properties, String basePath)
			throws EolModelLoadingException {
		delegate.load(properties, basePath);
	}

	public void load() throws EolModelLoadingException {
		delegate.load();
	}

	public String getName() {
		return delegate.getName();
	}

	public void setName(String name) {
		delegate.setName(name);
	}

	public List<String> getAliases() {
		return delegate.getAliases();
	}

	public Object getEnumerationValue(String enumeration, String label)
			throws EolEnumerationValueNotFoundException {
		return delegate.getEnumerationValue(enumeration, label);
	}

	public Collection<?> allContents() {
		return delegate.allContents();
	}

	public Collection<?> getAllOfType(String type)
			throws EolModelElementTypeNotFoundException {
		return delegate.getAllOfType(type);
	}

	public Collection<?> getAllOfKind(String type)
			throws EolModelElementTypeNotFoundException {
		return delegate.getAllOfKind(type);
	}

	public Object getTypeOf(Object instance) {
		return delegate.getTypeOf(instance);
	}

	public String getTypeNameOf(Object instance) {
		return delegate.getTypeNameOf(instance);
	}

	public Object createInstance(String type)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return delegate.createInstance(type);
	}

	public Object createInstance(String type, Collection<Object> parameters)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return delegate.createInstance(type, parameters);
	}

	public Object getElementById(String id) {
		return delegate.getElementById(id);
	}

	public String getElementId(Object instance) {
		return delegate.getElementId(instance);
	}

	public void setElementId(Object instance, String newId) {
		delegate.setElementId(instance, newId);
	}

	public void deleteElement(Object instance) throws EolRuntimeException {
		delegate.deleteElement(instance);
	}

	public boolean isOfKind(Object instance, String type)
			throws EolModelElementTypeNotFoundException {
		return delegate.isOfKind(instance, type);
	}

	public boolean isOfType(Object instance, String type)
			throws EolModelElementTypeNotFoundException {
		return delegate.isOfType(instance, type);
	}

	public boolean owns(Object instance) {
		return delegate.owns(instance);
	}

	public boolean knowsAboutProperty(Object instance, String property) {
		return delegate.knowsAboutProperty(instance, property);
	}

	public boolean isInstantiable(String type) {
		return delegate.isInstantiable(type);
	}

	public boolean isModelElement(Object instance) {
		return delegate.isModelElement(instance);
	}

	public boolean hasType(String type) {
		return delegate.hasType(type);
	}

	public boolean store(String location) {
		return delegate.store(location);
	}

	public boolean store() {
		return delegate.store();
	}

	public void dispose() {
		delegate.dispose();
	}

	public IPropertySetter getPropertySetter() {
		return delegate.getPropertySetter();
	}

	public boolean isStoredOnDisposal() {
		return delegate.isStoredOnDisposal();
	}

	public void setStoredOnDisposal(boolean storedOnDisposal) {
		delegate.setStoredOnDisposal(storedOnDisposal);
	}

	public boolean isReadOnLoad() {
		return delegate.isReadOnLoad();
	}

	public void setReadOnLoad(boolean readOnLoad) {
		delegate.setReadOnLoad(readOnLoad);
	}

	public IModelTransactionSupport getTransactionSupport() {
		return delegate.getTransactionSupport();
	}
	
	
}