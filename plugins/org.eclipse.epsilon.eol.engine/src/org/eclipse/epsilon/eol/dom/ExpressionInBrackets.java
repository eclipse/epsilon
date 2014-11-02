package org.eclipse.epsilon.eol.dom;

public class ExpressionInBrackets extends Expression {
	
	protected Expression expression;
	
	@Override
	public void build() {
		super.build();
		expression = (Expression) getFirstChild();
	}
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
}
