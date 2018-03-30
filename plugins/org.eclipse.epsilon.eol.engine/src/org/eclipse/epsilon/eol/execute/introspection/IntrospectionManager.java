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
	
	protected IPropertyGetter defaultPropertyGetter = new JavaPropertyGetter();
	protected IPropertySetter defaultPropertySetter = new JavaPropertySetter();
	
	public IPropertySetter getPropertySetterFor(Object object, String property, IEolContext context) {
		final IPropertySetter propertySetter;
		
		if (property.startsWith("~")) {
			propertySetter = new ExtendedPropertySetter(context);
		}
		else {
			IModel knowsModel = getModelThatKnowsAboutProperty(object, property, context);
			propertySetter = knowsModel != null ? knowsModel.getPropertySetter() : defaultPropertySetter;
		}
		
		propertySetter.setObject(object);
		propertySetter.setProperty(property);
		propertySetter.setContext(context);
		
		return propertySetter;
	}
	
	public IPropertyGetter getPropertyGetterFor(Object object, String property, IEolContext context) {
		final IPropertyGetter propertyGetter;
		
		if (property.startsWith("~")) {
			propertyGetter = new ExtendedPropertyGetter(context);
		}
		else { 
			IModel knowsModel = getModelThatKnowsAboutProperty(object, property, context);
			propertyGetter = knowsModel != null ? knowsModel.getPropertyGetter() : defaultPropertyGetter;
		}
		
		propertyGetter.setContext(context);
		
		return propertyGetter;
	}
	
	public boolean isModelBasedProperty(Object object, String property, IEolContext context) {
		return getModelThatKnowsAboutProperty(object, property, context) != null;
	}
	
	public static IModel getModelThatKnowsAboutProperty(Object object, String property, IEolContext context) {
		return context.getModelRepository().getModels()
			.stream()
			.filter(model -> model.knowsAboutProperty(object, property))
			.findAny()
			.orElse(null);
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
}
