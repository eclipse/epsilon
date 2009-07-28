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
package org.eclipse.epsilon.migration.copy;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetter;
import org.eclipse.epsilon.eol.models.IModel;

public class ModelElement {

	private final IModel model;
	private final Object element;
	
	public ModelElement(IModel model, Object element) {
		this.model   = model;
		this.element = element;
	}
	
	public Collection<String> getProperties() {
		return model.getPropertiesOf(element);
	}
	
	public boolean knowsAboutProperty(String property) {
		return model.knowsAboutProperty(element, property);
	}
	
	public Object getProperty(String property) throws CopyingException {
		try {
			return model.getPropertyGetter().invoke(element, property);
		
		} catch (EolRuntimeException ex) {
			throw new CopyingException("Could not get the value of " + property + " on " + element, ex);
		}
	}
	
	public void setProperty(String property, Object value) throws CopyingException {
		try {
			final IPropertySetter setter = model.getPropertySetter();
			setter.setObject(element);
			setter.setProperty(property);
			setter.invoke(value);
		
		} catch (EolRuntimeException ex) {
			throw new CopyingException("Could not set " + property + " to " + value + " on " + element, ex);
		}
	}
}
