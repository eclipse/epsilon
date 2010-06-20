package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.Import;

public class ImportPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		Import imp = (Import) e;
		return "import " + f.addQuotes(imp.getImported()) + ";";
	}

}
