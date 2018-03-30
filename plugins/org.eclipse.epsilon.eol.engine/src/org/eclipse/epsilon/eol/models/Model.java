/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.epsilon.common.util.StringProperties;
import org.eclipse.epsilon.eol.compile.m3.Metamodel;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolModelLoadingException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;
import org.eclipse.epsilon.eol.models.transactions.NoModelTransactionSupport;

public abstract class Model implements IModel {
	
	public static final String
		PROPERTY_NAME = "name",
		PROPERTY_READONLOAD = "readOnLoad",
		PROPERTY_STOREONDISPOSAL = "storeOnDisposal",
		PROPERTY_ALIASES = "aliases";
	
	protected String name;
	protected List<String> aliases = new ArrayList<>();
	protected boolean storeOnDisposal = false;
	protected boolean readOnLoad = true;
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public List<String> getAliases() {
		return aliases;
	}
	
	@Override
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException {	
		load(properties, relativePath -> basePath + relativePath);	
	}
	
	@Override
	public void load(StringProperties properties) throws EolModelLoadingException {
		load(properties, relativePath -> relativePath);
	}
	
	@Override
	public void load(StringProperties properties, IRelativePathResolver resolver) throws EolModelLoadingException {
		this.name = properties.getProperty(PROPERTY_NAME);
		this.readOnLoad = Boolean.parseBoolean(properties.getProperty(PROPERTY_READONLOAD));
		this.storeOnDisposal = Boolean.parseBoolean(properties.getProperty(PROPERTY_STOREONDISPOSAL));
		
		for (String alias : properties.getProperty(PROPERTY_ALIASES).split(",")) {
			this.aliases.add(alias.trim());
		}
	}
	
	@Override
	public Object createInstance(String type, Collection<Object> parameters)
			throws EolModelElementTypeNotFoundException,
			EolNotInstantiableModelElementTypeException {
		return createInstance(type);
	}
	
	public Collection<?> allInstances() {
		return allContents();
	}

	@Override
	public boolean isOfKind(Object instance, String metaClass) throws EolModelElementTypeNotFoundException {
		Collection<?> allOfKind = getAllOfKind(metaClass);
		if (allOfKind != null && allOfKind.contains(instance)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isOfType(Object instance, String metaClass) throws EolModelElementTypeNotFoundException {
		Collection<?> allOfClass = getAllOfType(metaClass);
		if (allOfClass != null && allOfClass.contains(instance)) {
			return true;
		}
		else {
			return false;
		}		
	}
	
	@Override
	public String getFullyQualifiedTypeNameOf(Object instance) {
		return getTypeNameOf(instance);
	}
	
	@Override
	public boolean isModelElement(Object instance) {
		return owns(instance);
	}
	
	@Override
	public Object getTypeOf(Object instance) {
		return null;
	}
	
	@Override
	public boolean isReadOnLoad() {
		return readOnLoad;
	}

	@Override
	public boolean isStoredOnDisposal() {
		return storeOnDisposal;
	}

	@Override
	public void setReadOnLoad(boolean readOnLoad) {
		this.readOnLoad = readOnLoad;
	}

	@Override
	public void setStoredOnDisposal(boolean storedOnDisposal) {
		this.storeOnDisposal = storedOnDisposal;
	}

	@Override
	public IPropertyGetter getPropertyGetter() {
		return new JavaPropertyGetter();
	}

	@Override
	public IPropertySetter getPropertySetter() {
		return new JavaPropertySetter();
	}
	
	@Override
	public void dispose() {
		if (this.isStoredOnDisposal()){
			this.store();
		}
	}
	
	@Override
	public boolean knowsAboutProperty(Object instance, String property) {
		return owns(instance);
	}
	
	NoModelTransactionSupport transactionSupport = new NoModelTransactionSupport();
	@Override
	public IModelTransactionSupport getTransactionSupport() {
		return transactionSupport;
	}
	
	@Override
	public Metamodel getMetamodel(StringProperties properties, IRelativePathResolver resolver) {
		return null;
	}

	@Override
	public boolean isPropertySet(Object instance, String property) throws EolRuntimeException {
		return getPropertyGetter().invoke(instance, property) != null;
	}
}
