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

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.epsilon.migration.MigrationContext;
import org.eclipse.epsilon.migration.copy.Copier;

public class MigrationStrategy {

	private final List<MigrationRule> rules = new LinkedList<MigrationRule>();
	
	private final Copier copier;
	
	public MigrationStrategy() {
		this(new Copier());
	}
	
	// used by unit tests
	MigrationStrategy(Copier copier) {
		this.copier = copier;
	}
	
	public void addRule(MigrationRule rule) {
		rules.add(rule);
	}
	
	public MigrationRule getRule(int index) {
		return rules.get(index);
	}
	
	public int numberOfRules() {
		return rules.size();
	}
	
	public void migrate(EObject object, MigrationContext context) {		
		final MigrationRule applicableRule = getFirstApplicableRuleFor(object, context);
		
		if (applicableRule == null) {
			copier.copy(object, context.getTargetModel());
			
		} else {
			final EObject copied = copier.copy(object, applicableRule.getTargetType(), context.getTargetModel());
			applicableRule.migrate(object, copied, context);
		}
	}
	
	private MigrationRule getFirstApplicableRuleFor(EObject object, MigrationContext context) {
		for (MigrationRule rule : rules) {
			if (rule.appliesFor(object, context))
				return rule;
		}
		
		return null;
	}
}
