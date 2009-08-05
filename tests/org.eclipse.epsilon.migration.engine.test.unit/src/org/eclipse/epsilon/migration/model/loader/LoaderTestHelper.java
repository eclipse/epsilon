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

import java.util.Arrays;

import org.antlr.runtime.CommonToken;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.migration.parse.MigrationParser;

public abstract class LoaderTestHelper {
	
	private LoaderTestHelper() {}
	
	static AST createMigrationStrategyAst(AST... rules) {
		final AST strategy = createAST(MigrationParser.MIGRATIONMODULE, "MIGRATIONMODULE");
		strategy.addChildren(Arrays.asList(rules));
		return strategy;
	}
	
	static AST createMigrationRuleAst(String originalType, String migratedType, AST guard, AST block) {
		final AST rule = createAST(MigrationParser.MIGRATE, "MIGRATE");
		rule.addChild(createAST(MigrationParser.NAME, originalType));
		
		if (migratedType != null)
			rule.addChild(createAST(MigrationParser.NAME, migratedType));
		
		if (guard != null)
			rule.addChild(guard);
		
		rule.addChild(block);
		
		return rule;
	}
	
	static AST createGuard() {
		return createAST(MigrationParser.BOOLEAN, "true");
	}
	
	static AST createBody() {
		return createAST(MigrationParser.BLOCK, "BLOCK");
	}
	
	static AST createAST(int token, String text) {
		return new AST(new CommonToken(token, text), null);
	}
}
