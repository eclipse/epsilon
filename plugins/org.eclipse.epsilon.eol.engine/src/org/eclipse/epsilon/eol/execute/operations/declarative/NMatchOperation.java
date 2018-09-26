/*********************************************************************
* Copyright (c) 2018 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import java.util.List;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolNoType;
import org.eclipse.epsilon.eol.types.EolType;

public class NMatchOperation extends FirstOrderOperation {

	private int n = -1;
	
	public NMatchOperation() {
		
	}
	
	public NMatchOperation(int n) {
		this.n = n;
	}
	
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
		
		int targetMatches = n;
		if (expressions.size() > 1) {
			Object userDefinedN = expressions.get(1).execute(context);
			if (userDefinedN instanceof Integer) {
				targetMatches = (int) userDefinedN;
			}
			else {
				throw new EolIllegalOperationParametersException("nMatch", "Integer", expressions.get(1));
			}
		}
		if (targetMatches < 0) {
			throw new EolIllegalOperationParametersException("nMatch");
		}
		
		return execute(target, new Variable(iterator.getName(), null, iteratorType), expressions.get(0), targetMatches, context);
	}
	
	protected boolean execute(Object target, Variable iterator, Expression expression,
			final int targetMatches, IEolContext context) throws EolRuntimeException {
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		final int sourceSize = source.size();
		if (sourceSize < targetMatches) return false;

		int currentIndex = 0, currentMatches = 0;
		EolType iteratorType = iterator.getType();
		String iteratorName = iterator.getName();
		FrameStack scope = context.getFrameStack();
		
		for (Object item : source) {
			++currentIndex;
			if (iteratorType == null || iteratorType.isKind(item)) {
				
				scope.enterLocal(FrameType.UNPROTECTED, expression,
					Variable.createReadOnlyVariable(iteratorName, item)
				);
				
				Object bodyResult = context.getExecutorFactory().execute(expression, context);
				boolean leave = false;
				
				if (bodyResult instanceof Boolean && (boolean) bodyResult) {
					leave = ++currentMatches > targetMatches;
				}
				//         # of remaining elements  vs   # of remaining matches
				leave |= (sourceSize - currentIndex) < (targetMatches - currentMatches);
				
				// Short-circuit if we exceeded the number OR already failed to meet threshold
				if (leave) {
					scope.leaveLocal(expression);
					return false;
				}
			}
		}

		return currentMatches == targetMatches;
	}
	
	@Override
	public Boolean execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {
		
		return execute(target, iterator, expression, n, context);
	}
}
