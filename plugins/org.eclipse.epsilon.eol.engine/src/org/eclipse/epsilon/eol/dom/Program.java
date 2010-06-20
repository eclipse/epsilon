package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class Program extends DomElement {
	
	protected ArrayList<Statement> statements = new ArrayList<Statement>();
	public ArrayList<Import> imports = new ArrayList<Import>();
	
	public ArrayList<Import> getImports() {
		return imports;
	}

	public ArrayList<Statement> getStatements() {
		return statements;
	}
	
}
