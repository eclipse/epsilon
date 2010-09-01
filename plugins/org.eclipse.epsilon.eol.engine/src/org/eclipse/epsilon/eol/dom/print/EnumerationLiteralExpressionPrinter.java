package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.EnumerationLiteralExpression;

public class EnumerationLiteralExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		String s = "";
		EnumerationLiteralExpression ex = (EnumerationLiteralExpression) e;
		if (ex.getModel() != null) {
			s = ex.getModel() + "!";
		}
		s = s + ex.getEnumeration() + "#" + ex.getLiteral();
		return s;
	}

}
