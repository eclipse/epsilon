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
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class EolIllegalReturnException extends EolRuntimeException{
	
	private String expectedType = "";
	private Object returnedValue = null;
	
	public EolIllegalReturnException(String expectedType, Object returnedValue, AST ast, IEolContext context){
		this.expectedType = expectedType;
		this.returnedValue = returnedValue;
		this.context = context;
		this.ast = ast;
	}
	
	@Override
	public String getReason() {
		return "Expected to return '" + expectedType + "' instead of '" 
		+ context.getPrettyPrinterManager().toString(returnedValue) + "'";
	}

	public String getExpectedType() {
		return expectedType;
	}

	public Object getReturnedValue() {
		return returnedValue;
	}
	
}
