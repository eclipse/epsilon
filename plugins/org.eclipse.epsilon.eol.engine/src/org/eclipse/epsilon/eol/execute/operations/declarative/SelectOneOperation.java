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
import java.util.concurrent.Future;
import org.eclipse.epsilon.common.concurrent.ConcurrentExecutionStatus;
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

public class SelectOneOperation extends FirstOrderOperation {

	protected final boolean isSelect;
	protected boolean hasResult;
	
	public SelectOneOperation() {
		isSelect = true;
	}
	
	protected SelectOneOperation(boolean select) {
		this.isSelect = select;
	}
	
	@Override
	public Object execute(Object target, Variable iterator, Expression expression,
			IEolContext context_) throws EolRuntimeException {
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		if (source.isEmpty()) return null;
		
		IEolContextParallel context = EolContextParallel.convertToParallel(context_);
		
		EolExecutorService executor = context.getExecutorService();
		ConcurrentExecutionStatus execStatus = executor.getExecutionStatus();
		Object condition = execStatus.register();
		Collection<Future<?>> jobs = new ArrayList<>(source.size());

		for (Object item : source) {
			jobs.add(executor.submit(() -> {
				if (iterator.getType() == null || iterator.getType().isKind(item)) {
					FrameStack scope = context.getFrameStack();
					scope.enterLocal(FrameType.UNPROTECTED, expression,
						Variable.createReadOnlyVariable(iterator.getName(), item)
					);
					
					Object bodyResult = null;
					try {
						bodyResult = context.getExecutorFactory().execute(expression, context);
					}
					catch (EolRuntimeException ex) {
						context.handleException(ex, executor);
					}
					
					if (bodyResult instanceof Boolean) {
						boolean brBool = (boolean) bodyResult;
						if ((brBool && isSelect) || (!brBool && !isSelect)) {
							hasResult = true;
							// "item" will be the result
							scope.leaveLocal(expression);
							execStatus.completeSuccessfully(condition, item);
							return;
						}
					}
					
					scope.leaveLocal(expression);
				}
			}));
			
		}
		
		// Prevent unnecessary evaluation of remaining jobs once we have the result
		return executor.shortCircuitCompletion(jobs, condition);
	}
	
}
