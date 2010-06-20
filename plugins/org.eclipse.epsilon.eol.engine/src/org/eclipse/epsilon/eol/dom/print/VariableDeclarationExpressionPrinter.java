package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;

public class VariableDeclarationExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		VariableDeclarationExpression exp = (VariableDeclarationExpression) e;
		String s = exp.getName();
		if (exp.getType() != null) {
			s = s + ":" + exp.getType();
		}
		return s;
	}

}
