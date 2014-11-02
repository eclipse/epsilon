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
import org.eclipse.epsilon.eol.dom.WhileStatement;
import org.eclipse.epsilon.eol.exceptions.EolIllegalReturnException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class WhileStatementExecutor extends AbstractExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		
		WhileStatement whileStatement = (WhileStatement) ast;
		
		//how many times the loop has been executed
		int loop = 0;
		
		while (true){
			context.getFrameStack().enterLocal(FrameType.UNPROTECTED, ast);
			
			loop ++;
			Object condition = context.getExecutorFactory().executeAST(whileStatement.getCondition(), context);		
			
			if (!(condition instanceof Boolean)) {
				context.getFrameStack().leaveLocal(ast);
				throw new EolIllegalReturnException("Boolean", condition, whileStatement.getCondition(), context);
			}
			
			Object result = null;
			
			if (((Boolean) condition).booleanValue()){
				context.getFrameStack().put(Variable.createReadOnlyVariable("loopCount", loop));
				
				
				try {
					result = context.getExecutorFactory().executeAST(whileStatement.getBody(), context, true);
				}
				catch (EolBreakException bex){
					if (bex.isBreaksAll() && context.getFrameStack().isInLoop()){
						throw bex;
					}
					context.getFrameStack().leaveLocal(ast);
					break;
				}
				catch (EolContinueException cex){
					context.getFrameStack().leaveLocal(ast);
					continue;
				}
				
				// /*@config(maxLoops=1000,firstLoop=0,loopCountName="z")*/
				//if (loop > 100000) {
				//	throw new EolRuntimeException("Possibly infinite loop (>100000 loops)", conditionAst);
				//}
			}
			else {
				context.getFrameStack().leaveLocal(ast);
				break;
			}
			
			context.getFrameStack().leaveLocal(ast);
		
			if (result instanceof Return) {
				return result;
			}
		}
		
		return null;
	}

}
