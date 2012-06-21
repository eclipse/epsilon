/*******************************************************************************
 * Copyright (c) 2008-2012 The University of York, Antonio García-Domínguez.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Antonio García-Domínguez - track current statement
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;


public class StatementBlockExecutor extends AbstractExecutor {

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		AST statementAst = ast.getFirstChild();
		while (statementAst != null){
			context.getFrameStack().setCurrentStatement(statementAst);
			Object result = context.getExecutorFactory().executeAST(statementAst, context, true);
			if (result instanceof Return) {
				return result;
			}
			statementAst = statementAst.getNextSibling();
		}
		return null;
	}

}
