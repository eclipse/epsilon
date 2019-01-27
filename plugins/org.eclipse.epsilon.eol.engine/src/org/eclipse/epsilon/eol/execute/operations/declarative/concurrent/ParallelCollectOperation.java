/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.CollectOperation;
import org.eclipse.epsilon.eol.function.CheckedEolFunction;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolSequence;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ParallelCollectOperation extends CollectOperation {

	@Override
	public Collection<?> execute(Object target, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context_) throws EolRuntimeException {
	
		Collection<?> source = resolveSource(target, iterators, context_);
		final int sourceSize = source.size();
		
		Collection<Object> resultsCol = EolCollectionType.isOrdered(source) ?
			new EolSequence<>(sourceSize) : new EolBag<>(sourceSize);
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		Collection<Future<Object>> jobResults = new ArrayList<>(sourceSize);
		CheckedEolFunction<Object, ?> function = resolveFunction(operationNameExpression, iterators, expressions, context);
		Expression expression = expressions.get(0);
		EolExecutorService executor = context.beginParallelTask(expression);
		
		for (Object item : source) {
			jobResults.add(executor.submit(() -> function.applyThrows(item)));
		}
		
		resultsCol.addAll(executor.collectResults(jobResults));
		context.endParallelTask(expression);
		
		return resultsCol;
	}
}
