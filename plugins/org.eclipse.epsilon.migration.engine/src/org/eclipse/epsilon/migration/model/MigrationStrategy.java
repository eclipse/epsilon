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
package org.eclipse.epsilon.migration.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.migration.IMigrationContext;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;

public class MigrationStrategy {

	private final List<MigrationRule> rules = new LinkedList<MigrationRule>();
	
	public MigrationStrategy() {}
	
	public MigrationStrategy(MigrationRule... rules) {
		addRules(rules);
	}
	
	public void addRule(MigrationRule rule) {
		rules.add(rule);
	}
	
	public void addRules(MigrationRule... rules) {
		this.rules.addAll(Arrays.asList(rules));
	}
	
	public MigrationRule ruleFor(ModelElement original, IMigrationContext context) throws MigrationExecutionException {
		for (MigrationRule rule : rules) {
			if (rule.appliesFor(original, context))
				return rule;
		}
		
		return null;
	}
	
	
	// Used by MigrationStrategyLoader tests
	
	public int numberOfRules() {
		return rules.size();
	}
}
