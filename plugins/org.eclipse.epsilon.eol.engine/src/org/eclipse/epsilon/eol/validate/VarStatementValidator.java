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
package org.eclipse.epsilon.eol.validate;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.AbstractExecutor;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;


public class VarStatementValidator extends AbstractExecutor {

	@Override
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {
		
		AST variableNameAst = ast.getFirstChild();
		AST variableTypeAst = variableNameAst.getNextSibling();
		//AST variableCollectionMemberTypeAst = null;
		//Variable resultVariable = null;
		
		String variableName = variableNameAst.getText();
		Object newInstance = null;
		
		EolType variableType = null;
		if (variableTypeAst == null){ // No type defined
			variableType = EolAnyType.Instance;
		}
		else { // Type defined
			variableType = (EolType) context.getExecutorFactory().executeAST(variableTypeAst, context);
		}
		
		Variable variable = new Variable(variableName, null, variableType);
		context.getFrameStack().put(variable);
		return variable;
	}

}
