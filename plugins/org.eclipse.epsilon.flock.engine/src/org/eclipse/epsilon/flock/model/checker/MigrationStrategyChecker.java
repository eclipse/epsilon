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
package org.eclipse.epsilon.flock.model.checker;

import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;
import org.eclipse.epsilon.flock.model.domain.common.TypedAndGuardedConstruct;

public class MigrationStrategyChecker {

	private final MigrationStrategy strategy;
	private final MigrationStrategyCheckingContext context;
	
	public MigrationStrategyChecker(MigrationStrategy strategy, MigrationStrategyCheckingContext context) {
		this.strategy = strategy;
		this.context  = context;
	}

	public void check() {
		checkOriginalTypeOfEachTypedConstructIsMemberOfOriginalMetamodel();
	}
	
	private void checkOriginalTypeOfEachTypedConstructIsMemberOfOriginalMetamodel() {
		for (TypedAndGuardedConstruct construct : strategy.getTypeMappingsAndRules()) {
			checkTypeIsMemberOfOriginalMetamodel(construct.getOriginalType());
		}
	}

	private void checkTypeIsMemberOfOriginalMetamodel(String originalType) {
		if (!context.isTypeInOriginalMetamodel(originalType)) {
			addWarning("Rule defined for migrating instances of " + originalType + ", " +
			           "but no type " + originalType + " was found in the original metamodel.");
		}
	}

	private void addWarning(String message) {
		context.addWarning(message);
	}
}
