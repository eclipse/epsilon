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
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
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
import org.eclipse.epsilon.eol.types.EolCollectionType;

public class SelectOperation extends FirstOrderOperation {
	
	protected final boolean isSelect;
	
	public SelectOperation() {
		this(true);
	}
	
	public SelectOperation(boolean select) {
		this.isSelect = select;
	}
	
	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression, 
		IEolContext context_) throws EolRuntimeException {
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		Collection<Object> resultsCol = EolCollectionType.createSameType(source);
		EolExecutorService executor = context.getAndCacheExecutorService();
		Collection<Future<Optional<?>>> futures = new ArrayList<>(source.size());
		
		for (Object item : source) {
			futures.add(executor.submit(() -> {
				Optional<?> intermediateResult = null;
				if (iterator.getType() == null || iterator.getType().isKind(item)) {
					
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, expression,
						Variable.createReadOnlyVariable(iterator.getName(), item)
					);
					
					Object bodyResult = context.getExecutorFactory().execute(expression, context);
					
					if (bodyResult instanceof Boolean) {
						boolean brBool = (boolean) bodyResult;
						if ((isSelect && brBool) || (!isSelect && !brBool)) {
							intermediateResult = Optional.ofNullable(item);
						}
					}
					
					scope.leaveLocal(expression);
				}
				return intermediateResult;
			}));
		}
		
		executor.collectResults(futures)
			.stream()
			.filter(opt -> opt != null)
			.map(opt -> opt.orElse(null))
			.forEach(resultsCol::add);
		
		return resultsCol;
	}
}
