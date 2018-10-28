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
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.context.concurrent.EolContextParallel;
import org.eclipse.epsilon.eol.execute.context.concurrent.IEolContextParallel;
import org.eclipse.epsilon.eol.execute.operations.declarative.NMatchOperation;
import org.eclipse.epsilon.eol.types.EolType;

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
	protected boolean execute(final Collection<?> source, final int sourceSize, EolType iteratorType,
			String iteratorName, Expression expression, final int targetMatches, IEolContext context_)
			throws EolRuntimeException {
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		AtomicInteger currentMatches = new AtomicInteger();
		AtomicInteger evaluated = new AtomicInteger();
		Collection<Runnable> jobs = new ArrayList<>(source.size());
		
		for (Object item : source) {
			if (iteratorType == null || iteratorType.isKind(item)) {
				jobs.add(() -> {
					
					FrameStack scope = context.getFrameStack();
					try {
						scope.enterLocal(FrameType.UNPROTECTED, expression,
							new Variable(iteratorName, item, iteratorType, true)
						);
						
						Object bodyResult = context.getExecutorFactory().execute(expression, context);
						boolean leave = false;
						
						if (bodyResult instanceof Boolean && (boolean) bodyResult) { 
							leave = currentMatches.incrementAndGet() > targetMatches;
						}
						
						int evaluatedInt = evaluated.incrementAndGet();
						leave = leave || (sourceSize - evaluatedInt) < (targetMatches - currentMatches.get());
						
						if (leave) {
							context.completeShortCircuit(expression, null);
						}
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex);
					}
					finally {
						// The finally block is to ensure we don't leak variables if this job is cancelled
						scope.leaveLocal(expression);
					}
					
				});
			}
		}
		
		// Prevent unnecessary evaluation of remaining jobs once we have the result
		context.shortCircuit(expression, jobs);
		
		return currentMatches.get() == targetMatches;
	}
}
