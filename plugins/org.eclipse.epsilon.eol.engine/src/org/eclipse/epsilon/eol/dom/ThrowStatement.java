package org.eclipse.epsilon.eol.dom;

public class ThrowStatement extends Statement {
	
	protected Expression thrown;
	
	@Override
	public void build() {
		super.build();
		thrown = (Expression) getFirstChild();
	}
	
}
