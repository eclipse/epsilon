/*********************************************************************
 * Copyright (c) 2018-2019 The University of York.
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
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.NMatchOperation;
import org.eclipse.epsilon.eol.function.CheckedEolPredicate;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ParallelNMatchOperation extends NMatchOperation {
	
	public ParallelNMatchOperation(MatchMode behaviour, int n) throws IllegalArgumentException {
		super(behaviour, n);
	}

	public ParallelNMatchOperation(MatchMode behaviour) {
		super(behaviour);
	}

	@Override
	protected boolean execute(int sourceSize, int targetMatches, Collection<Object> source, NameExpression operationNameExpression, List<Parameter> iterators, Expression expression, IEolContext context_) throws EolRuntimeException {

		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		AtomicInteger currentMatches = new AtomicInteger();
		AtomicInteger evaluated = new AtomicInteger();
		Collection<Future<?>> jobResults = new ArrayList<>(sourceSize);
		CheckedEolPredicate<Object> predicate = resolvePredicate(operationNameExpression, iterators, expression, context);
		EolExecutorService executor = context.beginParallelTask(expression);
		
		for (Object item : source) {
			jobResults.add(executor.submit(() -> {
				final int currentInt = predicate.testThrows(item) ?
					currentMatches.incrementAndGet() : currentMatches.get(),
					evaluatedInt = evaluated.incrementAndGet();
				
				if (shouldShortCircuit(sourceSize, targetMatches, currentInt, evaluatedInt)) {
					executor.getExecutionStatus().completeWithResult(Boolean.TRUE);
				}
			}));
		}
		
		// Prevent unnecessary evaluation of remaining jobs once we have the result
		executor.shortCircuitCompletion(jobResults);
		context.endParallelTask();
		
		return determineResult(currentMatches.get(), targetMatches);
	}
}
