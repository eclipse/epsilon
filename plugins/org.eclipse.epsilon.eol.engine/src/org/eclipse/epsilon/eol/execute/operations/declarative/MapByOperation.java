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
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolType;

public class MapByOperation extends FirstOrderOperation {

	@Override
	public EolMap<?, EolSequence<Object>> execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {
		
		Collection<?> source = CollectionUtil.asCollection(target);
		EolMap<Object, EolSequence<Object>> result = new EolMap<>();
		
		if (source.isEmpty()) return result;
		
		FrameStack scope = context.getFrameStack();	
		EolType iteratorType = iterator.getType();
		String iteratorName = iterator.getName();
		
		for (Object item : source) {
			if (iteratorType == null || iteratorType.isKind(item)) {
				scope.enterLocal(FrameType.UNPROTECTED, expression,
					new Variable(iteratorName, item, iteratorType, true)
				);
				
				Object bodyResult = context.getExecutorFactory().execute(expression, context);
				
				EolSequence<Object> sequence = (EolSequence<Object>) result.get(bodyResult);
				if (sequence == null) sequence = new EolSequence<>();
				sequence.add(item);
				result.put(bodyResult, sequence);
				
				scope.leaveLocal(expression);
			}
		}
		
		return result;
	}
}
