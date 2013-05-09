/*******************************************************************************
 * Copyright (c) 2010 The University of York.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Louis Rose - initial API and implementation
 ******************************************************************************/
package org.eclipse.epsilon.flock.model.domain.typemappings;

import org.eclipse.epsilon.common.module.ModuleElement;
import org.eclipse.epsilon.flock.context.MigrationStrategyCheckingContext;
import org.eclipse.epsilon.flock.equivalences.factory.EquivalenceFactory;
import org.eclipse.epsilon.flock.execution.GuardedConstructContext;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;

public interface TypeMappingConstruct extends EquivalenceFactory, ModuleElement {

	public boolean appliesIn(GuardedConstructContext original) throws FlockRuntimeException;

	public void check(MigrationStrategyCheckingContext context);
}
