package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.dom.DomElement;

public abstract class BinaryOperatorPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		BinaryOperatorExpression exp = (BinaryOperatorExpression) e;
		return "(" + f.print(exp.getLhs()) + " " + getOperatorSymbol() + " " + f.print(exp.getRhs()) + ")";
	}
	
	protected abstract String getOperatorSymbol();
	
}
