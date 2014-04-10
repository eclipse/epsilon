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
package org.eclipse.epsilon.erl.rules;

import java.util.Collections;
import java.util.List;

import org.eclipse.epsilon.common.parse.AST;

public class NamedRule implements INamedRule {
	
	protected String name;
	protected AST ast;
	
	public AST getAst() {
		return ast;
	}
	public void setAst(AST ast) {
		this.ast = ast;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public List<?> getChildren() {
		return Collections.emptyList();
	}
}
