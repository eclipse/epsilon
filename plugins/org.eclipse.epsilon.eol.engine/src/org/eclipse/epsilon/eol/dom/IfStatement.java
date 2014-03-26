package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;

public class IfStatement extends Statement {
	
	public Expression getCondition() {
		return (Expression) getFirstChild();
	}
	
	public AST getThen() {
		return getSecondChild();
	}
	
	public AST getElse() {
		if (getChildCount() == 3) {
			return getChild(2);
		}
		else return null;
	}
	
}
