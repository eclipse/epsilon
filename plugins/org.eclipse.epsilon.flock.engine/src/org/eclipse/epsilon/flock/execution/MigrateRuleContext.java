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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.epsilon.eol.execute.context.Variable;
import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.ClassifierTypedConstruct;
import org.eclipse.epsilon.flock.model.domain.rules.Body;

public class MigrateRuleContext {
	
	private final Equivalence equivalence;
	private final EolExecutor executor;
	private final FlockExecution execution;
	private final Map<ClassifierTypedConstruct, Boolean> applicabilityCache = new HashMap<ClassifierTypedConstruct, Boolean>();

	public MigrateRuleContext(Equivalence equivalence, EolExecutor executor, FlockExecution execution) {
		this.equivalence = equivalence;
		this.executor = executor;
		this.execution = execution;
	}

	public boolean isEligibleFor(ClassifierTypedConstruct guardedConstruct) throws FlockRuntimeException {
		final boolean applicability;
		
		if (applicabilityCache.containsKey(guardedConstruct)) {
			applicability = applicabilityCache.get(guardedConstruct);
			
		} else {			
			applicability = guardedConstruct.appliesIn(getOriginal());
			applicabilityCache.put(guardedConstruct, applicability);
		}

		return applicability;
	}
	
	private GuardedConstructContext getOriginal() {
		return new GuardedConstructContext(equivalence.getOriginal(), executor);
	}

	public void execute(Body body) throws FlockRuntimeException {
		equivalence.ruleApplied(execution);
		body.applyTo(executor, equivalence.getVariables().toArray(new Variable[]{}));
	}
}