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
	
	public EolIllegalOperationParametersException(String method) {
		this.method = method;
	}
	
	public EolIllegalOperationParametersException(String method, ModuleElement ast) {
		this.ast = ast;
		this.method = method;
	}
	
	@Override
	public String getReason(){
		return "Invalid number (or types) of arguements for operation '" + method + "'";
	}
	
	@Override
	public void setReason(String reason){
		this.method = reason;
	}
}
