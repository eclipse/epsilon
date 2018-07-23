/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.epl.execute;

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.epl.combinations.ExceptionHandler;

public class RuntimeExceptionThrower implements ExceptionHandler {
	
	protected IEolContext context;
	
	public RuntimeExceptionThrower(IEolContext context) {
		this.context = context;
	}
	
	@Override
	public void handleException(Exception ex) {
		throw new RuntimeException(ex.getMessage());
		//context.getExecutorFactory().reportException(EolRuntimeException.wrap(ex));
	}

}
