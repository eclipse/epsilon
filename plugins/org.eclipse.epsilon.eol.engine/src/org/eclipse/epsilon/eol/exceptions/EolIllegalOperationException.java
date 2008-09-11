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

import org.eclipse.epsilon.commons.parse.AST;

public class EolIllegalOperationException extends EolRuntimeException {
	
	protected String methodName = "";
	protected Object object = null;
	
	public EolIllegalOperationException(Object object, String methodName, AST ast) {
		super();
		this.ast = ast;
		this.methodName = methodName;
		this.object = object;
	}
	
	public String getMethodName() {
		return methodName;
	}
	
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	
	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
	@Override
	public String getReason(){
		//return "Object " + object.toString() + " does not support method: " + methodName;
		return "Method '" + methodName + "' not found";
	}
}
