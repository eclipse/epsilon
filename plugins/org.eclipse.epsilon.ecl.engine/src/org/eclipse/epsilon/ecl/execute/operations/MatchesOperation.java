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
package org.eclipse.epsilon.ecl.execute.operations;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;

public class MatchesOperation extends AbstractOperation{

	@Override
	public Object execute(Object obj, AST ast, IEolContext context_) throws EolRuntimeException {
		IEclContext context = (IEclContext) context_;
		AST parameterAst = ast.getFirstChild().getFirstChild();
		Object parameter = context.getExecutorFactory().executeAST(parameterAst, context);
		if (obj == null && parameter == null) return true;
		
		if (obj instanceof Collection && parameter instanceof Collection){
			
			Collection<?> leftCol = (Collection<?>) obj;
			Collection<?> rightCol = (Collection<?>) parameter;

			//context.getDefaultDebugStream().print(leftCol.size() + ":" + rightCol.size());
			
			//if (leftCol.size() != rightCol.size()) return EolBoolean.FALSE;
			
			//context.getDefaultDebugStream().print(leftCol.size() + ":" + rightCol.size());
			
			
			Collection<?> leftColFlat = CollectionUtil.flatten(leftCol);
			Collection<?> rightColFlat = CollectionUtil.flatten(rightCol);
			
			if (leftColFlat.size() != rightColFlat.size()){
				return false;
			}
			
			Iterator<?> lit = leftColFlat.iterator();
			Iterator<?> rit = rightColFlat.iterator();
			
			Boolean match = true;
			
			while (lit.hasNext() && match){
				match = match && (matchInstances(lit.next(), rit.next(), context, false));
			}
			
			return match;
		}
		else if (obj instanceof Collection ^ parameter instanceof Collection) {
			return false;
		}
		else {
			return matchInstances(obj, parameter, context, false);
		}
		
	}
	
	protected boolean matchInstances(Object left, Object right, IEclContext context, boolean forcedMatch) throws EolRuntimeException{
		
		Match match = context.getModule().match(left,right, forcedMatch);
		return match.isMatching();
	}
}
