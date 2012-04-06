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

import org.eclipse.epsilon.eol.dom.CaseExpressionStatement;
import org.eclipse.epsilon.eol.dom.CaseStatement;
import org.eclipse.epsilon.eol.dom.DomElement;

public class CaseStatementPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		CaseStatement statement = (CaseStatement) e;
		String r = "";
		
		if (statement instanceof CaseExpressionStatement) {
			r = "case " + f.print(((CaseExpressionStatement) statement).getExpression());
		}
		else {
			r = "default";
		}
		
		r+= ":" + f.newline() + f.indent() + f.print(statement.getBody())
		+ f.outdent();
		
		return r;
	}

}
