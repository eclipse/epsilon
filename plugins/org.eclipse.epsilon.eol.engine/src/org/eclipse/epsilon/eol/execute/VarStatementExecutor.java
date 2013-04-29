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
package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

// TODO: Is it worth making collections strongly typed?
public class VarStatementExecutor extends TypeInitialiserExecutor {

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		AST variableNameAst = ast.getFirstChild();
		AST variableTypeAst = variableNameAst.getNextSibling();
		AST parametersAst = null;
		if (variableTypeAst != null) {
			parametersAst = variableTypeAst.getNextSibling();
		}
		//AST variableCollectionMemberTypeAst = null;
		//Variable resultVariable = null;
		
		String variableName = variableNameAst.getText();
		
		EolType variableType = null;
		if (variableTypeAst == null){ // No type defined
			variableType = EolAnyType.Instance;
		}
		else { // Type defined
			variableType = (EolType) context.getExecutorFactory().executeAST(variableTypeAst, context);
		}
		
		//TODO : Add try-catch and support for EolInstantiationExceptions
		Object newInstance = initialiseType(variableType, parametersAst, context, ast.getText().equalsIgnoreCase("new"));
		
		Variable variable = new Variable(variableName, newInstance, variableType);
		context.getFrameStack().put(variable);
		return variable;
		
	}
	
}
