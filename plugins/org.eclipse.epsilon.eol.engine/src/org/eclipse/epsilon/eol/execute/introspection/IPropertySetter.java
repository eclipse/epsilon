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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IPropertySetter {
	
	/**
	 * 
	 * @param target
	 * @param property
	 * @param value
	 * @param ast
	 * @param context
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	void invoke(Object target, String property, Object value, ModuleElement ast, IEolContext context) throws EolRuntimeException;
}
