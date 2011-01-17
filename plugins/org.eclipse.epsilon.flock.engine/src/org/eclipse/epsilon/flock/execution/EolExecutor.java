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
package org.eclipse.epsilon.flock.execution;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class EolExecutor {
	
	private final EolContext context;
	
	public EolExecutor(EolContext context) {
		this.context = context;
	}
	
	public boolean executeGuard(AST guard, Variable originalVar) throws FlockRuntimeException {
		context.enterProtectedFrame(guard, originalVar);
		
		final Boolean guardSatisfied = (Boolean)context.getExecutorFactory().executeBlockOrExpressionAst(guard, context, false);
		
		context.leaveFrame(guard);
		
		return guardSatisfied.booleanValue();
	}

	public Object executeBlock(AST block, Variable... variables) throws FlockRuntimeException {
		try {
			context.enterProtectedFrame(block, variables);
			
			final Object result = context.getExecutorFactory().executeAST(block, context);
			
			context.leaveFrame(block);
			
			return result;
			
		} catch (EolRuntimeException e) {
			e.printStackTrace();
			throw new FlockRuntimeException("Exception encountered while executing EOL block.", e);
		}
	}
}