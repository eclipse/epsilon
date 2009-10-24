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

import java.util.ListIterator;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertyGetter;
import org.eclipse.epsilon.eol.execute.introspection.java.JavaPropertySetter;
import org.eclipse.epsilon.eol.models.IModel;

public class IntrospectionManager {
	
	/*
	protected ArrayList<PropertySetter> propertySetters = new ArrayList();
	protected ArrayList<PropertyGetter> propertyGetters = new ArrayList();
	*/
	
	protected IPropertyGetter defaultPropertyGetter = null;
	protected IPropertySetter defaultPropertySetter = null;
	
	public IntrospectionManager(){
		
		defaultPropertyGetter = new JavaPropertyGetter();
		defaultPropertySetter = new JavaPropertySetter();
		
		/*
		propertySetters.add(new EmfPropertySetter());
		propertyGetters.add(new EmfPropertyGetter());
	
		if (useExperimental){
			propertySetters.add(new MofPropertySetter());
			propertyGetters.add(new MofPropertyGetter());
			propertySetters.add(new XmlPropertySetter());
			propertyGetters.add(new XmlPropertyGetter());
		}
		*/
	}
	
	public IPropertySetter getPropertySetterFor(Object object, String property, IEolContext context) {
		
		if (property.startsWith("~")) {
			ExtendedPropertySetter propertySetter = new ExtendedPropertySetter(context);
			propertySetter.setObject(object);
			propertySetter.setProperty(property.substring(1));
			propertySetter.setContext(context);
			return propertySetter;
		}
		
		/*
		ListIterator li = propertySetters.listIterator();
		while (li.hasNext()){
			PropertySetter propertySetter = (PropertySetter) li.next();
			if (propertySetter.appliesTo(object, property)){
				PropertySetter ps = (PropertySetter) newInstance(propertySetter);
				ps.setProperty(property);
				ps.setObject(object);
				return ps;
			}
		}
		JavaPropertySetter jps = new JavaPropertySetter();
		jps.setProperty(property);
		jps.setObject(object);
		return jps;
		*/
		
		ListIterator li = context.getModelRepository().getModels().listIterator();
		while (li.hasNext()){
			IModel model = (IModel) li.next();
			if (model.knowsAboutProperty(object, property)) {
				IPropertySetter ps = model.getPropertySetter();
				ps.setObject(object);
				ps.setProperty(property);
				ps.setContext(context);
				return ps;
			}
		}
		
		//JavaPropertySetter jps = new JavaPropertySetter();
		//jps.setProperty(property);
		//jps.setObject(object);
		//return jps;
		
		defaultPropertySetter.setProperty(property);
		defaultPropertySetter.setObject(object);
		defaultPropertySetter.setContext(context);
		return defaultPropertySetter;
		
	}
	
	public IPropertyGetter getPropertyGetterFor(Object object, String property, IEolContext context){
		
		if (property.startsWith("~")) {
			ExtendedPropertyGetter propertyGetter = new ExtendedPropertyGetter(context);
			propertyGetter.setContext(context);
			return propertyGetter;
		}
		
		for (IModel model : context.getModelRepository().getModels()) {
			if (model.knowsAboutProperty(object, property)) {
				IPropertyGetter pg = model.getPropertyGetter();
				pg.setContext(context);
				return pg;
			}
		}
		
		defaultPropertyGetter.setContext(context);
		return defaultPropertyGetter;
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
