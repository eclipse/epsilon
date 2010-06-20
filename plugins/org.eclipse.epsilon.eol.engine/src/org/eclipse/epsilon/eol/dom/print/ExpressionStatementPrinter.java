package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ExpressionStatement;

public class ExpressionStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		ExpressionStatement s = (ExpressionStatement) e;
		return f.print(s.getExpression()) + ";";
	}

}
