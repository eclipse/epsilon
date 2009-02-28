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

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolType;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;


public class NewExecutor extends AbstractExecutor {

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		AST typeAst = ast.getFirstChild();
		
		Object result = context.getExecutorFactory().executeAST(typeAst, context);
		
		if (!(result instanceof EolType)) throw new EolRuntimeException("Expected type, found " + result, typeAst);
		
		AST parametersAst = typeAst.getNextSibling();
		
		if (parametersAst == null) {
			return ((EolType) result).createInstance();
		}
		else {
			List<Object> parameters = (List<Object>) context.getExecutorFactory().executeAST(parametersAst, context);
			return ((EolType) result).createInstance(EolTypeWrapper.getInstance().unwrapAll(parameters));
		}
		
	}

}
