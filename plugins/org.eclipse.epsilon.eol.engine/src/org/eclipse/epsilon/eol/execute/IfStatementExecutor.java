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
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class IfStatementExecutor extends AbstractExecutor{
	
	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		
		IfStatement ifStatement = (IfStatement) ast;
		context.getFrameStack().enterLocal(FrameType.UNPROTECTED, ast);
		Object condition = context.getExecutorFactory().executeAST(ifStatement.getCondition(), context);
		
		if (!(condition instanceof Boolean)) throw new EolIllegalReturnException("Boolean", condition, ifStatement.getCondition(), context);
		
		Object result = null;
		
		if (((Boolean) condition).booleanValue()){
			result = context.getExecutorFactory().executeAST(ifStatement.getThen(), context, true);
		}
		else if (ifStatement.getElse() != null){
			result = context.getExecutorFactory().executeAST(ifStatement.getElse(), context, true);
		}
		
		context.getFrameStack().leaveLocal(ast);
		return result;
	}

}
