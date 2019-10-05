/*********************************************************************
* Copyright (c) 2008-2018 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.OperationCallExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolIllegalOperationParametersException;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.function.CheckedEolFunction;
import org.eclipse.epsilon.eol.function.CheckedEolPredicate;
import org.eclipse.epsilon.eol.function.EolLambdaFactory;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolType;

/**
 * 
 * @since 1.6 Major refactoring - EOL lambdas are converted to Java lambdas.
 */
public abstract class FirstOrderOperation extends AbstractOperation {
	
	/**
	 * 
	 * @param item
	 * @param parameter
	 * @param context
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	protected static Variable createIteratorVariable(Object item, Parameter parameter, IEolContext context) throws EolRuntimeException {
		return new Variable(parameter.getName(), item, parameter.getType(context), true);
	}
	
	/**
	 * 
	 * @param target
	 * @param iterators
	 * @param context
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	protected Collection<Object> resolveSource(Object target, List<Parameter> iterators, IEolContext context) throws EolRuntimeException {
		final Collection<Object> source = CollectionUtil.asCollection(target);
		
		if (!iterators.isEmpty()) {
			EolType iteratorType = iterators.get(0).getType(context);
			Collection<Object> result = EolCollectionType.createSameType(source);
			// Don't do this if we're dealing with a ConcurrentLinkedDeque due to potentially infinite loop when calling size()
			if (result instanceof ArrayList && !(source instanceof ConcurrentLinkedDeque) && !(source instanceof ConcurrentLinkedQueue)) {
				((ArrayList<Object>) result).ensureCapacity(source.size());
			}
			
			for (Object item : source) {
				if (iteratorType.isKind(item)) {
					result.add(item);
				}
			}
			
			return result;
		}
		else return source;
	}
	
	/**
	 * 
	 * @param operationNameExpression
	 * @param iterators
	 * @param expressions
	 * @param context
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	@SuppressWarnings("unchecked")
	protected final CheckedEolFunction<Object, ?> resolveFunction(NameExpression operationNameExpression, List<Parameter> iterators, Expression expression, IEolContext context) throws EolRuntimeException {
		return resolveFunction(CheckedEolFunction.class, operationNameExpression, iterators, expression, context);
	}

	/**
	 * 
	 * @param operationNameExpression
	 * @param iterators
	 * @param expressions
	 * @param context
	 * @return
	 * @throws EolRuntimeException
	 *  @since 1.6
	 */
	@SuppressWarnings("unchecked")
	protected final CheckedEolPredicate<Object> resolvePredicate(NameExpression operationNameExpression, List<Parameter> iterators, Expression expression, IEolContext context) throws EolRuntimeException {
		return resolveFunction(CheckedEolPredicate.class, operationNameExpression, iterators, expression, context);
	}
	
	/**
	 * 
	 * @param functionType
	 * @param operationNameExpression
	 * @param iterators
	 * @param expressions
	 * @param context
	 * @return
	 * @throws EolRuntimeException
	 * @since 1.6
	 */
	@SuppressWarnings("unchecked")
	protected <R, F extends CheckedEolFunction<Object, R>> F resolveFunction(Class<F> functionType, NameExpression operationNameExpression, List<Parameter> iterators, Expression expression, IEolContext context) throws EolRuntimeException {
		if (iterators.isEmpty()) {
			Object exprValue = expression.execute(context);
			
			try {
				return functionType.cast(exprValue);
			}
			catch (ClassCastException ccx) {
				throw new EolIllegalOperationParametersException(
					((OperationCallExpression)expression.getParent()).getOperationName(),
					functionType.getSimpleName(),
					java.util.Objects.toString(exprValue),
					expression
				);
			}
		}
		else {
			return (F) EolLambdaFactory.resolveFor(functionType, iterators, expression, operationNameExpression, context);
		}
	}

}
