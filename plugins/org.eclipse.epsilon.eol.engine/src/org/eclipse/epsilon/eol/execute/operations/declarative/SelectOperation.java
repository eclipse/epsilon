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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolCollectionType;

public class SelectOperation extends IteratorOperation {
	
	public boolean isReturnOnFirstMatch() {
		return false;
	}
	
	public Object execute(Object target, Variable iterator, AST expressionAst,
			IEolContext context, boolean returnOnFirstMatch) throws EolRuntimeException {
		
		Collection source = CollectionUtil.asCollection(target);
		Collection result = EolCollectionType.createSameType(source);
		
		FrameStack scope = context.getFrameStack();
		
		for (Object listItem : source) {	
			if (iterator.getType()==null || iterator.getType().isKind(listItem)){
				scope.enterLocal(FrameType.UNPROTECTED, expressionAst);
				//scope.put(new Variable(iteratorName, listItem, iteratorType, true));
				scope.put(Variable.createReadOnlyVariable(iterator.getName(),listItem));
				Object bodyResult = context.getExecutorFactory().executeAST(expressionAst, context);
				if (bodyResult instanceof Boolean && ((Boolean) bodyResult)){
					result.add(listItem);
					if (returnOnFirstMatch) {
						scope.leaveLocal(expressionAst);
						return result;
					}
				}
				scope.leaveLocal(expressionAst);
			}
		}
		
		return result;

	}
	
	@Override
	public Object execute(Object target, Variable iterator, AST expressionAst,
			IEolContext context) throws EolRuntimeException {
		
		return execute(target, iterator, expressionAst, context, isReturnOnFirstMatch());
	}

}
