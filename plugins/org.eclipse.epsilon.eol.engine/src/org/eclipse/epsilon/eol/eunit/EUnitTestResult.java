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
package org.eclipse.epsilon.eol.eunit;

import org.eclipse.epsilon.eol.EolOperation;

public class EUnitTestResult {
	
	protected EolOperation operation;
	private EUnitTestResultType type;
	protected Exception exception;
	protected String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public EolOperation getOperation() {
		return operation;
	}
	
	public void setOperation(EolOperation operation) {
		this.operation = operation;
	}
	
	public EUnitTestResultType getType() {
		return type;
	}
	
	public void setType(EUnitTestResultType type) {
		this.type = type;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
}
