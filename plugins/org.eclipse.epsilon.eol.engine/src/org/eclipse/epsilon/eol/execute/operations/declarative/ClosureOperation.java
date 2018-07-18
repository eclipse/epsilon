/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
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
			if (iteratorType==null || iteratorType.isKind(listItem)){
				scope.enterLocal(FrameType.UNPROTECTED, expression);
				scope.put(Variable.createReadOnlyVariable(iteratorName,listItem));
				Object bodyResult = context.getExecutorFactory().execute(expression, context);
				if (bodyResult != null) { // && closure.includes(bodyResult).not().booleanValue()) {
					for (Object result : CollectionUtil.asCollection(bodyResult)) {
						if (result != null && !closure.contains(result)) {
							closure.add(result);
							closure(CollectionUtil.asCollection(bodyResult),iteratorName,iteratorType,expression,context,closure);
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
