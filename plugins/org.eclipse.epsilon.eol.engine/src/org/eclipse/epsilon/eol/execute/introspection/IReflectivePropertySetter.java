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

import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;

public interface IReflectivePropertySetter extends IPropertySetter {
	
	/**
	 * Indicates whether the specified value is permitted for this property.
	 *              
	 * For example, the value "John Doe" would conform for a string-typed
	 * property with lowerbound <= 1 and upperbound >= 1.
	 * 
	 * The precise semantics of conformance differ between types of model.
	 *              
	 * @throws EolIllegalPropertyException when getObject is not a valid
	 *         model object or when getProperty is not a property that
	 *         getObject knows about.
	 */
	public boolean conforms(Object value) throws EolIllegalPropertyException;
	
	/**
	 * Coerces the given value such that it is permitted for this property.
	 * 
	 * For example, in EMF single values can be stored in many-valued
	 * features only when they are first stored in a collection.
	 *              
	 * @throws EolIllegalPropertyException when getObject is not a valid
	 *         model object or when getProperty is not a property that
	 *         getObject knows about.
	 */
	public Object coerce(Object value) throws EolIllegalPropertyException;	
}
