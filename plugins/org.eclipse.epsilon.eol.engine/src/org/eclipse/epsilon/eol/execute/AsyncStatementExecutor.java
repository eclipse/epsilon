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
import org.eclipse.epsilon.eol.execute.context.AsyncStatement;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class AsyncStatementExecutor extends AbstractExecutor {

	@Override
	public Object execute(final AST ast, final IEolContext context) throws EolRuntimeException {
		
		if (ast.getFirstChild() != null){
			
			final FrameStack frameStack = context.getFrameStack().clone();
			
			AsyncStatement asyncStatement = new AsyncStatement();
			asyncStatement.setAst(ast.getFirstChild());
			asyncStatement.setLocalFrameStack(frameStack);
			context.getAsyncStatementsQueque().add(asyncStatement);
			
			/*
			new Thread(new Runnable() {

				public void run() {
					synchronized (context) {
						FrameStack oldStack = context.getFrameStack();
						context.setFrameStack(frameStack);
						try {
							context.getExecutorFactory().executeAST(ast.getFirstChild(), context);
						}
						catch (EolRuntimeException e) {
							e.printStackTrace();
						}
						context.setFrameStack(oldStack);
						frameStack.dispose();
					}
				}
			}).start();
			*/
		}
		
		return null;
		
	}

}
