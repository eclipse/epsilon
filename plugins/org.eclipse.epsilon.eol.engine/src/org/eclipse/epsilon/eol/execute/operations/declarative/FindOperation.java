package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.ISearchableModel;

public class FindOperation extends FirstOrderOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
		IEolContext context) throws EolRuntimeException {
		
		if (target instanceof ISearchableModel) {
			ISearchableModel searchableModel = (ISearchableModel) target;
			return searchableModel.find(iterator, expression, context);
		}
		else {
			return new SelectOperation().execute(target, iterator, expression, context);
		}
	}
	
}
