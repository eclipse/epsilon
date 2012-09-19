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
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolType;

public class ClosureOperation extends AbstractOperation {
	
	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException{
		
		AST declarationsAst = ast.getFirstChild();
		AST bodyAst = declarationsAst.getNextSibling();
		
		AST declarationAst = declarationsAst.getFirstChild();
		AST iteratorNameAst = declarationAst.getFirstChild();
		AST iteratorTypeAst = iteratorNameAst.getNextSibling();
		
		String iteratorName = iteratorNameAst.getText();
		EolType iteratorType = null;
		
		if (iteratorTypeAst != null){
			iteratorType = (EolType) context.getExecutorFactory().executeAST(iteratorTypeAst,context);
		}
		else {
			iteratorType = EolAnyType.Instance;
		}
		
		Collection<?>      source = CollectionUtil.asCollection(obj);
		Collection<Object> result = CollectionUtil.createDefaultList();
		
		closure(source,iteratorName,iteratorType,bodyAst,context,result);
		
		return result;
	}
	
	public void closure(Collection<?> source, String iteratorName, EolType iteratorType, AST expressionAST, IEolContext context, Collection<Object> closure) throws EolRuntimeException {
		FrameStack scope = context.getFrameStack();
		
		for (Object listItem : source) {
			if (iteratorType==null || iteratorType.isKind(listItem)){
				scope.enterLocal(FrameType.UNPROTECTED, expressionAST);
				scope.put(Variable.createReadOnlyVariable(iteratorName,listItem));
				Object bodyResult = context.getExecutorFactory().executeAST(expressionAST, context);
				if (bodyResult != null) { // && closure.includes(bodyResult).not().booleanValue()) {
					for (Object result : CollectionUtil.asCollection(bodyResult)) {
						if (result != null && !closure.contains(result)) {
							closure.add(result);
							closure(CollectionUtil.asCollection(bodyResult),iteratorName,iteratorType,expressionAST,context,closure);
						}
					}
					
				}
				scope.leaveLocal(expressionAST);
			}
		}
	}
	
}
