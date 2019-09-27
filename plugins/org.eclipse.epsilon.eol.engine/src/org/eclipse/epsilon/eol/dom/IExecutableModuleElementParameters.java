/*********************************************************************
 * Copyright (c) 2019 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public interface IExecutableModuleElementParameters extends IExecutableModuleElement {
	
	Object executeImpl(IEolContext context, Object...parameters) throws EolRuntimeException;
	
	default Object execute(IEolContext context, Object... parameters) throws EolRuntimeException {
		return context.getExecutorFactory().execute(this, context, parameters);
	}
	
	@Override
	default Object execute(IEolContext context) throws EolRuntimeException {
		return execute(context, new Object[0]);
	}
	
	//Class<?>[] getExpectedParameterTypes();
	
}
