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
import org.eclipse.epsilon.eol.execute.context.FrameStack;

public class EolIllegalOperationParametersException extends EolRuntimeException {
	private static final long serialVersionUID = 1304130213870921841L;
	
	public EolIllegalOperationParametersException(String method) {
		this(method, null, null);
	}
	
	public EolIllegalOperationParametersException(String method, AST ast, FrameStack stack) {
		super("Invalid number (or types) of arguements for operation '" + method + "'", ast, stack);
	}
}
