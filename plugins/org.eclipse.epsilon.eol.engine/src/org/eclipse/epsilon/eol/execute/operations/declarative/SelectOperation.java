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
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolType;


public class SelectOperation extends AbstractOperation {
	
	protected boolean returnOnFirstMatch = false;
	
	public boolean isReturnOnFirstMatch() {
		return returnOnFirstMatch;
	}


	public void setReturnOnFirstMatch(boolean returnOnFirstMatch) {
		this.returnOnFirstMatch = returnOnFirstMatch;
	}

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
		
		Collection source = CollectionUtil.asCollection(obj);
		Collection result = EolCollectionType.createSameType(source);
		
		FrameStack scope = context.getFrameStack();
		
		for (Object listItem : source) {	
			if (iteratorType==null || iteratorType.isKind(listItem)){
				scope.enter(FrameType.UNPROTECTED, ast);
				//scope.put(new Variable(iteratorName, listItem, iteratorType, true));
				scope.put(Variable.createReadOnlyVariable(iteratorName,listItem));
				Object bodyResult = context.getExecutorFactory().executeAST(bodyAst, context);
				if (bodyResult instanceof Boolean && ((Boolean) bodyResult)){
					result.add(listItem);
					if (isReturnOnFirstMatch()) {
						scope.leave(ast);
						return result;
					}
				}
				scope.leave(ast);
			}
		}
		
		return result;
	}

}
