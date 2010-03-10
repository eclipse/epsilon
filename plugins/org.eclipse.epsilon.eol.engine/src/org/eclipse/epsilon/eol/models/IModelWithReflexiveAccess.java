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
package org.eclipse.epsilon.eol.models;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.execute.introspection.IPropertySetterWithReflexiveAccess;

public interface IModelWithReflexiveAccess extends IModel {

	/**
	 * Returns a collection containing all of the properties that instances
	 * of type know about.
	 * 
	 * @param type The type of model object whose properties are to be determined.
	 * @return all of the properties that instances of type knows about.
	 * @throws EolModelElementTypeNotFoundException when this model has no such type
	 */
	public Collection<String> getPropertiesOf(String type) throws EolModelElementTypeNotFoundException;
	
	public IPropertySetterWithReflexiveAccess getPropertySetter();
}
