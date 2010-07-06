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

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.CollectionUtil;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.parse.EolParser;


public class CollectionExecutor extends AbstractExecutor{

	@Override
	public Object execute(AST ast, IEolContext context) throws EolRuntimeException{
		
		Collection collection = null; 
		
		if (ast.getText().equals("Sequence") || ast.getText().equals("List")){
			collection = CollectionUtil.createDefaultList();
		}
		else if (ast.getText().equals("Set")){
			collection = CollectionUtil.createDefaultSet();
		}
		else if (ast.getText().equals("OrderedSet")){
			collection = CollectionUtil.createDefaultSet();
		}
		else {
			collection = CollectionUtil.createDefaultList();
		}
		
		AST expressionListAst = ast.getFirstChild();
		
		if (expressionListAst != null){
			
			if (expressionListAst.getType() == EolParser.EXPRLIST){
				AST statementAst = expressionListAst.getFirstChild();
				while (statementAst != null){
					Object value = context.getExecutorFactory().executeAST(statementAst, context);
					//collection.add(EolTypeWrapper.getInstance().unwrap(value));
					//collection.add(EolTypeWrapper.getInstance().wrap(value));
					collection.add(value);
					statementAst = statementAst.getNextSibling();
				}
			}
			else { // EolParserTokenTypes.EXPRRANGE
				AST rangeStartAst = expressionListAst.getFirstChild();
				AST rangeEndAst = rangeStartAst.getNextSibling();
				
				Object rangeStart = context.getExecutorFactory().executeAST(rangeStartAst, context);
				Object rangeEnd = context.getExecutorFactory().executeAST(rangeEndAst, context);
				
				if (rangeStart instanceof Integer && rangeEnd instanceof Integer){
					for (int i=((Integer)rangeStart).intValue(); i<=((Integer)rangeEnd).intValue(); i++){
						collection.add(i);
						//collection.add(i);
					}
				}
				else {
					if (!(rangeStart instanceof Integer)){
						throw new EolRuntimeException("The start of a range should be of type Integer", rangeStartAst);
					}
					if (!(rangeEnd instanceof Integer)){
						throw new EolRuntimeException("The end of a range should be of type Integer", rangeEndAst);
					}
					
				}
			}
		}
		
		return collection;
	}

}
