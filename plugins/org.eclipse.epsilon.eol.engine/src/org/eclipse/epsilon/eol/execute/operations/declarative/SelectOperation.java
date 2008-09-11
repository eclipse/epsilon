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

import java.util.Iterator;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.FrameStack;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolType;


public class SelectOperation extends AbstractOperation {
	
	@Override
	public Object execute(Object obj, AST ast, IEolContext context) throws EolRuntimeException{
		
		//AST parametersAst = ast.getFirstChild();
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
		
		EolCollection source = EolCollection.asCollection(obj);
		EolCollection result = source.createCollection();
		
		Iterator li = source.getStorage().iterator();
		FrameStack scope = context.getFrameStack();
		
		while (li.hasNext()){
			Object listItem = li.next();
			
			if (iteratorType==null || iteratorType.isKind(listItem)){
				scope.enter(FrameType.UNPROTECTED, ast);
				//scope.put(new Variable(iteratorName, listItem, iteratorType, true));
				scope.put(Variable.createReadOnlyVariable(iteratorName,listItem));
				Object bodyResult = context.getExecutorFactory().executeAST(bodyAst, context);
				if (bodyResult instanceof EolBoolean && ((EolBoolean) bodyResult).getValue()){
					result.add(listItem);
				}
				scope.leave(ast);
			}
		}
		
		return result;
	}

}
