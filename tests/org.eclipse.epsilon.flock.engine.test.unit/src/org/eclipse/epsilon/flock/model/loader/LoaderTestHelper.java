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
	
	static AST createMigrationStrategyAst(AST... content) {
		final AST strategy = createAST(FlockParser.FLOCKMODULE, "FLOCKMODULE");
		strategy.addChildren(Arrays.asList(content));
		return strategy;
	}
	
	static AST createMigrateRuleAst(String originalType, AST guard, AST block) {
		final AST rule = createAST(FlockParser.MIGRATE, "MIGRATE");
		rule.addChild(createAST(FlockParser.NAME, originalType));
		
		if (guard != null)
			rule.addChild(guard);
		
		rule.addChild(block);
		
		return rule;
	}
	
	static AST createDeletionAst(String originalType) {
		return createDeletionAst(originalType, null);
	}
	
	static AST createDeletionAst(String originalType, AST guard) {
		return createTypeMappingAst(FlockParser.DELETE, "DELETE", guard, originalType);
	}
	
	static AST createRetypingAst(String originalType, String migratedType) {
		return createRetypingAst(originalType, migratedType, null);
	}
	
	static AST createRetypingAst(String originalType, String migratedType, AST guard) {
		return createTypeMappingAst(FlockParser.RETYPE, "RETYPE", guard, new String[]{originalType, migratedType});
	}
	
	private static AST createTypeMappingAst(int token, String mappingType, AST guard, String... metamodelTypes) {
		final AST rule = createAST(token, mappingType);
		
		for (String metamodelType : metamodelTypes) {
			rule.addChild(createAST(FlockParser.NAME, metamodelType));
		}
		
		if (guard != null)
			rule.addChild(guard);
		
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
		final AST guard = createAST(FlockParser.GUARD, "GUARD");
		guard.addChild(createAST(FlockParser.BOOLEAN, "true"));
		return guard;
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
