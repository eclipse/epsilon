/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Future;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.concurrent.executors.EolExecutorService;
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
		
		EolExecutorService executor = context.getExecutorService();
		Collection<Future<Object>> futures = new ArrayList<>(sourceSize);
		context.enterParallelNest(expression);
		
		for (Object item : source) {
			if (iteratorType == null || iteratorType.isKind(item)) {
				futures.add(executor.submit(() -> {
					
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, expression,
						new Variable(iteratorName, item, iteratorType, true)
					);
					
					Object bodyResult = context.getExecutorFactory().execute(expression, context);
					
					scope.leaveLocal(expression);
					return bodyResult;
				}));
			}
		}
		
		resultsCol.addAll(executor.collectResults(futures));
		context.exitParallelNest();
		
		return resultsCol;
	}
}
