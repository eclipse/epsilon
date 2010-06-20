package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.DomElement;

public class AssignmentStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		AssignmentStatement s = (AssignmentStatement) e;
		return f.print(s.getLhs()) + " = " + f.print(s.getRhs()) + ";";
	}

}
