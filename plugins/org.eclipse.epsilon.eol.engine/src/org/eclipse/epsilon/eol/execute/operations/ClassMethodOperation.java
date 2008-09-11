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
package org.eclipse.epsilon.eol.execute.operations;

import java.util.ArrayList;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;
import org.eclipse.epsilon.eol.util.ReflectionUtil;


public class ClassMethodOperation extends AbstractOperation{
	
	private boolean unwrapParameters = false;
	
	public ClassMethodOperation(boolean unwrapParameters){
		this.unwrapParameters = unwrapParameters;
	}
	
	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException {
		
		String methodName = ast.getText();
		ArrayList parameters = new ArrayList();
		
		if (ast.getNumberOfChildren() == 1){
			AST parametersAst = ast.getFirstChild();
			if (parametersAst.getNumberOfChildren() > 0){
				AST parameterAst = parametersAst.getFirstChild();
				while (parameterAst != null){
					Object parameter = context.getExecutorFactory().executeAST(parameterAst, context);
					parameters.add(parameter);
					parameterAst = parameterAst.getNextSibling();
				}
			}
		}
		
		Object result = null;
		try {
			result = ReflectionUtil.executeMethod(obj, methodName, parameters.toArray(), unwrapParameters, ast);
		}
		catch (Throwable t){
			result = ReflectionUtil.executeMethod(obj, methodName, parameters.toArray(), !unwrapParameters, ast);
		}
		return EolTypeWrapper.getInstance().wrap(result);
		
	}

}
