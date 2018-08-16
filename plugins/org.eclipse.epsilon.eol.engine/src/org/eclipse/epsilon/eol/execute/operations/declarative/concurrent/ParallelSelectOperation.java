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
import java.util.Optional;
import java.util.concurrent.Callable;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.SelectOperation;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolType;

public class ParallelSelectOperation extends SelectOperation {
	
	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression, IEolContext context_,
		boolean isSelect, boolean returnOnMatch) throws EolRuntimeException {
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		Collection<Object> resultsCol = EolCollectionType.createSameType(source);
		
		if (source.isEmpty()) return resultsCol;
		
		boolean isRejectOne = !isSelect && returnOnMatch;
		if (isRejectOne) {
			resultsCol.addAll(source);
		}
		
		EolType iteratorType = iterator.getType();
		String iteratorName = iterator.getName();
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		Collection<Callable<Optional<?>>> jobs = new ArrayList<>(source.size());
		
		for (Object item : source) {
			if (iteratorType == null || iteratorType.isKind(item)) {
				jobs.add(() -> {
					
					Optional<?> intermediateResult = null;
					FrameStack scope = context.getFrameStack();
					
					try {
						scope.enterLocal(FrameType.UNPROTECTED, expression,
							new Variable(iteratorName, item, iteratorType, true)
						);
						
						Object bodyResult = context.getExecutorFactory().execute(expression, context);
						
						if (bodyResult instanceof Boolean) {
							boolean brBool = (boolean) bodyResult;
							
							if (isRejectOne && brBool || (!isRejectOne && ((isSelect && brBool) || (!isSelect && !brBool)))) {
								intermediateResult = Optional.ofNullable(item);
								
								if (returnOnMatch) {
									context.completeShortCircuit(expression, intermediateResult);
								}
							}
						}
					}
					finally {
						// The finally block is to ensure we don't leak variables if this job is cancelled
						scope.leaveLocal(expression);
					}
					
					return intermediateResult;
				});
			}
		}
		
		if (returnOnMatch) {
			Optional<?> result = context.shortCircuitTyped(expression, jobs);
			
			if (result != null) {
				Object actualResult = result.orElse(null);		
				if (isRejectOne) {
					resultsCol.remove(actualResult);
				}
				else {
					resultsCol.add(actualResult);
				}
			}
		}
		else {
			context.executeParallelTyped(expression, jobs)
				.stream()
				.filter(opt -> opt != null)
				.map(opt -> opt.orElse(null))
				.forEach(resultsCol::add);
		}
		
		return resultsCol;
	}
}
