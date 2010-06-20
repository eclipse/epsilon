package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class IfStatement extends Statement {
	
	protected Expression condition;
	protected ArrayList<Statement> ifBody = new ArrayList<Statement>();
	protected ArrayList<Statement> elseBody = new ArrayList<Statement>();
	
	public Expression getCondition() {
		return condition;
	}
	
	public void setCondition(Expression condition) {
		this.condition = condition;
	}
	
	public ArrayList<Statement> getIfBody() {
		return ifBody;
	}
	
	public ArrayList<Statement> getElseBody() {
		return elseBody;
	}
	
}


