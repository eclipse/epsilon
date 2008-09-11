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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.ecl.execute.context.IEclContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolCollection;


public class DoMatchOperation extends MatchesOperation{

	@Override
	public Object execute(Object obj, AST ast, IEolContext context_) throws EolRuntimeException {
		IEclContext context = (IEclContext) context_;
		AST parameterAst = ast.getFirstChild().getFirstChild();
		Object parameter = context.getExecutorFactory().executeAST(parameterAst, context);
		if (obj == null && parameter == null) return null;
		
		EolCollection leftCol = EolCollection.asCollection(obj).flatten();
		EolCollection rightCol = EolCollection.asCollection(parameter).flatten();
		
		for (Object left : leftCol.getStorage()) {
			for (Object right : rightCol.getStorage()) {
				matchInstances(left, right, context, true);
			}
		}

		return null;
		
	}
	
}
