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
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.execute.context.concurrent.EclContextParallel;
import org.eclipse.epsilon.ecl.execute.context.concurrent.IEclContextParallel;
import org.eclipse.epsilon.ecl.execute.operations.DoMatchOperation;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;

public class ParallelDoMatchOperation extends DoMatchOperation {

	@Override
	protected boolean matchAll(Collection<?> leftColFlat, Collection<?> rightColFlat, IEclContext context_) throws EolRuntimeException {
		
		IEclContextParallel context = EclContextParallel.convertToParallel(context_);
		Collection<Runnable> jobs = new ArrayList<>(leftColFlat.size() * rightColFlat.size());
		
		for (Object left : leftColFlat) {
			for (Object right : rightColFlat) {
				jobs.add(() -> {
					try {
						if (!matchInstances(left, right, context, forcedMatch)) {
							context.completeShortCircuit(context.getModule(), Boolean.FALSE);
						}
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex);
					}
				});
			}
		}

		return context.shortCircuit(context.getModule(), jobs) == null;
	}
	
}
