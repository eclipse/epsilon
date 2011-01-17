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

import org.eclipse.epsilon.eol.execute.context.IEolContext;
import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.context.RuleApplicationContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.execution.exceptions.FlockUnsupportedModelException;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;

public interface IFlockContext extends IEolContext {
	
	public void setOriginalModel(int indexInRepository) throws FlockUnsupportedModelException;
	public void setMigratedModel(int indexInRepository) throws FlockUnsupportedModelException;
				
	public FlockResult execute(MigrationStrategy strategy) throws FlockRuntimeException;
	
	public MigrationStrategyCheckingContext getMigrationStrategyCheckingContext();
	public EquivalenceEstablishmentContext getEquivalenceEstablishmentContext();
	public ConservativeCopyContext getConservativeCopyContext();
	public RuleApplicationContext getRuleApplicationContext();
}