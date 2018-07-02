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

import java.util.Collection;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.ExecutorFactory;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolType;

public class ForAllOperation extends FirstOrderOperation {
	
	@Override
	public Boolean execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {
		
		Collection<?> source = CollectionUtil.asCollection(target);
		ExecutorFactory executorFactory = context.getExecutorFactory();
		FrameStack scope = context.getFrameStack();
		String iteratorName = iterator.getName();
		EolType iteratorType = iterator.getType();
		
		for (Object item : source) {
			if (iteratorType == null || iteratorType.isKind(item)) {
				scope.enterLocal(FrameType.UNPROTECTED, expression,
					Variable.createReadOnlyVariable(iteratorName, item)
				);
				Object bodyResult = executorFactory.execute(expression, context);
				if (bodyResult instanceof Boolean && !(boolean) bodyResult) {
					return false;
				}
				scope.leaveLocal(expression);
			}
		}
		
		return true;

	}

}
