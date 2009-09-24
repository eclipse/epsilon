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
import org.eclipse.epsilon.flock.model.MigrationStrategy;
import org.eclipse.epsilon.flock.parse.FlockParser;

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
		
		for (AST childAst : ast.getChildren()) {
			switch (childAst.getType()) {
				case FlockParser.MIGRATE:
					strategy.addRule(new MigrateRuleLoader(childAst).run());
					break;
				
				case FlockParser.DELETE:
					strategy.addRule(new DeleteRuleLoader(childAst).run());
					break;
			}
		}
		
		return strategy;
	}
}
