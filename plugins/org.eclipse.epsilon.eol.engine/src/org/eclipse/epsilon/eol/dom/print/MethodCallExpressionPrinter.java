package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.MethodCallExpression;

public class MethodCallExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		MethodCallExpression exp = (MethodCallExpression) e;
		String pointOrArrow = ".";
		if (exp.isArrow()) pointOrArrow = "->";
		String s = "";
		if (exp.getTarget() != null) {
			s +=f.print(exp.getTarget()) + pointOrArrow;
		}
		s += f.escapeName(exp.getMethod()) + "("
			+ f.print(exp.getArguments(), ", ") + ")";
		return s;
	}
	
	
	
}
