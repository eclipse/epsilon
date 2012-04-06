/*******************************************************************************
 * Copyright (c) 2012 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.dom.print;

import org.eclipse.epsilon.eol.dom.DomElement;
import org.eclipse.epsilon.eol.dom.ForStatement;

public class ForStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		ForStatement s = (ForStatement) e;
		return "for (" + f.print(s.getIterator()) + " in " + 
			f.print(s.getIterated()) + ") {" + f.newline() + 
			f.indent() + f.print(s.getBody()) + f.outdent() + f.newline() 
			+ f.whitespace() + "}";
	}

}
