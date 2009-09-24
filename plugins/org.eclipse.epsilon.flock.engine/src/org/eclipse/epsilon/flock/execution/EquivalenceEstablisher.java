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
			equivalences.add(createEquivalenceFor(original));
		}
				
		return equivalences;
	}
	
	Equivalence createEquivalenceFor(ModelElement original) throws FlockRuntimeException {
		return strategy.ruleFor(original, context).createEquivalence(original, context);
	}
}