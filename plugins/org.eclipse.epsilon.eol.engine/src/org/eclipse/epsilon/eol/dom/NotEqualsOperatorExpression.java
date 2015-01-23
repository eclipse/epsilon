package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class NotEqualsOperatorExpression extends EqualsOperatorExpression {
	
	public NotEqualsOperatorExpression() {}
	
	public NotEqualsOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	@Override
	public Object execute(Object o1, Object o2, IEolContext context)
			throws EolRuntimeException {
		return !((Boolean) super.execute(o1, o2, context)).booleanValue();
	}
	
}
