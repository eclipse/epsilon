package org.eclipse.epsilon.eol.execute.operations.declarative.concurrent;

import java.util.Collection;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.declarative.RejectOneOperation;

public class ParallelRejectOneOperation extends RejectOneOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {

		ParallelSelectOneOperation delegate = new ParallelSelectOneOperation(true);
		Object result = delegate.execute(target, iterator, expression, context);

		Collection<Object> source = CollectionUtil.asCollection(target);
		if (delegate.hasResult) {
			source.remove(result);
		}
		return source;
	}
	
}
