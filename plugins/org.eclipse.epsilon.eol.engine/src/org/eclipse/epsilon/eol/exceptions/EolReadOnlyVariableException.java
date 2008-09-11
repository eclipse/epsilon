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

import org.eclipse.epsilon.eol.execute.context.Variable;

public class EolReadOnlyVariableException extends EolRuntimeException{
	
	protected Variable variable;
	
	public EolReadOnlyVariableException(Variable variable) {
		super();
		this.variable = variable;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getReason(){
		return "Variable '" + variable.getName() + "' is read-only";
	}
}
