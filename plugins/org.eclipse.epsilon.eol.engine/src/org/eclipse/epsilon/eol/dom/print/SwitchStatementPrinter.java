package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.SwitchStatement;

public class SwitchStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		SwitchStatement statement = (SwitchStatement) e;
		String r = "switch (" + f.print(statement.getExpression()) + ") {" + f.newline()
		+ f.indent() + f.print(statement.getCases()) + f.newline() + 
		f.outdent() + f.whitespace() + "}";
		return r;
	}
	
}
