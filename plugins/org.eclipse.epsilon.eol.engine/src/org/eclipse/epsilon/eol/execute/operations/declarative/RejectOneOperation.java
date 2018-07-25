package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.Collection;
import org.eclipse.epsilon.common.util.CollectionUtil;
import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;

public class RejectOneOperation extends FirstOrderOperation {

	@Override
	public Collection<?> execute(Object target, Variable iterator, Expression expression,
			IEolContext context) throws EolRuntimeException {

		Collection<Object> source = CollectionUtil.asCollection(target);
		if (source.isEmpty()) return source;
		
		SelectOneOperation delegate = new SelectOneOperation(true);
		Object result = delegate.execute(target, iterator, expression, context);

		if (delegate.hasResult) {
			source.remove(result);
		}
		return source;
	}

}
