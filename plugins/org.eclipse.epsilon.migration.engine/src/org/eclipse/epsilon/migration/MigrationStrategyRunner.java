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
package org.eclipse.epsilon.migration;

import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.EquivalenceEstablisher;
import org.eclipse.epsilon.migration.execution.Equivalences;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.eclipse.epsilon.migration.model.MigrationStrategy;

public class MigrationStrategyRunner {

	private final IMigrationContext context;
	private final MigrationStrategy strategy;
	
	public MigrationStrategyRunner(IMigrationContext context, MigrationStrategy strategy) {
		this.context  = context;
		this.strategy = strategy;
	}
	
	private Equivalences equivalences;
	
	public void run() throws MigrationExecutionException {
		establishEquivalences();
		populateEachEquivalent();
	}

	private void establishEquivalences() throws MigrationExecutionException {
		equivalences = new EquivalenceEstablisher(strategy, context).establishEquivalences();
	}

	private void populateEachEquivalent() throws MigrationExecutionException {
		equivalences.populateEachEquivalent();
	}
	
	public ModelElement getEquivalent(ModelElement originalModelElement) {
		return equivalences.getEquivalent(originalModelElement);
	}
}
