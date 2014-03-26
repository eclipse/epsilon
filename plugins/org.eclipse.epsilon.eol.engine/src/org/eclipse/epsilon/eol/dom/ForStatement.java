package org.eclipse.epsilon.eol.dom;

import org.eclipse.epsilon.common.parse.AST;

public class ForStatement extends Statement {
	
	public VariableDeclaration getIterator() {
		return (VariableDeclaration) getFirstChild();
	}
	
	public Expression getIterated() {
		return (Expression) getSecondChild();
	}
	
	public AST getBody() {
		return getThirdChild();
	}
	
}
