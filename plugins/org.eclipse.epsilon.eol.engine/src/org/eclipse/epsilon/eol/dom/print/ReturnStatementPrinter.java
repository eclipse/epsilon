package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ReturnStatement;

public class ReturnStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		String r = "return";
		ReturnStatement s = (ReturnStatement) e;
		if (s.getReturned() != null) {
			r += " " + f.print(s.getReturned());
		}
		r += ";";
		return r;
		
	}

}
