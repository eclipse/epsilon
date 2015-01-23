package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.compile.context.IEolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ExpressionStatement extends Statement {
	
	protected Expression expression = null;
	
	public ExpressionStatement() {}
	
	public ExpressionStatement(Expression expression) {
		this.expression = expression;
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return context.getExecutorFactory().executeAST(expression, context);
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	@Override
	public void compile(IEolCompilationContext context) {
		expression.compile(context);
	}
	
}
