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
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollectionType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolType;


public class CollectOperation extends AbstractOperation{

	public CollectOperation() {
		super();
	}

	@Override
	public Object execute(Object obj, AST operationAst, IEolContext context) throws EolRuntimeException {
		
		AST declarationsAst = operationAst.getFirstChild();
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
		
		Collection<Object> source = CollectionUtil.asCollection(obj);
		Collection<Object> result = null;
		
		if (EolCollectionType.isOrdered(source)) {
			result = new EolSequence();
		}
		else {
			result = new EolBag();
		}
		
		FrameStack scope = context.getFrameStack();
		
		for (Object listItem : source) {
			if (iteratorType==null || iteratorType.isKind(listItem)){
				scope.enter(FrameType.UNPROTECTED, operationAst);
				scope.put(new Variable(iteratorName, listItem, iteratorType, true));
				Object bodyResult = context.getExecutorFactory().executeAST(bodyAst, context);
				result.add(bodyResult);
				scope.leave(operationAst);
			}
		}
		
		return result;

	}

}
