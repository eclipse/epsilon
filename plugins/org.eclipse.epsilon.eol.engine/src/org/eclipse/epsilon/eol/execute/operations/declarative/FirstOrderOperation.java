/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.List;

import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolType;

public abstract class FirstOrderOperation extends AbstractOperation {
	
	@Override
	public Object execute(Object target,
			NameExpression operationNameExpression, List<Parameter> iterators,
			List<Expression> expressions, IEolContext context)
			throws EolRuntimeException {
		
		Parameter iterator = iterators.get(0);
		EolType iteratorType = iterator.getType(context);
		
		if (target == EolNoType.Instance && iteratorType instanceof EolModelElementType) {
			target = ((EolModelElementType) iteratorType).getAllOfKind();
		}
		
		return execute(target, new Variable(iterator.getName(), null, iteratorType), expressions.get(0), context);
	}
	
	protected abstract Object execute(Object target, Variable iterator, Expression expression, IEolContext context) throws EolRuntimeException;
	
}
