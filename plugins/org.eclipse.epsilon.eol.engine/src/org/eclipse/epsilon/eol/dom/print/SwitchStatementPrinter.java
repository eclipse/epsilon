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
import org.eclipse.epsilon.eol.dom.SwitchStatement;

public class SwitchStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		SwitchStatement statement = (SwitchStatement) e;
		String r = "switch (" + f.print(statement.getExpression()) + ") {" + f.newline()
		+ f.indent() + f.print(statement.getCases()) + f.newline() + 
		f.outdent() + f.whitespace() + "}";
		return r;
	}
	
}
