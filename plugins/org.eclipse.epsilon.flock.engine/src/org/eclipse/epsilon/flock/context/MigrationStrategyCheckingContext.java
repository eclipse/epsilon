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
package org.eclipse.epsilon.flock.context;

import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.emc.wrappers.Model;

public class MigrationStrategyCheckingContext {
	
	private final Model originalModel;
	private final FlockExecution execution;
	
	public MigrationStrategyCheckingContext(Model originalModel, FlockExecution execution) {
		this.originalModel = originalModel;
		this.execution = execution;
	}
	
	public boolean isTypeInOriginalMetamodel(String type) {
		return originalModel.hasType(type);
	}
	
	public void addWarning(String warning) {
		execution.addWarning(warning);
	}
}