package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;

public abstract class StatementBlockContainer extends DomElement {
	
	protected List<Statement> statements = new ArrayList<Statement>();
	
	public List<Statement> getStatements() {
		return statements;
	}
}
