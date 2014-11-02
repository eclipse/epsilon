package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;

public class WhileStatement extends Statement {
	
	protected Expression condition;
	protected AbstractModuleElement body;
	
	@Override
	public void build() {
		super.build();
		condition = (Expression) getFirstChild();
		body = (AbstractModuleElement) getSecondChild();
	} 
	
	public Expression getCondition() {
		return condition;
	}
	
	public AbstractModuleElement getBody() {
		return body;
	}
}
