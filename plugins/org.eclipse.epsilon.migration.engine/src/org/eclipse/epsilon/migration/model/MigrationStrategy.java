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

import org.eclipse.epsilon.migration.MigrationContext;

public class MigrationStrategy {

	private final List<ExecutableMigrationRule> rules = new LinkedList<ExecutableMigrationRule>();
	
	public MigrationStrategy() {}
	
	public MigrationStrategy(ExecutableMigrationRule... rules) {
		addRules(rules);
	}
	
	public void addRule(ExecutableMigrationRule rule) {
		rules.add(rule);
	}
	
	public void addRules(ExecutableMigrationRule... rules) {
		this.rules.addAll(Arrays.asList(rules));
	}
	
	public ExecutableMigrationRule getRule(int index) {
		return rules.get(index);
	}
	
	public int numberOfRules() {
		return rules.size();
	}
	
	public void migrate(Object original, Object target, MigrationContext context) {
		ruleFor(original, context).migrate(original, target, context);
	}
	
	public MigrationRule ruleFor(Object object, MigrationContext context) {
		for (ExecutableMigrationRule rule : rules) {
			if (rule.appliesFor(object, context))
				return rule;
		}
		
		return new NoOpMigrationRule(context.typeNameOfOriginalModelElement(object));
	}
}
