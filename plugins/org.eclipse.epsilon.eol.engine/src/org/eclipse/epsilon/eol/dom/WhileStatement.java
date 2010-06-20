package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class WhileStatement extends Statement {
	
	protected Expression condition;
	protected ArrayList<Statement> body = new ArrayList<Statement>();
	
	public ArrayList<Statement> getBody() {
		return body;
	}
	
	public void setCondition(Expression condition) {
		this.condition = condition;
	}
	
	public Expression getCondition() {
		return condition;
	}
	
}


