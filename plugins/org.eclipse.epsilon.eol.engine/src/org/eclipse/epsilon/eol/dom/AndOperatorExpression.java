package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class AndOperatorExpression extends OperatorExpression {
	
	public AndOperatorExpression() {}
	
	public AndOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}

	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		Object o1 = context.getExecutorFactory().execute(firstOperand, context);
		
		if (o1 instanceof Boolean) {
			boolean b1 = (boolean) o1;
			if (!b1) {
				return false;
			}
			else {
				Object o2 = context.getExecutorFactory().execute(secondOperand, context);
				if (o2 instanceof Boolean) {
					return (Boolean) o2;
				}
				else {
					throw new EolRuntimeException("Operator 'and' applies only to operands of type Boolean", this);
				}
			}
		}
		else {
			throw new EolRuntimeException("Operator 'and' applies only to operands of type Boolean", this);
		}
	}
	
}
