/*********************************************************************
* Copyright (c) 2019 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.CountOperation;
import org.eclipse.epsilon.eol.function.CheckedEolPredicate;

/**
 * Counts the number of elements satisying the condition.
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ParallelCountOperation extends CountOperation {

	@Override
	public Integer execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators,
		List<Expression> expressions, IEolContext context_) throws EolRuntimeException {
		
		final IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		final Iterable<?> source = resolveSource(target, iterators, context);
		final CheckedEolPredicate<Object> predicate = resolvePredicate(operationNameExpression, iterators, expressions, context);
		final AtomicInteger result = new AtomicInteger();
		final EolExecutorService executor = context.beginParallelTask(expressions.get(0));
		
		for (Object item : source) {
			executor.execute(() -> {
				try {
					if (predicate.testThrows(item)) {
						result.incrementAndGet();
					}
				}
				catch (EolRuntimeException ex) {
					context.handleException(ex, executor);
				}
			});
		}
		
		executor.awaitCompletion();
		context.endParallelTask(expressions.get(0));
		return result.get();
	}

}
