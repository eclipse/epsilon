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
package org.eclipse.epsilon.flock.model.domain.typemappings;

import org.eclipse.epsilon.common.parse.AST;
import org.eclipse.epsilon.flock.FlockExecution;
import org.eclipse.epsilon.flock.context.EquivalenceEstablishmentContext.EquivalentFactory;
import org.eclipse.epsilon.flock.emc.wrappers.ModelElement;
import org.eclipse.epsilon.flock.equivalences.Equivalence;
import org.eclipse.epsilon.flock.equivalences.NoEquivalence;
import org.eclipse.epsilon.flock.execution.EolExecutor;
import org.eclipse.epsilon.flock.execution.exceptions.FlockRuntimeException;
import org.eclipse.epsilon.flock.model.domain.common.PackageTypedConstruct;

public class PackageDeletion extends PackageTypedConstruct implements TypeMappingConstruct {

	public PackageDeletion(AST ast, String originalPackage, AST guard) {
		super(ast, guard, originalPackage);
	}
	
	public Equivalence createEquivalence(EolExecutor executor, FlockExecution execution, ModelElement original, EquivalentFactory equivalentFactory) throws FlockRuntimeException {
		return new NoEquivalence(executor, execution, original);
	}
	
	@Override
	public String toString() {
		return "delete package " + getOriginalPackage() + " when " + getGuard();
	}
}
