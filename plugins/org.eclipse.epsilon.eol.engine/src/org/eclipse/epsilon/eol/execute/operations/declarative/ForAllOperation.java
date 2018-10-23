/*******************************************************************************
 * Copyright (c) 2008-2018 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 *     Sina Madani - refactoring
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NotOperatorExpression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class ForAllOperation extends SelectBasedOperation {
	
	@Override
	public Boolean execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {
		
		// Look for a counter-example
		return getSelectOperation().execute(target, iterator,
			new NotOperatorExpression(expression), context, true, true).isEmpty();
	}

}
