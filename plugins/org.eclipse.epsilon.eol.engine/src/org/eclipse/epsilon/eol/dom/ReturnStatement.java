package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.Return;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ReturnStatement extends Statement {
	
	protected Expression returnedExpression;
	
	public ReturnStatement() {}
	
	public ReturnStatement(Expression returnedExpression) {
		this.returnedExpression = returnedExpression;
	}
	
	@Override
	public void build() {
		super.build();
		returnedExpression = (Expression) getFirstChild();
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
	
		Object result = null;
		if (returnedExpression != null){
			result = context.getExecutorFactory().executeAST(returnedExpression, context);
		}
		
		return new Return(result);
	}
	
	public Expression getReturnedExpression() {
		return returnedExpression;
	}
	
	public void setReturnedExpression(Expression returnedExpression) {
		this.returnedExpression = returnedExpression;
	}
	
}
