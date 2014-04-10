/*******************************************************************************
 * Copyright (c) 2012 The University of York.
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
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolMap;
import org.eclipse.epsilon.eol.types.EolType;

public class AggregateOperation extends AbstractOperation {

	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException{
		
		AST declarationsAst = ast.getFirstChild();
		AST keyAst = declarationsAst.getNextSibling();
		AST valueAst = keyAst.getNextSibling();
		AST initialAst = valueAst.getNextSibling();
		
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
		
		Collection<?> source = CollectionUtil.asCollection(obj);
		Iterator<?> li = source.iterator();
		FrameStack scope = context.getFrameStack();
		
		EolMap result = new EolMap();
		
		while (li.hasNext()){
			Object listItem = li.next();
			
			if (iteratorType==null || iteratorType.isKind(listItem)){
				scope.enterLocal(FrameType.UNPROTECTED, ast);
				scope.put(Variable.createReadOnlyVariable(iteratorName,listItem));
				Object keyResult = context.getExecutorFactory().executeAST(keyAst, context);
				Object total = null;
				
				if (result.containsKey(keyResult)) {
					total = result.get(keyResult);
				}
				else {
					total = context.getExecutorFactory().executeAST(initialAst, context);
				}
				
				scope.put(Variable.createReadOnlyVariable("total", total));
				Object valueResult = context.getExecutorFactory().executeAST(valueAst, context);
				result.put(keyResult, valueResult);
				scope.leaveLocal(ast);
			}
		}
		
		return result;
	}


}
