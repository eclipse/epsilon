package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;

public class IfStatement extends Statement {
	
	protected Expression condition;
	protected AbstractModuleElement then;
	protected AbstractModuleElement _else;
	
	@Override
	public void build() {
		super.build();
		condition = (Expression) getFirstChild();
		then = (AbstractModuleElement) getSecondChild();
		if (getChildCount() == 3) {
			_else = (AbstractModuleElement) getThirdChild();
		}
	}
	
	public Expression getCondition() {
		return condition;
	}
	
	public AbstractModuleElement getThen() {
		return then;
	}
	
	public AbstractModuleElement getElse() {
		return _else;
	}
	
}
