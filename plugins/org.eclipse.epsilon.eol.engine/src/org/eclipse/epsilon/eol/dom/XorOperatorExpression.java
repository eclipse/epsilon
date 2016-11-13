package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class XorOperatorExpression extends OperatorExpression {

	public XorOperatorExpression() {}
	
	public XorOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object o1 = context.getExecutorFactory().execute(firstOperand,context);
		Object o2 = context.getExecutorFactory().execute(secondOperand,context);
		if (o1 instanceof Boolean && o2 instanceof Boolean){
			return ((Boolean) o1) ^ ((Boolean) o2);
		} else {
			throw new EolRuntimeException("Operator 'xor' applies only to Booleans", this);
		}
	}
	
}
