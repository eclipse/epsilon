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

public class AssignmentStatement extends Statement {
	
	protected Expression lhs;
	protected Expression rhs;
	
	public Expression getLhs() {
		return lhs;
	}
	
	public Expression getRhs() {
		return rhs;
	}
	
	public void setLhs(Expression lhs) {
		this.lhs = lhs;
	}
	
	public void setRhs(Expression rhs) {
		this.rhs = rhs;
	}
	
}
