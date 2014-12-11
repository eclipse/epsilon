/*******************************************************************************
 * Copyright (c) 2011 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;

public class FlockExecution {
	
	private final MigrationStrategyRunner runner;
	private final FlockResult result = new FlockResult();

	public FlockExecution(IFlockContext context, MigrationStrategy strategy) {
		this(new MigrationStrategyRunner(context, strategy));
	}
	
	public FlockExecution(MigrationStrategyRunner runner) {
		this.runner = runner;
	}
	
	public FlockResult run(Model originalModel) throws FlockRuntimeException {
		ensureExpandIsOff(originalModel);
	
		try {
			runner.run();
		} catch (EolRuntimeException e) {
			throw new FlockRuntimeException(e);
		}
		
		return result;
	}
	
	private void ensureExpandIsOff(Model originalModel) {
		/*
		 * When expand is on, Flock will copy model elements referenced by
		 * the original model into the migrated model (i.e. performs a
		 * merging). This is typically not desirable, so we force expand
		 * to false.
		 */
		if (originalModel.preventLoadingOfExternalModelElements()) {
			addWarning("Flock can produce unexpected results when the original model includes references to other models. Flock is ignoring these external references in your original model and proceeding.");
		}
	}	
	
	public void addWarning(String warning) {
		result.addWarning(warning);
	}

	public ModelElement getEquivalent(ModelElement originalModelElement) {
		return runner.getEquivalent(originalModelElement);
	}
}