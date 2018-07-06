package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.declarative.ExistsOperation;

public class ParallelExistsOperation extends ExistsOperation {

	@Override
	public Boolean execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {
		
		ParallelSelectOneOperation op = new ParallelSelectOneOperation();
		op.execute(target, iterator, expression, context);
		return op.hasResult;
	}
	
}
