package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.LiteralExpression;

public class LiteralValueExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		LiteralExpression exp = (LiteralExpression) e;
		return exp.getValue();
	}

}
