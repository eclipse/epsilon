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

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolType;

public class EolIllegalVariableAssignmentException extends EolRuntimeException{
	
	protected Variable variable;
	protected EolType expected;
	protected Object value;
	protected IEolContext context;
	
	public EolIllegalVariableAssignmentException(Variable variable, EolType expected, Object value, IEolContext context) {
		super();
		this.variable = variable;
		this.expected = expected;
		this.value = value;
		this.context = context;
	}
	
	@Override
	public String getReason(){
		return "Illegal assignment to variable '" + variable.getName() + "'. Expected " + expected.getName() + " and found " + context.getPrettyPrinterManager().toString(value);
	}
}
