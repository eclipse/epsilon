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

import java.util.List;

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.commons.util.AstUtil;
import org.eclipse.epsilon.migration.model.MigrationStrategy;
import org.eclipse.epsilon.migration.parse.MigrationParser;

/**
 * Walks the AST, constructing an equivalent domain model
 * containing MigrationRule objects.
 * 
 * @author lrose
 */
public class MigrationStrategyLoader {

	private AST ast;
	
	public MigrationStrategyLoader(AST ast) {
		this.ast = ast;
	}
	
	public MigrationStrategy run() {
		final MigrationStrategy strategy = new MigrationStrategy();
		
		for (AST ruleAst : ruleAsts()) {
			strategy.addRule(new MigrationRuleLoader(ruleAst).run());
		}
		
		return strategy;
	}

	private List<AST> ruleAsts() {
		return AstUtil.getChildren(ast, MigrationParser.MIGRATE);
	}
}
