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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;
import org.eclipse.epsilon.eol.types.EolBag;
import org.eclipse.epsilon.eol.types.EolCollection;
import org.eclipse.epsilon.eol.types.EolInteger;
import org.eclipse.epsilon.eol.types.EolOrderedSet;
import org.eclipse.epsilon.eol.types.EolSequence;
import org.eclipse.epsilon.eol.types.EolSet;
import org.eclipse.epsilon.eol.types.EolTypeWrapper;


public class CollectionExecutor extends AbstractExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		
		EolCollection collection = null; 
		
		if (ast.getText().equals("Sequence")){
			collection = new EolSequence();
		}
		else if (ast.getText().equals("Set")){
			collection = new EolSet();
		}
		else if (ast.getText().equals("OrderedSet")){
			collection = new EolOrderedSet();
		}
		else {
			collection = new EolBag();
		}
		
		AST expressionListAst = ast.getFirstChild();
		
		if (expressionListAst != null){
			
			if (expressionListAst.getType() == EolParser.EXPRLIST){
				AST statementAst = expressionListAst.getFirstChild();
				while (statementAst != null){
					Object value = context.getExecutorFactory().executeAST(statementAst, context);
					collection.add(EolTypeWrapper.getInstance().unwrap(value));
					statementAst = statementAst.getNextSibling();
				}
			}
			else { // EolParserTokenTypes.EXPRRANGE
				AST rangeStartAst = expressionListAst.getFirstChild();
				AST rangeEndAst = rangeStartAst.getNextSibling();
				
				Object rangeStart = context.getExecutorFactory().executeAST(rangeStartAst, context);
				Object rangeEnd = context.getExecutorFactory().executeAST(rangeEndAst, context);
				
				if (rangeStart instanceof EolInteger && rangeEnd instanceof EolInteger){
					for (int i=((EolInteger)rangeStart).intValue(); i<=((EolInteger)rangeEnd).intValue(); i++){
						//collection.add(new EolInteger(i));
						collection.add(i);
					}
				}
				else {
					if (!(rangeStart instanceof EolInteger)){
						throw new EolRuntimeException("The start of a range should be of type Integer", rangeStartAst);
					}
					if (!(rangeEnd instanceof EolInteger)){
						throw new EolRuntimeException("The end of a range should be of type Integer", rangeEndAst);
					}
					
				}
			}
		}
		
		return collection;
	}

}
