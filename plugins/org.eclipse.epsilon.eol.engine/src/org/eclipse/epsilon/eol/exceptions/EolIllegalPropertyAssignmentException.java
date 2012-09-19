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

public class EolIllegalPropertyAssignmentException extends EolRuntimeException {

	public String property;
	
	public EolIllegalPropertyAssignmentException(String property, AST ast) {
		super();
		this.property = property;
		this.ast = ast;
	}
	
	@Override
	public String getReason(){
		return "Invalid assignment to property '" + property + "'";
	}
	
}
