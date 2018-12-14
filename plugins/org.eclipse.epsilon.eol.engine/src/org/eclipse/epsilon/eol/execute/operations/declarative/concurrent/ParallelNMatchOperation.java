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
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
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
	
	public ParallelNMatchOperation(int n) {
		super(n);
	}
	
	public ParallelNMatchOperation() {
		super();
	}
	
	@Override
	protected boolean execute(int sourceSize, int targetMatches, Collection<Object> source, NameExpression operationNameExpression, List<Parameter> iterators, List<Expression> expressions, IEolContext context_) throws EolRuntimeException {
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		AtomicInteger currentMatches = new AtomicInteger();
		AtomicInteger evaluated = new AtomicInteger();
		Collection<Callable<Boolean>> jobs = new ArrayList<>(sourceSize);
		CheckedEolPredicate<Object> predicate = resolvePredicate(operationNameExpression, iterators, expressions, context);
		Expression expression = expressions.get(0);
		
		for (Object item : source) {
			jobs.add(() -> {
				boolean leave = predicate.testThrows(item) && currentMatches.incrementAndGet() > targetMatches;
				int evaluatedInt = evaluated.incrementAndGet();
				leave = leave || (sourceSize - evaluatedInt) < (targetMatches - currentMatches.get());
				
				if (leave) {
					context.completeShortCircuit(expression, leave);
				}
				
				return leave;
			});
		}
		
		// Prevent unnecessary evaluation of remaining jobs once we have the result
		context.shortCircuitTyped(expression, jobs);
		return currentMatches.get() == targetMatches;
	}
}
