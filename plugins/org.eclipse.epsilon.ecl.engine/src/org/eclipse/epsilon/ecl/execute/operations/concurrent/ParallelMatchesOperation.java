/*********************************************************************
 * Copyright (c) 2018 The University of York.
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.ecl.execute.operations.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.execute.context.concurrent.EclContextParallel;
import org.eclipse.epsilon.ecl.execute.context.concurrent.IEclContextParallel;
import org.eclipse.epsilon.ecl.execute.operations.MatchesOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ParallelMatchesOperation extends MatchesOperation {
	
	@Override
	protected boolean matchCollectionOrdered(Collection<?> leftColFlat, Collection<?> rightColFlat, IEclContext context_) throws EolRuntimeException {
		
		IEclContextParallel context = EclContextParallel.convertToParallel(context_);
		EolExecutorService executor = context.beginParallelTask();
		ArrayList<Future<?>> jobFutures = new ArrayList<>(leftColFlat.size());
		
		for (Iterator<?> lit = leftColFlat.iterator(), rit = rightColFlat.iterator(); lit.hasNext();) {
			final Object left = lit.next(), right = rit.next();
			
			jobFutures.add(executor.submit(() -> {
				try {
					if (!matchInstances(left, right, context, false)) {
						executor.getExecutionStatus().completeWithResult(Boolean.FALSE);
					}
				}
				catch (EolRuntimeException exception) {
					context.handleException(exception, executor);
				}
			}));
		}
		
		Object result = executor.shortCircuitCompletion(jobFutures);
		context.endParallelTask();
		if (result instanceof Boolean) {
			return (boolean) result;
		}
		return true;
	}
	
	
	@Override
	protected boolean matchCollectionUnordered(Collection<?> leftColFlat, Collection<?> rightColFlat, IEclContext context_) throws EolRuntimeException {
		IEclContextParallel context = EclContextParallel.convertToParallel(context_);
			
		for (Object left : leftColFlat) {
			Collection<Callable<Boolean>> jobs = new ArrayList<>(rightColFlat.size());
			
			jobs.add(() -> {
				for (Object right : rightColFlat) {
					if (matchInstances(left, right, context, forcedMatch)) {
						return true;
					}
				}
				return false;
			});
			
			if (context.executeParallelTyped(context.getModule(), jobs).contains(Boolean.FALSE)) {
				return false;
			}
		}
		
		return true;
	}

}
