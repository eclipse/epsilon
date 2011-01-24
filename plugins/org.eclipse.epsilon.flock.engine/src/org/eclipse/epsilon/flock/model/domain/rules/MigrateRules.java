/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.domain.rules;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.execution.MigrateRuleContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class MigrateRules {
	private final List<MigrateRule> migrateRules;
	
	public MigrateRules(MigrateRule... rules) {
		this.migrateRules = new LinkedList<MigrateRule>(Arrays.asList(rules));
	}

	public void add(MigrateRule rule) {
		migrateRules.add(rule);
	}

	public void check(MigrationStrategyCheckingContext context) {
		for (MigrateRule rule : migrateRules) {
			rule.check(context);
		}
	}
	
	public IgnoredProperties ignoredPropertiesFor(MigrateRuleContext context) throws FlockRuntimeException {
		final IgnoredProperties ignored = new IgnoredProperties();
		
		for (MigrateRule rule : migrateRules) {
			rule.gatherIgnoredPropertiesFor(context, ignored);
		}
		
		return ignored;
	}
	
	public void applyTo(MigrateRuleContext context) throws FlockRuntimeException {
		for (MigrateRule rule : migrateRules) {
			rule.applyTo(context);
		}
	}
}