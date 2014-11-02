package org.eclipse.epsilon.eol.dom;

public class AssignmentStatement extends Statement {
	
	protected Expression lhs;
	protected Expression rhs;
	
	@Override
	public void build() {
		super.build();
		
		//this.lhs = (Expression) getFirstChild();
		//this.rhs = (Expression) getSecondChild();
		
	}
	
}
