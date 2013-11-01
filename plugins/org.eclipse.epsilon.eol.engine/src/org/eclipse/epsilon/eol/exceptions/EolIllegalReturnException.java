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


public class EolIllegalReturnException extends EolRuntimeException {
	private static final long serialVersionUID = -7661232194117477675L;

	private final String expectedType;
	private final Object returnedValue;

	public EolIllegalReturnException(String expectedType, Object returnedValue, IEolContext context) {
		this(expectedType, returnedValue, null, context);
	}

	public EolIllegalReturnException(String expectedType, Object returnedValue, AST ast, IEolContext context) {
		super(null, ast, context.getFrameStack());
		this.expectedType = expectedType;
		this.returnedValue = returnedValue;
		this.context = context;
	}

	@Override
	public String getReason() {
		return "Expected to return '" + expectedType + "' instead of '" + context.getPrettyPrinterManager().toString(returnedValue) + "'";
	}

	public String getExpectedType() {
		return expectedType;
	}

	public Object getReturnedValue() {
		return returnedValue;
	}
}
