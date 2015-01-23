package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class LessThanOperatorExpression extends EagerOperatorExpression {

	public LessThanOperatorExpression() {}
	
	public LessThanOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	@Override
	public Object execute(Object o1, Object o2, IEolContext context) throws EolRuntimeException {
		if (o1 instanceof Number && o2 instanceof Number){
			return NumberUtil.lessThan((Number) o1, (Number) o2);
		}
		return false;
	}
	
}
