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
import org.eclipse.epsilon.migration.execution.Equivalence;
import org.eclipse.epsilon.migration.execution.Equivalences;
import org.eclipse.epsilon.migration.execution.MigrationExecutionException;

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
	
	public Equivalences establishEquivalences(IMigrationContext context) throws MigrationExecutionException {
		final Equivalences equivalences = new Equivalences();
		
		for (ModelElement original : context.getOriginalModelElements()) {
			equivalences.add(createEquivalenceFor(original, context));
		}
		
		return equivalences;
	}
	
	Equivalence createEquivalenceFor(ModelElement original, IMigrationContext context) throws MigrationExecutionException {
		final AbstractMigrationRule rule = ruleFor(original, context);
		final ModelElement migrated      = rule.createTargetModelElement(context);
		
		return new Equivalence(original, migrated, rule);
	}
	
	AbstractMigrationRule ruleFor(ModelElement original, IMigrationContext context) throws MigrationExecutionException {
		for (ExecutableMigrationRule rule : rules) {
			if (rule.appliesFor(original, context))
				return rule;
		}
		
		return new NoOpMigrationRule(original.getTypeName());
	}
}
