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

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.StringUtil;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolIllegalPropertyException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.introspection.IPropertyGetter;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolBoolean;


public class HasPropertyOperation extends AbstractOperation {

	@Override
	public Object execute(Object source, AST operationAst, IEolContext context) throws EolRuntimeException {
		
		AST parametersAst = operationAst.getFirstChild();
		
		List parameters = (List) context.getExecutorFactory().executeAST(parametersAst, context);
		
		if (parameters.size() != 1){
			throw new EolIllegalOperationParametersException("hasProperty", operationAst);
		}
		
		String property = StringUtil.toString(parameters.get(0));
		
		IPropertyGetter getter = context.getIntrospectionManager().getPropertyGetterFor(source, property, context);
		
		try {
			getter.invoke(source, property);
		}
		catch (EolIllegalPropertyException pex){
			return EolBoolean.FALSE;
		}
		
		return EolBoolean.TRUE;
	}

}
