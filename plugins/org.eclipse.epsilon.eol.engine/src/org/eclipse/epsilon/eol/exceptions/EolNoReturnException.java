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


public class EolNoReturnException extends EolRuntimeException{
	
	protected String expectedType = "";
	
	public EolNoReturnException(String expectedType, AST ast, IEolContext context){
		this.ast = ast;
		this.context = context;
		this.expectedType = expectedType;
	}
	
	@Override
	public String getReason(){
		return "Expected to return '" + expectedType + "'";
	}
}
