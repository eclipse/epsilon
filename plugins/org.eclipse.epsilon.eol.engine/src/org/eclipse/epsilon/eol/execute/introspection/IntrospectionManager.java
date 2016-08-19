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
package org.eclipse.epsilon.eol.execute.introspection;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;
import org.eclipse.epsilon.eol.models.IModel;

public class IntrospectionManager {
	
	protected IPropertyGetter defaultPropertyGetter = null;
	protected IPropertySetter defaultPropertySetter = null;
	
	public IntrospectionManager(){
		defaultPropertyGetter = new JavaPropertyGetter();
		defaultPropertySetter = new JavaPropertySetter();
	}
	
	public IPropertySetter getPropertySetterFor(Object object, String property, IEolContext context) {
		final IPropertySetter propertySetter;
		
		if (property.startsWith("~")) {
			propertySetter = new ExtendedPropertySetter(context);
		
		} else if (getModelThatKnowsAboutProperty(object, property, context) != null) {		
			propertySetter = getModelThatKnowsAboutProperty(object, property, context).getPropertySetter();
			
		} else {	
			propertySetter = defaultPropertySetter;
		}
		
		propertySetter.setProperty(property);
		propertySetter.setObject(object);
		propertySetter.setContext(context);
		
		return propertySetter;
	}
	
	public IPropertyGetter getPropertyGetterFor(Object object, String property, IEolContext context) {
		final IPropertyGetter propertyGetter;
		
		if (property.startsWith("~")) {
			propertyGetter = new ExtendedPropertyGetter(context);
		
		} else if (getModelThatKnowsAboutProperty(object, property, context) != null) {		// FIXME getModelThatKnowsAboutProperty is very inefficient and we call it twice
			propertyGetter = getModelThatKnowsAboutProperty(object, property, context).getPropertyGetter();
		
		} else {
			propertyGetter = defaultPropertyGetter;
		}
		
		propertyGetter.setContext(context);
		
		return propertyGetter;
	}
	
	public boolean isModelBasedProperty(Object object, String property, IEolContext context){
		return getModelThatKnowsAboutProperty(object, property, context) != null;
	}
	
	private IModel getModelThatKnowsAboutProperty(Object object, String property, IEolContext context) {
		for (IModel model : context.getModelRepository().getModels()) {
			if (model.knowsAboutProperty(object, property)) {
				return model;
			}
		}
		return null;
	}

	public IPropertyGetter getDefaultPropertyGetter() {
		return defaultPropertyGetter;
	}

	public void setDefaultPropertyGetter(IPropertyGetter defaultPropertyGetter) {
		this.defaultPropertyGetter = defaultPropertyGetter;
	}

	public IPropertySetter getDefaultPropertySetter() {
		return defaultPropertySetter;
	}

	public void setDefaultPropertySetter(IPropertySetter defaultPropertySetter) {
		this.defaultPropertySetter = defaultPropertySetter;
	}
	
	/*
	public ArrayList<PropertyGetter> getPropertyGetters() {
		return propertyGetters;
	}

	public ArrayList<PropertySetter> getPropertySetters() {
		return propertySetters;
	}
	*/
	
	
	/*
	private Object newInstance(Object object){
		try {
			return object.getClass().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList getPropertyGetters() {
		return propertyGetters;
	}

	public ArrayList getPropertySetters() {
		return propertySetters;
	}
	*/
}
