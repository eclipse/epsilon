package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.IfStatement;

public class IfStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		IfStatement s = (IfStatement) e;
		String r = "if (" + f.print(s.getCondition()) + ") {" + f.newline()
			+ f.indent() + f.print(s.getIfBody()) + f.outdent() + f.newline() + "}";
		if (s.getElseBody().size() > 0) {
			r = r + "else { " + f.newline() + f.indent() + f.print(s.getElseBody()) 
			+ f.newline() + f.outdent() + "}"; 
		}
		return r;
	}

}
