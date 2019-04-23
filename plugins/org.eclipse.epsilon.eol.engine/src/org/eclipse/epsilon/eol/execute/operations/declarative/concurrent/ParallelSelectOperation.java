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
import java.util.Optional;
import java.util.concurrent.Future;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.function.CheckedEolPredicate;
import org.eclipse.epsilon.eol.types.EolCollectionType;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ParallelSelectOperation extends SelectOperation {
	
	@Override
	public Collection<?> execute(boolean returnOnMatch, Object target, NameExpression operationNameExpression, List<Parameter> iterators, Expression expression, IEolContext context_) throws EolRuntimeException {

		Collection<Object> source = resolveSource(target, iterators, context_);
		Collection<Object> resultsCol = EolCollectionType.createSameType(source);
		if (source.isEmpty()) return resultsCol;

		Collection<Future<Optional<?>>> jobResults = new ArrayList<>(source.size());
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		CheckedEolPredicate<Object> predicate = resolvePredicate(operationNameExpression, iterators, expression, context);
		EolExecutorService executor = context.beginParallelTask(expression);
		
		for (Object item : source) {
			jobResults.add(executor.submit(() -> {
				
				Optional<?> intermediateResult = null;
				
				if (predicate.testThrows(item)) {
					intermediateResult = Optional.ofNullable(item);
					
					if (returnOnMatch) {
						executor.getExecutionStatus().completeWithResult(intermediateResult);
					}
				}
				
				return intermediateResult;
			}));
		}
		
		if (returnOnMatch) {
			Optional<?> result = (Optional<?>) executor.shortCircuitCompletion(jobResults);
			
			if (result != null) {	
				resultsCol.add(result.orElse(null));
			}
		}
		else {
			executor.collectResults(jobResults)
				.stream()
				.filter(opt -> opt != null)
				.map(opt -> opt.orElse(null))
				.forEach(resultsCol::add);
		}
		
		context.endParallelTask();
		return resultsCol;
	}
}
