package org.eclipse.epsilon.eol.dom;

public class ReturnStatement extends Statement {
	
	protected Expression returned;
	
	public Expression getReturned() {
		return returned;
	}
	
	public void setReturned(Expression returned) {
		this.returned = returned;
	}
	
}
