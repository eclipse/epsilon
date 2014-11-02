package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.module.AbstractModuleElement;

public class ForStatement extends Statement {
	
	protected Parameter iterator;
	protected Expression iterated;
	protected AbstractModuleElement body;
	
	@Override
	public void build() {
		super.build();
		iterator = (Parameter) getFirstChild();
		iterated = (Expression) getSecondChild();
		body = (AbstractModuleElement) getThirdChild();
	}
	
	public Parameter getIterator() {
		return iterator;
	}
	
	public Expression getIterated() {
		return iterated;
	}
	
	public AbstractModuleElement getBody() {
		return body;
	}
	
}
