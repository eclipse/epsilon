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
package org.eclipse.epsilon.eol.types;

import java.util.List;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.tools.ITool;

public abstract class AbstractToolNativeTypeDelegate implements IToolNativeTypeDelegate {
	
	public abstract Object createInstance(String clazz, List<Object> parameters) 
			throws EolRuntimeException;
	
	public Object createInstance(String clazz, List<Object> parameters, IEolContext context)
			throws EolRuntimeException {
		
		Object instance = createInstance(clazz, parameters);
		if (instance instanceof ITool) {
			((ITool) instance).setContext(context);
			((ITool) instance).initialize(parameters);
		}
		return instance;
	}

}
