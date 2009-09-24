/*******************************************************************************
 * Copyright (c) 2009 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************
 *
 * $Id$
 */
package org.eclipse.epsilon.flock.model.loader;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.flock.model.DeleteRule;
import org.eclipse.epsilon.flock.parse.FlockParser;

public class DeleteRuleLoader {

	private AST ast;
	
	public DeleteRuleLoader(AST ast) {
		this.ast = ast;
	}
	
	public DeleteRule run() {
		return new DeleteRule(getOriginalType(), getGuard());
	}

	private String getOriginalType() {
		return getFirstChild().getText();
	}
	
	private AST getGuard() {
		return hasChildOfType(FlockParser.GUARD) ? getFirstChildOfType(FlockParser.GUARD).getFirstChild() : null;
	}
	
	
	private AST getFirstChild() {
		return ast.getChild(0);
	}
	
	private boolean hasChildOfType(int type) {
		return !AstUtil.getChildren(ast, type).isEmpty();
	}
	
	private AST getFirstChildOfType(int type) {
		return hasChildOfType(type) ? AstUtil.getChildren(ast, type).get(0) : null;
	}
}
