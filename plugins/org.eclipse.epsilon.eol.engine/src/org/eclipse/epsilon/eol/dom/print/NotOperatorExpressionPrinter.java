package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.NotOperatorExpression;

public class NotOperatorExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		NotOperatorExpression ex = (NotOperatorExpression) e;
		return "not " + f.print(ex.getExpression());
	}
	
}
