package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ImpliesOperatorExpression extends OperatorExpression {

	public ImpliesOperatorExpression() {}
	
	public ImpliesOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	@Override
	public Boolean execute(IEolContext context) throws EolRuntimeException {
		Object o1 = context.getExecutorFactory().execute(firstOperand, context);
		
		if (o1 instanceof Boolean) {
			if (!(boolean) o1) {
				return true;
			}
			else {
				Object o2 = context.getExecutorFactory().execute(secondOperand, context);
				if (o2 instanceof Boolean) {
					return ((boolean) o2) && ((boolean) o1);
				}
			}
		}
		
		throw new EolRuntimeException("Operator 'implies' applies only to operands of type Boolean", this);
	}
	
}
