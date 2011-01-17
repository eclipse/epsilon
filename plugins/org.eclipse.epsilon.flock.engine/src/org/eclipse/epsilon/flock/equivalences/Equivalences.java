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
package org.eclipse.epsilon.flock.equivalences;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.context.RuleApplicationContext;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.TypeMappingContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;

public class Equivalences {

	private final List<Equivalence> equivalences = new LinkedList<Equivalence>();
	
	/**
	 * Factory method for establishing original to migrated model Equivalences from a MigrationStrategy and an IFlockContext.
	 */
	public static Equivalences establishFrom(MigrationStrategy strategy, EquivalenceEstablishmentContext context) throws FlockRuntimeException {
		final Equivalences equivalences = new Equivalences();
		
		for (TypeMappingContext c : context.getTypeMappingContexts()) {
			equivalences.add(strategy.createEquivalence(c));
		}
				
		return equivalences;
	}
	
	
	protected void add(Equivalence equivalence) {
		equivalences.add(equivalence);
	}
	
	public ModelElement getEquivalent(ModelElement original) {
		for (Equivalence candidate : equivalences) {
			if (candidate.getOriginal().equals(original))
				return candidate.getEquivalent();
		}
		
		return null;
	}

	public void conservativeCopy(ConservativeCopyContext context) throws FlockRuntimeException {		
		for (Equivalence equivalence : equivalences) {
			equivalence.automaticallyPopulateEquivalent(context);
		}
	}
	
	public void applyRules(MigrationStrategy strategy, RuleApplicationContext context) throws FlockRuntimeException {
		for (Equivalence equivalence : equivalences) {
			strategy.applyRulesTo(context.getMigrateRuleContextFor(equivalence));
		}
	}
	
	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		
		for (Equivalence equivalence : equivalences) {
			builder.append(equivalence);
			builder.append('\n');
		}
		
		return builder.toString();
	}
}
