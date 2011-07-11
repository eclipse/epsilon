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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class IfStatementExecutor extends AbstractExecutor{
	
	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		AST conditionAst = ast.getFirstChild();
		//thenAst is the block executed if the
		//condition returns true
		AST thenAst = conditionAst.getNextSibling();
		AST elseAst = null;
		
		context.getFrameStack().enter(FrameType.UNPROTECTED, ast);
		
		if (ast.getNumberOfChildren() == 3){
			elseAst = thenAst.getNextSibling();
		} 
		
		Object condition = context.getExecutorFactory().executeAST(conditionAst, context);		
		
		if (!(condition instanceof Boolean)) throw new EolIllegalReturnException("Boolean", condition, conditionAst, context);
		
		Object result = null;
		
		if (((Boolean) condition).booleanValue()){
			result = context.getExecutorFactory().executeAST(thenAst, context, true);
		}
		else if (elseAst != null){
			result = context.getExecutorFactory().executeAST(elseAst, context, true);
		}
		
		context.getFrameStack().leave(ast);
		return result;
	}

}
