package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ForStatement;

public class ForStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		ForStatement s = (ForStatement) e;
		return "for (" + f.print(s.getIterator()) + " in " + 
			f.print(s.getIterated()) + ") {" + f.newline() + 
			f.indent() + f.print(s.getBody()) + f.outdent() + f.newline() 
			+ f.whitespace() + "}";
	}

}
