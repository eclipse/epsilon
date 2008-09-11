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
package org.eclipse.epsilon.eol.execute.operations.simple;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolSequence;



public class AtOperationOld extends AbstractOperation{

	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException {
		
		if (ast.getNumberOfChildren() != 1 || 
			ast.getFirstChild().getNumberOfChildren() != 1){		
			throw new EolIllegalOperationParametersException(ast.getText(), ast);
		}
		
		if (!(obj instanceof EolSequence)){
			throw new EolRuntimeException("Operation at applies only to objects of type Sequence", ast);
		}
		
		Object parameterResult = context.getExecutorFactory().executeAST(ast.getFirstChild().getFirstChild(), context);
		
		if (!(parameterResult instanceof EolInteger)){
			throw new EolRuntimeException("Expression should return an Integer instead of: " + parameterResult, ast.getFirstChild());
		}
		
		EolSequence sequence = (EolSequence) obj;
		EolInteger parameter = (EolInteger) parameterResult;
		
		return sequence.at(parameter);
		
	}
	
}
