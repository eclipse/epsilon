package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class NotOperatorExpression extends OperatorExpression {

	public NotOperatorExpression() {}
	
	public NotOperatorExpression(Expression operand) {
		super(operand, null);
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object o1 = context.getExecutorFactory().execute(firstOperand,context);
		if (o1 instanceof Boolean){
			return !((Boolean) o1);
		} else {
			throw new EolRuntimeException("Operator 'not' applies only to Booleans", this);
		}
	}
	
}
