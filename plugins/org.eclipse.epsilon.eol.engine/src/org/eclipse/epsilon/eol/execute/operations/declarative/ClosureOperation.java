/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.function.CheckedEolFunction;
import org.eclipse.epsilon.eol.types.EolSequence;

public class ClosureOperation extends FirstOrderOperation {
	
	protected void closure(Collection<Object> closure, Collection<?> source, Parameter parameter, Expression expression, CheckedEolFunction<Object, ?> function, IEolContext context) throws EolRuntimeException {
		
		FrameStack scope = context.getFrameStack();
		
		for (Object item : source) {
			scope.enterLocal(FrameType.UNPROTECTED, expression, createIteratorVariable(item, parameter, context));
			
			Object bodyResult = context.getExecutorFactory().execute(expression, context);
			
			if (bodyResult != null) {
				Collection<?> bodyCollection = CollectionUtil.asCollection(bodyResult);
				for (Object result : bodyCollection) {
					if (result != null && !closure.contains(result)) {
						closure.add(result);
						closure(closure, Arrays.asList(result), parameter, expression, function, context);
					}
				}
				
			}
			scope.leaveLocal(expression);
		}
	
	}

	@Override
	public Object execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context) throws EolRuntimeException {
		
		Collection<?> source = resolveSource(target, iterators, context);
		if (source.isEmpty()) return new EolSequence<>(0);
		Collection<Object> results = CollectionUtil.createDefaultList();
		CheckedEolFunction<Object, ?> function = resolveFunction(operationNameExpression, iterators, expressions.get(0), context);
		
		closure(results, source, iterators.get(0), expressions.get(0), function, context);
		
		return results;
	}
	
}
