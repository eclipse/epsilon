package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;

public class Case extends AbstractModuleElement {
	
	protected Expression condition;
	protected StatementBlock body;
	
	@Override
	public void build() {
		super.build();
		if (getChildCount() == 2) { // regular case
			condition = (Expression) getFirstChild();
			body = (StatementBlock) getSecondChild();
		} else { // default
			body = (StatementBlock) getFirstChild();
		}
	}
	
	public Expression getCondition() {
		return condition;
	}
	
	public void setCondition(Expression condition) {
		this.condition = condition;
	}
	
	public StatementBlock getBody() {
		return body;
	}
	
	public void setBody(StatementBlock body) {
		this.body = body;
	}
}
