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
package org.eclipse.epsilon.eol.execute.operations.simple;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;


public abstract class AbstractSimpleOperation extends AbstractOperation{

	public AbstractSimpleOperation() {
		super();
	}

	@Override
	public Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		
		List parameters = new ArrayList();
		AST parametersAst = operationAst.getFirstChild();
		if (parametersAst != null){
			//parameters = (List) context.getExecutorFactory().executeAST(parametersAst, context);
		
			AST parameterAst = parametersAst.getFirstChild();
			int parameterIndex = 0;
			while (parameterAst != null){
				try {
					parameters.add(context.getExecutorFactory().executeAST(parameterAst, context));
				}
				catch (EolRuntimeException ex) {
					if (getTolerateExceptionInParameter(parameterIndex)) {
						parameters.add(ex);
					}
					else {
						throw ex;
					}
				}
				catch (Throwable t) {
					context.getErrorStream().println("THROWABLE " + t.getClass().getName());
					
				}
				parameterAst = parameterAst.getNextSibling();
				parameterIndex++;
			}
		}
		try {
			return execute(source,parameters, context, operationAst);
		}
		catch (EolRuntimeException ex){
			if (ex.getAst() == null) {
				ex.setAst(operationAst);
			}
			throw ex;
		}
	}
	
	public abstract Object execute(Object source, List parameters, IEolContext context, AST ast) throws EolRuntimeException;
	
	public boolean getTolerateExceptionInParameter(int parameterIndex) {
		return false;
	}
	
}
