package org.eclipse.epsilon.eol.dom;

public class CaseExpressionStatement extends CaseStatement {
	
	protected Expression expression;
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
}
