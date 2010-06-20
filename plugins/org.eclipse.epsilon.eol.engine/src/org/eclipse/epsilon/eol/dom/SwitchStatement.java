package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class SwitchStatement extends Statement {
	
	protected Expression expression;
	protected ArrayList<CaseStatement> cases = new ArrayList<CaseStatement>();
	
	public Expression getExpression() {
		return expression;
	}
	
	public void setExpression(Expression expression) {
		this.expression = expression;
	}
	
	public ArrayList<CaseStatement> getCases() {
		return cases;
	}
	
}
