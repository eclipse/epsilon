package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.AssignmentStatement;
import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ExpressionStatement;
import org.eclipse.epsilon.eol.dom.Import;
import org.eclipse.epsilon.eol.dom.VariableDeclarationExpression;

public class VariableDeclarationExpressionPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		VariableDeclarationExpression exp = (VariableDeclarationExpression) e;
		String s = "";
		if (exp.eContainer() instanceof ExpressionStatement || 
				(exp.eContainer() instanceof AssignmentStatement && ((AssignmentStatement) exp.eContainer()).getLhs() == exp)) {
			s += "var ";
		}
		s += exp.getName();
		if (exp.getType() != null) {
			s = s + " : " + exp.getType();
		}
		return s;
	}

}
