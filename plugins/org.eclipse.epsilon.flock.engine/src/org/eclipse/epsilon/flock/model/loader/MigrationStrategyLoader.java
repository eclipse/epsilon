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

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;
import org.eclipse.epsilon.flock.model.domain.rules.MigrateRule;
import org.eclipse.epsilon.flock.model.domain.typemappings.Deletion;
import org.eclipse.epsilon.flock.model.domain.typemappings.PackageDeletion;
import org.eclipse.epsilon.flock.model.domain.typemappings.PackageRetyping;
import org.eclipse.epsilon.flock.model.domain.typemappings.Retyping;
import org.eclipse.epsilon.flock.parse.FlockParser;

/**
 * Walks the AST, constructing an equivalent domain model
 * containing MigrationRule objects.
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
					strategy.addRule((MigrateRule)childAst);
					break;
				
				case FlockParser.RETYPE:
					strategy.addTypeMappingConstruct((Retyping)childAst);
					break;
					
				case FlockParser.RETYPEPACKAGE:
					strategy.addTypeMappingConstruct((PackageRetyping)childAst);
					break;
					
				case FlockParser.DELETE:
					strategy.addTypeMappingConstruct((Deletion)childAst);
					break;
				
				case FlockParser.DELETEPACKAGE:
					strategy.addTypeMappingConstruct((PackageDeletion)childAst);
					break;
			}
		}
		
		return strategy;
	}
}
