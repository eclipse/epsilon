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
import org.eclipse.epsilon.eol.dom.Program;

public class ProgramPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		Program p = (Program) e;
		return f.print(p.getImports()) + f.newline() + 
			f.print(p.getStatements()) + f.newline();
	}

}
