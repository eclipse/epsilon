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
import org.eclipse.epsilon.eol.types.EolType;

public class ClosureOperation extends FirstOrderOperation {
	
	public void closure(Collection<?> source, String iteratorName, EolType iteratorType, Expression expression, IEolContext context, Collection<Object> closure) throws EolRuntimeException {
		FrameStack scope = context.getFrameStack();
		
		for (Object listItem : source) {
			if (iteratorType == null || iteratorType.isKind(listItem)) {
				scope.enterLocal(FrameType.UNPROTECTED, expression);
				scope.put(Variable.createReadOnlyVariable(iteratorName, listItem));
				
				Object bodyResult = context.getExecutorFactory().execute(expression, context);
				
				if (bodyResult != null) { //&& !closure.contains(bodyResult)) {
					Collection<?> bodyCollection = CollectionUtil.asCollection(bodyResult);
					for (Object result : bodyCollection) {
						if (result != null && !closure.contains(result)) {
							closure.add(result);
							closure(bodyCollection, iteratorName, iteratorType, expression, context, closure);
						}
					}
					
				}
				scope.leaveLocal(expression);
			}
		}
	}

	@Override
	public Object execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {

		Collection<?>      source = CollectionUtil.asCollection(target);
		Collection<Object> result = CollectionUtil.createDefaultList();
		
		closure(source,iterator.getName(),iterator.getType(),expression,context,result);
		
		return result;
	}
	
}
