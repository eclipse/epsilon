package org.eclipse.epsilon.eol.dom;

public class ExpressionStatement extends Statement {
	
	protected Expression expression;
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	public Expression getExpression() {
		return expression;
	}
	
}
