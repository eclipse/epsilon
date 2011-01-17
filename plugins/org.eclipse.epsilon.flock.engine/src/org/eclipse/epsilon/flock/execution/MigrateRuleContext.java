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

import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.TypedAndGuardedConstruct;
import org.eclipse.epsilon.flock.model.domain.rules.Body;

public class MigrateRuleContext {
	
	public final Equivalence equivalence;
	public final EolExecutor executor;

	public MigrateRuleContext(Equivalence equivalence, EolExecutor executor) {
		this.equivalence = equivalence;
		this.executor = executor;
	}

	public boolean isEligibleFor(TypedAndGuardedConstruct guardedConstruct) throws FlockRuntimeException {
		return guardedConstruct.appliesIn(getOriginal());
	}

	private GuardedConstructContext getOriginal() {
		return new GuardedConstructContext(equivalence.getOriginal(), executor);
	}

	public void execute(Body body) throws FlockRuntimeException {
		body.applyTo(executor, equivalence.getVariables());
	}
}