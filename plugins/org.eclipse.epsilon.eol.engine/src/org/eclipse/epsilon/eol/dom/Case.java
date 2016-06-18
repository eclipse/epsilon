package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;
import org.eclipse.epsilon.common.module.IModule;
import org.eclipse.epsilon.common.parse.AST;

public class Case extends AbstractModuleElement {
	
	protected Expression condition;
	protected StatementBlock body;
	
	@Override
	public void build(AST cst, IModule module) {
		super.build(cst, module);
		if (cst.getChildCount() == 2) { // regular case
			condition = (Expression) module.createAst(cst.getFirstChild(), this);
			body = (StatementBlock) module.createAst(cst.getSecondChild(), this);
		} else { // default
			body = (StatementBlock) module.createAst(cst.getFirstChild(), this);
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
