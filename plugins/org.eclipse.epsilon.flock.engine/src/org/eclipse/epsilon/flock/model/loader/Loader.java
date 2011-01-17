/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.loader;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.flock.parse.FlockParser;

public abstract class Loader {

	protected AST ast;
	
	public Loader(AST ast) {
		this.ast = ast;
	}

	protected AST getGuard() {
		return hasChildOfType(FlockParser.GUARD) ? getFirstChildOfType(FlockParser.GUARD).getFirstChild() : null;
	}

	protected AST getFirstChild() {
		return ast.getChild(0);
	}
	
	protected AST getSecondChild() {
		return ast.getChild(1);
	}

	protected boolean hasChildOfType(int type) {
		return !AstUtil.getChildren(ast, type).isEmpty();
	}

	protected AST getFirstChildOfType(int type) {
		return hasChildOfType(type) ? AstUtil.getChildren(ast, type).get(0) : null;
	}
}