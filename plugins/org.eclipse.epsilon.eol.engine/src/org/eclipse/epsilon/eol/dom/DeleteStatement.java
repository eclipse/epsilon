package org.eclipse.epsilon.eol.dom;

public class DeleteStatement extends Statement {
	
	protected Expression deleted;
	
	public Expression getDeleted() {
		return deleted;
	}
	
	public void setDeleted(Expression deleted) {
		this.deleted = deleted;
	}
	
}
