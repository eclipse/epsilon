/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.egl.engine.traceability.fine.operations.print;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.egl.engine.traceability.fine.context.IEglTraceabilityContext;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;



class Arguments {

	private final AST argumentsAst;
	
	public Arguments(AST argumentsAst) {
		this.argumentsAst = argumentsAst;
	}

	public void ensureNumberOfArgumentsIs(int expectedNumberOfArguments) throws EolIllegalOperationParametersException {
		if (argumentsAst.getNumberOfChildren() != expectedNumberOfArguments)
			throw new EolIllegalOperationParametersException(argumentsAst.getText());
	}
			
	public Object evaluateFirstArgument(IEglTraceabilityContext context) throws EolRuntimeException {
		return context.recordPropertyAccessesWhileExecuting(getFirstArgument());	
	}

	private AST getFirstArgument() {
		return argumentsAst.getFirstChild();
	}
}