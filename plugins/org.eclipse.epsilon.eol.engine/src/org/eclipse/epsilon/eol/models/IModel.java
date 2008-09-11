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
import org.eclipse.epsilon.eol.models.transactions.IModelTransactionSupport;

public interface IModel {
	
	public void load(StringProperties properties, String basePath) throws EolModelLoadingException;
	
	public void load() throws EolModelLoadingException;
	
	public String getName();
	
	public void setName(String name);
	
	public List<String> getAliases();
	
	public Object getEnumerationValue(String enumeration, String label) throws EolEnumerationValueNotFoundException;
	
	public Collection allContents();
	
	public Collection getAllOfType(String type) throws EolModelElementTypeNotFoundException;
	
	public Collection getAllOfKind(String type) throws EolModelElementTypeNotFoundException;
	
	public Object getTypeOf(Object instance);
	
	public Object createInstance(String type) throws EolModelElementTypeNotFoundException, EolNotInstantiableModelElementTypeException;
	
	public Object getElementById(String id);
	
	public String getElementId(Object instance);
	
	public void deleteElement(Object instance) throws EolRuntimeException;
	
	public boolean isOfKind(Object instance, String type) throws EolModelElementTypeNotFoundException;

	public boolean isOfType(Object instance, String type) throws EolModelElementTypeNotFoundException;
	
	public boolean owns(Object instance);
	
	public boolean isInstantiable(String type); 
	
	public boolean isModelElement(Object instance);
	
	public boolean hasType(String type);
	
	public boolean store(String location);
	
	public boolean store();
	
	public void dispose();
	
	public IPropertyGetter getPropertyGetter();
	
	public IPropertySetter getPropertySetter();
	
	public boolean isStoredOnDispoal();
	
	public void setStoredOnDisposal(boolean storedOnDisposal);
	
	public boolean isReadOnLoad();
	
	public void setReadOnLoad(boolean readOnLoad);
	
	public IModelTransactionSupport getTransactionSupport();
}
