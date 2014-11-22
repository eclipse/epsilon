package org.eclipse.epsilon.eol.execute.operations.declarative;

import java.util.List;

import org.eclipse.epsilon.eol.dom.Expression;
import org.eclipse.epsilon.eol.dom.NameExpression;
import org.eclipse.epsilon.eol.dom.Parameter;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.execute.operations.AbstractOperation;

public abstract class FirstOrderOperation extends AbstractOperation {
	
	@Override
	public Object execute(Object target,
			NameExpression operationNameExpression, List<Parameter> iterators,
			List<Expression> expressions, IEolContext context)
			throws EolRuntimeException {

		Parameter iterator = iterators.get(0);
		return execute(target, new Variable(iterator.getName(), null, iterator.getType(context)), expressions.get(0), context);
	}
	

	
	public abstract Object execute(Object target, Variable iterator, Expression expression, IEolContext context) throws EolRuntimeException;
	
}
