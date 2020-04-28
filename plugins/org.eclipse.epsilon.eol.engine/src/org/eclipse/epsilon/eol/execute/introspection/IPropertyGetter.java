/*******************************************************************************
 * Copyright (c) 2008-2020 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio Garcia-Dominguez - add isPropertySet
 *     Sina Madani - stateless refactoring
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.introspection;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IPropertyGetter {
	
	/**
	 * 
	 * @param object
	 * @param property
	 * @param ast
	 * @param context
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	Object invoke(Object object, String property, ModuleElement ast, IEolContext context) throws EolRuntimeException;
	
	/**
	 * 
	 * @param object
	 * @param property
	 * @param ast
	 * @param context
	 * @return
	 * @since 1.6
	 */
	default boolean hasProperty(Object object, String property, IEolContext context) {
		try {
			invoke(object, property, null, context);
			return true;
		}
		catch (EolRuntimeException ex) {
			return false;
		}
	}
}
