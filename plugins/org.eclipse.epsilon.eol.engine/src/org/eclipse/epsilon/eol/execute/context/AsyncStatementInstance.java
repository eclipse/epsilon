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
package org.eclipse.epsilon.eol.execute.context;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;


public class AsyncStatementInstance {
	
	protected AST ast;
	protected FrameStack localFrameStack;
	
	public AST getAst() {
		return ast;
	}
	
	public void setAst(AST ast) {
		this.ast = ast;
	}
	
	public FrameStack getLocalFrameStack() {
		return localFrameStack;
	}
	
	public void setLocalFrameStack(FrameStack localFrameStack) {
		this.localFrameStack = localFrameStack;
	}
	
	public void execute(IEolContext context) throws EolRuntimeException {
		FrameStack frameStack = context.getFrameStack();
		context.setFrameStack(this.localFrameStack);
		context.getExecutorFactory().executeAST(this.ast, context);
		context.setFrameStack(frameStack);
		this.localFrameStack.dispose();
	}
	
}
