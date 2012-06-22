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
package org.eclipse.epsilon.flock.execution;

import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext.EquivalentFactory;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.equivalences.factory.EquivalenceFactory;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.typemappings.TypeMappingConstruct;

public class TypeMappingContext {
	
	private final ModelElement original;
	private final EolExecutor executor;
	private final FlockExecution execution;
	private final EquivalentFactory equivalentFactory;

	public TypeMappingContext(ModelElement original, EolExecutor executor, FlockExecution execution, EquivalentFactory equivalentFactory) {
		this.original = original;
		this.executor = executor;
		this.execution = execution;
		this.equivalentFactory = equivalentFactory;
	}
	
	public boolean isEligibleFor(TypeMappingConstruct typeMapping) throws FlockRuntimeException {
		return typeMapping.appliesIn(getOriginal());
	}

	private GuardedConstructContext getOriginal() {
		return new GuardedConstructContext(original, executor);
	}

	public Equivalence createEquivalenceUsing(EquivalenceFactory equivalenceFactory) throws FlockRuntimeException {
		return equivalenceFactory.createEquivalence(executor, execution, original, equivalentFactory);
	}
}