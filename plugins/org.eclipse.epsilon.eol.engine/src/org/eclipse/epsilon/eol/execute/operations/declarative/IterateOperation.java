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
import java.util.Iterator;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public class IterateOperation extends AbstractOperation {
	
	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException{
		
		Object result = null;
		
		AST parametersAst = ast.getFirstChild();
		AST declarationsAst = parametersAst.getFirstChild();
		AST bodyAst = declarationsAst.getNextSibling();
		
		AST declarationAst = declarationsAst.getFirstChild();
		AST iteratorNameAst = declarationAst.getFirstChild();
		AST iteratorTypeAst = iteratorNameAst.getNextSibling();
		
		AST resultAst = declarationAst.getNextSibling();
		AST resultNameAst = resultAst.getFirstChild();
		AST resultTypeAst = resultNameAst.getNextSibling();
		AST resultInitialValueAst = resultTypeAst.getNextSibling().getNextSibling();
		
		// Find the name and the type of the iterator
		String iteratorName = iteratorNameAst.getText();
		EolType iteratorType = null;
		
		if (iteratorTypeAst != null){
			iteratorType = (EolType) context.getExecutorFactory().executeAST(iteratorTypeAst,context);
		}
		else {
			iteratorType = EolAnyType.Instance;
		}
		
		// Find the name and the type of the result
		String resultName = resultNameAst.getText();
		EolType resultType = null;
		if (resultTypeAst != null){
			resultType = (EolType) context.getExecutorFactory().executeAST(resultTypeAst,context);
		}
		else {
			resultType = EolAnyType.Instance;
		}
		
		
		// If the source is a single instance
		// convert it to an EolCollection
		Collection source = CollectionUtil.asCollection(obj);
		
		Iterator li = source.iterator();
		
		Object resultInitialValue = context.getExecutorFactory().executeAST(resultInitialValueAst, context);
		
		FrameStack scope = context.getFrameStack();
		
		scope.enter(FrameType.UNPROTECTED, ast);
		scope.put(new Variable(resultName, resultInitialValue, resultType));
		
		while (li.hasNext()){
			Object listItem = li.next();
			
			if (iteratorType==null || iteratorType.isKind(listItem)){
				scope.enter(FrameType.UNPROTECTED, bodyAst);
				scope.put(new Variable(iteratorName, listItem, iteratorType));
				context.getExecutorFactory().executeAST(bodyAst, context);
				scope.leave(bodyAst);
			}
		}
		
		result = scope.get(resultName).getValue();
		
		scope.leave(ast);
		
		return result;
	}

}
