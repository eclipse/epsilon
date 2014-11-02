package org.eclipse.epsilon.eol.dom;

public class ReturnStatement extends Statement {
	
	protected Expression returned;
	
	@Override
	public void build() {
		super.build();
		returned = (Expression) getFirstChild();
	}
	
	public Expression getReturned() {
		return returned;
	}
	
}
