/*******************************************************************************
 * Copyright (c) 2008-2013 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - switch to frame stack
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class EolNoReturnException extends EolRuntimeException {
	private static final long serialVersionUID = 1777127646978346547L;

	protected String expectedType = "";
	
	public EolNoReturnException(String expectedType, AST ast, IEolContext context){
		super("Expected to return '" + expectedType + "'", ast, context.getFrameStack());
		
		this.context = context;
		this.expectedType = expectedType;
	}
}
