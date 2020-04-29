/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

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
	public boolean conforms(Object target, String property, Object value, ModuleElement ast, IEolContext context) throws EolIllegalPropertyException;
	
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
	public Object coerce(Object target, String property, Object value, ModuleElement ast, IEolContext context) throws EolIllegalPropertyException;	
}
