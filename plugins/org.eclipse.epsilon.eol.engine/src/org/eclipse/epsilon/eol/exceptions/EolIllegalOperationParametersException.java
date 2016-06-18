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
