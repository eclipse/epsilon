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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.emc.wrappers.ModelValue;
import org.eclipse.epsilon.flock.execution.exceptions.ConservativeCopyException;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.execution.operations.FlockOperationFactory;
import org.eclipse.epsilon.flock.model.MigrationStrategy;

public class FlockContext extends EolContext implements IFlockContext {

	private Model originalModel;
	private Model migratedModel;
		
	public FlockContext() {
		this((IModel)null, (IModel)null);
	}
	
	public FlockContext(IModel original, IModel migrated) {
		initialiseModels(original, migrated);
		setOperationFactory(new FlockOperationFactory());
	}
	
	// Used by tests
	FlockContext(Model original, Model migrated) {
		this.originalModel = original;
		this.migratedModel = migrated;
	}

	private void initialiseModels(IModel original, IModel migrated) {
		addModel(original);
		addModel(migrated);
		
		this.originalModel = wrapModel(original);
		this.migratedModel = wrapModel(migrated);
	}
	
	private void addModel(IModel model) {
		if (model != null)
			getModelRepository().addModel(model);
	}
	
	private Model wrapModel(IModel model) {
		return new Model(model, getPrettyPrinterManager());
	}
	
	public void setOriginalModel(int indexInRepository) {
		this.originalModel = getModelFromRepositoryByIndex(indexInRepository);
	}
	
	public void setMigratedModel(int indexInRepository) {
		this.migratedModel = getModelFromRepositoryByIndex(indexInRepository);
	}
	
	private Model getModelFromRepositoryByIndex(int index) {
		return wrapModel(getModelRepository().getModels().get(index));
	}
	
	
	
	public Object executeBlock(AST block, Variable... variables) throws FlockRuntimeException {
		try {
			enterProtectedFrame(block, variables);
			
			final Object result = getExecutorFactory().executeAST(block, this);
			
			leaveFrame(block);
			
			return result;
			
		} catch (EolRuntimeException e) {
			e.printStackTrace();
			throw new FlockRuntimeException("Exception encountered while executing EOL block.", e);
		}
	}

	public boolean executeGuard(AST guard, Variable originalVar) {
		enterProtectedFrame(guard, originalVar);
		
		final EolBoolean guardSatisfied = (EolBoolean)getExecutorFactory().executeBlockOrExpressionAst(guard, this, EolBoolean.FALSE);
		
		leaveFrame(guard);
		
		return guardSatisfied.booleanValue();
	}
	
	public Iterable<ModelElement> getOriginalModelElements() {
		return originalModel.allContents();
	}
	
	public ModelElement createModelElementInMigratedModel(String type) throws FlockRuntimeException {
		try {
			return migratedModel.createInstance(type);
		
		} catch (EolRuntimeException e) {
			throw new FlockRuntimeException("Could not create in the migrated model a model element of type: " + type, e);
		}
	}
	
	public ModelElement safelyCreateModelElementInMigratedModel(String type) throws FlockRuntimeException {
		if (migratedModel.isInstantiable(type))
			return createModelElementInMigratedModel(type);
		else
			return null;
	}

	public boolean isTypeInOriginalMetamodel(String type) {
		return originalModel.hasType(type);
	}
	
	public boolean isElementInOriginalModel(ModelElement element) {
		return originalModel.owns(element);
	}
	
	public boolean isElementInMigratedModel(ModelElement element) {
		return migratedModel.owns(element);
	}
	
	private ModelValue<?> treatAsValueInOriginalModel(Object unwrappedModelElement) {
		return originalModel.wrap(unwrappedModelElement);
	}

	private MigrationStrategyRunner runner;
	
	public FlockResult run(MigrationStrategy strategy) throws FlockRuntimeException {
		runner = new MigrationStrategyRunner(this, strategy);
		runner.run();
		
		return result;
	}

	public ModelElement getEquivalent(ModelElement originalModelElement) {
		return runner.getEquivalent(originalModelElement);
	}

	public Object getUnwrappedEquivalent(Object unwrappedModelElement) throws ConservativeCopyException {		
		return treatAsValueInOriginalModel(unwrappedModelElement).getEquivalentIn(migratedModel, this).unwrap();
	}

	
	private final FlockResult result = new FlockResult();
	
	public void addWarning(String warning) {
		result.addWarning(warning);
	}
}
