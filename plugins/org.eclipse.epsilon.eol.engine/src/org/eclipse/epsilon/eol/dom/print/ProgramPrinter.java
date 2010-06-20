package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Program;

public class ProgramPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		Program p = (Program) e;
		return f.print(p.getImports()) + f.newline() + 
			f.print(p.getStatements()) + f.newline();
	}

}
