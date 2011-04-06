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


import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.models.IReflectiveModel;
import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext;
import org.eclipse.epsilon.flock.context.ConservativeCopyContext;
import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.context.RuleApplicationContext;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.execution.exceptions.FlockUnsupportedModelException;
import org.eclipse.epsilon.flock.execution.operations.FlockOperationFactory;
import org.eclipse.epsilon.flock.model.domain.MigrationStrategy;

public class FlockContext extends EolContext implements IFlockContext {

	private Model originalModel;
	private Model migratedModel;
	
	public FlockContext() {
		setOperationFactory(new FlockOperationFactory());
	}
	
	public FlockContext(IModel original, IModel migrated) throws FlockUnsupportedModelException {
		initialiseModels(original, migrated);
		setOperationFactory(new FlockOperationFactory());
	}

	private void initialiseModels(IModel original, IModel migrated) throws FlockUnsupportedModelException {
		addModel(original);
		addModel(migrated);
		
		this.originalModel = wrapModel(original);
		this.migratedModel = wrapModel(migrated);
	}
	
	private void addModel(IModel model) {
		if (model != null)
			getModelRepository().addModel(model);
	}
	
	private Model wrapModel(IModel model) throws FlockUnsupportedModelException {
		if (model == null)
			return null;
		
		else if (model instanceof IReflectiveModel)
			return new Model((IReflectiveModel)model, getPrettyPrinterManager());
		
		else
			throw new FlockUnsupportedModelException("Flock can only be used with models that implement IReflectiveModel. " + model.getName() + " does not.");
	}
	
	public void setOriginalModel(int indexInRepository) throws FlockUnsupportedModelException {
		this.originalModel = getModelFromRepositoryByIndex(indexInRepository);
	}
	
	public void setMigratedModel(int indexInRepository) throws FlockUnsupportedModelException {
		this.migratedModel = getModelFromRepositoryByIndex(indexInRepository);
	}
	
	private Model getModelFromRepositoryByIndex(int index) throws FlockUnsupportedModelException {
		return wrapModel(getModelRepository().getModels().get(index));
	}
	
	
	private FlockExecution execution;
	
	public FlockResult execute(MigrationStrategy strategy) throws FlockRuntimeException {
		execution = new FlockExecution(this, strategy);
		return execution.run(originalModel);
	}
	
	
	private final EolExecutor executor = new EolExecutor(this);
	
	public EquivalenceEstablishmentContext getEquivalenceEstablishmentContext() {
		return new EquivalenceEstablishmentContext(originalModel, migratedModel, executor);
	}

	public MigrationStrategyCheckingContext getMigrationStrategyCheckingContext() {
		return new MigrationStrategyCheckingContext(originalModel, execution);
	}
	
	public ConservativeCopyContext getConservativeCopyContext() {
		return new ConservativeCopyContext(originalModel, migratedModel, execution, executor);
	}
	
	public RuleApplicationContext getRuleApplicationContext() {
		return new RuleApplicationContext(executor);
	}
}
