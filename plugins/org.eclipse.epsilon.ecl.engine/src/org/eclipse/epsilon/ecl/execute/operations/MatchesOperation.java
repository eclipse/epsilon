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

import java.util.Iterator;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.ecl.trace.Match;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.eol.types.EolCollection;


public class MatchesOperation extends AbstractOperation{

	@Override
	public Object execute(Object obj, AST ast, IEolContext context_) throws EolRuntimeException {
		IEclContext context = (IEclContext) context_;
		AST parameterAst = ast.getFirstChild().getFirstChild();
		Object parameter = context.getExecutorFactory().executeAST(parameterAst, context);
		if (obj == null && parameter == null) return EolBoolean.TRUE;
		
		if (obj instanceof EolCollection && parameter instanceof EolCollection){
			
			EolCollection leftCol = (EolCollection) obj;
			EolCollection rightCol = (EolCollection) parameter;

			//context.getDefaultDebugStream().print(leftCol.size() + ":" + rightCol.size());
			
			//if (leftCol.size() != rightCol.size()) return EolBoolean.FALSE;
			
			//context.getDefaultDebugStream().print(leftCol.size() + ":" + rightCol.size());
			
			
			EolCollection leftColFlat = leftCol.flatten();
			EolCollection rightColFlat = rightCol.flatten();
			
			if (!leftColFlat.size().equals(rightColFlat.size())){
				return EolBoolean.FALSE;
			}
			
			Iterator lit = leftColFlat.iterator();
			Iterator rit = rightColFlat.iterator();
			
			EolBoolean match = EolBoolean.TRUE;
			
			while (lit.hasNext()){
				match = match.and(matchInstances(lit.next(), rit.next(), context, false));
			}
			
			return match;
		}
		else if (obj instanceof EolCollection ^ parameter instanceof EolCollection) {
			return EolBoolean.FALSE;
		}
		else {
			return matchInstances(obj, parameter, context, false);
		}
		
	}
	
	protected EolBoolean matchInstances(Object left, Object right, IEclContext context, boolean forcedMatch) throws EolRuntimeException{
		
		Match match = context.getModule().match(left,right, forcedMatch);
		return new EolBoolean(match.isMatching());
	}
}
