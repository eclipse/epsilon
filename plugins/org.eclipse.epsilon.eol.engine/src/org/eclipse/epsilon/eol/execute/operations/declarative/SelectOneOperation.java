package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class SelectOneOperation extends SelectBasedOperation {

	@Override
	public Object execute(Object target, Variable iterator, Expression expression, IEolContext context)
		throws EolRuntimeException {

		Collection<?> result = getSelectOperation().execute(target, iterator, expression, context, true, true);
		return result.isEmpty() ? null : result.iterator().next();
	}

}
