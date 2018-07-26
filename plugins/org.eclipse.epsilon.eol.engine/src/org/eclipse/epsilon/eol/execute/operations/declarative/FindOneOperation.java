package org.eclipse.epsilon.eol.execute.operations.declarative;

import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.ISearchableModel;

public class FindOneOperation extends SelectBasedOperation {

	@Override
	public Object execute(Object target, Variable iterator, Expression expression,
		IEolContext context) throws EolRuntimeException {
		
		if (target instanceof ISearchableModel) {
			ISearchableModel searchableModel = (ISearchableModel) target;
			return searchableModel.findOne(iterator, expression, context);
		}
		else {
			return getSelectOperation().execute(target, iterator, expression, context, true, true);
		}
	}

}
