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
package org.eclipse.epsilon.migration.model.loader;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.migration.model.ExecutableMigrationRule;
import org.eclipse.epsilon.migration.parse.MigrationParser;

public class MigrationRuleLoader {

	private AST ast;
	
	public MigrationRuleLoader(AST ast) {
		this.ast = ast;
	}
	
	public ExecutableMigrationRule run() {
		return new ExecutableMigrationRule(getOriginalType(), getMigratedType(), getGuard(), getBody());
	}

	private String getOriginalType() {
		return getFirstChild().getText();
	}

	private String getMigratedType() {
		return hasToPart() ? getSecondChild().getText() : getOriginalType();
	}
	
	private AST getGuard() {
		return hasGuard() ? getPenultimateChild() : null;
	}

	private AST getBody() {
		return getLastChild();
	}
	
	private boolean hasToPart() {
		return getSecondChild().getType() == MigrationParser.NAME;
	}
		
	private boolean hasGuard() {
		return getPenultimateChild().getType() != MigrationParser.NAME;
	}
	
	
	private AST getFirstChild() {
		return ast.getChild(0);
	}
	
	private AST getSecondChild() {
		return ast.getChild(1);
	}
	
	private AST getPenultimateChild() {
		return ast.getChild(ast.getChildCount() - 2);
	}
	
	private AST getLastChild() {
		return ast.getChild(ast.getChildCount() - 1);
	}
}
