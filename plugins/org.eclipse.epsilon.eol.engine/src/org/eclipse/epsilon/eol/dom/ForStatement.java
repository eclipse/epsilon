package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class ForStatement extends Statement {
	
	protected VariableDeclarationExpression iterator;
	protected Expression iterated;
	protected ArrayList<Statement> body = new ArrayList<Statement>();
	
	public VariableDeclarationExpression getIterator() {
		return iterator;
	}
	
	public void setIterator(VariableDeclarationExpression iterator) {
		this.iterator = iterator;
	}
	
	public Expression getIterated() {
		return iterated;
	}
	
	public void setIterated(Expression iterated) {
		this.iterated = iterated;
	}
	
	public ArrayList<Statement> getBody() {
		return body;
	}
	
}
