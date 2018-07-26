/*********************************************************************
* Copyright (c) 2008 The University of York.
*
* This program and the accompanying materials are made
* available under the terms of the Eclipse Public License 2.0
* which is available at https://www.eclipse.org/legal/epl-2.0/
*
* SPDX-License-Identifier: EPL-2.0
**********************************************************************/
package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.ISearchableModel;

public class FindOperation extends SelectBasedOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
		IEolContext context) throws EolRuntimeException {
		
		if (target instanceof ISearchableModel) {
			ISearchableModel searchableModel = (ISearchableModel) target;
			return searchableModel.find(iterator, expression, context);
		}
		else {
			return getSelectOperation().execute(target, iterator, expression, context, true, false);
		}
	}
	
}
