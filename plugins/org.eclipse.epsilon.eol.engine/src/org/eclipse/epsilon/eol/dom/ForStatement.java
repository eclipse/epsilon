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
package org.eclipse.epsilon.eol.dom;

import java.util.ArrayList;

public class ForStatement extends Statement {
	
	protected VariableDeclarationExpression iterator;
	protected Expression iterated;
	protected ArrayList<Statement> body = new ArrayList<Statement>();
	
	public VariableDeclarationExpression getIterator() {
		return iterator;
	}
	
	public void setIterator(VariableDeclarationExpression iterator) {
		this.iterator = iterator;
	}
	
	public Expression getIterated() {
		return iterated;
	}
	
	public void setIterated(Expression iterated) {
		this.iterated = iterated;
	}
	
	public ArrayList<Statement> getBody() {
		return body;
	}
	
}
