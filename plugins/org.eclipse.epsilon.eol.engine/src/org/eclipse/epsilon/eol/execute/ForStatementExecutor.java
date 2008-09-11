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
package org.eclipse.epsilon.eol.execute;

import java.util.Iterator;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolBreakException;
import org.eclipse.epsilon.eol.exceptions.flowcontrol.EolContinueException;
import org.eclipse.epsilon.eol.execute.context.FrameType;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.types.EolAnyType;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolModelElementType;
import org.eclipse.epsilon.eol.types.EolPrimitiveType;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolType;


public class ForStatementExecutor extends AbstractExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		
		AST iteratorAst = ast.getFirstChild();
		//System.err.println(iteratorAst);
		AST iteratedCollectionAst = ast.getFirstChild().getNextSibling();
		//System.err.println(iteratedCollectionAst);
		AST bodyAst = iteratedCollectionAst.getNextSibling();
		//System.err.println(bodyAst);
		
		Object iterated = context.getExecutorFactory().executeAST(iteratedCollectionAst, context);
		
		EolCollection iteratedCol = null;
		
		if (iterated instanceof EolCollection){
			iteratedCol = (EolCollection) iterated;
		}
		//TODO: See if we can make other classes iterable as well
		//TODO: Reduce duplication between here and EolCollection.asCollection
		else if (iterated instanceof Iterable){
			iteratedCol = EolSequence.asSequence(iterated);
		}
		else if (iterated instanceof EolModelElementType) {
			iteratedCol = new EolSequence(((EolModelElementType) iterated).all());
		}
		else {
			iteratedCol = new EolSequence();
			iteratedCol.add(iterated);
		}
		
		//TODO : See how this affects performance
		//iteratedCol = iteratedCol.clone();
		
		String iteratorName = "";
		EolType iteratorType = null;
		//if (iteratorAst.getType() == EolParser.NAME) {
		//	iteratorName = iteratorAst.getText();
		//	iteratorType = EolAnyType.Instance;
		//}
		//else {
		iteratorName = iteratorAst.getFirstChild().getText();
		AST iteratorTypeAst = iteratorAst.getFirstChild().getNextSibling();
		if (iteratorTypeAst != null) {
			iteratorType = (EolType) context.getExecutorFactory().executeAST(iteratorTypeAst, context);
		}
		else {
			iteratorType = EolAnyType.Instance;
		}
		//}
		
		Iterator li = iteratedCol.getStorage().iterator();
		
		if (iteratorType != EolAnyType.Instance) {
			EolSequence typeSafeCollection = new EolSequence();
			while (li.hasNext()) {
				Object next = li.next();
				if (iteratorType.isKind(next)) {
					typeSafeCollection.add(next);
				}
			}
			li = typeSafeCollection.iterator();
		}
		
		boolean loopBroken = false;
		
		//TODO : Address the case where elements are removed from the collection during iteration
		
		int loop = 1;
		while (li.hasNext() && !loopBroken){
			Object next = li.next();
			
			if (!iteratorType.isKind(next)) continue;
			
			// TODO: See if enter and leave should be performed inside or outside the while loop
			context.getFrameStack().enter(FrameType.UNPROTECTED, ast);
			
			context.getFrameStack().put(new Variable(iteratorName, next, iteratorType));
			context.getFrameStack().put(new Variable("hasMore",new EolBoolean(li.hasNext()), EolPrimitiveType.Boolean, true));
			context.getFrameStack().put(new Variable("loopCount",new EolInteger(loop++), EolPrimitiveType.Integer, true));

			try {
				context.getExecutorFactory().executeAST(bodyAst, context);
				context.getFrameStack().leave(ast);
			}
			catch (EolBreakException ex){
				loopBroken = true;
				context.getFrameStack().leave(ast);
				if (ex.isBreaksAll() && context.getFrameStack().isInLoop()){
					throw ex;
				}
			}
			catch (EolContinueException cex){
				context.getFrameStack().leave(ast);
			}
			
			
		}
		
		return null;
		
	}

}
