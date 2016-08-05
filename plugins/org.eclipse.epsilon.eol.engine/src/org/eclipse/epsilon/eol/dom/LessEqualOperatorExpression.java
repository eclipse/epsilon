package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.types.EolObjectComparator;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class LessEqualOperatorExpression extends EagerOperatorExpression {

	public LessEqualOperatorExpression() {}
	
	public LessEqualOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	@Override
	public Object execute(Object o1, Object o2, IEolContext context) throws EolRuntimeException {
		return (
				o1 instanceof Number
				&& o2 instanceof Number
				&& NumberUtil.lessThan((Number) o1, (Number) o2)
		) || EolObjectComparator.equals(o1, o2);
	}

}
