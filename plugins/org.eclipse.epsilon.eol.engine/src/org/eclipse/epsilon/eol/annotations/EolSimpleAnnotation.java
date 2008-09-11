/*******************************************************************************
 * Copyright (c) 2008 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Dimitrios Kolovos - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.eol.annotations;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.execute.context.IEolContext;



public class EolSimpleAnnotation implements IEolAnnotation {
	
	protected String name;
	protected String value;
	protected AST ast;
	
	public EolSimpleAnnotation(AST ast, String name, String value) {
		this.ast = ast;
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public String getValue(IEolContext context) {
		return value;
	}
	
	public String toString() {
		return "@" + name + "=[" + value + "]";
	}

	public AST getAst() {
		return ast;
	}

	public boolean hasValue() {
		return value.length() > 0;
	}
	
}
