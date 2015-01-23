package org.eclipse.epsilon.eol.dom;

import java.util.Collection;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.eol.execute.operations.contributors.IterableOperationContributor;
import org.eclipse.epsilon.eol.types.NumberUtil;

public class MinusOperatorExpression extends EagerOperatorExpression {
	
	public MinusOperatorExpression() {}
	
	public MinusOperatorExpression(Expression firstOperand, Expression secondOperand) {
		super(firstOperand, secondOperand);
	}
	
	@Override
	public Object execute(Object o1, Object o2, IEolContext context) throws EolRuntimeException {
		if (o1 instanceof Number && o2 instanceof Number){
			return NumberUtil.subtract((Number) o1, (Number) o2);
		}
		else if (o1 instanceof Collection && o2 instanceof Collection){
			return new IterableOperationContributor((Collection<?>) o1).excludingAll((Collection<?>) o2);
		}
		return null;
	}
	
}
