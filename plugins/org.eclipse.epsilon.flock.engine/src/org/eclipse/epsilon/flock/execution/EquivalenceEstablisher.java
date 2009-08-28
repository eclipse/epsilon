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
package org.eclipse.epsilon.flock.execution;

import org.eclipse.epsilon.flock.IFlockContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.MigrationRule;
import org.eclipse.epsilon.flock.model.MigrationStrategy;

public class EquivalenceEstablisher {

	private final MigrationStrategy strategy;
	private final IFlockContext context;
	
	public EquivalenceEstablisher(MigrationStrategy strategy, IFlockContext context) {
		this.strategy = strategy;
		this.context  = context;
	}
	
	public Equivalences establishEquivalences() throws FlockRuntimeException {
		final Equivalences equivalences = new Equivalences();
		
		for (ModelElement original : context.getOriginalModelElements()) {
			final Equivalence equivalence = createEquivalenceFor(original);
			
			if (equivalence != null)
				equivalences.add(equivalence);
		}
		
		return equivalences;
	}
	
	Equivalence createEquivalenceFor(ModelElement original) throws FlockRuntimeException {
		final MigrationRule rule = strategy.ruleFor(original, context);
		
		final ModelElement equivalent;
		
		// TODO : need some more examples to figure out how to refactor this
		// Need to know whether different types of equivalence are needed,
		// or different types of rule, or both
		
		if (rule == null) {
			equivalent = context.safelyCreateModelElementInMigratedModel(original.getTypeName());
		
		} else {
			equivalent = rule.createMigratedModelElement(context);
		}
		
		if (equivalent == null)
			return null;
		
		if (rule == null) {
			return new TypeBasedEquivalence(context, original, equivalent);
		
		} else {
			return new RuleBasedEquivalence(context, original, equivalent, rule);
		}
	}
}