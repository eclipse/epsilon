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
import org.eclipse.epsilon.migration.execution.MigrationExecutionException;

public class MigrationContext extends EolContext implements IMigrationContext {

	protected final Model originalModel;
	protected final Model migratedModel;
		
	public MigrationContext() {
		this(null, null);
	}
	
	public MigrationContext(IModel original, IModel migrated) {
		this.originalModel = new Model(original);
		this.migratedModel = new Model(migrated);
		
		addModel(original);
		addModel(migrated);
	}
	
	private void addModel(IModel model) {
		if (model != null)
			getModelRepository().addModel(model);
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
}
