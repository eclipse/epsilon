package org.eclipse.epsilon.eol.dom;

public abstract class BinaryOperatorExpression extends OperatorExpression {

	protected Expression lhs;
	protected Expression rhs;
	
	public Expression getLhs() {
		return lhs;
	}
	
	public Expression getRhs() {
		return rhs;
	}
	
	public void setLhs(Expression lhs) {
		this.lhs = lhs;
	}
	
	public void setRhs(Expression rhs) {
		this.rhs = rhs;
	}

}
