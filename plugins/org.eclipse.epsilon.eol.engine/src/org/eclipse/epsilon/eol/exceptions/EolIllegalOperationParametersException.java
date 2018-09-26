/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.exceptions;

import org.eclipse.epsilon.common.module.ModuleElement;

public class EolIllegalOperationParametersException extends EolRuntimeException {
	
	private String method = "";
	private String expected;
	
	public EolIllegalOperationParametersException(String method) {
		this.method = method;
	}
	
	public EolIllegalOperationParametersException(String method, ModuleElement ast) {
		this(method);
		this.ast = ast;
	}
	
	public EolIllegalOperationParametersException(String method, String expected) {
		this(method);
		this.expected = expected;
	}
	
	public EolIllegalOperationParametersException(String method, String expected, ModuleElement ast) {
		this(method, ast);
		this.expected = expected;
	}
	
	@Override
	public String getReason() {
		String reason = "Invalid number (or types) of arguments for operation '" + method + "'";
		if (expected != null && !expected.isEmpty()) {
			reason += ": expected '"+expected+"'";
		}
		return reason;
	}
	
	@Override
	public void setReason(String reason) {
		this.method = reason;
	}
}
