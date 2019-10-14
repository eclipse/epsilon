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
import java.util.concurrent.Future;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.execute.context.concurrent.IEclContextParallel;
import org.eclipse.epsilon.ecl.execute.operations.DoMatchOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ParallelDoMatchOperation extends DoMatchOperation {

	@Override
	protected boolean matchAll(Collection<?> leftColFlat, Collection<?> rightColFlat, IEclContext context_) throws EolRuntimeException {
		
		IEclContextParallel context = (IEclContextParallel) context_;
		EolExecutorService executor = context.beginParallelTask();
		ArrayList<Future<?>> jobFutures = new ArrayList<>(leftColFlat.size() * rightColFlat.size());
		
		for (Object left : leftColFlat) {
			for (Object right : rightColFlat) {
				jobFutures.add(executor.submit(() -> {
					if (!matchInstances(left, right, context)) {
						executor.getExecutionStatus().completeWithResult(Boolean.FALSE);
					}
				}));
			}
		}

		Object result = executor.shortCircuitCompletion(jobFutures);
		context.endParallelTask();
		if (result instanceof Boolean) {
			return (boolean) result;
		}
		return true;
	}
	
}
