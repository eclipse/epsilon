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
package org.eclipse.epsilon.migration.model.checker;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.model.MigrationRule;
import org.eclipse.epsilon.migration.model.MigrationStrategy;

public class MigrationStrategyChecker {

	private final MigrationStrategy strategy;
	private final IMigrationContext context;
	
	public MigrationStrategyChecker(MigrationStrategy strategy, IMigrationContext context) {
		this.strategy = strategy;
		this.context  = context;
	}

	public void check() {
		checkOriginalTypeOfEachRuleIsMemberOfOriginalMetamodel();
	}
	
	private void checkOriginalTypeOfEachRuleIsMemberOfOriginalMetamodel() {
		for (MigrationRule rule : strategy.getRules()) {
			if (!context.isTypeInOriginalMetamodel(rule.getOriginalType())) {
				addWarning("Rule defined for migrating instances of " + rule.getOriginalType() + ", " +
				           "but no type " + rule.getOriginalType() + " was found in the original metamodel.");
			}
		}
	}

	private void addWarning(String message) {
		context.addWarning(message);
	}
}
