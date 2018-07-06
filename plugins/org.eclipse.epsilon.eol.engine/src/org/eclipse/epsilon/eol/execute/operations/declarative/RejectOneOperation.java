package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class RejectOneOperation extends SelectBasedOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {

		return selectOperation.execute(target, iterator, expression, context, true, false);
	}

}
