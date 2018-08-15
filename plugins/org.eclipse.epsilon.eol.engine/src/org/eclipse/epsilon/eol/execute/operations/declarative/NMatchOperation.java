/*********************************************************************
* Copyright (c) 2018 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolType;

public class NMatchOperation extends FirstOrderOperation {

	protected final int targetMatches;
	
	public NMatchOperation(int targetMatches) {
		this.targetMatches = targetMatches;
	}
	
	@Override
	public Boolean execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {
		
		Collection<Object> source = CollectionUtil.asCollection(target);
		if (source.size() < targetMatches) return false;

		int currentIndex = 0, currentMatches = 0;
		EolType iteratorType = iterator.getType();
		String iteratorName = iterator.getName();
		FrameStack scope = context.getFrameStack();
		
		for (Object item : source) {
			++currentIndex;
			if (iteratorType == null || iteratorType.isKind(item)) {
				scope.enterLocal(FrameType.UNPROTECTED, expression,
					Variable.createReadOnlyVariable(iteratorName, item)
				);
				
				Object bodyResult = context.getExecutorFactory().execute(expression, context);
				
				if (bodyResult instanceof Boolean && (boolean) bodyResult) {
					// Short-circuit if we exceeded the number OR already failed to meet threshold
					if (
						++currentMatches > targetMatches ||
						(currentIndex > targetMatches && (currentMatches < targetMatches))
					)
						return false;
				}
				
				scope.leaveLocal(expression);
			}
		}

		return currentMatches == targetMatches;
	}
}
