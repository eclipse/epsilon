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

import java.util.Arrays;

import org.antlr.runtime.CommonToken;
import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.flock.parse.FlockParser;

public abstract class LoaderTestHelper {
	
	private LoaderTestHelper() {}
	
	static AST createMigrationStrategyAst(AST... rules) {
		final AST strategy = createAST(FlockParser.FLOCKMODULE, "FLOCKMODULE");
		strategy.addChildren(Arrays.asList(rules));
		return strategy;
	}
	
	static AST createMigrationRuleAst(String originalType, String migratedType, AST guard, AST block) {
		final AST rule = createAST(FlockParser.MIGRATE, "MIGRATE");
		rule.addChild(createAST(FlockParser.NAME, originalType));
		
		if (migratedType != null)
			rule.addChild(createAST(FlockParser.NAME, migratedType));
		
		if (guard != null)
			rule.addChild(guard);
		
		rule.addChild(block);
		
		return rule;
	}
	
	static AST createOperationAst(String context, String name, AST block) {
		final AST rule = createAST(FlockParser.HELPERMETHOD, "HELPERMETHOD");
		rule.addChild(createAST(FlockParser.NAME, context));
		rule.addChild(createAST(FlockParser.NAME, name));
		rule.addChild(block);
		
		return rule;
	}
	
	static AST createAnnotatedOperationAst(String annotation, String context, String name, String body) {
		final AST rule = createAST(FlockParser.ANNOTATIONBLOCK, "ANNOTATIONBLOCK");
		rule.addChild(createAST(FlockParser.Annotation, annotation + context + name + body));
		
		return rule;
	}
	
	static AST createGuard() {
		return createAST(FlockParser.BOOLEAN, "true");
	}
	
	static AST createBody() {
		return createBlock();
	}

	static AST createBlock() {
		return createAST(FlockParser.BLOCK, "BLOCK");
	}
	
	static AST createAST(int token, String text) {
		return new AST(new CommonToken(token, text), null);
	}
}
