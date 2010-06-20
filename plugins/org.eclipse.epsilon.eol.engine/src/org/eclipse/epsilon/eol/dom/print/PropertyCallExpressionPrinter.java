package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.PropertyCallExpression;

public class PropertyCallExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		PropertyCallExpression exp = (PropertyCallExpression) e;
		return f.print(exp.getTarget()) + "." + f.escapeName(exp.getProperty());
	}

}
