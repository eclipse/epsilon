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

import org.eclipse.epsilon.commons.parse.AST;
import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.eol.execute.context.EolContext;
import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.eol.models.IModel;
import org.eclipse.epsilon.eol.types.EolBoolean;
import org.eclipse.epsilon.migration.emc.wrappers.Model;
import org.eclipse.epsilon.migration.emc.wrappers.ModelElement;
import org.eclipse.epsilon.migration.execution.exceptions.MigrationExecutionException;
import org.eclipse.epsilon.migration.execution.operations.MigrationLanguageOperationFactory;
import org.eclipse.epsilon.migration.model.MigrationStrategy;

public class MigrationContext extends EolContext implements IMigrationContext {

	private final MigrationStrategyRunner runner;
	
	private Model originalModel;
	private Model migratedModel;
		
	public MigrationContext() {
		this(null, null, null);
	}
	
	public MigrationContext(IModel original, IModel migrated) {
		this(null, original, migrated);
	}
	
	private MigrationContext(MigrationStrategyRunner runner, IModel original, IModel migrated) {
		if (runner == null)
			this.runner = new MigrationStrategyRunner(this);
		else
			this.runner = runner;
		
		initialiseModels(original, migrated);
		setOperationFactory(new MigrationLanguageOperationFactory());
	}
	
	// Used by tests
	MigrationContext(MigrationStrategyRunner runner, Model original) {
		this.runner        = runner;
		this.originalModel = original;
	}

	private void initialiseModels(IModel original, IModel migrated) {
		addModel(original);
		addModel(migrated);
		
		setOriginalModel(original);
		setMigratedModel(migrated);
	}
	
	private void addModel(IModel model) {
		if (model != null)
			getModelRepository().addModel(model);
	}
	
	public void setOriginalModel(IModel original) {
		this.originalModel = new Model(original, getPrettyPrinterManager());
	}
	
	public void setMigratedModel(IModel migrated) {
		this.migratedModel = new Model(migrated, getPrettyPrinterManager());
	}
	
	
	
	public Object executeBlock(AST block, Variable... variables) throws MigrationExecutionException {
		try {
			enterProtectedFrame(block, variables);
			
			final Object result = getExecutorFactory().executeAST(block, this);
			
			leaveFrame(block);
			
			return result;
			
		} catch (EolRuntimeException e) {
			throw new MigrationExecutionException("Exception encountered while executing EOL block.", e);
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
	
	public ModelElement createModelElementInMigratedModel(String type) throws MigrationExecutionException {
		try {
			return migratedModel.createInstance(type);
		
		} catch (EolRuntimeException e) {
			throw new MigrationExecutionException("Could not create in the migrated model a model element of type: " + type, e);
		}
	}
	
	public ModelElement createModelElementOfSameTypeInMigratedModel(ModelElement original) throws MigrationExecutionException {
		if (migratedModel.hasType(original.getTypeName()))
			return createModelElementInMigratedModel(original.getTypeName());
		else
			return null;
	}

	public boolean isElementInOriginalModel(ModelElement element) {
		return originalModel.owns(element);
	}
	
	public boolean isElementInMigratedModel(ModelElement element) {
		return migratedModel.owns(element);
	}
	
	private boolean isElementInOriginalModel(Object unwrappedModelElement) {
		return originalModel.owns(unwrappedModelElement);
	}
	
	private ModelElement toElementInOriginalModel(Object unwrappedModelElement) {
		return originalModel.wrapModelElement(unwrappedModelElement);
	}

	
	public void run(MigrationStrategy strategy) throws MigrationExecutionException {
		runner.run(strategy);
	}

	public ModelElement getEquivalent(ModelElement originalModelElement) {
		return runner.getEquivalent(originalModelElement);
	}

	public Object getUnwrappedEquivalent(Object unwrappedModelElement) {
		if (!isElementInOriginalModel(unwrappedModelElement))
			return null;
		
		return getEquivalent(toElementInOriginalModel(unwrappedModelElement)).unwrap();
	}
}
