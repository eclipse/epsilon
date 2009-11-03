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
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;


public class StatementBlockExecutor extends AbstractExecutor {

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
				
		AST statementAst = ast.getFirstChild();
		
		while (statementAst != null){
			
			if (statementAst.getType() == EolParser.OPERATOR && "=".equals(statementAst.getText())) {
				statementAst.getToken().setType(EolParser.ASSIGNMENT);
				statementAst.getToken().setText(":=");
			}
			
			Object result = context.getExecutorFactory().executeAST(statementAst, context);
			
			if (result instanceof Return) {
				return result;
			}
			
			statementAst = statementAst.getNextSibling();
		}
				
		return null;
	}

}
