package org.eclipse.epsilon.eol.dom;

public abstract class FeatureCallExpression extends Expression {
	
	protected Expression target;
	protected boolean arrow;
	
	public boolean isArrow() {
		return arrow;
	}
	
	public void setArrow(boolean arrow) {
		this.arrow = arrow;
	}
	
	public void setTarget(Expression target) {
		this.target = target;
	}
	
	public Expression getTarget() {
		return target;
	}
}
