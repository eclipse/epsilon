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
package org.eclipse.epsilon.eol.execute;

import java.util.Collection;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.parse.problem.ParseProblem;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.EolModule;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolMap;

public class ItemSelectorExecutor extends AbstractExecutor {
	
	public Object execute(AST ast, IEolContext context)
			throws EolRuntimeException {
		
		AST expressionAst = ast.getFirstChild();
		AST indexAst = expressionAst.getNextSibling();
		
		Object expression = context.getExecutorFactory().executeAST(expressionAst, context);
		Object index = context.getExecutorFactory().executeAST(indexAst, context);
		
		if ((expression instanceof Collection)) {
			if (!(index instanceof Integer)) 
				throw new EolRuntimeException("Collection index must be an integer but " + index + " was provided instead.", indexAst, context.getFrameStack());
			else return CollectionUtil.asList(expression).get((Integer)index);
		}
		else if (expression instanceof EolMap){
			return ((EolMap) expression).get(index);
		}
		
		throw new EolRuntimeException(expression + " is not a collection or a map.", expressionAst, context.getFrameStack());
	}
	
	public static void main(String[] args) throws Exception {
		
		EolModule module = new EolModule();
		//module.parse("var map = new Map; map.put('foo', 'bar'); map['foo'].println();");
		module.parse("var list = List{1,2,3}; list.println();");
		if (module.getParseProblems().size() > 0) {
			for (ParseProblem p : module.getParseProblems()) {
				System.out.println(p);
			}
		}
		else {
			module.execute();
		}
	}
	
	
}
