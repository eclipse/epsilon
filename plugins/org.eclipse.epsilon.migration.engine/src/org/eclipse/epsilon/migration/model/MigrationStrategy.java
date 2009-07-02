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
import org.eclipse.epsilon.eol.exceptions.models.EolModelElementTypeNotFoundException;
import org.eclipse.epsilon.eol.exceptions.models.EolNotInstantiableModelElementTypeException;
import org.eclipse.epsilon.migration.MigrationContext;
import org.eclipse.epsilon.migration.copy.Copier;
import org.eclipse.epsilon.migration.copy.CopierFactory;

public class MigrationStrategy {

	private final List<MigrationRule> rules = new LinkedList<MigrationRule>();
	
	private final CopierFactory copiers;
	
	public MigrationStrategy() {
		this(new CopierFactory());
	}
	
	// used by unit tests
	MigrationStrategy(CopierFactory copiers) {
		this.copiers = copiers;
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
		final Copier copier = copiers.createCopier(object, context.getTargetModel());
		final MigrationRule applicableRule = getFirstApplicableRuleFor(object, context);
	
		try {
			if (applicableRule == null) {
				copier.copy();
				
			} else {
				final EObject copied = copier.copy(applicableRule.getTargetType());
				applicableRule.migrate(object, copied, context);
			}
			
		} catch (EolModelElementTypeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EolNotInstantiableModelElementTypeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
