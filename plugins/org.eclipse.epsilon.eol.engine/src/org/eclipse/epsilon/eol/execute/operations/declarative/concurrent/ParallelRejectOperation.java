package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.declarative.RejectOperation;

public class ParallelRejectOperation extends RejectOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {
		
		selectOperation = new ParallelSelectOperation();
		return super.execute(target, iterator, expression, context);
	}
	
}
