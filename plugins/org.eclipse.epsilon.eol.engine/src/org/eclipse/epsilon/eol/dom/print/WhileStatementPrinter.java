package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.IfStatement;
import org.eclipse.epsilon.eol.dom.WhileStatement;

public class WhileStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		WhileStatement s = (WhileStatement) e;
		String r = "while (" + f.print(s.getCondition()) + ") {" + f.newline()
			+ f.indent() + f.print(s.getBody()) + f.outdent() + f.newline() + "}";
		return r;
	}

}
