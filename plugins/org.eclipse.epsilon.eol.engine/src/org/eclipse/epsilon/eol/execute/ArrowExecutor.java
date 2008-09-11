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


//FIXME : Fix this to match the description
//provided in the documentation
public class ArrowExecutor extends PointExecutor {

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		
		AST objectAst = ast.getFirstChild();
		AST operationAst = objectAst.getNextSibling();
		Object object = context.getExecutorFactory().executeAST(objectAst, context);		
		/*
		 * return context.getOperationFactory().executeOperation(object, operationAst, context);
		*/
		
		return executeOperation(context, object, operationAst, false);
		
	}

}
 
