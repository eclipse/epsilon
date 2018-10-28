/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class SelectOneOperation extends SelectBasedOperation {

	private boolean hasResult;
	
	@Override
	public Object execute(Object target, Variable iterator, Expression expression, IEolContext context) throws EolRuntimeException {
		Collection<?> result = getSelectOperation().execute(target, iterator, expression, context, true, true);
		return ((hasResult = !result.isEmpty()) == true) ? result.iterator().next() : null;
	}

	public boolean hasResult() {
		return hasResult;
	}
	
}
