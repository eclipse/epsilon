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
import org.eclipse.epsilon.eol.execute.operations.declarative.CollectOperation;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolType;

/**
 * 
 * @author Sina Madani
 * @since 1.6
 */
public class ParallelCollectOperation extends CollectOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
			IEolContext context_) throws EolRuntimeException {
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		
		EolType iteratorType = iterator.getType();
		String iteratorName = iterator.getName();
		Collection<Object> source = CollectionUtil.asCollection(target);
		final int sourceSize = source.size();
		
		Collection<Object> resultsCol = EolCollectionType.isOrdered(source) ?
			new EolSequence<>(sourceSize) : new EolBag<>(sourceSize);
		
		Collection<Callable<Object>> jobs = new ArrayList<>(sourceSize);
		
		for (Object item : source) {
			if (iteratorType == null || iteratorType.isKind(item)) {
				jobs.add(() -> {
					
					FrameStack scope = context.getFrameStack();
					try {
						scope.enterLocal(FrameType.UNPROTECTED, expression,
							new Variable(iteratorName, item, iteratorType, true)
						);
						
						return context.getExecutorFactory().execute(expression, context);
					}
					finally {
						scope.leaveLocal(expression);
					}
					
				});
			}
		}
		
		resultsCol.addAll(context.executeParallelTyped(expression, jobs));
		
		return resultsCol;
	}
}
