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

import org.eclipse.epsilon.eol.dom.BinaryOperatorExpression;
import org.eclipse.epsilon.eol.dom.DomElement;

public abstract class BinaryOperatorPrinter implements DomElementPrinter {

	public String print(DomElement e, DomElementPrinterFactory f) {
		BinaryOperatorExpression exp = (BinaryOperatorExpression) e;
		return "(" + f.print(exp.getLhs()) + " " + getOperatorSymbol() + " " + f.print(exp.getRhs()) + ")";
	}
	
	protected abstract String getOperatorSymbol();
	
}
