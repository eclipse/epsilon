package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class NegativeOperatorExpression extends EagerOperatorExpression {

	public NegativeOperatorExpression() {}
	
	public NegativeOperatorExpression(Expression operand) {
		super(operand, null);
	}
	
	@Override
	public Object execute(Object o1, Object o2, IEolContext context) throws EolRuntimeException {
		if (o1 instanceof Number){
			return NumberUtil.negative((Number) o1);
		}
		return o1;
	}
	
}
