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
package org.eclipse.epsilon.flock.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.DefaultEquivalenceCreator;
import org.eclipse.epsilon.flock.execution.Equivalence;
import org.eclipse.epsilon.flock.execution.EquivalenceCreator;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class MigrationStrategy {
	
	private final List<Rule> rules = new LinkedList<Rule>();
	
	private EquivalenceCreator defaultEquivalenceCreator = DefaultEquivalenceCreator.getInstance();
	
	
	public MigrationStrategy(Rule... rules) {
		addRules(rules);
	}
	
	
	public void addRule(Rule rule) {
		rules.add(rule);
	}
	
	public void addRules(Rule... rules) {
		this.rules.addAll(Arrays.asList(rules));
	}
	
	public Collection<Rule> getRules() {
		return Collections.unmodifiableCollection(rules);
	}
	
	
	public Equivalence createEquivalenceFor(ModelElement original, IFlockContext context) throws FlockRuntimeException {
		for (Rule rule : rules) {
			if (rule.appliesFor(original, context))
				return rule.createEquivalence(original, context);
		}
		
		return defaultEquivalenceCreator.createEquivalence(original, context);
	}
	
	// Used by tests
	void setDefaultEquivalenceCreator(EquivalenceCreator defaultEquivalenceCreator) {
		this.defaultEquivalenceCreator = defaultEquivalenceCreator;
	}
}
