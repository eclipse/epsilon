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

public class IfStatement extends Statement {
	
	protected Expression condition;
	protected ArrayList<Statement> ifBody = new ArrayList<Statement>();
	protected ArrayList<Statement> elseBody = new ArrayList<Statement>();
	
	public Expression getCondition() {
		return condition;
	}
	
	public void setCondition(Expression condition) {
		this.condition = condition;
	}
	
	public ArrayList<Statement> getIfBody() {
		return ifBody;
	}
	
	public ArrayList<Statement> getElseBody() {
		return elseBody;
	}
	
}


