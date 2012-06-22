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

import java.util.Collection;
import java.util.LinkedList;

import org.eclipse.epsilon.eol.exceptions.EolRuntimeException;
import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.emc.wrappers.Model;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.TypeMappingContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public class EquivalenceEstablishmentContext {
	
	private final Model originalModel;
	private final Model migratedModel;
	private final EolExecutor executor;
	private final FlockExecution execution;
	private final EquivalentFactory factory;
	
	public EquivalenceEstablishmentContext(Model originalModel, Model migratedModel, EolExecutor executor, FlockExecution execution) {
		this.originalModel = originalModel;
		this.migratedModel = migratedModel;
		this.executor      = executor;
		this.execution     = execution;
		this.factory       = new EquivalentFactory();
	}
	
	public Collection<TypeMappingContext> getTypeMappingContexts() {
		final Collection<TypeMappingContext> contexts = new LinkedList<TypeMappingContext>();
		
		for (ModelElement original : originalModel.directContents()) {
			contexts.add(new TypeMappingContext(original, executor, execution, factory));
		}
		
		return contexts;
	}
	
	public class EquivalentFactory {

		public ModelElement createModelElementInMigratedModel(String type) throws FlockRuntimeException {
			try {
				return migratedModel.createInstance(type);
			
			} catch (EolRuntimeException e) {
				throw new FlockRuntimeException("Could not create in the migrated model a model element of type: " + type, e);
			}
		}

		public boolean typeConformsToEvolvedMetamodel(String type) {
			return migratedModel.isInstantiable(type);
		}
	}
}