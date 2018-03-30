package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public abstract class EagerOperatorExpression extends OperatorExpression {
	
	public EagerOperatorExpression() {}
	
	public EagerOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object o1 = context.getExecutorFactory().execute(firstOperand, context);
		Object o2 = null;
		
		if (secondOperand != null) {
			o2 = context.getExecutorFactory().execute(secondOperand, context);
		}
		return execute(o1, o2, context);
	}
	
	public abstract Object execute(Object o1, Object o2, IEolContext context) throws EolRuntimeException;
	
}
