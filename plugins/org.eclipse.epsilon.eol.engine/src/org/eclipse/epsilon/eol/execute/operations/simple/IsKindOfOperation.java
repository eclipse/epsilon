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
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolType;


public class IsKindOfOperation extends AbstractOperation{

	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException {
		
		if (ast.getNumberOfChildren() != 1 || 
				ast.getFirstChild().getNumberOfChildren() != 1){		
				throw new EolIllegalOperationParametersException(ast.getText(), ast);
			}
		
		AST typeAst = ast.getFirstChild().getFirstChild();
		Object result = context.getExecutorFactory().executeAST(typeAst, context);
		
		if (!(result instanceof EolType)) throw new EolRuntimeException("Expected type, found " + result, typeAst);
		
		EolType type = (EolType) result;
		
		if (type!=null){
			return new EolBoolean(type.isKind(obj));
		}
		else {
			return EolBoolean.FALSE;
		}
		
		/*
		if (ast.getNumberOfChildren() != 1 || 
			ast.getFirstChild().getNumberOfChildren() != 1){		
			throw new EolInvalidOperationCallException(ast.getText(), ast);
		}
		
		String type = ast.getFirstChild().getFirstChild().getText();
		
		if (context.getModelRepository().isModelElementType(type)){
			return new EolBoolean(context.getModelRepository().allOfType(type).contains(obj));
		}
		else {
			return new EolBoolean(EolTypeChecker.isOfType(obj, type, context));
		}*/
	}
	
}
