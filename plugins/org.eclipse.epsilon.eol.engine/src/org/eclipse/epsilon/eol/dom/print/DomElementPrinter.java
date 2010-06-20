package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;

public interface DomElementPrinter {
	
	public String print(DomElement e, DomElementPrinterFactory f);
	
}
