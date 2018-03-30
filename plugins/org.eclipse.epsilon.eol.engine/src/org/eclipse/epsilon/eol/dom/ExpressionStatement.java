package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.eol.compile.context.EolCompilationContext;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.IEolContext;

public class ExpressionStatement extends Statement {
	
	protected Expression expression = null;
	
	public ExpressionStatement() {}
	
	public ExpressionStatement(Expression expression) {
		this.setExpression(expression);
		if (expression.getParent() != null) expression.getParent().getChildren().remove(expression);
		expression.setParent(this);
		this.getChildren().add(expression);
		this.setUri(expression.getUri());
		this.setRegion(expression.getRegion());
	}
	
	@Override
	public Object execute(IEolContext context) throws EolRuntimeException {
		return context.getExecutorFactory().execute(expression, context);
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	@Override
	public void compile(EolCompilationContext context) {
		expression.compile(context);
	}
}
