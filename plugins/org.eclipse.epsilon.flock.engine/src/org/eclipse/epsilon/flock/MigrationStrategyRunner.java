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
package org.eclipse.epsilon.flock;

import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.equivalences.Equivalences;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.checker.MigrationStrategyChecker;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;

public class MigrationStrategyRunner {

	private final IFlockContext context;
	private final MigrationStrategy strategy;
	
	public MigrationStrategyRunner(IFlockContext context, MigrationStrategy strategy) {
		this.context  = context;
		this.strategy = strategy;
	}
	
	private Equivalences equivalences;
	
	public void run() throws FlockRuntimeException {
		checkStrategyAgainstModels();
		establishEquivalences();
		conservativeCopy();
		applyRules();
	}
	
	private void checkStrategyAgainstModels() {
		new MigrationStrategyChecker(strategy, context.getMigrationStrategyCheckingContext()).check();
	}

	private void establishEquivalences() throws FlockRuntimeException {
		equivalences = Equivalences.establishFrom(strategy, context.getEquivalenceEstablishmentContext());
	}

	private void conservativeCopy() throws FlockRuntimeException {
		equivalences.conservativeCopy(context.getConservativeCopyContext());
	}
	
	private void applyRules() throws FlockRuntimeException {
		equivalences.applyRules(strategy, context.getRuleApplicationContext());
	}
	
	public ModelElement getEquivalent(ModelElement originalModelElement) {
		return equivalences.getEquivalent(originalModelElement);
	}
}
