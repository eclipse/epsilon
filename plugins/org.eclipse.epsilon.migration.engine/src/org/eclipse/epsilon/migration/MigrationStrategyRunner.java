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

public class MigrationStrategyRunner {

	private final IMigrationContext context;
	
	public MigrationStrategyRunner(IMigrationContext context) {
		this.context = context;
	}
	
	private Equivalences equivalences;
	
	public void run(EquivalenceEstablisher establisher) throws MigrationExecutionException {
		establishEquivalences(establisher);
		populateEachEquivalent();
	}

	private void establishEquivalences(EquivalenceEstablisher establisher) throws MigrationExecutionException {
		equivalences = establisher.establishEquivalences(context);
	}

	private void populateEachEquivalent() throws MigrationExecutionException {
		equivalences.populateEachEquivalent(context);
	}
	
	public ModelElement getEquivalent(ModelElement originalModelElement) {
		return equivalences.getEquivalent(originalModelElement);
	}
}
