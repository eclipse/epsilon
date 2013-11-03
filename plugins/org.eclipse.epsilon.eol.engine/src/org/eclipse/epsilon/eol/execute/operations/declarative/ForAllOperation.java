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

import org.antlr.runtime.CommonToken;
import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.parse.EolParser;

public class ForAllOperation extends SelectBasedOperation {

	@Override
	public Object execute(Object target, Variable iterator, AST expressionAst,
			IEolContext context) throws EolRuntimeException {
		
		AST negatedExpressionAst = new AST(new CommonToken(EolParser.OPERATOR, "not"), expressionAst);
		negatedExpressionAst.addChild(expressionAst);
		
		Collection<?> selected = (Collection<?>) selectOperation.execute(target, iterator, negatedExpressionAst, context, true);
		return selected.size() == 0;
	}

}
