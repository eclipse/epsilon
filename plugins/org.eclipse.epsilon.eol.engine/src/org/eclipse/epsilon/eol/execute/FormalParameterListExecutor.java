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

import java.util.TreeMap;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.OrderComparator;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolType;


public class FormalParameterListExecutor extends AbstractExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException {
		TreeMap parameters = new TreeMap(new OrderComparator());
		AST parameterAst = ast.getFirstChild();
		
		while (parameterAst != null){
			AST parameterNameAst = parameterAst.getFirstChild();
			AST parameterTypeAst = parameterNameAst.getNextSibling();
			EolType parameterType = (EolType) context.getExecutorFactory().executeAST(parameterTypeAst,context);
			parameters.put(parameterNameAst.getText(), parameterType);
			parameterAst = parameterAst.getNextSibling();
		}

		return parameters;
	}
	
}
