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
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolSequence;

public class CollectOperation extends FirstOrderOperation {

	public CollectOperation() {
		super();
	}

	@Override
	public Object execute(Object target, Variable iterator, Expression expression, IEolContext context) throws EolRuntimeException {

		Collection<?>      source = CollectionUtil.asCollection(target);
		Collection<Object> result = null;
		
		if (EolCollectionType.isOrdered(source)) {
			result = new EolSequence<Object>();
		}
		else {
			result = new EolBag<Object>();
		}
		
		FrameStack scope = context.getFrameStack();
		
		for (Object listItem : source) {
			if (iterator.getType() ==null || iterator.getType().isKind(listItem)){
				scope.enterLocal(FrameType.UNPROTECTED, expression);
				scope.put(new Variable(iterator.getName(), listItem, iterator.getType(), true));
				Object bodyResult = context.getExecutorFactory().executeAST(expression, context);
				result.add(bodyResult);
				scope.leaveLocal(expression);
			}
		}
		
		return result;

	}

}
