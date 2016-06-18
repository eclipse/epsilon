/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.control;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public interface IExecutionListener {

	public void aboutToExecute(ModuleElement ast, IEolContext context);
	
	/**
	 * @param result the result of evaluating ast, calculated during execution
	 */
	public void finishedExecuting(ModuleElement ast, Object result, IEolContext context);
	
	public void finishedExecutingWithException(ModuleElement ast, EolRuntimeException exception, IEolContext context);
	
}
