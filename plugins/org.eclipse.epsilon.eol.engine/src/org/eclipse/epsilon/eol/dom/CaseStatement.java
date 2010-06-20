package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public abstract class CaseStatement extends Statement {
	
	protected ArrayList<Statement> body = new ArrayList<Statement>();
	
	public ArrayList<Statement> getBody() {
		return body;
	}
	
}
